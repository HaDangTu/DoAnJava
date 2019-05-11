package notepad.ui;

import notepad.listener.CloseTabButtonListener;

import javax.swing.JTabbedPane;
import java.util.ArrayList;
public class EditorWindow extends JTabbedPane {

    private ArrayList<Integer> deletedTab;

    public EditorWindow(){
        deletedTab = new ArrayList<>();
        loadComponent();
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private void loadComponent(){
        int number = getTabCount() + 1;
        TextEditor textEditor = new TextEditor(number);
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

    /*
        add element in deleted tab
     */
    public void addDeletedTab(int element){
        deletedTab.add(element);
    }
    /*
        get length of array list deletedTab
    */
    public int getDeletedTabLength(){
        return deletedTab.size();
    }

    /*
        get first element of array list deletedTab
     */
    public int getTabNumber(){
        return deletedTab.get(0);
    }

    /*
        Remove element of array list deletedTab
        @index: position of element need remove
     */
    public void removeDeletedTab(int index){
        deletedTab.remove(index);
    }

    /*
        Set name of Tab
     */
    public void setTitleForTab(String nameOfTab){
        TabUI tabUI = new TabUI();
        tabUI.setLabel(nameOfTab);
        setTabComponentAt(getTabCount() - 1, tabUI);
    }

    public void setTitleForTab(String nameOfTab, int index){
        TabUI tabUI = new TabUI();
        tabUI.setLabel(nameOfTab);
        setTabComponentAt(index, tabUI);
    }

    public String getTitleOfTab(int index){
        TabUI tabUI = (TabUI) getTabComponentAt(index);
        return tabUI.getLabel();
    }
    /*
        Get tab
     */
    public TextEditor getTextEditor(int index){
        return (TextEditor) this.getComponentAt(index);
    }

    /*
        Check if tab exists or not
        @filePath: filePath of tab
        return position of tab
     */
    public int isExist(String filePath){
        TextEditor[] textEditors = new TextEditor[getTabCount()];
        for (int j = 0; j < textEditors.length; j++)
            textEditors[j] = getTextEditor(j);

        for (int i = 0; i < textEditors.length; i++){
            if (textEditors[i].getFilePath().equalsIgnoreCase(filePath))
                return i;
        }
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

    public String getFileTypeOfTab(int index){
        TextEditor textEditor = getTextEditor(index);
        return textEditor.getFileType();
    }

    public String getFilePathOfTab(int index) {
        TextEditor textEditor = getTextEditor(index);
        return textEditor.getFilePath();
    }
}
