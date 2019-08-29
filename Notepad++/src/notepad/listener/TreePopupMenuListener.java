package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.NewFileDialog;
import notepad.ui.Tree;
import notepad.ui.NewFolderDialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeCellEditor;

import java.awt.event.ActionEvent;

import java.io.IOException;

public class TreePopupMenuListener extends BaseActionListener {
    private JFrame parentFrame;
    private Tree tree;

    public TreePopupMenuListener(EditorWindow editorWindow, Tree tree, JFrame parentFrame){
        super(editorWindow);
        this.parentFrame = parentFrame;
        this.tree = tree;
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
                    boolean result = tree.addNewFile(dialog.getName());
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
            NewFolderDialog dialog = new NewFolderDialog(parentFrame, tree);
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Open")){
            try {
                tree.openFile(editorWindow);
            }
            catch (IOException ioe){
                System.err.println(ioe.getMessage());
            }
        }
        else if (command.equalsIgnoreCase("Cut")){
            tree.cutFile();
        }
        else if (command.equalsIgnoreCase("Copy")){
            tree.copyFile();
        }
        else if (command.equalsIgnoreCase("Copy Path")){
            tree.copyPath();
        }
        else if (command.equalsIgnoreCase("Paste")){
            try {
                tree.paste();
            }
            catch (IOException ioe){
                System.err.println(ioe.getMessage());
            }
        }
        else if (command.equalsIgnoreCase("Rename")){
            DefaultTreeCellEditor cellEditor = (DefaultTreeCellEditor) tree.getCellEditor();
            cellEditor.actionPerformed(e);
        }
        else if (command.equalsIgnoreCase("Delete")){
            int result = JOptionPane.showConfirmDialog(parentFrame,
                    "This will remove permanently file or folder", "Warning",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);

            if (result == 0) { //yes
                boolean isDel = tree.deleteFileOrFolder();
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
