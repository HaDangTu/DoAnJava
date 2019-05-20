package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.SearchDialog;

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
        else if (command.equalsIgnoreCase("Replace")){
            SearchDialog dialog = new SearchDialog(parentFrame, editorWindow);
            dialog.setSelectedTab(1);
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Mark...")){
            SearchDialog dialog = new SearchDialog(parentFrame, editorWindow);
            dialog.setSelectedTab(2);
            dialog.showDialog();
        }
    }
}
