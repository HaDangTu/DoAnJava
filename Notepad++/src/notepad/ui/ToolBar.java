package notepad.ui;
import notepad.listener.ToolBarButtonsListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar{

    private JButton buttonSave;
    private JButton buttonSaveAll;
    private JButton buttonUndo;
    private JButton buttonRedo;
    private JButton buttonCut;
    private JButton buttonCopy;
    private JButton buttonPaste;

    public ToolBar(JFileChooser fileChooser, EditorWindow editorWindow, Tree tree, MainWindow parentFrame){
        ToolBarButtonsListener listener = new ToolBarButtonsListener(fileChooser, editorWindow,
                tree, parentFrame);

        JButton buttonNewFile = new JButton(new ImageIcon("icon\\new.png"));
        buttonNewFile.addActionListener(listener);
        buttonNewFile.setActionCommand("New");
        buttonNewFile.setToolTipText("New");

        JButton buttonOpen = new JButton(new ImageIcon("icon\\open.png"));
        buttonOpen.setActionCommand("Open file");
        buttonOpen.setToolTipText("Open");
        buttonOpen.addActionListener(listener);

        buttonSave = new JButton(new ImageIcon("icon\\save.png"));
        buttonSave.addActionListener(listener);
        buttonSave.setActionCommand("Save file");
        buttonSave.setToolTipText("Save");
        buttonSave.setEnabled(false);

        buttonSaveAll = new JButton(new ImageIcon("icon\\save_all.png"));
        buttonSaveAll.addActionListener(listener);
        buttonSaveAll.setActionCommand("Save all");
        buttonSaveAll.setToolTipText("Save all");
        buttonSaveAll.setEnabled(false);

        JButton buttonClose = new JButton(new ImageIcon("icon\\close_file.png"));
        buttonClose.addActionListener(listener);
        buttonClose.setActionCommand("Close file");
        buttonClose.setToolTipText("Close file");

        JButton buttonCloseAll = new JButton(new ImageIcon("icon\\close_all.png"));
        buttonCloseAll.addActionListener(listener);
        buttonCloseAll.setActionCommand("Close all");
        buttonCloseAll.setToolTipText("Close all");

        //JButton buttonPrint = new JButton(new ImageIcon("icon\\print.png"));
        JButton buttonOpenTree = new JButton(new ImageIcon("icon\\directory.png"));
        buttonOpenTree.addActionListener(listener);
        buttonOpenTree.setActionCommand("Open workspace");
        buttonOpenTree.setToolTipText("Open workspace");

        buttonCut = new JButton(new ImageIcon("icon\\cut.png"));
        buttonCut.addActionListener(listener);
        buttonCut.setActionCommand("Cut");
        buttonCut.setToolTipText("Cut");

        buttonCopy = new JButton(new ImageIcon("icon\\copy.png"));
        buttonCopy.addActionListener(listener);;
        buttonCopy.setActionCommand("Copy");
        buttonCopy.setToolTipText("Copy");

        buttonPaste = new JButton(new ImageIcon("icon\\paste.png"));
        buttonPaste.addActionListener(listener);
        buttonPaste.setActionCommand("Paste");
        buttonPaste.setToolTipText("Paste");

        buttonUndo = new JButton(new ImageIcon("icon\\undo.png"));
        buttonUndo.addActionListener(listener);
        buttonUndo.setActionCommand("Undo");
        buttonUndo.setToolTipText("Undo");
        buttonUndo.setEnabled(false);

        buttonRedo = new JButton(new ImageIcon("icon\\redo.png"));
        buttonRedo.addActionListener(listener);
        buttonRedo.setActionCommand("Redo");
        buttonRedo.setToolTipText("Redo");
        buttonRedo.setEnabled(false);

        JButton buttonFind = new JButton(new ImageIcon("icon\\find.png"));
        buttonFind.addActionListener(listener);
        buttonFind.setActionCommand("Find");
        buttonFind.setToolTipText("Find");

        JButton buttonReplace = new JButton(new ImageIcon("icon\\replace.png"));
        buttonReplace.addActionListener(listener);
        buttonReplace.setActionCommand("Replace");
        buttonReplace.setToolTipText("Replace");

        setRollover(true);
        setFloatable(true);

        add(buttonNewFile);
        add(buttonOpen);
        add(buttonOpenTree);
        add(buttonSave);
        add(buttonSaveAll);
        add(buttonClose);
        add(buttonCloseAll);
        addSeparator();

        add(buttonCut);
        add(buttonCopy);
        add(buttonPaste);
        addSeparator();

        add(buttonUndo);
        add(buttonRedo);
        addSeparator();

        add(buttonFind);
        add(buttonReplace);
    }

    public void setButtonUndoEnabled(boolean enabled){
        buttonUndo.setEnabled(enabled);
    }

    public void setButtonRedoEnabled(boolean enabled){
        buttonRedo.setEnabled(enabled);
    }

    public void setButtonSaveEnabled(boolean enabled){
        buttonSave.setEnabled(enabled);
    }

    public void setButtonSaveAllEnabled (boolean enabled){buttonSaveAll.setEnabled(enabled);}
}
