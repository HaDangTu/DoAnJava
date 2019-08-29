package notepad.listener;

import notepad.ui.Tree;
import notepad.util.BuildingFilePath;

import javax.swing.tree.TreePath;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import java.io.File;

public class TreeCellEditorListener implements CellEditorListener {

    private Tree tree;

    public TreeCellEditorListener(Tree tree){
        this.tree = tree;
    }

    @Override
    public void editingStopped(ChangeEvent e) {
        TreePath srcTreePath = tree.getSelectionPath();
        String location = tree.getLocationOfNode();

        String oldFilePath = location + BuildingFilePath.buildFilePath(srcTreePath);
        String oldFileName = srcTreePath.getLastPathComponent().toString();
        String newFileName = tree.getCellEditor().getCellEditorValue().toString();

        //Rename file
        String newFilePath = oldFilePath.substring(0, oldFilePath.indexOf(oldFileName)) + newFileName;

        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);

        if (oldFile.renameTo(newFile))
            System.out.println("Rename successful");
        else System.out.println("Rename failed");

        //tree.setEditable(false);
    }

    @Override
    public void editingCanceled(ChangeEvent e) {

    }
}
