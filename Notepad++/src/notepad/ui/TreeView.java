package notepad.ui;

import notepad.listener.TreeCellEditorListener;
import notepad.listener.TreeMouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class TreeView extends JPanel{
    private Tree tree;
    private JScrollPane scrollPane;
    private CloseTreeViewPanel treeViewPanel;

    private TreeMouseListener mouseListener;

    public TreeView(EditorWindow editorWindow, JFrame parentFrame){
        super();
        tree = new Tree(null);
        scrollPane = new JScrollPane(tree);
        treeViewPanel = new CloseTreeViewPanel();

        mouseListener = new TreeMouseListener(tree, editorWindow, parentFrame);
        tree.addMouseListener(mouseListener);

        tree.getCellEditor().addCellEditorListener(new TreeCellEditorListener(tree));

        treeViewPanel.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (parentFrame instanceof MainWindow)
                    ((MainWindow) parentFrame).setSelectedWorkspace(false);
            }
        });

        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        setLayout(new BorderLayout(0,0));
        setBorder(border);
        //setPreferredSize(new Dimension(200,600));
        add(scrollPane, BorderLayout.CENTER);
        add(treeViewPanel, BorderLayout.NORTH);
        setVisible(false);
    }

    public Tree getTree(){
        return tree;
    }
}
