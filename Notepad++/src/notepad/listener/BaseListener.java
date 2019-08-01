package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.MainWindow;

import java.awt.event.ActionListener;

public abstract class BaseListener implements ActionListener{

    protected EditorWindow editorWindow;
    protected MainWindow parentFrame;

    public BaseListener(){
        editorWindow = null;
        parentFrame = null;
    }

    public BaseListener(EditorWindow editorWindow, MainWindow parentFrame){
        this.editorWindow = editorWindow;
        this.parentFrame = parentFrame;
    }
}
