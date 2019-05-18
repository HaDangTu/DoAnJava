package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindNextButtonListener implements ActionListener {

    private JCheckBox matchCase;
    private EditorWindow editorWindow;
    private JTextField content;
    private JDialog parent;

    public FindNextButtonListener(JCheckBox matchCase, EditorWindow editorWindow, JTextField content, JDialog parent){
        this.matchCase = matchCase;
        this.editorWindow = editorWindow;
        this.content = content;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        String command = e.getActionCommand();

        SearchContext searchContext = new SearchContext();

        if (content.getText().isEmpty())
            return;

        if (textArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Nothing to search", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        searchContext.setSearchFor(content.getText());
        searchContext.setMatchCase(matchCase.isSelected());
        searchContext.setSearchForward(command.equalsIgnoreCase("Find Next"));
        searchContext.setWholeWord(false);

        boolean found = SearchEngine.find(textArea, searchContext).wasFound();

        if (!found) {
            JOptionPane.showMessageDialog(parent, "Text not found", "Result",
                    JOptionPane.INFORMATION_MESSAGE);
            textArea.setCaretPosition(0);
        }
    }
}
