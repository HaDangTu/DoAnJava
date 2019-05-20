package notepad.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

public class MarkButtonListener implements ActionListener {
    private EditorWindow editorWindow;
    private JDialog parent;
    private JCheckBox chbMatchCase;
    private JCheckBox chbMatchWholeWord;
    private JTextField fieldFind;

    public MarkButtonListener(EditorWindow editorWindow, JDialog parent, JCheckBox matchCase, JCheckBox matchWholeWord,
                              JTextField fieldFind){
        this.editorWindow = editorWindow;
        this.parent = parent;
        this.chbMatchCase = matchCase;
        this.chbMatchWholeWord = matchWholeWord;
        this.fieldFind = fieldFind;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        if (fieldFind.getText().isEmpty())
            return;

        if (textArea.getText().isEmpty()){
            JOptionPane.showMessageDialog(parent, "Nothing to mark", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SearchContext searchContext = new SearchContext();
        String command = e.getActionCommand();
        searchContext.setSearchFor(fieldFind.getText());
        searchContext.setMarkAll(command.equalsIgnoreCase("Mark all"));
        searchContext.setMatchCase(chbMatchCase.isSelected());
        searchContext.setWholeWord(chbMatchWholeWord.isSelected());

        SearchEngine.markAll(textArea, searchContext);
    }
}
