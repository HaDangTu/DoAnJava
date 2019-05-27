package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.NewFileDialog;
import notepad.ui.MyTree;
import notepad.ui.NewFolderDialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.TreePath;

import notepad.util.BuildingFilePath;
import notepad.util.TreeInteraction;

import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

/**
 * TODO test new file and new folder
 */
public class TreePopupMenuListener implements ActionListener {
    private EditorWindow editorWindow;
    private JFrame parentFrame;
    private MyTree tree;
    private TreeInteraction treeInteraction;

    public TreePopupMenuListener(EditorWindow editorWindow, MyTree tree, JFrame parentFrame){
        this.editorWindow = editorWindow;
        this.parentFrame = parentFrame;
        this.tree = tree;
        treeInteraction = new TreeInteraction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("New file")){
            final String[] kind = {"Normal text", "C file", "C++ file", "C# file", "PHP file",
                    "Python file", "Java file", "JavaScript file", "JSON file"};
            NewFileDialog dialog = new NewFileDialog(parentFrame, kind, editorWindow);
            dialog.showDialog();

            String fileName = dialog.getName();
            fileName = fileName.substring(0, fileName.indexOf("."));
            try {
                if (!fileName.trim().equalsIgnoreCase("")) {
                    boolean result = treeInteraction.addNewFile(tree, dialog.getName());
                    if (!result)
                        JOptionPane.showMessageDialog(parentFrame, "Can't create file, because " +
                                        "your file already exists", "Error",
                                JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (IOException ioe){
                System.err.println(ioe.getMessage());
            }
        }
        else if (command.equalsIgnoreCase("New folder")){
            NewFolderDialog dialog = new NewFolderDialog(parentFrame, tree, treeInteraction);
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Open")){
            try {
                treeInteraction.openFile(editorWindow, tree);
            }
            catch (IOException ioe){
                System.err.println(ioe.getMessage());
            }
        }
        else if (command.equalsIgnoreCase("Copy Path")){
            String location = tree.getLocation1();
            TreePath treePath = tree.getSelectionPath();
            String path = BuildingFilePath.buildFilePath(treePath);
            String fullPath = location + path;

            StringSelection stringSelection = new StringSelection(fullPath);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
        else if (command.equalsIgnoreCase("Delete")){
            int result = JOptionPane.showConfirmDialog(parentFrame,
                    "This will remove permanently file or folder", "Warning",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);

            if (result == 0) { //yes
                boolean isDel = treeInteraction.deleteFileOrFolder(tree);
                if (isDel)
                    JOptionPane.showMessageDialog(parentFrame, "Deleted file or folder successful",
                            "Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(parentFrame, "Deleted file or folder failed",
                            "Failed",
                            JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
