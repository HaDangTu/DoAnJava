package notepad.ui;
import notepad.listener.EditorWindowMouseListener;
import notepad.listener.MainWindowListener;
import notepad.listener.WindowFocusListener;
import notepad.listener.TabChangeListener;

import notepad.util.StatusBarTimer;
import notepad.util.ImageManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

import java.lang.Exception;

public class MainWindow extends  JFrame{
    private MainMenu mainMenu;
    private ToolBar toolBar;

    private EditorView editorView;
    private TreeView treeView;
    private SearchStatusBar searchStatusBar;

    private JPanel panel;

    private JSplitPane splitPane;

    private StatusBarTimer timer;

    protected ImageManager imageManager;

    public MainWindow(){
        super();
        imageManager = ImageManager.getInstance();
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);

            loadComponent();

            this.pack();
            this.setVisible(true);
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    private void loadComponent() {
        editorView = new EditorView();
        EditorWindow editorWindow = editorView.getEditorWindow();
        treeView = new TreeView(editorWindow, this);
        searchStatusBar = new SearchStatusBar(editorWindow);

        mainMenu = new MainMenu(editorWindow, treeView.getTree(), this);

        editorWindow.addChangeListener(new TabChangeListener(this, editorWindow));


        BorderLayout layout =  new BorderLayout();
        panel = new JPanel();
        panel.setLayout(layout);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeView, editorView);

        initSplitPane();

        toolBar = new ToolBar(new JFileChooser(), editorWindow, treeView.getTree(), this);

        panel.add(splitPane,BorderLayout.CENTER);
        panel.add(toolBar, BorderLayout.PAGE_START);
        panel.add(searchStatusBar, BorderLayout.PAGE_END);


        this.setJMenuBar(mainMenu);
        this.getContentPane().add(panel);
        this.addWindowFocusListener(new WindowFocusListener(editorWindow));

        this.setPreferredSize(new Dimension(1000, 600));
        this.setMaximumSize(new Dimension(1366, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.setTitle("Notepad++");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        editorWindow.addMouseListener(new EditorWindowMouseListener(editorWindow));
        timer = new StatusBarTimer(searchStatusBar.getStatusBar(), editorWindow);
        addWindowListener(new MainWindowListener(editorWindow));
    }

    private void initSplitPane(){
        splitPane.setDividerLocation(200);
        splitPane.setResizeWeight(0);
        Dimension minimumSize = new Dimension(200, 600);
        splitPane.getLeftComponent().setMinimumSize(minimumSize);
        splitPane.getRightComponent().setMinimumSize(minimumSize);
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

    public void setMenuItemSaveEnabled(boolean enabled){
        mainMenu.setMenuSaveEnabled(enabled);
    }

    public void setMenuItemSaveAllEnabled(boolean enabled){
        mainMenu.setMenuSaveAllEnabled(enabled);
    }

    public void setSelectedLangItem(String extension){
        mainMenu.setSelectedItem(extension);
    }

    public void setMenuItemUndoEnabled(boolean enabled){
        mainMenu.setMenuUndoEnabled(enabled);
    }

    public void setMenuItemRedoEnabled(boolean enabled){
        mainMenu.setMenuRedoEnabled(enabled);
    }

    public void addItem(String windowName){
        mainMenu.addItem(windowName);
    }

    public void setSelectedWindowItem(int index){
        mainMenu.setSelectedItem(index);
    }

    public void removeItem(int index){
        mainMenu.removeItem(index);
    }

    public void setTooBarVisible(boolean visible){
        toolBar.setVisible(visible);
    }

    public void setWorkspaceVisible(boolean visible){
        splitPane.resetToPreferredSizes();
        treeView.setVisible(visible);
    }

    public void setStatusBarVisible(boolean visible){
        searchStatusBar.setVisible(visible);
    }

    public void setSelectedWorkspace (boolean isSelected) {
        mainMenu.setSelectedWorkspace(isSelected);
    }

    public void resetSlitPane(){
        setSelectedWorkspace(true);
        setWorkspaceVisible(true);
    }

    public ImageManager getImageManager(){
        return this.imageManager;
    }
}
