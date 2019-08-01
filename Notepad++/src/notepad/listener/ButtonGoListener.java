package notepad.listener;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;

public class ButtonGoListener extends BaseListener {
    private int maxLine;
    private JTextField fieldGo;
    private JDialog parent;

    public ButtonGoListener (EditorWindow editorWindow,  int maxLine, JTextField fieldGo, JDialog parent){
        super(editorWindow, null);
        this.fieldGo = fieldGo;
        this.maxLine = maxLine;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        if (fieldGo.getText().isEmpty())
            return;

        try{
            int lineToGo = Integer.parseInt(fieldGo.getText());
            if (lineToGo > maxLine){
                JOptionPane.showMessageDialog(null, "Line to go is greater than max line");
                return;
            }
            else if (lineToGo < maxLine) {
                int position = textArea.getLineStartOffset(lineToGo) - 1;
                textArea.setCaretPosition(position);
            }
            parent.dispose();

        }catch (Exception except){
            JOptionPane.showMessageDialog(parent, except.getMessage());
        }
    }
}
