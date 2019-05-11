package notepad.listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import notepad.ui.TextEditor;

public class MyDocumentListener implements DocumentListener {
    private TextEditor editor;

    public MyDocumentListener(TextEditor editor){
        this.editor = editor;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        if(!editor.getIsChanged()){
            editor.setIsChanged(true);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(!editor.getIsChanged()){
            editor.setIsChanged(true);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
