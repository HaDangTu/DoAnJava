package notepad.listener;
import notepad.ui.EditorWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindowActionListener implements ActionListener {
    private EditorWindow editorWindow;

    public MenuWindowActionListener(EditorWindow editorWindow){
        this.editorWindow = editorWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Integer index = Integer.parseInt(e.getActionCommand());
       editorWindow.setSelectedIndex(index);
    }
}
