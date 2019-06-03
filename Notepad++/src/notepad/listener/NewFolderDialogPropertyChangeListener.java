package notepad.listener;

import notepad.ui.NewFolderDialog;
import notepad.ui.Tree;
import notepad.util.TreeInteraction;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NewFolderDialogPropertyChangeListener implements PropertyChangeListener {
    private JDialog dialog;
    private JFrame parentFrame;
    private TreeInteraction treeInteraction;
    private Tree tree;

    public NewFolderDialogPropertyChangeListener(JDialog dialog, JFrame parentFrame, Tree tree,
                                                 TreeInteraction treeInteraction){
        this.dialog = dialog;
        this.parentFrame = parentFrame;
        this.treeInteraction = treeInteraction;
        this.tree = tree;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String command = ((NewFolderDialog) dialog).getValue().toString();

        if (command.equalsIgnoreCase("Create folder")){
            if (((NewFolderDialog) dialog).getFolderName().trim().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(parentFrame, "Folder name is null",
                        "Error", JOptionPane.ERROR_MESSAGE);

            treeInteraction.addNewFolder(tree, ((NewFolderDialog) dialog).getFolderName());
            dialog.setVisible(false);
        }
        else if (command.equalsIgnoreCase("Cancel"))
            dialog.setVisible(false);

        ((NewFolderDialog) dialog).setValue(JOptionPane.UNINITIALIZED_VALUE);
    }
}
