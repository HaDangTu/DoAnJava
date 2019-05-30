package notepad.ui;
import notepad.listener.FindButtonListener;
import notepad.listener.FindDocumentListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.FlowLayout;
import java.awt.Dimension;

public class SearchBar extends JPanel{

    public SearchBar(EditorWindow editorWindow){
        JButton buttonClose = new JButton(new ImageIcon("icon\\close.png"));
        buttonClose.setSize(10, 10);
        buttonClose.setOpaque(false);
        buttonClose.setPreferredSize(new Dimension(16, 16));
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton buttonFindNext = new JButton("Find Next");
        JButton buttonFindPrevious = new JButton("Find Previous");

        JLabel labelFind = new JLabel("Find what: ");
        JLabel labelResult = new JLabel();

        JCheckBox chbMatchCase = new JCheckBox("Match case");
        JCheckBox chbHighlightAll = new JCheckBox("Highlight all");

        JTextField fieldFind = new JTextField();
        fieldFind.setPreferredSize(new Dimension(180, 20));
        fieldFind.getDocument().addDocumentListener(new FindDocumentListener(chbHighlightAll, chbMatchCase, labelResult,
                editorWindow));

        FindButtonListener listener = new FindButtonListener(chbMatchCase, editorWindow, fieldFind, null,
                labelResult, chbHighlightAll.isSelected());

        buttonFindNext.addActionListener(listener);
        buttonFindPrevious.addActionListener(listener);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setVgap(0);
        setLayout(flowLayout);

        add(buttonClose);
        add(labelFind);
        add(fieldFind);
        add(buttonFindNext);
        add(buttonFindPrevious);
        add(chbHighlightAll);
        add(chbMatchCase);
        add(labelResult);
        setVisible(false);
    }
}
