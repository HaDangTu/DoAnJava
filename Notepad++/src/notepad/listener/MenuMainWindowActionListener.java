package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.MainWindow;


public abstract class MenuMainWindowActionListener extends BaseActionListener {

    public MenuMainWindowActionListener(EditorWindow editorWindow, MainWindow parentFrame){
        super(editorWindow, parentFrame);
    }

    public MenuMainWindowActionListener(EditorWindow editorWindow){
        super(editorWindow, null);
    }
}
