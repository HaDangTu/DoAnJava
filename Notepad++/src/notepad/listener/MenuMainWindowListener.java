package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.MainWindow;


public abstract class MenuMainWindowListener extends BaseListener {

    public MenuMainWindowListener(EditorWindow editorWindow, MainWindow parentFrame){
        super(editorWindow, parentFrame);
    }

    public MenuMainWindowListener(EditorWindow editorWindow){
        super(editorWindow, null);
    }
}
