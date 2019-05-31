package notepad.ui;
import notepad.listener.MenuFileActionListener;
import notepad.listener.MenuEditActionListener;
import notepad.listener.MenuLanguageActionListener;
import notepad.listener.MenuSearchActionListener;
import notepad.listener.WindowFocusListener;

import notepad.util.StatusBarTimer;

import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import java.lang.Exception;

public class MainWindow extends  JFrame{

    private MenuLanguageActionListener langListener;
    private MenuEditActionListener editListener;
    private MenuSearchActionListener searchListener;


    private MainMenu mainMenu;
    private ToolBar toolBar;

    private EditorView editorView;
    private TreeView treeView;
    private SearchStatusBar searchStatusBar;

    private JPanel panel;

    private JSplitPane splitPane;

    private StatusBarTimer timer;

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

        editorView = new EditorView();
        EditorWindow editorWindow = editorView.getEditorWindow();
        treeView = new TreeView(editorWindow, this);
        searchStatusBar = new SearchStatusBar(editorWindow);

        mainMenu = new MainMenu(editorWindow, treeView.getTree(), this);

        langListener = new MenuLanguageActionListener(editorWindow);
        editListener = new MenuEditActionListener(editorWindow);
        searchListener = new MenuSearchActionListener(editorWindow, this);

        panel = new JPanel(new BorderLayout());


        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeView, editorView);

        initSplitPane();


        toolBar = new ToolBar(new JFileChooser(), editorWindow, treeView.getTree(), this);

        panel.add(toolBar, BorderLayout.PAGE_START);
        panel.add(splitPane,BorderLayout.CENTER);
        panel.add(searchStatusBar, BorderLayout.SOUTH);

        this.setJMenuBar(mainMenu);
        this.setTitle("Notepad++");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.addWindowFocusListener(new WindowFocusListener(editorWindow));

        timer = new StatusBarTimer(searchStatusBar.getStatusBar(), editorWindow);
    }

    private void initSplitPane(){
        splitPane.setDividerLocation(200);
        splitPane.setResizeWeight(0.2);
        Dimension minimumSize = new Dimension(200, 600);
        treeView.setMinimumSize(minimumSize);
        editorView.setMinimumSize(minimumSize);
    }

    public void setVisiblePanelSearchIncremental(boolean visible){
        searchStatusBar.setSearchBarVisible(visible);
    }

    public EditorWindow getEditorWindow() {return editorView.getEditorWindow();}

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
