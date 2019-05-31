package notepad.ui;

import javax.swing.JMenuBar;

public class MainMenu  extends JMenuBar{
    MenuFile menuFile;
    MenuEdit menuEdit ;
    MenuSearch menuSearch ;
    MenuLanguage menuLanguage;

    public MainMenu (EditorWindow editorWindow, MyTree tree, MainWindow parentFrame){
        menuFile = new MenuFile(editorWindow, tree, parentFrame);
        menuEdit = new MenuEdit(editorWindow);
        menuSearch = new MenuSearch(editorWindow, parentFrame);
        menuLanguage = new MenuLanguage(editorWindow);

        add(menuFile);
        add(menuEdit);
        add(menuSearch);
        add(menuLanguage);
    }

    public void setSelectedItem(String extension){
        menuLanguage.setSelectedItem(extension);
    }

    public void setMenuSaveEnabled(boolean enabled){
        menuFile.setMenuItemSaveEnabled(enabled);
    }

    public void setMenuSaveAllEnabled(boolean enabled){
        menuFile.setMenuItemSaveAllEnabled(enabled);
    }

    public void setMenuUndoEnabled(boolean enabled) {
        menuEdit.setMenuItemUndoEnabled(enabled);
    }

    public void setMenuRedoEnabled(boolean enabled){
        menuEdit.setMenuItemRedoEnabled(enabled);
    }
}
