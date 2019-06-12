package notepad.ui;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuView extends JMenu{

    private JCheckBoxMenuItem wordWrap;
    private JCheckBoxMenuItem workspace;
    private JCheckBoxMenuItem statusBar;
    private JCheckBoxMenuItem toolBar;
    private JCheckBoxMenuItem lineNumber;

    private MainWindow mainWindow;
    private EditorWindow editorWindow;

    public MenuView (EditorWindow editorWindow, MainWindow mainWindow){
        super("View");

        this.editorWindow = editorWindow;
        this.mainWindow = mainWindow;

        createWordWrap();
        createWorkspace();
        createStatusBar();
        createToolBar();
        createLineNumber();

        add(wordWrap);
        add(workspace);
        add(statusBar);
        add(toolBar);
        add(lineNumber);
    }

    private void createWordWrap(){
        wordWrap = new JCheckBoxMenuItem("Word wrap");
        wordWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editorWindow.setWordWrapAllTab(wordWrap.isSelected());
            }
        });
    }

    private void createWorkspace(){
        workspace = new JCheckBoxMenuItem("Workspace");
        workspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setWorkspaceVisible(workspace.isSelected());
            }
        });
    }

    private void createStatusBar(){
        statusBar = new JCheckBoxMenuItem("Status bar");
        statusBar.setSelected(true);
        statusBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setStatusBarVisible(statusBar.isSelected());
            }
        });
    }

    private void createToolBar(){
        toolBar = new JCheckBoxMenuItem("Tool bar");
        toolBar.setSelected(true);
        toolBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setTooBarVisible(toolBar.isSelected());
            }
        });
    }

    private void createLineNumber(){
        lineNumber = new JCheckBoxMenuItem("Line number");
        lineNumber.setSelected(true);
        lineNumber.addActionListener((ActionEvent e)->{
            editorWindow.setLineNumberEnabledAllTab(lineNumber.isSelected());
        });
    }
    public void setSelectedWordWrap(boolean isSelected){
        wordWrap.setSelected(isSelected);
    }

    public void setSelectedWorkspace(boolean isSelected){
        workspace.setSelected(isSelected);
    }
}
