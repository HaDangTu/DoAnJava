package notepad.ui;

import notepad.listener.MenuEditActionListener;

import javax.swing.JMenuItem;

import javax.swing.KeyStroke;


import java.awt.event.KeyEvent;
import java.awt.Toolkit;


class MenuEdit extends Menu{
    private JMenuItem editUndo;
    private JMenuItem editRedo;

    private JMenuItem editCut;
    private JMenuItem editCopy;
    private JMenuItem editPaste;

    private JMenuItem editDelete;

    private JMenuItem editSelectAll;

    private MenuEditActionListener editListener;

    public MenuEdit(EditorWindow editorWindow, MainWindow parentFrame){
        super("Edit", parentFrame);
        editListener = new MenuEditActionListener(editorWindow);

        editUndo = new JMenuItem("Undo");
        editUndo.setEnabled(false);
        editUndo.setIcon(imageManager.get("undo"));
        editUndo.addActionListener(editListener);
        editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editRedo = new JMenuItem("Redo");
        editRedo.setEnabled(false);
        editRedo.setIcon(imageManager.get("redo"));
        editRedo.addActionListener(editListener);
        editRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editCut = new JMenuItem("Cut");
        editCut.setIcon(imageManager.get("cut"));
        editCut.addActionListener(editListener);
        editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editCopy = new JMenuItem("Copy");
        editCopy.setIcon(imageManager.get("copy"));
        editCopy.addActionListener(editListener);
        editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        editPaste = new JMenuItem("Paste");
        editPaste.setIcon(imageManager.get("paste"));
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
