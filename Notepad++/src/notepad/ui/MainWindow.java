package notepad.ui;
import notepad.listener.MenuFileActionListener;
import notepad.listener.MenuEditActionListener;
import notepad.listener.MenuLanguageActionListener;
import notepad.listener.MenuSearchActionListener;
import notepad.listener.TreeMouseListener;
import notepad.listener.WindowFocusListener;

import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import java.lang.Exception;

public class MainWindow extends  JFrame{

    private MenuLanguageActionListener langListener;
    private MenuFileActionListener fileListener;
    private MenuEditActionListener editListener;
    private MenuSearchActionListener searchListener;
    private TreeMouseListener treeMouseListener;

    private JMenuBar mainMenu;
    private ToolBar toolBar;

    private EditorWindow editorWindow;

    private MyTree myTree;

    private JPanel panel;
    //private JPanel panelIncrementalSearch;
    private SearchBar searchBar;

    private JScrollPane treeScrollPane;
    private JSplitPane splitPane;

    public MainWindow(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        loadComponent();
    }

    private void loadComponent() {
        mainMenu = new JMenuBar();

        editorWindow = new EditorWindow();

        myTree = new MyTree(null);

        langListener = new MenuLanguageActionListener(editorWindow);
        fileListener = new MenuFileActionListener(editorWindow, myTree, this);
        editListener = new MenuEditActionListener(editorWindow);
        searchListener = new MenuSearchActionListener(editorWindow, this);

        panel = new JPanel(new BorderLayout());

        treeScrollPane = new JScrollPane(myTree);
        treeMouseListener = new TreeMouseListener(myTree, editorWindow);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, editorWindow);
        myTree.addMouseListener(treeMouseListener);

        //Menu File
        initMenuFile();
        //-------------------------------------------------------------------------------------

        //Menu Edit
        initMenuEdit();
        //-------------------------------------------------------------------------------------

        //Menu Search
        initMenuSearch();
        //-------------------------------------------------------------------------------------

        //Menu Language
        initMenuLanguage();
        //-------------------------------------------------------------------------------------

        //Innit split pane
        initSplitPane();
        //-------------------------------------------------------------------------------------

        //Init search incremental
        searchBar = new SearchBar(editorWindow);
        //-------------------------------------------------------------------------------------

        //Init tool bar
        toolBar = new ToolBar(fileListener.getFileChooser(), editorWindow, myTree, this);
        //-------------------------------------------------------------------------------------
        panel.add(toolBar, BorderLayout.PAGE_START);
        panel.add(splitPane,BorderLayout.CENTER);
        panel.add(searchBar, BorderLayout.SOUTH);

        this.setJMenuBar(mainMenu);
        this.setTitle("Notepad++");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.addWindowFocusListener(new WindowFocusListener(editorWindow));
    }

    private void initMenuFile(){
        JMenu menuFile = new JMenu("File");
        JMenu fileNew = new JMenu("New");
        fileNew.setIcon(new ImageIcon("icon\\new.png"));

        JMenuItem newFile = new JMenuItem("New file");
        newFile.addActionListener(fileListener);
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem newC = new JMenuItem("C file");
        newC.addActionListener(fileListener);

        JMenuItem newCplusplus = new JMenuItem("C++ file");
        newCplusplus.addActionListener(fileListener);

        JMenuItem newCSharp = new JMenuItem("C# file");
        newCSharp.addActionListener(fileListener);

        JMenuItem newPython = new JMenuItem("Python file");
        newPython.addActionListener(fileListener);

        JMenuItem newPhp = new JMenuItem("PHP file");
        newPhp.addActionListener(fileListener);

        JMenuItem newJava = new JMenuItem("Java file");
        newJava.addActionListener(fileListener);

        JMenuItem newJavaScript = new JMenuItem("JavaScript file");
        newJavaScript.addActionListener(fileListener);

        JMenuItem newJSon = new JMenuItem("JSON file");
        newJSon.addActionListener(fileListener);

        JMenuItem newOtherFile = new JMenuItem("Other file");
        newOtherFile.addActionListener(fileListener);
        newOtherFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));

        fileNew.add(newFile);
        fileNew.addSeparator();
        fileNew.add(newC);
        fileNew.add(newCplusplus);
        fileNew.add(newCSharp);
        fileNew.add(newPython);
        fileNew.add(newPhp);
        fileNew.add(newPython);
        fileNew.add(newJava);
        fileNew.add(newJavaScript);
        fileNew.add(newJSon);
        fileNew.addSeparator();
        fileNew.add(newOtherFile);


        JMenu fileOpen = new JMenu("Open");
        fileOpen.setIcon(new ImageIcon("icon\\open.png"));

        JMenuItem openFolder = new JMenuItem("Open directory");
        openFolder.addActionListener(fileListener);
        openFolder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));

        JMenuItem openFile = new JMenuItem("Open file");
        openFile.addActionListener(fileListener);
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        fileOpen.add(openFolder);
        fileOpen.add(openFile);

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.setIcon(new ImageIcon("icon\\save.png"));
        fileSave.addActionListener(fileListener);
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem fileSaveAs = new JMenuItem("Save As...");
        fileSaveAs.setIcon(new ImageIcon("icon\\save_as.png"));
        fileSaveAs.addActionListener(fileListener);
        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));

        JMenuItem fileSaveAll = new JMenuItem("Save All");
        fileSaveAll.setIcon(new ImageIcon("icon\\save_all.png"));
        fileSaveAll.addActionListener(fileListener);
        fileSaveAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));

        JMenuItem fileCloseTab = new JMenuItem("Close tab");
        fileCloseTab.setIcon(new ImageIcon("icon\\close_file.png"));
        fileCloseTab.addActionListener(fileListener);
        fileCloseTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                ActionEvent.CTRL_MASK));

        JMenuItem fileCloseAllTab = new JMenuItem("Close all tab");
        fileCloseAllTab.setIcon(new ImageIcon("icon\\close_all.png"));
        fileCloseAllTab.addActionListener(fileListener);
        fileCloseAllTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));

        JMenuItem fileCloseAllButThis = new JMenuItem("Close all but this...");
        fileCloseAllButThis.addActionListener(fileListener);

        JMenuItem fileCloseRightTab = new JMenuItem("Close right tab...");
        fileCloseRightTab.addActionListener(fileListener);

        JMenuItem fileCloseLeftTab = new JMenuItem("Close left tab...");
        fileCloseLeftTab.addActionListener(fileListener);

        JMenuItem fileExit = new JMenuItem("Exit");
        fileExit.addActionListener(fileListener);
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));

        menuFile.add(fileNew);
        menuFile.add(fileOpen);
        menuFile.addSeparator();
        menuFile.add(fileSave);
        menuFile.add(fileSaveAs);
        menuFile.add(fileSaveAll);
        menuFile.addSeparator();
        menuFile.add(fileCloseTab);
        menuFile.add(fileCloseAllTab);
        menuFile.add(fileCloseAllButThis);
        menuFile.add(fileCloseRightTab);
        menuFile.add(fileCloseLeftTab);
        menuFile.addSeparator();
        menuFile.add(fileExit);

        //add to main menu
        mainMenu.add(menuFile);
    }

    private void initMenuEdit(){
        JMenu menuEdit = new JMenu("Edit");
        JMenuItem editUndo = new JMenuItem("Undo");
        editUndo.setIcon(new ImageIcon("icon\\undo.png"));
        editUndo.addActionListener(editListener);
        editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem editRedo = new JMenuItem("Redo");
        editRedo.setIcon(new ImageIcon("icon\\redo.png"));
        editRedo.addActionListener(editListener);
        editRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem editCut = new JMenuItem("Cut");
        editCut.setIcon(new ImageIcon("icon\\cut.png"));
        editCut.addActionListener(editListener);
        editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem editCopy = new JMenuItem("Copy");
        editCopy.setIcon(new ImageIcon("icon\\copy.png"));
        editCopy.addActionListener(editListener);
        editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem editPaste = new JMenuItem("Paste");
        editPaste.setIcon(new ImageIcon("icon\\paste.png"));
        editPaste.addActionListener(editListener);
        editPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem editDelete = new JMenuItem("Delete");
        JMenuItem editSelectAll = new JMenuItem("Select All");
        editSelectAll.addActionListener(editListener);
        editSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        menuEdit.add(editUndo);
        menuEdit.add(editRedo);
        menuEdit.addSeparator();
        menuEdit.add(editCut);
        menuEdit.add(editCopy);
        menuEdit.add(editPaste);
        menuEdit.add(editDelete);
        menuEdit.addSeparator();
        menuEdit.add(editSelectAll);

        //Add to main menu
        mainMenu.add(menuEdit);
    }

    private void initMenuSearch(){
        JMenu menuSearch = new JMenu("Search");
        JMenuItem searchFind = new JMenuItem("Find");
        searchFind.setIcon(new ImageIcon("icon\\find.png"));
        searchFind.addActionListener(searchListener);
        searchFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem searchFindNext = new JMenuItem("Find Next");
        searchFindNext.addActionListener(searchListener);
        searchFindNext.setAccelerator(KeyStroke.getKeyStroke("F3"));

        JMenuItem searchFindPrevious = new JMenuItem("Find Previous");
        searchFindPrevious.addActionListener(searchListener);
        searchFindPrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                ActionEvent.SHIFT_MASK));

        JMenuItem searchReplace = new JMenuItem("Replace");
        searchReplace.setIcon(new ImageIcon("icon\\replace.png"));
        searchReplace.addActionListener(searchListener);
        searchReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        JMenuItem incrementalSearch = new JMenuItem("Incremental Search");
        incrementalSearch.addActionListener(searchListener);
        incrementalSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));

        JMenuItem searchGoto = new JMenuItem("Go to...");
        searchGoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        searchGoto.addActionListener(searchListener);

        JMenuItem searchMark = new JMenuItem("Mark...");
        searchMark.addActionListener(searchListener);

        menuSearch.add(searchFind);
        menuSearch.add(searchFindNext);
        menuSearch.add(searchFindPrevious);
        menuSearch.add(searchReplace);
        menuSearch.add(incrementalSearch);
        menuSearch.addSeparator();
        menuSearch.add(searchGoto);
        menuSearch.add(searchMark);

        mainMenu.add(menuSearch);
    }

    private void initMenuLanguage(){
        JMenu menuLanguage = new JMenu("Language");
        JMenu menuC = new JMenu("C");
        JMenuItem languageC = new JMenuItem("C");
        languageC.addActionListener(langListener);
        JMenuItem languageCplusplus = new JMenuItem("C++");
        languageCplusplus.addActionListener(langListener);
        JMenuItem languageCSharp = new JMenuItem("C#");
        languageCSharp.addActionListener(langListener);
        JMenuItem languageCSS = new JMenuItem("CSS");
        languageCSS.addActionListener(langListener);

        menuC.add(languageC);
        menuC.add(languageCplusplus);
        menuC.add(languageCSharp);
        menuC.add(languageCSS);

        JMenuItem normalText = new JMenuItem("Normal text");
        normalText.addActionListener(langListener);

        JMenu menuP = new JMenu("P");
        JMenuItem languagePython= new JMenuItem("Python");
        languagePython.addActionListener(langListener);
        JMenuItem languagePhp = new JMenuItem("PHP");
        languagePhp.addActionListener(langListener);
        menuP.add(languagePhp);
        menuP.add(languagePython);

        JMenu menuJ = new JMenu("J");
        JMenuItem languageJava = new JMenuItem("Java");
        languageJava.addActionListener(langListener);
        JMenuItem languageJavaScript = new JMenuItem("Java Script");
        languageJavaScript.addActionListener(langListener);
        JMenuItem languageJson = new JMenuItem("JSON");
        languageJavaScript.addActionListener(langListener);
        menuJ.add(languageJava);
        menuJ.add(languageJavaScript);
        menuJ.add(languageJson);

        JMenu menuH = new JMenu("H");
        JMenuItem languageHTML = new JMenuItem("HTML");
        languageHTML.addActionListener(langListener);
        menuH.add(languageHTML);

        JMenu menuS = new JMenu("S");
        JMenuItem languageSQL = new JMenuItem("SQL");
        languageSQL.addActionListener(langListener);
        menuS.add(languageSQL);

        JMenu menuX = new JMenu("X");
        JMenuItem languageXML = new JMenuItem("XML");
        languageXML.addActionListener(langListener);
        menuX.add(languageXML);

        menuLanguage.add(menuC);
        menuLanguage.add(normalText);
        menuLanguage.add(menuJ);
        menuLanguage.add(menuP);
        menuLanguage.add(menuH);
        menuLanguage.add(menuS);
        menuLanguage.add(menuX);

        mainMenu.add(menuLanguage);
    }

    private void initSplitPane(){
        splitPane.setDividerLocation(150);
        splitPane.setResizeWeight(0.2);
        Dimension minimumSize = new Dimension(150, 600);
        treeScrollPane.setMinimumSize(minimumSize);
        editorWindow.setMinimumSize(minimumSize);
    }

    public void setVisiblePanelSearchIncremental(boolean visible){
        searchBar.setVisible(visible);
    }

    public EditorWindow getEditorWindow() {return editorWindow;}

    public void setButtonUndoEnabled(boolean enabled){
        toolBar.setButtonUndoEnabled(enabled);
    }

    public void setButtonRedoEnabled(boolean enabled){
        toolBar.setButtonRedoEnabled(enabled);
    }

    public void setButtonSaveEnabled(boolean enabled){
        toolBar.setButtonSaveEnabled(enabled);
    }

    public void setButtonSaveAllEnabled (boolean enabled){
        toolBar.setButtonSaveAllEnabled(enabled);
    }

}
