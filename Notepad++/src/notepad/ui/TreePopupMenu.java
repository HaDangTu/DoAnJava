package notepad.ui;
import notepad.listener.TreePopupMenuListener;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFrame;

public class TreePopupMenu extends JPopupMenu{
    public TreePopupMenu(EditorWindow editorWindow, Tree tree, JFrame parentFrame){
        TreePopupMenuListener listener = new TreePopupMenuListener(editorWindow, tree, parentFrame);

        JMenu menuNew = new JMenu("New");
        JMenuItem newFile = new JMenuItem("New file");
        newFile.addActionListener(listener);
        JMenuItem newFolder = new JMenuItem("New folder");
        newFolder.addActionListener(listener);

        menuNew.add(newFile);
        menuNew.add(newFolder);

        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(listener);

        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(listener);

        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(listener);

        JMenuItem copyPath = new JMenuItem("Copy Path");
        copyPath.addActionListener(listener);
        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(listener);

        JMenuItem rename = new JMenuItem("Rename");
        rename.addActionListener(listener);
        JMenuItem delete = new JMenuItem("Delete");
        delete.addActionListener(listener);

        add(menuNew);
        add(open);
        addSeparator();
        add(cut);
        add(copy);
        add(copyPath);
        add(paste);
        addSeparator();
        add(rename);
        add(delete);
    }

}
