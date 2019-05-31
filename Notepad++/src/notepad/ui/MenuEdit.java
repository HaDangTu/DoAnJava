package notepad.ui;

import notepad.listener.MenuEditActionListener;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;


class MenuEdit extends JMenu{
    private JMenuItem editUndo;
    private JMenuItem editRedo;

    private JMenuItem editCut;
    private JMenuItem editCopy;
    private JMenuItem editPaste;

    private JMenuItem editDelete;

    private JMenuItem editSelectAll;

    private MenuEditActionListener editListener;

    public MenuEdit(EditorWindow editorWindow){
        super("Edit");
        editListener = new MenuEditActionListener(editorWindow);
        editUndo = new JMenuItem("Undo");
        editUndo.setEnabled(false);
        editUndo.setIcon(new ImageIcon("icon\\undo.png"));
        editUndo.addActionListener(editListener);
        editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editRedo = new JMenuItem("Redo");
        editRedo.setEnabled(false);
        editRedo.setIcon(new ImageIcon("icon\\redo.png"));
        editRedo.addActionListener(editListener);
        editRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editCut = new JMenuItem("Cut");
        editCut.setIcon(new ImageIcon("icon\\cut.png"));
        editCut.addActionListener(editListener);
        editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editCopy = new JMenuItem("Copy");
        editCopy.setIcon(new ImageIcon("icon\\copy.png"));
        editCopy.addActionListener(editListener);
        editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editPaste = new JMenuItem("Paste");
        editPaste.setIcon(new ImageIcon("icon\\paste.png"));
        editPaste.addActionListener(editListener);
        editPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editDelete = new JMenuItem("Delete");
        editDelete.addActionListener(editListener);

        editSelectAll = new JMenuItem("Select All");
        editSelectAll.addActionListener(editListener);
        editSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        add(editUndo);
        add(editRedo);
        addSeparator();
        add(editCut);
        add(editCopy);
        add(editPaste);
        add(editDelete);
        addSeparator();
        add(editSelectAll);
    }

    public void setMenuItemUndoEnabled(boolean enabled){
        editUndo.setEnabled(enabled);
    }

    public void setMenuItemRedoEnabled(boolean enabled){
        editRedo.setEnabled(enabled);
    }
}
