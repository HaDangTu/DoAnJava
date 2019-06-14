package notepad.ui;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class RenameDialog extends JDialog{
    private JLabel labelRename;
    private JTextField fieldName;
    private JButton btOk;
    private JButton btCancel;

    private GroupLayout layout;
    private JPanel panel;
    public RenameDialog(EditorWindow editorWindow){
        int index = editorWindow.getSelectedIndex();
        String oldName = editorWindow.getTitleOfTab(index);

        labelRename = new JLabel("New name: ");
        fieldName = new JTextField(oldName);
        btOk = new JButton("OK");

        btOk.addActionListener((ActionEvent e)->{
            editorWindow.setTitleForTab(fieldName.getText(), index);
            setVisible(false);
        });

        btCancel = new JButton("Cancel");
        btCancel.addActionListener((ActionEvent e)->{
            setVisible(false);
        });

        btCancel.setActionCommand("Cancel");

        panel = new JPanel();
        layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(labelRename)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(fieldName)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btOk)
                                        .addComponent(btCancel)))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelRename)
                                .addComponent(fieldName))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btOk)
                                .addComponent(btCancel))
        );


        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        setTitle("Rename");
        setPreferredSize(new Dimension(300, 105));
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(editorWindow.getRootPane().getParent());
        pack();
    }

    public void showDialog(){
        setVisible(true);
    }
}
