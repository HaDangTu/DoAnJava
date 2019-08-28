package notepad.ui;
import notepad.listener.MenuWindowActionActionListener;

import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.AbstractButton;

import java.util.Enumeration;

public class MenuWindow extends JMenu{

    private ButtonGroup buttonGroup;

    private EditorWindow editorWindow;

    private MenuWindowActionActionListener windowListener;

    public MenuWindow(EditorWindow editorWindow){
        super("Window");
        buttonGroup = new ButtonGroup();

        this.editorWindow = editorWindow;

        windowListener = new MenuWindowActionActionListener(this.editorWindow);
        addItem("New 1");
    }

    /**
     * add new window to menu when new window is created
     * @param windowName title of tab
     */
    public void addItem(String windowName){
        buttonGroup.clearSelection();
        String itemName = editorWindow.getSelectedIndex() + 1 + ": " + windowName;
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(itemName);

        /*
         * Edit action command of check box
         */
        Integer actionCommand = editorWindow.getSelectedIndex();
        checkBoxMenuItem.addActionListener(windowListener);
        checkBoxMenuItem.setActionCommand(actionCommand.toString());

        checkBoxMenuItem.setSelected(true);
        add(checkBoxMenuItem);

        buttonGroup.add(checkBoxMenuItem);
    }

    /**
     * remove item when tab is close
     * @param index position of tab
     */
    public void removeItem(int index){
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        int i = 0;
        JCheckBoxMenuItem checkBox;
        remove(index);
        if (index == editorWindow.getTabCount())
            setSelectedItem(index - 1);
        else
            setSelectedItem(index + 1);

        while (buttons.hasMoreElements()){
            checkBox = (JCheckBoxMenuItem) buttons.nextElement();
            if (i == index) {
                buttonGroup.remove(checkBox);
                renameWindow();
                return;
            }
            else
                i++;
        }
    }

    public void setSelectedItem(int index) {
        buttonGroup.clearSelection();
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        int i = 0;
        JCheckBoxMenuItem checkBox;
        while (buttons.hasMoreElements()){
            checkBox = (JCheckBoxMenuItem) buttons.nextElement();
            if (i == index) {
                checkBox.setSelected(true);
                return;
            }
            else
                i++;
        }
    }

    private void renameWindow(){
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        int i = 0;
        while (buttons.hasMoreElements()){
            JCheckBoxMenuItem checkBox = (JCheckBoxMenuItem) buttons.nextElement();
            String name = checkBox.getText();
            name = (i + 1) + name.substring(name.lastIndexOf(":"));
            checkBox.setText(name);
            checkBox.setActionCommand(((Integer)i).toString());
            i++;
        }
    }
}
