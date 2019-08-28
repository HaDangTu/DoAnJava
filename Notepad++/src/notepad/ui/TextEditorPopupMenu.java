package notepad.ui;

import notepad.listener.TextEditorPopupMenuListener;
import notepad.util.ImageManager;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class TextEditorPopupMenu  extends JPopupMenu{
    private JMenuItem undo;
    private JMenuItem redo;

    private JMenuItem copy;
    private JMenuItem cut;
    private JMenuItem paste;

    private JMenuItem delete;

    private JMenuItem select;

    private TextEditorPopupMenuListener listener;
    public TextEditorPopupMenu(TextEditor textEditor){
        super();

        listener = new TextEditorPopupMenuListener(textEditor);


        undo = new JMenuItem("Undo");
//        undo.setIcon(imageManager.get("undo"));
        undo.setEnabled(false);
        undo.addActionListener(listener);

        redo = new JMenuItem("Redo");
        redo.setEnabled(false);
//        redo.setIcon(imageManager.get("redo"));
        redo.addActionListener(listener);

        cut = new JMenuItem("Cut");
//        cut.setIcon(imageManager.get("cut"));
        cut.addActionListener(listener);

        copy = new JMenuItem("Copy");
//        copy.setIcon(imageManager.get("copy"));
        copy.addActionListener(listener);

        paste = new JMenuItem("Paste");
//        paste.setIcon(imageManager.get("paste"));
        paste.addActionListener(listener);

        delete = new JMenuItem("Delete");
        delete.addActionListener(listener);

        select = new JMenuItem("Select all");
        select.addActionListener(listener);

        add(undo);
        add(redo);
        addSeparator();
        add(cut);
        add(copy);
        add(paste);
        addSeparator();
        add(delete);
        add(select);
    }

    public void setUndoEnabled(boolean enabled){
        undo.setEnabled(enabled);
    }

    public void setRedoEnabled(boolean enabled){
        redo.setEnabled(enabled);
    }
}