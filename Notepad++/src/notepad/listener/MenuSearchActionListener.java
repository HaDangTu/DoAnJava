package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.SearchDialog;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;

public class MenuSearchActionListener extends MenuMainWindowListener {

    private JFrame parentFrame;
    public MenuSearchActionListener(EditorWindow editorWindow, JFrame frame) {
        super(editorWindow);
        this.parentFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("Find")) {
            SearchDialog dialog = new SearchDialog(parentFrame, editorWindow);
            dialog.showDialog();
        }
    }
}
