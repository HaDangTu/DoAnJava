package notepad.util;
import notepad.ui.EditorWindow;
import notepad.ui.TabUI;
import notepad.ui.TextEditor;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TabInteraction {
    private EditorWindow editorWindow;
    private TabUI tabUI;

    /*
        @tabUI: should be not null
     */

    public TabInteraction( EditorWindow editorWindow,  TabUI tabUI){
        this.editorWindow = editorWindow;
        this.tabUI = tabUI;
    }


    public TabInteraction(EditorWindow editorWindow){
        this.editorWindow = editorWindow;
        this.tabUI = null;
    }
    /*
        close any tab when click on close tab button
     */
    public void closeTab(JFileChooser fileChooser){
        int index = editorWindow.indexOfTab(tabUI.getLabel());
        closeTabAt(fileChooser, index);
    }

    /*
        close tab at
        @index: position of tab
     */
    public void closeTabAt(JFileChooser fileChooser, int index){
        TextEditor textEditor = editorWindow.getTextEditor(index);
        if (!textEditor.getIsChanged()){
            if (editorWindow.getFilePathOfTab(index).equalsIgnoreCase(""))
                editorWindow.addDeletedTab(textEditor.getNumberOfTab());
            editorWindow.removeTabAt(index);
        }
        else{
            int result = JOptionPane.showConfirmDialog(null,
                    "Do you want to save change of file?",
                    "Save file",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
            if (result == 0){
                OpenAndSaveFile openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, null);
                openAndSaveFile.saveFile(textEditor, index);
                if (textEditor.getNumberOfTab() != -1)
                    editorWindow.addDeletedTab(textEditor.getNumberOfTab());
                editorWindow.removeTabAt(index);
            }
            else if (result == 1)
                editorWindow.removeTabAt(index);
        }
    }

    /*
        close all tab
     */
    public void closeAllTab(JFileChooser fileChooser){
        int tabCount = editorWindow.getTabCount();
        for (int i = 0; i < tabCount; i++)
            closeTabAt(fileChooser, 0);
    }

    /*
        close all tab except selected tab
     */
    public void closeAllButThis(JFileChooser fileChooser){
        int i;
        int tabCount = editorWindow.getTabCount();
        int selectedTab = editorWindow.getSelectedIndex();
        int deleteTab = 0;
        for (i = 0; i < tabCount; i++){
            if (i == selectedTab){
                deleteTab = 1;
                continue;
            }
            closeTabAt(fileChooser, deleteTab);
        }
    }

    /*
        close right tab of selected tab
     */
    public void closeRightTab(JFileChooser fileChooser){
        int index = editorWindow.getSelectedIndex() + 1;
        if (index < editorWindow.getTabCount())
            closeTabAt(fileChooser, index);
    }

    /*
        close left tab of selected tab
     */
    public void closeLeftTab(JFileChooser fileChooser){
        int index = editorWindow.getSelectedIndex() - 1;
        if (index >= 0)
            closeTabAt(fileChooser, index);
    }
}
