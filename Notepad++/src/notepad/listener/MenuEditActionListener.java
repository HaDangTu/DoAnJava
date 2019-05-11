package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class MenuEditActionListener extends MenuMainWindowListener{

    public MenuEditActionListener(EditorWindow editorWindow) {
        super(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        UndoManager undoManager = textEditor.getUndoManger();
        if (command.equalsIgnoreCase("Undo")){
            if (undoManager.canUndo())
                undoManager.undo();
            else
                System.err.println("Can't undo");
        }
        else if (command.equalsIgnoreCase("Redo")){
            if (undoManager.canRedo())
                undoManager.redo();
            else
                System.err.println("Can't redo");
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
        else if (command.equalsIgnoreCase("Delete")){

        }
        else if (command.equalsIgnoreCase("Select All")){
            textArea.selectAll();
        }
    }
}
