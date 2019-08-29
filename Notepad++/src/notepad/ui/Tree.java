package notepad.ui;
import notepad.util.BuildingFilePath;
import notepad.util.CategoryOfFile;
import notepad.util.MyReadAndWriteAdapter;
import notepad.util.MyTreeCellRenderer;
import org.apache.commons.io.FileUtils;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Tree extends JTree {
    private String locationOfNode;
    private DefaultMutableTreeNode root;
    private TreePath srcTreePath;
    private boolean isCopy;

    public Tree(DefaultMutableTreeNode root){
        super(root);
        MyTreeCellRenderer renderer = new MyTreeCellRenderer();
        setCellRenderer(renderer);
        setEditable(true);
    }

    public void createTree(File file, DefaultMutableTreeNode root){
        File[] files = file.listFiles();
        DefaultMutableTreeNode child;
        for (File f: files){
            if(f.isDirectory()) {
                child = new DefaultMutableTreeNode(f.getName());
                createTree(f, child);
            }
            else
                child = new DefaultMutableTreeNode(f.getName());
            root.add(child);
        }
    }

    public void setLocationOfNode(String locationOfNode){
        this.locationOfNode = locationOfNode;
    }

    public void setRootWithFile(File file){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.getName());
        setLocationOfNode(file.getAbsolutePath());
        createTree(file, root);
        setRoot(root);
    }

    public void setRoot(DefaultMutableTreeNode root){
        DefaultTreeModel treeModel = (DefaultTreeModel) getModel();
        treeModel.setRoot(root);
    }

    /**
     * Get location of root
     * @return location
     */
    public String getLocationOfNode(){
        return locationOfNode;
    }

    public DefaultMutableTreeNode getRoot (){
        return root;
    }

    public void reloadTree(){
        File rootFile = new File(locationOfNode);
        DefaultMutableTreeNode root1 = new DefaultMutableTreeNode();
        createTree(rootFile, root1);
        setRoot(root1);
    }

    /**
     * Open file when user select file on tree and want to open it
     * @param editorWindow editorWindow
     * @throws FileNotFoundException file doesn't exist
     * @throws IOException error read file
     */
    public void openFile(EditorWindow editorWindow) throws FileNotFoundException, IOException{
        TreePath treePath = getSelectionPath();
        String directory = BuildingFilePath.buildFilePath(treePath);
        String filePath = getLocationOfNode() + "\\" + directory;

        int result = editorWindow.isExist(filePath);
        /**
         * if file not exist then open file else
         * set selected file
         */
        if (result < 0) {
            File file = new File(filePath);

            //Nếu file được chọn không phải là thư mục thì tiến hành mở file
            if (!file.isDirectory()) {
                editorWindow.addNewTab(file.getName());
                int index = editorWindow.getTabCount() - 1;
                editorWindow.setFilePathForTab(filePath, index);

                CategoryOfFile category = new CategoryOfFile();
                String extension = category.getExtensionOfFile(file.getName());
                String fileType = category.ChangeStyleEditorForFile(extension, editorWindow);
                editorWindow.setFileTypeForTab(fileType, index);
                TextEditor textEditor = editorWindow.getTextEditor(index);
                RSyntaxTextArea textArea = textEditor.getTextArea();

                MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter(textArea);
                textEditor.setIsOpened(true); //see comment at function openFile() in file OpenAndSaveFile.java
                adapter.read(filePath);
                textEditor.setIsChanged(false); //set isChanged = false vi trong qua trinh doc file de hien thi tren textarea se lam bien isChanged = true
                textEditor.setIsOpened(false);
                editorWindow.setSelectedIndex(index);

                MainWindow  mainWindow = (MainWindow) editorWindow.getRootPane().getParent();
                mainWindow.addItem(editorWindow.getTitleOfTab(index));
            }
        }
        else
            editorWindow.setSelectedIndex(result);
    }

    /**
     * add new file on tree
     * @param newFileName file name
     * @return true if add new file successful
     * @throws IOException error write file
     */
    public boolean addNewFile(String newFileName) throws IOException{
        newFileName = "\\" + newFileName;
        TreePath treePath = getSelectionPath();
        String filePath = BuildingFilePath.buildFilePath(treePath);
        String location = getLocationOfNode();
        String fullPath = location + filePath;

        File file = new File(fullPath);

        if (!file.isDirectory()){
            fullPath = fullPath.substring(0, fullPath.indexOf(treePath.getLastPathComponent().toString()));
            file = new File(fullPath + newFileName);
            treePath = treePath.getParentPath();
        }
        else
            file = new File(fullPath + newFileName);

        if (file.exists())
            return false;

        if (file.createNewFile()){
            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());

            DefaultTreeModel treeModel = (DefaultTreeModel) getModel();
            treeModel.insertNodeInto(childNode, parentNode, 0);
        }

        return true;
    }

    /**
     * add new folder on tree
     * @param newFolderName folder name
     * @return true if new folder is added successfully
     */
    public boolean addNewFolder(String newFolderName){
        newFolderName = "\\" + newFolderName;
        TreePath treePath = getSelectionPath();
        String filePath = BuildingFilePath.buildFilePath(treePath);
        String location = getLocationOfNode();
        String fullPath = location + filePath;

        File file = new File(fullPath);
        if (!file.isDirectory()){
            fullPath = fullPath.substring(0, fullPath.indexOf(treePath.getLastPathComponent().toString()));
            file = new File(fullPath + newFolderName);
            treePath = treePath.getParentPath();
        }
        else
            file = new File(fullPath + newFolderName);

        if (file.exists())
            return false;

        if (file.mkdir()){
            System.out.println("Create directory successful");
            DefaultTreeModel treeModel = (DefaultTreeModel) getModel();

            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());

            treeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount());
        }
        else System.err.println("Create directory  failed");

        return true;
    }

    /**
     * delete file
     * @param file file need to be deleted
     */
    private void deleteFile(File file){
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory())
                deleteFile(f);
            f.delete();
        }
    }

    public boolean deleteFileOrFolder(){
        TreePath treePath = getSelectionPath();
        return deleteFileOrFolder(treePath);
    }

    /**
     * delete file or folder
     * @return true if delete successful
     */
    public boolean deleteFileOrFolder(TreePath treePath){
        String path = BuildingFilePath.buildFilePath(treePath);
        String location = getLocationOfNode();
        String fullPath = location + path;

        File file = new File(fullPath);

        deleteFile(file);

        if (file.delete()) {
            DefaultMutableTreeNode deleteNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();

            DefaultTreeModel treeModel = (DefaultTreeModel) getModel();
            treeModel.removeNodeFromParent(deleteNode);
            return true;
        }
        else return false;
    }

    /**
     * copy path of file
     */
    public void copyPath (){
        String location = getLocationOfNode();
        TreePath treePath = getSelectionPath();
        String path = BuildingFilePath.buildFilePath(treePath);
        String fullPath = location + path;

        StringSelection stringSelection = new StringSelection(fullPath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    /**
     * Copy file
     */

    public void copyFile(){
        srcTreePath = getSelectionPath();
        isCopy = true; //copy file
    }

    /**
     * cut file
     */
    public void cutFile(){
        copyFile();
        isCopy = false; //cut file
    }

    /**
     * Paste file
     * @throws IOException error write file
     */
    public void paste() throws IOException{
        String location = getLocationOfNode();

        String srcFilePath = location + BuildingFilePath.buildFilePath(srcTreePath);
        File srcFile = new File(srcFilePath);

        TreePath destTreePath = getSelectionPath();
        String destFilePath = location + BuildingFilePath.buildFilePath(destTreePath);
        File destFile = new File(destFilePath);

        if (!destFile.isFile()) {
            destFilePath = location + BuildingFilePath.buildFilePath(getSelectionPath()) +
                    "\\" + srcFile.getName();
            destFile = new File(destFilePath);
        }
        else return;

        if (!destFile.isFile()){
            DefaultMutableTreeNode childNode;
            if (srcFile.isDirectory()) {
                FileUtils.copyDirectory(srcFile, destFile);
                childNode = new DefaultMutableTreeNode(srcFile.getName());
                createTree(destFile, childNode); //tao cay thu muc cua folder duoc copy or cut
            }
            else {
                FileUtils.copyFile(srcFile, destFile);
                childNode = new DefaultMutableTreeNode(srcFile.getName());
            }

            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) destTreePath.getLastPathComponent();

            DefaultTreeModel treeModel = (DefaultTreeModel) getModel();
            treeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount());

            if (!isCopy){ //cut paste
                deleteFileOrFolder(srcTreePath);
            }
        }
    }

    public void setCopy(boolean isCopy){
        this.isCopy = isCopy;
    }

    public boolean getCopy() {
        return this.isCopy;
    }
}
