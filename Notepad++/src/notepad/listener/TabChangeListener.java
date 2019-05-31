package notepad.listener;
import notepad.ui.MainMenu;
import notepad.ui.EditorWindow;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabChangeListener implements ChangeListener {

    private MainMenu mainMenu;
    private EditorWindow editorWindow;

    public TabChangeListener(MainMenu mainMenu, EditorWindow editorWindow){
        this.mainMenu = mainMenu;
        this.editorWindow = editorWindow;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int index = editorWindow.getSelectedIndex();
        mainMenu.setSelectedItem(editorWindow.getFileTypeOfTab(index));
    }
}
