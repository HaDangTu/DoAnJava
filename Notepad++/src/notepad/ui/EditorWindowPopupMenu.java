package notepad.ui;

import notepad.listener.EditorWindowPopupMenuListener;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class EditorWindowPopupMenu extends JPopupMenu{
    private EditorWindowPopupMenuListener listener;

    public EditorWindowPopupMenu(EditorWindow editorWindow){

        listener = new EditorWindowPopupMenuListener(editorWindow);
        createCloseMenuItems();
        createSaveMenuItems();
        createPrintAndRenameItems();

    }

    private void createCloseMenuItems(){
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(listener);
        JMenuItem closeAllButThis = new JMenuItem("Close all but this");
        closeAllButThis.addActionListener(listener);
        JMenuItem closeLeftTab = new JMenuItem("Close left tab");
        closeLeftTab.addActionListener(listener);
        JMenuItem closeRightTab = new JMenuItem("Close right tab");
        closeRightTab.addActionListener(listener);

        add(close);
        add(closeAllButThis);
        add(closeLeftTab);
        add(closeRightTab);
        addSeparator();
    }

    private void createSaveMenuItems(){
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(listener);
        JMenuItem saveAs = new JMenuItem("Save as");
        saveAs.addActionListener(listener);
        add(save);
        add(saveAs);
        addSeparator();
    }

    private void createPrintAndRenameItems(){
        JMenuItem rename = new JMenuItem("Rename");
        rename.addActionListener(listener);
        JMenuItem print = new JMenuItem("Print");
        print.addActionListener(listener);

        add(rename);
        add(print);
    }
}
