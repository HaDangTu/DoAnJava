package notepad.ui;

import notepad.listener.MenuFileActionActionListener;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

class MenuFile extends Menu {
    private JMenu fileNew;
    private JMenu fileOpen;

    private JMenuItem fileSave;
    private JMenuItem fileSaveAs;
    private JMenuItem fileSaveAll;

    private JMenuItem fileCloseTab;
    private JMenuItem fileCloseAllTab;
    private JMenuItem fileCloseAllButThis;
    private JMenuItem fileCloseRightTab;
    private JMenuItem fileCloseLeftTab;

    private JMenuItem pageSetup;
    private JMenuItem printNow;
    private JMenuItem print;

    private JMenuItem fileExit;
    private MenuFileActionActionListener fileListener;

    public MenuFile (EditorWindow editorWindow, Tree tree, MainWindow parentFrame){
        super("File", parentFrame);
        fileListener = new MenuFileActionActionListener(editorWindow, tree, parentFrame);

        createMenuFile();
        createMenuOpen();
        createSaveItems();
        createCloseTabAndExitItems();
        createPrintAndPageSetup();

        add(fileNew);
        add(fileOpen);
        addSeparator();
        add(fileSave);
        add(fileSaveAs);
        add(fileSaveAll);
        addSeparator();
        add(pageSetup);
        add(print);
        add(printNow);
        addSeparator();
        add(fileCloseTab);
        add(fileCloseAllTab);
        add(fileCloseAllButThis);
        add(fileCloseRightTab);
        add(fileCloseLeftTab);
        addSeparator();
        add(fileExit);
    }

    private void createMenuFile(){
        fileNew = new JMenu("New");
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
    }

    private void createMenuOpen(){
        fileOpen = new JMenu("Open");
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
    }

    private void createSaveItems(){
        fileSave = new JMenuItem("Save");
        fileSave.setEnabled(false);
        fileSave.setIcon(imageManager.get("save"));
        fileSave.addActionListener(fileListener);
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        fileSaveAs = new JMenuItem("Save As...");
        fileSaveAs.setIcon(imageManager.get("save_as"));
        fileSaveAs.addActionListener(fileListener);
        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));

        fileSaveAll = new JMenuItem("Save All");
        fileSaveAll.setEnabled(false);
        fileSaveAll.setIcon(imageManager.get("save_all"));
        fileSaveAll.addActionListener(fileListener);
        fileSaveAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
    }

    private void createCloseTabAndExitItems(){
        fileCloseTab = new JMenuItem("Close tab");
        fileCloseTab.setIcon(imageManager.get("close_file"));
        fileCloseTab.addActionListener(fileListener);
        fileCloseTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                ActionEvent.CTRL_MASK));

        fileCloseAllTab = new JMenuItem("Close all tab");
        fileCloseAllTab.setIcon(imageManager.get("close_all"));
        fileCloseAllTab.addActionListener(fileListener);
        fileCloseAllTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));

        fileCloseAllButThis = new JMenuItem("Close all but this...");
        fileCloseAllButThis.addActionListener(fileListener);

        fileCloseRightTab = new JMenuItem("Close right tab...");
        fileCloseRightTab.addActionListener(fileListener);

        fileCloseLeftTab = new JMenuItem("Close left tab...");
        fileCloseLeftTab.addActionListener(fileListener);

        fileExit = new JMenuItem("Exit");
        fileExit.addActionListener(fileListener);
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
    }

    private void createPrintAndPageSetup(){
        pageSetup = new JMenuItem("Page setup");
        pageSetup.addActionListener(fileListener);

        printNow = new JMenuItem("Print now");
        printNow.addActionListener(fileListener);

        print = new JMenuItem("Print...");
        print.addActionListener(fileListener);
        print.setIcon(imageManager.get("print"));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

    public void setMenuItemSaveEnabled(boolean enabled){
        fileSave.setEnabled(enabled);
    }

    public void setMenuItemSaveAllEnabled(boolean enabled){
        fileSaveAll.setEnabled(enabled);
    }
}
