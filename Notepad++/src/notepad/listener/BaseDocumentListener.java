package notepad.listener;

import notepad.ui.EditorWindow;

import javax.swing.event.DocumentListener;

public abstract class BaseDocumentListener extends BaseListener implements DocumentListener {

    public BaseDocumentListener(EditorWindow editorWindow){
        super(editorWindow);
    }

    public BaseDocumentListener(){
        super();
    }
}
