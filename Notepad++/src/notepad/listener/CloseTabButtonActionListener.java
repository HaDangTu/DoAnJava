package notepad.listener;

import notepad.ui.CloseTabButton;
import notepad.ui.TabUI;
import notepad.ui.EditorWindow;

import javax.swing.JFileChooser;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

public class CloseTabButtonActionListener extends BaseActionListener {
    private JButton button;

    public CloseTabButtonActionListener(EditorWindow editorWindow, JButton button){
        super(editorWindow, null);
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TabUI tabUI = (TabUI)button.getParent();
        int index = editorWindow.indexOfTab(tabUI.getLabel());
        editorWindow.closeTabAt(new JFileChooser(), index);
    }
}
