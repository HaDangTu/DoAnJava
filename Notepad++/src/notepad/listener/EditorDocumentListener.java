package notepad.listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import notepad.ui.MainWindow;

public class EditorDocumentListener implements DocumentListener {
    private TextEditor editor;

    public EditorDocumentListener(TextEditor editor){
        this.editor = editor;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        MainWindow mainWindow = (MainWindow) editor.getRootPane().getParent();
        if(!editor.getIsChanged()){
            editor.setIsChanged(true);
            mainWindow.setButtonUndoEnabled(true);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        MainWindow mainWindow = (MainWindow) editor.getRootPane().getParent();

        if(!editor.getIsChanged()){
            editor.setIsChanged(true);
            mainWindow.setButtonUndoEnabled(true);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
