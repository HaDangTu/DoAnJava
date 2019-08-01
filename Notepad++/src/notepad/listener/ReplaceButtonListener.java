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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplaceButtonListener extends BaseListener {
    private JCheckBox matchCase;
    private JCheckBox wholeWord;

//    private EditorWindow editorWindow;

    private JTextField findContent;
    private JTextField replaceContent;

    private JDialog parent;

    private JRadioButton regex;

    public ReplaceButtonListener (JCheckBox matchCase, JCheckBox wholeWord, EditorWindow editorWindow,
                                  JTextField findContent, JTextField replaceContent, JRadioButton regex, JDialog parent){
        super(editorWindow, null);
        this.matchCase = matchCase;
        this.wholeWord = wholeWord;

        this.findContent = findContent;
        this.replaceContent = replaceContent;

        this.parent = parent;

        this.regex = regex;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        String command = e.getActionCommand();

        SearchContext searchContext = new SearchContext();

        if (findContent.getText().isEmpty())
            return;

        if (textArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Nothing to replace", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        searchContext.setSearchFor(findContent.getText());
        searchContext.setMatchCase(matchCase.isSelected());
        searchContext.setReplaceWith(replaceContent.getText());
        searchContext.setWholeWord(wholeWord.isSelected());
        searchContext.setRegularExpression(regex.isSelected());

        int replace;
        if (command.equalsIgnoreCase("Replace"))
            replace = SearchEngine.replace(textArea, searchContext).getCount();
        else {
            replace = SearchEngine.replaceAll(textArea, searchContext).getCount();
            JOptionPane.showMessageDialog(parent, replace + " occurrences were replaced");
        }
    }
}
