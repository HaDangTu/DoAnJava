package notepad.listener;
import notepad.ui.MainWindow;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.undo.UndoManager;

public class TabChangeListener implements ChangeListener {

    private MainWindow mainWindow;
    private EditorWindow editorWindow;

    public TabChangeListener(MainWindow mainWindow, EditorWindow editorWindow){
        this.mainWindow = mainWindow;
        this.editorWindow = editorWindow;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (editorWindow.getTabCount() > 0) {
            int index = editorWindow.getSelectedIndex();
            TextEditor textEditor = editorWindow.getTextEditor(index);
            mainWindow.setSelectedLangItem(editorWindow.getFileTypeOfTab(index));

            mainWindow.setSelectedWindowItem(index);

            UndoManager undoManager = textEditor.getUndoManager();

            mainWindow.setButtonUndoEnabled(undoManager.canUndo());
            mainWindow.setButtonRedoEnabled(undoManager.canRedo());

            mainWindow.setMenuItemRedoEnabled(undoManager.canRedo());
            mainWindow.setMenuItemUndoEnabled(undoManager.canUndo());

            if (textEditor.getIsChanged()) {
                mainWindow.setMenuItemSaveEnabled(true);
                mainWindow.setMenuItemSaveAllEnabled(true);
                mainWindow.setButtonSaveAllEnabled(true);
                mainWindow.setButtonSaveEnabled(true);
            } else {
                mainWindow.setMenuItemSaveEnabled(false);
                mainWindow.setButtonSaveEnabled(false);

                mainWindow.setMenuItemSaveAllEnabled(false);
                mainWindow.setButtonSaveAllEnabled(false);
                if (!editorWindow.isSavedAll()) {
                    mainWindow.setMenuItemSaveAllEnabled(true);
                    mainWindow.setButtonSaveAllEnabled(true);
                }

            }
        }
    }
}
