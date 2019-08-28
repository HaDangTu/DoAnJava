package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;

import org.fife.ui.rtextarea.SearchEngine;
import org.fife.ui.rtextarea.SearchContext;
//import org.fife.ui.rtextarea.SearchResult;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import javax.swing.event.DocumentEvent;

import javax.swing.text.BadLocationException;

public class FindDocumentListener extends BaseDocumentListener {

    private JCheckBox highlightAll;
    private JCheckBox matchCase;
    private JLabel resultLabel;
    private SearchContext searchContext;

    public FindDocumentListener(JCheckBox highlightAll, JCheckBox matchCase, JLabel resultLabel, EditorWindow editorWindow){
        super(editorWindow);
        this.highlightAll = highlightAll;
        this.matchCase = matchCase;
        this.resultLabel = resultLabel;
        searchContext = new SearchContext();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        try{
            int length = e.getDocument().getLength();
            String searchString = e.getDocument().getText(0, length);
            search(searchString);

        }
        catch (BadLocationException be){
            System.out.println(be.getMessage());
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        try{
            int length = e.getDocument().getLength();
            String searchString = e.getDocument().getText(0, length);
            search(searchString);
        }
        catch (BadLocationException be){
            System.out.println(be.getMessage());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    public void search(String searchString){
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        searchContext.setSearchFor(searchString);
        searchContext.setSearchForward(true);
        searchContext.setMatchCase(matchCase.isSelected());
        searchContext.setMarkAll(highlightAll.isSelected());
        searchContext.setWholeWord(false);

        int pos = SearchEngine.getNextMatchPos(searchString, textArea.getText(), true,
                matchCase.isSelected(), false);


        if (pos >= 0){

            int numMatch = 0;
            textArea.setCaretPosition(pos);
            SearchEngine.find(textArea, searchContext);
            numMatch = getMatch(searchString, textArea.getText(), matchCase.isSelected());

            if (numMatch <= 1)
                resultLabel.setText(numMatch + " match");
            else
                resultLabel.setText(numMatch + " matches");
        }
        else resultLabel.setText("No text found");
    }

    /**
     * find all text which match with text you want to find
     * @param regex text you want to find
     * @param searchIn document you want to find your text
     * @param matchCase distinguish between lower and upper case
     * @return count match of what you find
     */
    public int getMatch(String regex, String searchIn, boolean matchCase){
        int numMatch = 0;

        if (!regex.equals("")) {
            Pattern pattern;
            if (matchCase)
                pattern = Pattern.compile(regex);
            else
                pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(searchIn);

            while (matcher.find())
                numMatch++;
        }
        return numMatch;
    }
}
