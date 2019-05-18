package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import javax.naming.directory.SearchResult;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DialogListener implements WindowListener {

    private EditorWindow editorWindow;

    public DialogListener(EditorWindow editorWindow){
        this.editorWindow = editorWindow;
    }
    @Override
    public void windowOpened(WindowEvent e) {
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor  = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();
        textArea.setCaretPosition(0);
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
