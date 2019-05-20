package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindButtonListener implements ActionListener {

    private JCheckBox matchCase;
    private JCheckBox wholeWord;
    private EditorWindow editorWindow;
    private JTextField content;
    private JDialog parent;
    private SearchContext searchContext;
    private JRadioButton regex;

    public FindButtonListener(JCheckBox matchCase, JCheckBox wholeWord, EditorWindow editorWindow,
                              JTextField content, JRadioButton regex, JDialog parent){
        this.matchCase = matchCase;
        this.wholeWord = wholeWord;
        this.editorWindow = editorWindow;
        this.content = content;
        this.parent = parent;
        searchContext = new SearchContext();
        this.regex = regex;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        String command = e.getActionCommand();

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
        searchContext.setMarkAll(false);
        searchContext.setWholeWord(wholeWord.isSelected());
        searchContext.setRegularExpression(regex.isSelected());

        boolean found = SearchEngine.find(textArea, searchContext).wasFound();

        if (!found) {
            JOptionPane.showMessageDialog(parent, "Text not found", "Result",
                    JOptionPane.INFORMATION_MESSAGE);
            textArea.setCaretPosition(0);
        }
    }
}
