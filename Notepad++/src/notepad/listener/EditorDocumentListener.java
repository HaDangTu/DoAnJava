package notepad.listener;

import javax.swing.event.DocumentEvent;;

import notepad.util.MyAutoCompletion;

import notepad.ui.TextEditor;
import notepad.ui.MainWindow;
import notepad.ui.TextEditorPopupMenu;

public class EditorDocumentListener extends BaseDocumentListener {
    private TextEditor editor;

    public EditorDocumentListener(TextEditor editor){
        super();
        this.editor = editor;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        MainWindow mainWindow = (MainWindow) editor.getRootPane().getParent();
        TextEditorPopupMenu popupMenu = (TextEditorPopupMenu) editor.getTextArea().getPopupMenu();

        if(!editor.getIsChanged() && !editor.getIsOpened()){
            editor.setIsChanged(true);
            mainWindow.setButtonSaveEnabled(true);
            mainWindow.setButtonSaveAllEnabled(true);
            mainWindow.setMenuItemSaveEnabled(true);
            mainWindow.setMenuItemSaveAllEnabled(true);

            mainWindow.setButtonUndoEnabled(true);
            mainWindow.setMenuItemUndoEnabled(true);
            popupMenu.setUndoEnabled(true);
        }

        MyAutoCompletion autoCompletion = editor.getAutoCompletion();
        if (autoCompletion != null){
            if (!autoCompletion.getFlag())
                autoCompletion.doCompletion();
            else
                autoCompletion.setFlag(false);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        MainWindow mainWindow = (MainWindow) editor.getRootPane().getParent();
        TextEditorPopupMenu popupMenu = (TextEditorPopupMenu) editor.getTextArea().getPopupMenu();

        if(!editor.getIsChanged() && !editor.getIsOpened()){
            editor.setIsChanged(true);
            mainWindow.setButtonSaveEnabled(true);
            mainWindow.setButtonSaveAllEnabled(true);
            mainWindow.setMenuItemSaveEnabled(true);
            mainWindow.setMenuItemSaveAllEnabled(true);

            mainWindow.setButtonUndoEnabled(true);
            mainWindow.setMenuItemUndoEnabled(true);
            popupMenu.setUndoEnabled(true);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
