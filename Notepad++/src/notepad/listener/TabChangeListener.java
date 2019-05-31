package notepad.listener;
import notepad.ui.MainWindow;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabChangeListener implements ChangeListener {

    private MainWindow mainWindow;
    private EditorWindow editorWindow;

    public TabChangeListener(MainWindow mainWindow, EditorWindow editorWindow){
        this.mainWindow = mainWindow;
        this.editorWindow = editorWindow;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        mainWindow.setSelectedLangItem(editorWindow.getFileTypeOfTab(index));

        mainWindow.setButtonUndoEnabled(textEditor.getTextArea().canUndo());
        mainWindow.setButtonSaveEnabled(textEditor.getTextArea().canRedo());
        mainWindow.setMenuItemRedoEnabled(textEditor.getTextArea().canRedo());
        mainWindow.setMenuItemUndoEnabled(textEditor.getTextArea().canUndo());

        if (textEditor.getIsChanged()) {
            mainWindow.setMenuItemSaveEnabled(true);
            mainWindow.setMenuItemSaveAllEnabled(true);
            mainWindow.setButtonSaveAllEnabled(true);
            mainWindow.setButtonSaveEnabled(true);
        }
        else {
            mainWindow.setMenuItemSaveEnabled(false);
            mainWindow.setButtonSaveEnabled(false);
            if (!editorWindow.isSavedAll()) {
                mainWindow.setMenuItemSaveAllEnabled(true);
                mainWindow.setButtonSaveAllEnabled(true);
            }

        }
    }
}
