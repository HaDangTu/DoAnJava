package notepad.listener;
import notepad.ui.EditorWindow;
import notepad.ui.MyTree;
import notepad.ui.MainWindow;
import notepad.ui.TextEditor;
import notepad.ui.SearchDialog;

import notepad.util.OpenAndSaveFile;
import notepad.util.TabInteraction;

import javax.swing.JFileChooser;
import javax.swing.undo.UndoManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class ToolBarButtonsListener implements ActionListener {
    private EditorWindow editorWindow;
    private JFileChooser fileChooser;
    private MyTree tree;
    private MainWindow parentFrame;

    private TabInteraction tabInteraction;
    public ToolBarButtonsListener(JFileChooser fileChooser, EditorWindow editorWindow,
                                  MyTree tree, MainWindow parentFrame){

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

        SearchDialog dialog = new SearchDialog(parentFrame, editorWindow);

        if (command.equalsIgnoreCase("New"))
            editorWindow.addTabEditor();
        else if (command.equalsIgnoreCase("Open file")){
            openAndSaveFile.openFile();
        }
        else if (command.equalsIgnoreCase("Open workspace")){
            openAndSaveFile.openDirectory();
        }
        else if (command.equalsIgnoreCase("Save file")){
            openAndSaveFile.saveFile(textEditor, index);
        }
        else if (command.equalsIgnoreCase("Save all")){
            openAndSaveFile.saveAllFile();
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
            UndoManager undoManager = textEditor.getUndoManger();
            if (undoManager.canUndo()) {
                undoManager.undo();

                if (undoManager.canRedo())
                    parentFrame.setButtonRedoEnabled(true);
                else
                    parentFrame.setButtonRedoEnabled(false);
            }
            else parentFrame.setButtonUndoEnabled(false);
        }
        else if (command.equalsIgnoreCase("Redo")){
            UndoManager undoManager = textEditor.getUndoManger();
            if (undoManager.canRedo()){
                undoManager.redo();

                if (undoManager.canUndo())
                    parentFrame.setButtonUndoEnabled(true);
            }
            else
                parentFrame.setButtonRedoEnabled(false);
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
