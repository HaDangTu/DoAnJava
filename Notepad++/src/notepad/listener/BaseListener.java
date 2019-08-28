package notepad.listener;

import notepad.ui.MainWindow;
import notepad.ui.EditorWindow;

public abstract class BaseListener {
    
    protected MainWindow mainWindow;
    protected EditorWindow editorWindow;

    public BaseListener(){
        mainWindow = null;
        editorWindow = null;
    }

    public BaseListener(EditorWindow editorWindow, MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.editorWindow = editorWindow;
    }

    public BaseListener(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.editorWindow = null;
    }

    public BaseListener(EditorWindow editorWindow){
        this.editorWindow = editorWindow;
        this.mainWindow = null;
    }
}
