package notepad.ui;
import notepad.listener.TreePopupMenuListener;
import notepad.util.ImageManager;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFrame;

public class TreePopupMenu extends JPopupMenu{
    public TreePopupMenu(EditorWindow editorWindow, Tree tree, JFrame parentFrame){
        TreePopupMenuListener listener = new TreePopupMenuListener(editorWindow, tree, parentFrame);

        ImageManager imageManager = ((MainWindow) parentFrame).getImageManager();

        JMenu menuNew = new JMenu("New");
        JMenuItem newFile = new JMenuItem("New file");
        newFile.setIcon(imageManager.get("new"));
        newFile.addActionListener(listener);

        JMenuItem newFolder = new JMenuItem("New folder");
        newFolder.addActionListener(listener);
        newFolder.setIcon(imageManager.get("folder"));

        menuNew.add(newFile);
        menuNew.add(newFolder);

        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(listener);
        open.setIcon(imageManager.get("open"));

        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(listener);
        cut.setIcon(imageManager.get("cut"));

        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(listener);
        copy.setIcon(imageManager.get("copy"));

        JMenuItem copyPath = new JMenuItem("Copy Path");
        copyPath.addActionListener(listener);

        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(listener);
        paste.setIcon(imageManager.get("paste"));

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
