package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.NewFileDialog;
import notepad.util.CategoryOfFile;

import javax.swing.JOptionPane;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FileDialogPropertyChangeListener implements PropertyChangeListener {
    private EditorWindow editorWindow;
    private NewFileDialog dialog;

    public FileDialogPropertyChangeListener(EditorWindow editorWindow, NewFileDialog dialog){
        this.editorWindow = editorWindow;
        this.dialog = dialog;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String command = dialog.getValue().toString();
        if (command.equals("Create file")){
            String fileName = dialog.getName().substring(0, dialog.getName().lastIndexOf("."));
            if (fileName.trim().equals(""))
                JOptionPane.showMessageDialog(dialog, "Invalid name of file",
                        "Error", JOptionPane.ERROR_MESSAGE);
            else {
                editorWindow.addTabEditor(dialog.getName());
                int index = editorWindow.getTabCount() - 1;

                CategoryOfFile category = new CategoryOfFile();
                String extension = category.getExtensionOfFile(dialog.getName());
                String fileType = category.ChangeStyleEditorForFile(extension, editorWindow);

                editorWindow.setSelectedIndex(index);
                editorWindow.setFileTypeForTab(fileType, index);
                dialog.setVisible(false);
            }
        }
        else if (command.equals("Cancel"))
            dialog.setVisible(false);
        dialog.setValue(JOptionPane.UNINITIALIZED_VALUE);
    }
}
