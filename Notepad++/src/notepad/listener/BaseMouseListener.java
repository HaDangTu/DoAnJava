package notepad.listener;

import notepad.ui.EditorWindow;
import java.awt.event.MouseListener;

public abstract class BaseMouseListener extends BaseListener implements MouseListener {

    public BaseMouseListener (EditorWindow editorWindow){
        super(editorWindow);
    }
}
