package notepad.listener;
import notepad.ui.EditorWindow;

import java.awt.event.ActionEvent;

public class MenuWindowActionListener extends MenuMainWindowListener {

    public MenuWindowActionListener(EditorWindow editorWindow){
        super(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Integer index = Integer.parseInt(e.getActionCommand());
       editorWindow.setSelectedIndex(index);
    }
}
