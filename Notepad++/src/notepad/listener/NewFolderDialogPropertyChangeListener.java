package notepad.listener;

import notepad.ui.NewFolderDialog;
import notepad.ui.Tree;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NewFolderDialogPropertyChangeListener implements PropertyChangeListener {
    private JDialog dialog;
    private JFrame parentFrame;
    private Tree tree;

    public NewFolderDialogPropertyChangeListener(JDialog dialog, JFrame parentFrame, Tree tree){
        this.dialog = dialog;
        this.parentFrame = parentFrame;
        //this.treeInteraction = treeInteraction;
        this.tree = tree;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String command = ((NewFolderDialog) dialog).getValue().toString();

        if (command.equalsIgnoreCase("Create folder")){
            if (((NewFolderDialog) dialog).getFolderName().trim().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(parentFrame, "Folder name is null",
                        "Error", JOptionPane.ERROR_MESSAGE);

            tree.addNewFolder(((NewFolderDialog) dialog).getFolderName());
            dialog.setVisible(false);
        }
        else if (command.equalsIgnoreCase("Cancel"))
            dialog.setVisible(false);

        ((NewFolderDialog) dialog).setValue(JOptionPane.UNINITIALIZED_VALUE);
    }
}
