package notepad.ui;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TreePopupMenu extends JPopupMenu{
    public TreePopupMenu(){
        JMenu menuNew = new JMenu("New");
        JMenuItem newFile = new JMenuItem("New file");
        JMenuItem newFolder = new JMenuItem("New folder");

        menuNew.add(newFile);
        menuNew.add(newFolder);

        JMenuItem open = new JMenuItem("Open");

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem copyPath = new JMenuItem("Copy Path");
        JMenuItem paste = new JMenuItem("Paste");

        JMenuItem rename = new JMenuItem("Rename");
        JMenuItem delete = new JMenuItem("Delete");

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
