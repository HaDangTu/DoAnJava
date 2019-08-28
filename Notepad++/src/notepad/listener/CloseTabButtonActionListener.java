package notepad.listener;

import notepad.ui.TabUI;
import notepad.ui.EditorWindow;

import notepad.util.TabInteraction;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;

public class CloseTabButtonActionListener extends BaseActionListener {

    private TabInteraction tabInteraction;

    public CloseTabButtonActionListener(EditorWindow editorWindow, TabUI tabUI){
        super(editorWindow, null);
        tabInteraction = new TabInteraction(editorWindow, tabUI);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        tabInteraction.closeTab(new JFileChooser());
    }
}
