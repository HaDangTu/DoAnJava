package notepad.ui;
import notepad.listener.FileDialogPropertyChangeListener;
import notepad.util.CategoryOfFile;
import notepad.listener.NewFileItemListener;

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ItemListener;

public class NewFileDialog extends JDialog{
    protected JFrame frame;
    protected JTextField textFieldName;
    protected JComboBox<String> comboBoxKind;
    protected JLabel labelName;
    protected JLabel labelKind;
    protected JOptionPane optionPane;
    //private EditorWindow editorWindow;
    private String[] buttonsName = {"Create file", "Cancel"};

    public NewFileDialog(JFrame frame, String[] kind, EditorWindow editorWindow){
        super();
        this.frame = frame;
        //this.editorWindow = editorWindow;
        textFieldName = new JTextField();
        textFieldName.requestFocusInWindow();
        textFieldName.setText(CategoryOfFile.ACTIONSCRIPT_FILE);

        comboBoxKind = new JComboBox<>(kind);
        comboBoxKind.addItemListener(new NewFileItemListener(this));

        labelKind = new JLabel("Kind: ");
        labelName = new JLabel("Name: ");

        JComponent[] components = {labelName, textFieldName, labelKind, comboBoxKind};


        optionPane = new JOptionPane(components, JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, null, buttonsName, buttonsName[0]);

        optionPane.addPropertyChangeListener(new FileDialogPropertyChangeListener(editorWindow, this));

        setTitle("Create new file");
        setContentPane(optionPane);
        setLocationRelativeTo(frame);
        setModal(true);
    }

    public NewFileDialog(JFrame frame, EditorWindow editorWindow){
        super();
        this.frame = frame;
        //this.editorWindow = editorWindow;
        textFieldName = new JTextField();
        textFieldName.requestFocusInWindow();
        labelName = new JLabel("Name: ");

        JComponent[] components = {labelName, textFieldName};

        optionPane = new JOptionPane(components,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, null,
                buttonsName, buttonsName[0]);

        optionPane.addPropertyChangeListener(new FileDialogPropertyChangeListener(editorWindow, this));

        setTitle("Create new file");
        setContentPane(optionPane);
        setLocationRelativeTo(frame);
        setModal(true);
    }

    public void showDialog(){
        pack();
        setVisible(true);
    }

    /**
     * @return Name of new file you want to create
     */
    public String getName(){
        return textFieldName.getText();
    }

    public void setName(String name) {
        textFieldName.setText(name);
    }

    public void setItemListener(ItemListener itemListener){
        comboBoxKind.removeItemListener(new NewFileItemListener(this));
        comboBoxKind.addItemListener(itemListener);
    }

    /*
        get value of optionpane
     */
    public Object getValue(){
        return optionPane.getValue();
    }

    /*
        set value of optionpane
     */
    public void setValue(Object value){
        optionPane.setValue(value);
    }
}
