package notepad.listener;

import notepad.ui.TextEditor;
//import notepad.ui.TextEditorPopupMenu;

import notepad.util.UndoAndRedo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class TextEditorPopupMenuListener extends BaseActionListener {
    private TextEditor textEditor;
//    private TextEditorPopupMenu popupMenu;

    public TextEditorPopupMenuListener(TextEditor textEditor){
        this.textEditor = textEditor;
//        this.popupMenu = popupMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        RSyntaxTextArea textArea = textEditor.getTextArea();
        UndoAndRedo undoAndRedo = new UndoAndRedo(textEditor);

        if (command.equalsIgnoreCase("Undo")){
            undoAndRedo.undoAction();
        }
        else if (command.equalsIgnoreCase("Redo")) {
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
        else if (command.equalsIgnoreCase("Select all")){
            textArea.selectAll();
        }
    }
}
