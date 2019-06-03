package notepad.ui;

import notepad.listener.CloseTabButtonListener;

import javax.swing.JTabbedPane;
import java.util.ArrayList;

public class EditorWindow extends JTabbedPane {

    private ArrayList<Integer> deletedTab;
    private boolean isWrapWord;

    public EditorWindow(){
        super();
        deletedTab = new ArrayList<>();
        isWrapWord = false;
        loadComponent();
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private void loadComponent(){
        int number = getTabCount() + 1;
        TextEditor textEditor = new TextEditor(number);
        textEditor.getTextArea().setLineWrap(isWrapWord);
        TabUI ui = new TabUI();

        if (deletedTab.size() <= 0) {
            addTab("New " + number, textEditor);
            ui.setLabel(getTitleAt(this.getTabCount() - 1));
        }
        else{
            addTab("New " + deletedTab.get(0), textEditor);
            ui.setLabel(getTitleAt(this.getTabCount() - 1));
            deletedTab.remove(0);
        }
        ui.setListener(new CloseTabButtonListener(this, ui));
        setTabComponentAt(getTabCount() - 1, ui);
    }

    public void addTabEditor(){
        loadComponent();
    }

    public void addTabEditor(String title){
        TextEditor textEditor = new TextEditor();
        textEditor.getTextArea().setLineWrap(isWrapWord);
        TabUI tabUI = new TabUI();

        addTab(title, textEditor);
        int index = getTabCount() - 1;
        tabUI.setLabel(getTitleAt(index));
        tabUI.setListener(new CloseTabButtonListener(this, tabUI));

        setTabComponentAt(index, tabUI);
    }

    /*
        Set style for editor
        @keyStyle: C, CPLUSPLUS, CSHARP, JAVA, JAVASCRIPT,...
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
     * @return position of file if file is exist
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
}
