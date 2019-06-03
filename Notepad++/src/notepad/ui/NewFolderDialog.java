package notepad.ui;
import notepad.listener.NewFolderDialogPropertyChangeListener;
import notepad.util.TreeInteraction;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComponent;

public class NewFolderDialog extends JDialog{
    private JOptionPane optionPane;
    private JLabel label;
    private JTextField fieldName;
    private String[] buttonsName = {"Create folder", "Cancel"};

    public NewFolderDialog(JFrame parentFrame, Tree tree, TreeInteraction treeInteraction){
        label = new JLabel("New folder name: ");
        fieldName = new JTextField();

        JComponent[] components = {label, fieldName};

        optionPane = new JOptionPane(components, JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.YES_NO_OPTION, null, buttonsName, buttonsName[0]);

        optionPane.addPropertyChangeListener(new NewFolderDialogPropertyChangeListener(this, parentFrame,
                tree, treeInteraction));
        setContentPane(optionPane);
        setTitle("New folder");
        setLocationRelativeTo(parentFrame);
        setModal(true);
    }

    public void showDialog(){
        pack();
        setVisible(true);
    }

    public String getFolderName(){
        return fieldName.getText();
    }

    /**
     *
     * @return value of option pane
     */
    public Object getValue(){
        return optionPane.getValue();
    }

    /**
     * set vaule of option pane
     * @param value UNINITIALIZED_VALUE
     */
    public void setValue(Object value){
        optionPane.setValue(value);
    }
}
