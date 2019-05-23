package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import javax.swing.JTextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@Deprecated
public class DialogListener implements WindowListener {

    private RSyntaxTextArea textArea;
    private FindButtonListener listener;

    public DialogListener(EditorWindow editorWindow, FindButtonListener listener){
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor  = editorWindow.getTextEditor(index);
        this.textArea = textEditor.getTextArea();
        this.listener = listener;
    }
    @Override
    public void windowOpened(WindowEvent e) {
        //textArea.setCaretPosition(0);
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
