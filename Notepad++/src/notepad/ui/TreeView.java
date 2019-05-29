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

public class TreeView extends JPanel{
    private MyTree tree;
    private JScrollPane scrollPane;

    private TreeMouseListener mouseListener;

    public TreeView(EditorWindow editorWindow, JFrame parentFrame){
        tree = new MyTree(null);
        scrollPane = new JScrollPane(tree);

        mouseListener = new TreeMouseListener(tree, editorWindow, parentFrame);
        tree.addMouseListener(mouseListener);

        tree.getCellEditor().addCellEditorListener(new TreeCellEditorListener(tree));

        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        setLayout(new BorderLayout());
        setBorder(border);
        add(scrollPane, BorderLayout.CENTER);
    }

    public MyTree getTree(){
        return tree;
    }
}
