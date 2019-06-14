package notepad.listener;

import notepad.ui.EditorWindow;

import notepad.util.TabInteraction;

import javax.swing.JFileChooser;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class MainWindowListener implements WindowListener {
    private TabInteraction tabInteraction;

    public MainWindowListener(EditorWindow editorWindow){
        tabInteraction = new TabInteraction(editorWindow);
    }
    @Override
    public void windowOpened(WindowEvent e) {
        //textArea.setCaretPosition(0);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        tabInteraction.closeAllTab(new JFileChooser());
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
