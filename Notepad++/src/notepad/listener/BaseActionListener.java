package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.MainWindow;

import java.awt.event.ActionListener;

public abstract class BaseActionListener extends BaseListener implements ActionListener{


    public BaseActionListener(){
        super();
    }

    public BaseActionListener(EditorWindow editorWindow,  MainWindow parentFrame){
        super(editorWindow, parentFrame);
    }

    public BaseActionListener(EditorWindow editorWindow){
        super(editorWindow);
    }
}
