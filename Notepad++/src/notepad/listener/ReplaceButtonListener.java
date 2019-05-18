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

public class ReplaceButtonListener implements ActionListener {
    private JCheckBox matchCase;
    private EditorWindow editorWindow;
    private JTextField findContent;
    private JTextField replaceContent;
    private JDialog parent;

    public ReplaceButtonListener (JCheckBox matchCase, EditorWindow editorWindow,
                                  JTextField findContent, JTextField replaceContent, JDialog parent){
        this.matchCase = matchCase;
        this.editorWindow = editorWindow;
        this.findContent = findContent;
        this.replaceContent = replaceContent;
        this.parent = parent;
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

        int replace;
        if (command.equalsIgnoreCase("Replace"))
            replace = SearchEngine.replace(textArea, searchContext).getCount();
        else {
            replace = SearchEngine.replaceAll(textArea, searchContext).getCount();
            JOptionPane.showMessageDialog(parent, replace + " occurrences were replaced");
        }
    }
}
