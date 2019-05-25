package notepad.listener;

import java.awt.event.WindowEvent;

import notepad.ui.EditorWindow;

public class WindowFocusListener implements java.awt.event.WindowFocusListener {
    private EditorWindow editorWindow;

    public  WindowFocusListener(EditorWindow editorWindow){
        this.editorWindow = editorWindow;
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        editorWindow.getTextEditor(0).getTextArea().requestFocusInWindow();
    }

    @Override
    public void windowLostFocus(WindowEvent e) {

    }
}
