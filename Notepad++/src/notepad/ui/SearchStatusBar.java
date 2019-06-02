package notepad.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SearchStatusBar extends JPanel {

    private SearchBar searchBar;
    private StatusBar statusBar;

    public SearchStatusBar(EditorWindow editorWindow){
        searchBar = new SearchBar(editorWindow);
        statusBar = new StatusBar(editorWindow);

        setLayout(new BorderLayout());
        add(searchBar, BorderLayout.NORTH);
        add(statusBar, BorderLayout.SOUTH);
    }

    public void setSearchBarVisible(boolean visible){
        searchBar.setVisible(visible);
    }

    public StatusBar getStatusBar(){
        return statusBar;
    }

    public void setStatusBarVisible(boolean visible){
        statusBar.setVisible(visible);
    }
}
