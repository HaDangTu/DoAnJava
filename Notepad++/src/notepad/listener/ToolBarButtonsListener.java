package notepad.listener;
import notepad.ui.EditorWindow;
import notepad.ui.Tree;
import notepad.ui.MainWindow;
import notepad.ui.TextEditor;
import notepad.ui.SearchDialog;

import notepad.util.OpenAndSaveFile;
import notepad.util.TabInteraction;
import notepad.util.UndoAndRedo;

import javax.swing.JFileChooser;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class ToolBarButtonsListener implements ActionListener {
    private EditorWindow editorWindow;
    private JFileChooser fileChooser;
    private Tree tree;
    private MainWindow parentFrame;

    private TabInteraction tabInteraction;
    public ToolBarButtonsListener(JFileChooser fileChooser, EditorWindow editorWindow,
                                  Tree tree, MainWindow parentFrame){

        this.editorWindow = editorWindow;
        this.fileChooser = fileChooser;
        this.tree = tree;
        this.parentFrame = parentFrame;
        tabInteraction = new TabInteraction(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();
        OpenAndSaveFile openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, tree, parentFrame);

        UndoAndRedo undoAndRedo = new UndoAndRedo(textEditor);
        SearchDialog dialog = new SearchDialog(parentFrame, editorWindow);

        if (command.equalsIgnoreCase("New")) {
            editorWindow.addTabEditor();
            int pos = editorWindow.getTabCount() - 1;
            editorWindow.setSelectedIndex(pos);
            editorWindow.getTextEditor(pos).getTextArea().requestFocusInWindow();
            parentFrame.addItem(editorWindow.getTitleOfTab(pos));
        }
        else if (command.equalsIgnoreCase("Open file")){
            openAndSaveFile.openFile();
        }
        else if (command.equalsIgnoreCase("Open workspace")){
            openAndSaveFile.openDirectory();
        }
        else if (command.equalsIgnoreCase("Save file")){
            openAndSaveFile.saveFile(textEditor, index);
            parentFrame.setButtonSaveEnabled(false);
            parentFrame.setMenuItemSaveEnabled(false);
            if (editorWindow.isSavedAll()) {
                parentFrame.setButtonSaveAllEnabled(false);
                parentFrame.setMenuItemSaveAllEnabled(false);
            }
        }
        else if (command.equalsIgnoreCase("Save all")){
            openAndSaveFile.saveAllFile();
            parentFrame.setButtonSaveEnabled(false);
            parentFrame.setMenuItemSaveEnabled(false);
            parentFrame.setButtonSaveAllEnabled(false);
            parentFrame.setMenuItemSaveAllEnabled(false);
        }
        else if (command.equalsIgnoreCase("Close file")){
            tabInteraction.closeTabAt(fileChooser, index);
        }
        else if (command.equalsIgnoreCase("Close all")){
            tabInteraction.closeAllTab(fileChooser);
        }
        else if (command.equalsIgnoreCase("Cut")){
            textArea.cut();
        }
        else if (command.equalsIgnoreCase("Copy")){
            textArea.copy();
        }
        else if (command.equalsIgnoreCase("Paste")){
            textArea.paste();
        }
        else if (command.equalsIgnoreCase("Undo")){
            undoAndRedo.undoAction();
        }
        else if (command.equalsIgnoreCase("Redo")){
            undoAndRedo.redoAction();
        }
        else if (command.equalsIgnoreCase("Find")){
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Replace")){
            dialog.setSelectedTab(1);
            dialog.showDialog();
        }
    }
}
