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
}
