package notepad.listener;

import notepad.ui.TabUI;
import notepad.ui.EditorWindow;

import notepad.util.TabInteraction;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseTabButtonListener extends BaseListener {

    private TabInteraction tabInteraction;

    public CloseTabButtonListener(EditorWindow editorWindow, TabUI tabUI){
        super(editorWindow, null);
        tabInteraction = new TabInteraction(editorWindow, tabUI);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        tabInteraction.closeTab(new JFileChooser());
    }
}
