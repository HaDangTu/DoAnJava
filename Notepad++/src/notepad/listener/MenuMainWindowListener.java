package notepad.listener;

import notepad.ui.EditorWindow;
import java.awt.event.ActionListener;

public abstract class MenuMainWindowListener implements ActionListener {

    protected EditorWindow editorWindow;
    public MenuMainWindowListener(EditorWindow editorWindow){
        this.editorWindow = editorWindow;
    }
}
