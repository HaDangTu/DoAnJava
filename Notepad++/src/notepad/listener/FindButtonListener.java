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
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindButtonListener implements ActionListener {

    private JCheckBox matchCase;
    private JCheckBox wholeWord;
    private EditorWindow editorWindow;
    private JTextField fieldFind;
    private JDialog parent;
    private SearchContext searchContext;
    private JRadioButton regex;
    private JLabel lbResult;
    private boolean highLight;

    public FindButtonListener(JCheckBox matchCase, JCheckBox wholeWord, EditorWindow editorWindow,
                              JTextField fieldFind, JRadioButton regex, JDialog parent){
        this.matchCase = matchCase;
        this.wholeWord = wholeWord;
        this.editorWindow = editorWindow;
        this.fieldFind = fieldFind;
        this.parent = parent;
        searchContext = new SearchContext();
        this.regex = regex;
        this.highLight = false;
        lbResult = null;
    }

    public FindButtonListener(JCheckBox matchCase, EditorWindow editorWindow, JTextField fieldFind,
                              JDialog parent, JLabel lbResult, boolean highLight){
        this.matchCase = matchCase;
        this.wholeWord = null;
        this.highLight = highLight;
        this.editorWindow = editorWindow;
        this.parent = parent;
        this.fieldFind = fieldFind;
        this.lbResult = lbResult;
        searchContext = new SearchContext();
        this.regex = null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        String command = e.getActionCommand();

        if (fieldFind.getText().isEmpty())
            return;

        if (textArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Nothing to search", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        searchContext.setSearchFor(fieldFind.getText());
        searchContext.setMatchCase(matchCase.isSelected());
        searchContext.setSearchForward(command.equalsIgnoreCase("Find Next"));
        searchContext.setMarkAll(highLight);
        if (wholeWord != null)
            searchContext.setWholeWord(wholeWord.isSelected());
        if (regex != null)
            searchContext.setRegularExpression(regex.isSelected());

        int found = SearchEngine.find(textArea, searchContext).getCount();

        if (lbResult != null) {
            if (found > 1)
                lbResult.setText(found + "match");
            else
                lbResult.setText(found + "matches");
        }

        if (found == 0) {
            JOptionPane.showMessageDialog(parent, "Text not found", "Result",
                    JOptionPane.INFORMATION_MESSAGE);
            textArea.setCaretPosition(0);
        }
    }
}
