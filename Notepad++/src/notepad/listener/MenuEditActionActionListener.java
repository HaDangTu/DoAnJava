package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;

import notepad.util.UndoAndRedo;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import java.awt.event.ActionEvent;

public class MenuEditActionActionListener extends MenuMainWindowActionListener {

    public MenuEditActionActionListener(EditorWindow editorWindow) {
        super(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        UndoAndRedo undoAndRedo = new UndoAndRedo(textEditor);
        if (command.equalsIgnoreCase("Undo")){
            undoAndRedo.undoAction();
        }
        else if (command.equalsIgnoreCase("Redo")){
            undoAndRedo.redoAction();
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
            int start = textArea.getSelectionStart();
            int end = textArea.getSelectionEnd();

            if (Math.abs(end - start) > 0)
                textArea.setText(textArea.getText().replace(textArea.getSelectedText(), ""));
        }
        else if (command.equalsIgnoreCase("Select All")){
            textArea.selectAll();
        }
    }
}
