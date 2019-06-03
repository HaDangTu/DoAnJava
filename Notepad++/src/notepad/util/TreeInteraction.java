package notepad.util;
import notepad.ui.Tree;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import notepad.ui.MainWindow;

import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import java.awt.datatransfer.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

import java.awt.Toolkit;

import org.apache.commons.io.FileUtils;

public class TreeInteraction {
    private TreePath srcTreePath;
    private boolean isCopy;

    public void openFile(EditorWindow editorWindow, Tree tree) throws FileNotFoundException, IOException{
        TreePath treePath = tree.getSelectionPath();
        String directory = BuildingFilePath.buildFilePath(treePath);
        String filePath = tree.getLocation1() + "\\" + directory;

        int result = editorWindow.isExist(filePath);
        if (result < 0) {
            File file = new File(filePath);

            //Nếu file được chọn không phải là thư mục thì tiến hành mở file
            if (!file.isDirectory()) {
                editorWindow.addTabEditor(file.getName());
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

    public boolean addNewFile(Tree tree, String newFileName) throws IOException{
        newFileName = "\\" + newFileName;
        TreePath treePath = tree.getSelectionPath();
        String filePath = BuildingFilePath.buildFilePath(treePath);
        String location = tree.getLocation1();
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

            DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
            treeModel.insertNodeInto(childNode, parentNode, 0);
        }

        return true;
    }

    public boolean addNewFolder(Tree tree, String newFolderName){
        newFolderName = "\\" + newFolderName;
        TreePath treePath = tree.getSelectionPath();
        String filePath = BuildingFilePath.buildFilePath(treePath);
        String location = tree.getLocation1();
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
            DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();

            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());

            treeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount());
        }
        else System.err.println("Create directory  failed");

        return true;
    }

    public boolean deleteFileOrFolder(Tree tree){
        TreePath treePath = tree.getSelectionPath();
        return deleteFileOrFolder(tree, treePath);
    }

    private boolean deleteFileOrFolder(Tree tree, TreePath treePath){
        String path = BuildingFilePath.buildFilePath(treePath);
        String location = tree.getLocation1();
        String fullPath = location + path;

        File file = new File(fullPath);

        deleteFile(file);

        if (file.delete()) {
            DefaultMutableTreeNode deleteNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();

            DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
            treeModel.removeNodeFromParent(deleteNode);
            return true;
        }
        else return false;
    }

    public void copyPath (Tree tree){
        String location = tree.getLocation1();
        TreePath treePath = tree.getSelectionPath();
        String path = BuildingFilePath.buildFilePath(treePath);
        String fullPath = location + path;

        StringSelection stringSelection = new StringSelection(fullPath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void copyFile(Tree tree){
        srcTreePath = tree.getSelectionPath();
        isCopy = true; //copy file
    }

    public void cutFile(Tree tree){
        copyFile(tree);
        isCopy = false; //cut file
    }

    public void paste(Tree tree) throws IOException{
        String location = tree.getLocation1();

        String srcFilePath = location + BuildingFilePath.buildFilePath(srcTreePath);
        File srcFile = new File(srcFilePath);

        TreePath destTreePath = tree.getSelectionPath();
        String destFilePath = location + BuildingFilePath.buildFilePath(destTreePath);
        File destFile = new File(destFilePath);

        if (!destFile.isFile()) {
            destFilePath = location + BuildingFilePath.buildFilePath(tree.getSelectionPath()) +
                    "\\" + srcFile.getName();
            destFile = new File(destFilePath);
        }
        else return;

        if (!destFile.isFile()){
            DefaultMutableTreeNode childNode;
            if (srcFile.isDirectory()) {
                FileUtils.copyDirectory(srcFile, destFile);
                childNode = new DefaultMutableTreeNode(srcFile.getName());
                tree.createTree(destFile, childNode); //tao cay thu muc cua folder duoc copy or cut
            }
            else {
                FileUtils.copyFile(srcFile, destFile);
                childNode = new DefaultMutableTreeNode(srcFile.getName());
            }

            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) destTreePath.getLastPathComponent();

            DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
            treeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount());

            if (!isCopy){ //cut paste
                deleteFileOrFolder(tree, srcTreePath);
            }
        }
    }

    public void setCopy(boolean isCopy){
        this.isCopy = isCopy;
    }

    public boolean getCopy() {
        return this.isCopy;
    }

    public void deleteFile(File file){
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory())
                deleteFile(f);
            f.delete();
        }
    }
}
