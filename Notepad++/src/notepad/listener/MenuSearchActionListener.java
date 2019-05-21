package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.GoToDialog;
import notepad.ui.SearchDialog;
import notepad.ui.TextEditor;
import notepad.ui.MainWindow;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class MenuSearchActionListener extends MenuMainWindowListener {

    private JFrame parentFrame;
    public MenuSearchActionListener(EditorWindow editorWindow, JFrame frame) {
        super(editorWindow);
        this.parentFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("Find")) {
            SearchDialog dialog = new SearchDialog(parentFrame, editorWindow);
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Find Next")){
            if (!search(true)){
                JOptionPane.showMessageDialog(parentFrame, "No text found");
            }
        }
        else if (command.equalsIgnoreCase("Find Previous")){
            if (!search(false)){
                JOptionPane.showMessageDialog(parentFrame, "No text found");
            }
        }
        else if (command.equalsIgnoreCase("Replace")){
            SearchDialog dialog = new SearchDialog(parentFrame, editorWindow);
            dialog.setSelectedTab(1);
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Incremental Search")){
            ((MainWindow) parentFrame).setVisiblePanelSearchIncremental(true);
        }
        else if (command.equalsIgnoreCase("Go to...")){
            GoToDialog dialog = new GoToDialog(editorWindow, parentFrame);
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Mark...")){
            SearchDialog dialog = new SearchDialog(parentFrame, editorWindow);
            dialog.setSelectedTab(2);
            dialog.showDialog();
        }
    }

    public boolean search(boolean searchForward){
        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        String selectedText = textArea.getSelectedText();
        if (selectedText != null){
            SearchContext searchContext = new SearchContext(selectedText);
            searchContext.setMatchCase(false);
            searchContext.setWholeWord(false);
            searchContext.setRegularExpression(false);
            searchContext.setSearchForward(searchForward);
            searchContext.setMarkAll(false);

            boolean result = SearchEngine.find(textArea, searchContext).wasFound();
            return result;
        }
        return false;
    }
}
