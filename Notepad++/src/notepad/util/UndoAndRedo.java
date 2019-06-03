package notepad.util;
import notepad.ui.MainWindow;
import notepad.ui.TextEditor;
import notepad.ui.TextEditorPopupMenu;

import javax.swing.undo.UndoManager;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class UndoAndRedo {

    private TextEditorPopupMenu popupMenu;
    private MainWindow mainWindow;
    private UndoManager undoManager;

    public UndoAndRedo(TextEditor textEditor){
        RSyntaxTextArea textArea = textEditor.getTextArea();
        popupMenu = (TextEditorPopupMenu)textArea.getPopupMenu();
        mainWindow = (MainWindow) textArea.getRootPane().getParent();
        undoManager = textEditor.getUndoManager();
    }

    public void undoAction(){
        if (undoManager.canUndo()){
            undoManager.undo();

            mainWindow.setMenuItemRedoEnabled(undoManager.canRedo());
            mainWindow.setButtonRedoEnabled(undoManager.canRedo());
            popupMenu.setRedoEnabled(undoManager.canRedo());
        }
        else{
            mainWindow.setMenuItemUndoEnabled(false);
            mainWindow.setButtonUndoEnabled(false);
            popupMenu.setUndoEnabled(false);
        }
    }

    public void redoAction(){
        if (undoManager.canRedo()){
            undoManager.redo();

            mainWindow.setMenuItemUndoEnabled(undoManager.canUndo());
            mainWindow.setButtonUndoEnabled(undoManager.canUndo());
            popupMenu.setUndoEnabled(undoManager.canUndo());
        }
        else {
            mainWindow.setMenuItemRedoEnabled(false);
            mainWindow.setButtonRedoEnabled(false);
            popupMenu.setRedoEnabled(false);
        }
    }
}
