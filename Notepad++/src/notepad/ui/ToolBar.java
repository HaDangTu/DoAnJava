package notepad.ui;
import notepad.listener.ToolBarButtonsListener;

import notepad.util.ImageManager;

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

    private ImageManager imageManager;

    public ToolBar(JFileChooser fileChooser, EditorWindow editorWindow, Tree tree, MainWindow parentFrame){
        super();
        ToolBarButtonsListener listener = new ToolBarButtonsListener(fileChooser, editorWindow,
                tree, parentFrame);

        imageManager = parentFrame.getImageManager();

        JButton buttonNewFile = new JButton(imageManager.get("new"));
        buttonNewFile.addActionListener(listener);
        buttonNewFile.setActionCommand("New");
        buttonNewFile.setToolTipText("New");

        JButton buttonOpen = new JButton(imageManager.get("open"));
        buttonOpen.setActionCommand("Open file");
        buttonOpen.setToolTipText("Open");
        buttonOpen.addActionListener(listener);

        buttonSave = new JButton(imageManager.get("save"));
        buttonSave.addActionListener(listener);
        buttonSave.setActionCommand("Save file");
        buttonSave.setToolTipText("Save");
        buttonSave.setEnabled(false);

        buttonSaveAll = new JButton(imageManager.get("save_all"));
        buttonSaveAll.addActionListener(listener);
        buttonSaveAll.setActionCommand("Save all");
        buttonSaveAll.setToolTipText("Save all");
        buttonSaveAll.setEnabled(false);

        JButton buttonClose = new JButton(imageManager.get("close_file"));
        buttonClose.addActionListener(listener);
        buttonClose.setActionCommand("Close file");
        buttonClose.setToolTipText("Close file");

        JButton buttonCloseAll = new JButton(imageManager.get("close_all"));
        buttonCloseAll.addActionListener(listener);
        buttonCloseAll.setActionCommand("Close all");
        buttonCloseAll.setToolTipText("Close all");

        //JButton buttonPrint = new JButton(new ImageIcon("icon\\print.png"));
        JButton buttonOpenTree = new JButton(imageManager.get("directory"));
        buttonOpenTree.addActionListener(listener);
        buttonOpenTree.setActionCommand("Open workspace");
        buttonOpenTree.setToolTipText("Open workspace");

        buttonCut = new JButton(imageManager.get("cut"));
        buttonCut.addActionListener(listener);
        buttonCut.setActionCommand("Cut");
        buttonCut.setToolTipText("Cut");

        buttonCopy = new JButton(imageManager.get("copy"));
        buttonCopy.addActionListener(listener);;
        buttonCopy.setActionCommand("Copy");
        buttonCopy.setToolTipText("Copy");

        buttonPaste = new JButton(imageManager.get("paste"));
        buttonPaste.addActionListener(listener);
        buttonPaste.setActionCommand("Paste");
        buttonPaste.setToolTipText("Paste");

        buttonUndo = new JButton(imageManager.get("undo"));
        buttonUndo.addActionListener(listener);
        buttonUndo.setActionCommand("Undo");
        buttonUndo.setToolTipText("Undo");
        buttonUndo.setEnabled(false);

        buttonRedo = new JButton(imageManager.get("redo"));
        buttonRedo.addActionListener(listener);
        buttonRedo.setActionCommand("Redo");
        buttonRedo.setToolTipText("Redo");
        buttonRedo.setEnabled(false);

        JButton buttonFind = new JButton(imageManager.get("find"));
        buttonFind.addActionListener(listener);
        buttonFind.setActionCommand("Find");
        buttonFind.setToolTipText("Find");

        JButton buttonReplace = new JButton(imageManager.get("replace"));
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
