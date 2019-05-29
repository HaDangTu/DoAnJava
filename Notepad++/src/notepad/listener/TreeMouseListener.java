package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.MyTree;
import notepad.ui.TreePopupMenu;


import notepad.util.TreeInteraction;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TreeMouseListener implements MouseListener {
    private EditorWindow editorWindow;
    private MyTree tree;
    private TreePopupMenu popupMenu;
    private TreeInteraction treeInteraction;

    public TreeMouseListener(MyTree tree, EditorWindow editorWindow, JFrame parentFrame){
        this.tree = tree;
        this.editorWindow = editorWindow;
        popupMenu = new TreePopupMenu(editorWindow, tree, parentFrame);
        treeInteraction = new TreeInteraction();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tree.getRowForLocation(e.getX(), e.getY());
        if (row >= 0) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                try {
                    treeInteraction.openFile(editorWindow, tree);
                } catch (FileNotFoundException fe) {
                    System.err.println(fe.getMessage());
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
            } else if (SwingUtilities.isRightMouseButton(e)) {
                tree.setSelectionRow(row);
                popupMenu.show(tree, e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
