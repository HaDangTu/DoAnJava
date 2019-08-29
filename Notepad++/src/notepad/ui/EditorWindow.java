package notepad.ui;

import notepad.util.OpenAndSaveFile;

import javax.swing.JTabbedPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.util.ArrayList;

/**
 * TODO: calculate function generate new tab number
 */
public class EditorWindow extends JTabbedPane {

    private ArrayList<Integer> deletedTab;
    private boolean isWrapWord;
    private boolean isHideLineNumber;
    private int newTabNumber;

    public EditorWindow(){
        super();
        deletedTab = new ArrayList<>();

        isWrapWord = false;
        isHideLineNumber = true;
        newTabNumber = 1;

        addNewTab();
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    /**
     * add new tab
     */
    public void addNewTab(){
        TextEditor textEditor = new TextEditor(newTabNumber);
        textEditor.getTextArea().setLineWrap(isWrapWord);
        textEditor.setLineNumberEnabled(isHideLineNumber);
        TabUI ui = new TabUI(this);

        if (deletedTab.size() <= 0) {
            addTab("New " + newTabNumber, textEditor);
            ui.setLabel(getTitleAt(this.getTabCount() - 1));
        }
        else{
            addTab("New " + deletedTab.get(0), textEditor);
            ui.setLabel(getTitleAt(this.getTabCount() - 1));
            deletedTab.remove(0);
        }
        newTabNumber++;
        //ui.setListener(new CloseTabButtonActionListener(this, ui));
        setTabComponentAt(getTabCount() - 1, ui);
    }

    /**
     * add new tab with title
     * @param title title for tab
     */
    public void addNewTab(String title){
        TextEditor textEditor = new TextEditor();
        textEditor.getTextArea().setLineWrap(isWrapWord);
        textEditor.setLineNumberEnabled(isHideLineNumber);
        TabUI tabUI = new TabUI(this);

        addTab(title, textEditor);
        int index = getTabCount() - 1;
        tabUI.setLabel(getTitleAt(index));
//        tabUI.setListener(new CloseTabButtonActionListener(this, tabUI));

        setTabComponentAt(index, tabUI);
    }

    /**
     *  Set style for editor
     * @keyStyle: C, CPLUSPLUS, CSHARP, JAVA, JAVASCRIPT,...
     */
    public void setEditorStyle(String keyStyle){
        TextEditor editor = (TextEditor) getComponentAt(getSelectedIndex());
        editor.setEditingStyle(keyStyle);
    }

    public void setEditorStyle(String keyStyle, TextEditor textEditor){
        textEditor.setEditingStyle(keyStyle);
    }

    /**
     * add element at the end of deletedTab
     * @param element value
     */
    public void addDeletedTab(int element){
        deletedTab.add(element);
    }

    /**
     * Get length of deleted tab
     * @return size of deleted tab array
     */
    public int getDeletedTabLength(){
        return deletedTab.size();
    }

    public ArrayList<Integer> getDeletedTab(){return deletedTab;}

    /**
     * Set name of Tab at last tab
     * @param nameOfTab name of tab
     */
    public void setTitleForTab(String nameOfTab){
        int index = getTabCount() - 1;
        setTitleForTab(nameOfTab, index);
    }

    /**
     * Set name of Tab at specify tab
     * @param nameOfTab name of tab
     * @param index position of tab
     */
    public void setTitleForTab(String nameOfTab, int index){
        TabUI tabUI = (TabUI) getTabComponentAt(index);
        tabUI.setLabel(nameOfTab);
        setTitleAt(index, nameOfTab);
    }

    public String getTitleOfTab(int index){
        TabUI tabUI = (TabUI) getTabComponentAt(index);
        return tabUI.getLabel();
    }

    /**
     * Get tab at index
     * @param index location of tab to get
     * @return a tab at specify location
     */
    public TextEditor getTextEditor(int index){
        return (TextEditor) this.getComponentAt(index);
    }

    /**
     * Check if tab exists or not
     * @param filePath directory of file
     * @return tab position if file is exist
     */
    public int isExist(String filePath){
        TextEditor[] textEditors = getAllTextEditor();

        for (int i = 0; i < textEditors.length; i++)
            if (textEditors[i].getFilePath().equalsIgnoreCase(filePath))
                return i;
        return -1;
    }

    public void setFilePathForTab(String filePath, int index){
        TextEditor textEditor = (TextEditor) getComponentAt(index);
        textEditor.setFilePath(filePath);
    }

    public void setFileTypeForTab(String fileType, int index){
        TextEditor textEditor = (TextEditor) getComponentAt(index);
        textEditor.setFileType(fileType);
    }

    public TextEditor[] getAllTextEditor(){
        TextEditor[] textEditors= new TextEditor[getTabCount()];
        int i;
        for (i = 0; i < textEditors.length; i++)
            textEditors[i] = getTextEditor(i);
        return textEditors;
    }
    /**
     * get file type of tab
     * @param index position of tab
     * @return .c, .txt, .cpp, .java...
     */
    public String getFileTypeOfTab(int index){
        TextEditor textEditor = getTextEditor(index);
        return textEditor.getFileType();
    }

    /**
     * get directory of file
     * @param index position of tab
     * @return directory, ex: "C\User\Desktop..."
     */
    public String getFilePathOfTab(int index) {
        TextEditor textEditor = getTextEditor(index);
        return textEditor.getFilePath();
    }

    /**
     * Check all tab is saved or not
     * @return true if all tab is saved, false if one or more tab is not saved
     */
    public boolean isSavedAll(){
        TextEditor[] textEditors = getAllTextEditor();
        for (TextEditor textEditor: textEditors){
            if (textEditor.getIsChanged())
                return false;
        }
        return true;
    }

    /**
     * Set or remove word wrap in all tab when checkbox word wrap in menu View is checked
     * @param flag true if set word wrap , false if remove word wrap
     */
    public void setWordWrapAllTab(boolean flag){
        isWrapWord = flag;
        TextEditor[] textEditors = getAllTextEditor();
        for (TextEditor textEditor : textEditors)
            textEditor.getTextArea().setLineWrap(flag);
    }

    public void setLineNumberEnabledAllTab(boolean enabled){
        isHideLineNumber = enabled;
        TextEditor[] textEditors = getAllTextEditor();
        for (TextEditor textEditor : textEditors)
            textEditor.setLineNumberEnabled(enabled);
    }

    /**
     * set style, filetype, auto complete for tab
     * @param keyStyle JAVA, C#, PHP,...
     * @param fileType .java, .c, .php, .cpp,...
     * @param isAutoComplete true if text editor has auto complete code
     */
    public void setStyleForTab(String keyStyle, String fileType, boolean isAutoComplete){
        int index = getSelectedIndex();
        setEditorStyle(keyStyle);
        setFileTypeForTab(fileType, index);
        if (isAutoComplete){
            TextEditor textEditor = getTextEditor(index);
            textEditor.setAutoComplete();
        }
    }

    /**
     * close selected tab
     * @param fileChooser: Show dialog to save file if necessary
     * @param index  position of tab
     */
    public void closeTabAt(JFileChooser fileChooser, int index) {
        TextEditor textEditor = getTextEditor(index);
        if (!textEditor.getIsChanged()) {
            if (getFilePathOfTab(index).equalsIgnoreCase(""))
                addDeletedTab(textEditor.getNumberOfTab());
            removeTabAt(index);
        } else {
            int result = JOptionPane.showConfirmDialog(null,
                    "Do you want to save change of file " + getTitleOfTab(index) + "?",
                    "Save file",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
            if (result == 0) {
                OpenAndSaveFile openAndSaveFile = new OpenAndSaveFile(fileChooser, this, null);
                openAndSaveFile.saveFile(textEditor, index);
                if (textEditor.getNumberOfTab() != -1)
                    addDeletedTab(textEditor.getNumberOfTab());
                removeTabAt(index);
            } else if (result == 1)
                removeTabAt(index);
        }
    }

    /**
     * close all tab which is opening
     * @param fileChooser: Show dialog to save file if necessary
     */
    public void closeAllTab(JFileChooser fileChooser){
        int tabCount = getTabCount();
        for (int i = 0; i < tabCount; i++)
            closeTabAt(fileChooser, 0);
    }

    /**
     * close all tab except selected tab
     * @param fileChooser: Show dialog to save file if necessary
     */
    public void closeAllButThis(JFileChooser fileChooser){
        int i;
        int tabCount = getTabCount();
        int selectedTab = getSelectedIndex();
        int deleteTab = 0;
        for (i = 0; i < tabCount; i++){
            if (i == selectedTab){
                deleteTab = 1;
                continue;
            }
            closeTabAt(fileChooser, deleteTab);
        }
    }

    /**
     * close right tab of selected tab
     * @param fileChooser Show dialog to save file if necessary
     */
    public void closeRightTab(JFileChooser fileChooser){
        int index = getSelectedIndex() + 1;
        if (index < getTabCount())
            closeTabAt(fileChooser, index);
    }

    /**
     * close left tab of selected tab
     * @param fileChooser Show dialog to save file if necessary
     */
    public void closeLeftTab(JFileChooser fileChooser){
        int index = getSelectedIndex() - 1;
        if (index >= 0)
            closeTabAt(fileChooser, index);
    }
}
