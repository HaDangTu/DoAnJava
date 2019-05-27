package notepad.util;
import notepad.ui.MyTree;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;

import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class TreeInteraction {

    public void openFile(EditorWindow editorWindow, MyTree tree) throws FileNotFoundException, IOException{
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
                category.ChangeStyleEditorForFile(extension, editorWindow);

                RSyntaxTextArea textArea = editorWindow.getTextEditor(index).getTextArea();

                MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter(textArea);
                adapter.read(filePath);
                TextEditor textEditor = editorWindow.getTextEditor(index);
                textEditor.setIsChanged(false); //set isChanged = false vi trong qua trinh doc file de hien thi tren textarea se lam bien isChanged = tru
                editorWindow.setSelectedIndex(index);
            }
        }
        else
            editorWindow.setSelectedIndex(result);
    }

    public boolean addNewFile(MyTree tree, String newFileName) throws IOException{
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

    public boolean addNewFolder(MyTree tree, String newFolderName){
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

    public boolean deleteFileOrFolder(MyTree tree){
        TreePath treePath = tree.getSelectionPath();
        String path = BuildingFilePath.buildFilePath(treePath);
        String location = tree.getLocation1();
        String fullPath = location + path;

        File file = new File(fullPath);

        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files.length > 0)
                for(File f: files)
                    f.delete();
        }

        if (file.delete()) {
            DefaultMutableTreeNode deleteNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();

            DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
            treeModel.removeNodeFromParent(deleteNode);
            return true;
        }
        else return false;
    }
}
