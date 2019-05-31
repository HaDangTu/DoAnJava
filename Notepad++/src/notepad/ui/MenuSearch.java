package notepad.ui;

import notepad.listener.MenuSearchActionListener;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

class MenuSearch extends JMenu{
    private JMenuItem searchFind;
    private JMenuItem searchFindNext;
    private JMenuItem searchFindPrevious;
    private JMenuItem searchReplace;
    private JMenuItem incrementalSearch;
    private JMenuItem searchGoto;
    private JMenuItem searchMark;

    private MenuSearchActionListener searchListener;

    public MenuSearch(EditorWindow editorWindow, MainWindow parentFrame){
        super("Search");
        searchListener = new MenuSearchActionListener(editorWindow, parentFrame);

        createSearchMenu();

        add(searchFind);
        add(searchFindNext);
        add(searchFindPrevious);
        add(searchReplace);
        add(incrementalSearch);
        addSeparator();
        add(searchGoto);
        add(searchMark);
    }

    private void createSearchMenu(){
        searchFind = new JMenuItem("Find");
        searchFind.setIcon(new ImageIcon("icon\\find.png"));
        searchFind.addActionListener(searchListener);
        searchFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        searchFindNext = new JMenuItem("Find Next");
        searchFindNext.addActionListener(searchListener);
        searchFindNext.setAccelerator(KeyStroke.getKeyStroke("F3"));

        searchFindPrevious = new JMenuItem("Find Previous");
        searchFindPrevious.addActionListener(searchListener);
        searchFindPrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                ActionEvent.SHIFT_MASK));

        searchReplace = new JMenuItem("Replace");
        searchReplace.setIcon(new ImageIcon("icon\\replace.png"));
        searchReplace.addActionListener(searchListener);
        searchReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        incrementalSearch = new JMenuItem("Incremental Search");
        incrementalSearch.addActionListener(searchListener);
        incrementalSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));

        searchGoto = new JMenuItem("Go to...");
        searchGoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        searchGoto.addActionListener(searchListener);

        searchMark = new JMenuItem("Mark...");
        searchMark.addActionListener(searchListener);
    }
}
