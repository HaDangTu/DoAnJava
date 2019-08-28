package notepad.ui;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import notepad.listener.ButtonGoActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;

public class GoToDialog extends JDialog{
    private JTextField fieldGo;

    private JLabel minLabel;
    private JLabel requireLabel;
    private JLabel maxLabel;
    private JLabel minValue;
    private JLabel maxValue;

    private JButton buttonGo;

    public GoToDialog(EditorWindow editorWindow, JFrame frame){
        fieldGo = new JTextField();
        minLabel = new JLabel("You are here: ");
        requireLabel = new JLabel("You want to go to: ");
        maxLabel = new JLabel("You can't go further than: ");
        minValue = new JLabel();
        maxValue = new JLabel();

        buttonGo = new JButton("Go");


        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);
        RSyntaxTextArea textArea = textEditor.getTextArea();

        Integer min = textArea.getCaretLineNumber() + 1;
        Integer max = textArea.getLineCount();
        minValue.setText(min.toString());
        maxValue.setText(max.toString());

        buttonGo.addActionListener(new ButtonGoActionListener(editorWindow, max, fieldGo, this));
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(minLabel)
                                .addComponent(requireLabel)
                                .addComponent(maxLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(minValue)
                                .addComponent(fieldGo)
                                .addComponent(maxValue))
                        .addComponent(buttonGo)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(minLabel)
                                .addComponent(minValue))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(requireLabel)
                                .addComponent(fieldGo)
                                .addComponent(buttonGo))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(maxLabel)
                                .addComponent(maxValue))
        );

        setContentPane(panel);
        pack();
        setTitle("Go to...");
        setSize(300, 150);
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(frame);
    }

    public void showDialog(){
        setVisible(true);
    }
}
