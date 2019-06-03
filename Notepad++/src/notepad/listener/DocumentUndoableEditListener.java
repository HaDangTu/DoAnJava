package notepad.listener;

import notepad.ui.TextEditor;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class DocumentUndoableEditListener implements UndoableEditListener {

    private UndoManager undoManager;
    private TextEditor textEditor;

    public DocumentUndoableEditListener(TextEditor textEditor){
        this.textEditor = textEditor;
        undoManager = new UndoManager();
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        /*
         * chỉ addEdit khi dữ liệu do user nhập trên text editor, không phải đọc từ file lên
         */
        if (!textEditor.getIsOpened())
            undoManager.addEdit(e.getEdit());
    }

    public UndoManager getUndoManager(){
        return undoManager;
    }
}
