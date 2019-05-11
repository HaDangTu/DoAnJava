package notepad.listener;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class DocumentUndoableEditListener implements UndoableEditListener {

    private UndoManager undoManger;

    public DocumentUndoableEditListener(){
        undoManger = new UndoManager();
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManger.addEdit(e.getEdit());
    }

    public UndoManager getUndoManger(){
        return undoManger;
    }
}
