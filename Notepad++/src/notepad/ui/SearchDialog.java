package notepad.ui;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import java.awt.BorderLayout;
import javax.swing.JDialog;

import notepad.listener.DialogListener;
import notepad.listener.FindNextButtonListener;
import notepad.listener.ReplaceButtonListener;

public class SearchDialog extends JDialog{
    private JTabbedPane tabbedPane;
    private JPanel panel;
    private FindNextButtonListener findListener;
    private ReplaceButtonListener replaceListener;

    public SearchDialog(JFrame frame, EditorWindow editorWindow){
        tabbedPane = new JTabbedPane();
        panel = new JPanel(new BorderLayout());

        //tab Find
        JPanel tabFindPanel = new JPanel();
        GroupLayout layoutTabFind = new GroupLayout(tabFindPanel);
        tabFindPanel.setLayout(layoutTabFind);

        layoutTabFind.setAutoCreateGaps(true);
        layoutTabFind.setAutoCreateContainerGaps(true);

        JLabel labelFind = new JLabel("Find what: ");
        JCheckBox checkMatchCase = new JCheckBox("Match case");
        JTextField fieldFind = new JTextField();

        findListener = new FindNextButtonListener(checkMatchCase, editorWindow, fieldFind, this);
        JButton buttonFindNext = new JButton("Find Next");
        buttonFindNext.addActionListener(findListener);

        JButton buttonFindPrevious = new JButton("Find Previous");
        buttonFindPrevious.addActionListener(findListener);

        layoutTabFind.setHorizontalGroup(
                layoutTabFind.createSequentialGroup()
                    .addGroup(layoutTabFind.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelFind)
                            .addComponent(checkMatchCase))
                    .addComponent(fieldFind)
                    .addGroup(layoutTabFind.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonFindNext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonFindPrevious, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layoutTabFind.setVerticalGroup(
                layoutTabFind.createSequentialGroup()
                        .addGroup(layoutTabFind.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelFind)
                                .addComponent(fieldFind)
                                .addComponent(buttonFindNext))
                        .addGroup(layoutTabFind.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(checkMatchCase)
                            .addComponent(buttonFindPrevious))
        );

        tabbedPane.addTab("Find", tabFindPanel);
        //---------------------------------------------------------------------------


        //tab Replace
        JPanel tabReplacePanel = new JPanel();
        GroupLayout layoutReplace = new GroupLayout(tabReplacePanel);
        tabReplacePanel.setLayout(layoutReplace);

        JTextField fieldReplace = new JTextField();
        JTextField fieldFindReplace = new JTextField();
        JLabel labelFindReplace = new JLabel("Find what: ");
        JLabel labelReplace = new JLabel("Replace with: ");
        JCheckBox checkMatchCaseReplace = new JCheckBox("Match Case");

        replaceListener = new ReplaceButtonListener(checkMatchCaseReplace, editorWindow,
                fieldFindReplace, fieldReplace, this);

        JButton buttonFindReplace = new JButton("Find Next");
        buttonFindReplace.addActionListener(new FindNextButtonListener(checkMatchCaseReplace,
                editorWindow, fieldFindReplace, this));

        JButton buttonReplace = new JButton("Replace");
        buttonReplace.addActionListener(replaceListener);

        JButton buttonReplaceAll = new JButton("Replace All");
        buttonReplaceAll.addActionListener(replaceListener);

        layoutReplace.setHorizontalGroup(
                layoutReplace.createSequentialGroup()
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelFindReplace)
                                .addComponent(labelReplace)
                                .addComponent(checkMatchCaseReplace))
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(fieldFindReplace)
                                .addComponent(fieldReplace))
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttonFindReplace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonReplace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonReplaceAll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layoutReplace.setVerticalGroup(
                layoutReplace.createSequentialGroup()
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelFindReplace)
                                .addComponent(fieldFindReplace)
                                .addComponent(buttonFindReplace))
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelReplace)
                                .addComponent(fieldReplace)
                                .addComponent(buttonReplace))
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(checkMatchCaseReplace)
                                .addComponent(buttonReplaceAll))
        );
        tabbedPane.addTab("Replace", tabReplacePanel);
        //---------------------------------------------------------------------------
        panel.add(tabbedPane, BorderLayout.CENTER);
        add(panel);
        setSize(500, 150);
        addWindowListener(new DialogListener(editorWindow));
        setResizable(false);
        setTitle("Find and Replace");
        setLocationRelativeTo(frame);
        //setModal(true);
    }

    public void showDialog(){
        //pack();
        setVisible(true);
    }
}
