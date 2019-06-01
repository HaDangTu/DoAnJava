package notepad.ui;

import javax.swing.JMenuBar;

public class MainMenu  extends JMenuBar{
    private MenuFile menuFile;
    private MenuEdit menuEdit ;
    private MenuSearch menuSearch ;
    private MenuLanguage menuLanguage;
    private MenuWindow menuWindow;

    public MainMenu (EditorWindow editorWindow, MyTree tree, MainWindow parentFrame){
        menuFile = new MenuFile(editorWindow, tree, parentFrame);
        menuEdit = new MenuEdit(editorWindow);
        menuSearch = new MenuSearch(editorWindow, parentFrame);
        menuLanguage = new MenuLanguage(editorWindow);
        menuWindow = new MenuWindow(editorWindow);

        add(menuFile);
        add(menuEdit);
        add(menuSearch);
        add(menuLanguage);
        add(menuWindow);
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

    public void addItem(String windowName){
        menuWindow.addItem(windowName);
    }

    public void setSelectedItem(int index){
        menuWindow.setSelectedItem(index);
    }

    public void removeItem(int index) {
        menuWindow.removeItem(index);
    }
}
