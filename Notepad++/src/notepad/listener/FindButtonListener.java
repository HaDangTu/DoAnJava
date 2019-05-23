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

        /**
         * Check some condition
         * - field Find is not empty
         * - textArea is not empty
         */
        if (fieldFind.getText().isEmpty())
            return;

        if (textArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Nothing to search", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int pos = -1;
        /**
         * wholeWord check box can be null in some solution because we have two constructor for this class
         * one of them doesn't have parameter wholeWord check box.
         * Check box wholeWord = null can cause exception
         */
        if (wholeWord != null)
            pos = SearchEngine.getNextMatchPos(fieldFind.getText(), textArea.getText(), true,
                matchCase.isSelected(), wholeWord.isSelected());
        else
            pos = SearchEngine.getNextMatchPos(fieldFind.getText(), textArea.getText(), true,
                    matchCase.isSelected(), false);

        searchContext.setSearchFor(fieldFind.getText());
        searchContext.setMatchCase(matchCase.isSelected());
        searchContext.setSearchForward(command.equalsIgnoreCase("Find Next"));
        searchContext.setMarkAll(highLight);

        if (wholeWord != null)
            searchContext.setWholeWord(wholeWord.isSelected());
        else searchContext.setWholeWord(false);

        if (regex != null)
            searchContext.setRegularExpression(regex.isSelected());
        else searchContext.setRegularExpression(false);

        boolean found = SearchEngine.find(textArea, searchContext).wasFound();

        if (!found) {
            /**
             * if pos < 0 => string that you want to find is not exist in
             * textArea.getText()
             */
            if (pos >= 0)
                textArea.setCaretPosition(pos);
            else
                JOptionPane.showMessageDialog(parent, "Text not found", "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
