package notepad.ui;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JRadioButton;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;

import notepad.listener.*;

public class SearchDialog extends JDialog{
    private JTabbedPane tabbedPane;
    private JPanel panel;
    private FindButtonListener findListener;
    private ReplaceButtonListener replaceListener;

    public SearchDialog(JFrame frame, EditorWindow editorWindow){
        super();
        tabbedPane = new JTabbedPane();
        panel = new JPanel(new BorderLayout());

        //tab Find
        initTabFind(editorWindow);
        //---------------------------------------------------------------------------

        //tab Replace
        initTabReplace(editorWindow);
        //---------------------------------------------------------------------------

        //tab Mark
        initTabMark(editorWindow);
        //---------------------------------------------------------------------------
        panel.add(tabbedPane, BorderLayout.CENTER);
        add(panel);
        setSize(500, 160);
        setResizable(false);
        setTitle("Find and Replace");
        setLocationRelativeTo(frame);
        setModal(true);
    }

    private void initTabFind(EditorWindow editorWindow){
        JPanel tabFindPanel = new JPanel();
        GroupLayout layoutTabFind = new GroupLayout(tabFindPanel);
        tabFindPanel.setLayout(layoutTabFind);

        layoutTabFind.setAutoCreateGaps(true);
        layoutTabFind.setAutoCreateContainerGaps(true);

        JLabel labelFind = new JLabel("Find what: ");
        JLabel labelSearchMode = new JLabel("SearchMode: ");
        JCheckBox checkMatchCase = new JCheckBox("Match case");
        JCheckBox checkWholeWord = new JCheckBox("Whole word");

        //Create radio button group for search mode;
        ButtonGroup btGroup = new ButtonGroup();
        JRadioButton radioRegex = new JRadioButton("Regular expression");
        JRadioButton radioNormal = new JRadioButton("Normal");
        radioNormal.setSelected(true);
        btGroup.add(radioRegex);
        btGroup.add(radioNormal);

        JTextField fieldFind = new JTextField();

        findListener = new FindButtonListener(checkMatchCase, checkWholeWord, editorWindow,
                fieldFind, radioRegex,this);
        JButton buttonFindNext = new JButton("Find Next");
        buttonFindNext.addActionListener(findListener);

        JButton buttonFindPrevious = new JButton("Find Previous");
        buttonFindPrevious.addActionListener(findListener);

        layoutTabFind.setHorizontalGroup(
                layoutTabFind.createSequentialGroup()
                        .addGroup(layoutTabFind.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelFind)
                                .addComponent(labelSearchMode))
                        .addGroup(layoutTabFind.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(fieldFind)
                                .addGroup(layoutTabFind.createSequentialGroup()
                                        .addComponent(checkMatchCase)
                                        .addComponent(checkWholeWord))
                                .addGroup(layoutTabFind.createSequentialGroup()
                                        .addComponent(radioNormal)
                                        .addComponent(radioRegex)))
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
                                .addComponent(checkWholeWord)
                                .addComponent(buttonFindPrevious))
                        .addGroup(layoutTabFind.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelSearchMode)
                                .addComponent(radioNormal)
                                .addComponent(radioRegex))
        );

        tabbedPane.addTab("Find", tabFindPanel);
    }

    private void initTabReplace(EditorWindow editorWindow){
        JPanel tabReplacePanel = new JPanel();
        GroupLayout layoutReplace = new GroupLayout(tabReplacePanel);
        tabReplacePanel.setLayout(layoutReplace);

        JTextField fieldReplace = new JTextField();
        JTextField fieldFindReplace = new JTextField();
        JLabel labelFindReplace = new JLabel("Find what: ");
        JLabel labelReplace = new JLabel("Replace with: ");
        JLabel labelSearchMode = new JLabel ("Search mode: ");

        ButtonGroup btGroup = new ButtonGroup();
        JRadioButton radioRegex = new JRadioButton("Regular expression");
        JRadioButton radioNormal = new JRadioButton("Normal");
        radioNormal.setSelected(true);
        btGroup.add(radioRegex);
        btGroup.add(radioNormal);

        JCheckBox checkMatchCaseReplace = new JCheckBox("Match Case");
        JCheckBox checkWholeWordReplace  = new JCheckBox("Whole word");

        replaceListener = new ReplaceButtonListener(checkMatchCaseReplace, checkWholeWordReplace, editorWindow,
                fieldFindReplace, fieldReplace, radioRegex,this);

        JButton buttonFindReplace = new JButton("Find Next");
        buttonFindReplace.addActionListener(new FindButtonListener(checkMatchCaseReplace, checkWholeWordReplace,
                editorWindow, fieldFindReplace, radioRegex, this));

        JButton buttonReplace = new JButton("Replace");
        buttonReplace.addActionListener(replaceListener);

        JButton buttonReplaceAll = new JButton("Replace All");
        buttonReplaceAll.addActionListener(replaceListener);

        layoutReplace.setHorizontalGroup(
                layoutReplace.createSequentialGroup()
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelFindReplace)
                                .addComponent(labelReplace)
                                .addComponent(labelSearchMode))
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(fieldFindReplace)
                                .addComponent(fieldReplace)
                                .addGroup(layoutReplace.createSequentialGroup()
                                        .addComponent(checkMatchCaseReplace)
                                        .addComponent(checkWholeWordReplace))
                                .addGroup(layoutReplace.createSequentialGroup()
                                        .addComponent(radioNormal)
                                        .addComponent(radioRegex)))
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
                                .addComponent(checkWholeWordReplace)
                                .addComponent(buttonReplaceAll))
                        .addGroup(layoutReplace.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelSearchMode)
                                .addComponent(radioNormal)
                                .addComponent(radioRegex))
        );
        tabbedPane.addTab("Replace", tabReplacePanel);
    }

    private void initTabMark(EditorWindow editorWindow){
        JLabel labelFindWhat = new JLabel("Find what: ");
        JLabel labelSearchMode = new JLabel("Search mode: ");

        JTextField fieldFind = new JTextField();

        JCheckBox matchCase = new JCheckBox("Match case");
        JCheckBox matchWholeWord = new JCheckBox("Whole word");

        MarkButtonListener listener = new MarkButtonListener(editorWindow, this, matchCase, matchWholeWord,
                fieldFind);

        //Group search mode
        ButtonGroup btGroup = new ButtonGroup();

        JRadioButton radioNormal = new JRadioButton("Normal");
        radioNormal.setSelected(true);
        radioNormal.addActionListener(new RadioMarkRegexListener(matchWholeWord));

        JRadioButton radioRegex = new JRadioButton("Regular expression");
        radioRegex.addActionListener(new RadioMarkRegexListener(matchWholeWord));
        btGroup.add(radioNormal);
        btGroup.add(radioRegex);
        //----------------------------------------------------------------

        JButton buttonMark = new JButton("Mark all");
        buttonMark.addActionListener(listener);
        JButton buttonClearMark = new JButton("Clear all marks");
        buttonClearMark.addActionListener(listener);

        JPanel markPanel = new JPanel();
        GroupLayout layoutMark = new GroupLayout(markPanel);
        markPanel.setLayout(layoutMark);

        layoutMark.setHorizontalGroup(
                layoutMark.createSequentialGroup()
                        .addGroup(layoutMark.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelFindWhat)
                                .addComponent(labelSearchMode))
                        .addGroup(layoutMark.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(fieldFind)
                                .addGroup(layoutMark.createSequentialGroup()
                                        .addComponent(matchCase)
                                        .addComponent(matchWholeWord))
                                .addGroup(layoutMark.createSequentialGroup()
                                        .addComponent(radioNormal)
                                        .addComponent(radioRegex)))
                        .addGroup(layoutMark.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttonMark,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonClearMark, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layoutMark.setVerticalGroup(
                layoutMark.createSequentialGroup()
                        .addGroup(layoutMark.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelFindWhat)
                                .addComponent(fieldFind)
                                .addComponent(buttonMark))
                        .addGroup(layoutMark.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(matchCase)
                                .addComponent(matchWholeWord)
                                .addComponent(buttonClearMark))
                        .addGroup(layoutMark.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelSearchMode)
                                .addComponent(radioNormal)
                                .addComponent(radioRegex))
        );

        tabbedPane.addTab("Mark", markPanel);
    }

    public void showDialog(){
        //pack();
        setVisible(true);
    }

    public void setSelectedTab(int index){
        tabbedPane.setSelectedIndex(index);
    }
}
