package notepad.ui;
import notepad.util.MyTreeCellRenderer;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;

public class MyTree extends JTree {
    private String filePath;
    private DefaultMutableTreeNode root;

    public MyTree(DefaultMutableTreeNode root){
        super(root);
        setCellRenderer(new MyTreeCellRenderer());
    }

    public void createTree(File file, DefaultMutableTreeNode root){
        File[] files = file.listFiles();
        DefaultMutableTreeNode child;
        for (File f: files){
            if(f.isDirectory()) {
                child = new DefaultMutableTreeNode(f.getName());
                createTree(f, child);
            }
            else
                child = new DefaultMutableTreeNode(f.getName());
            root.add(child);
        }
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public void setRootWithFilePath(String filePath){
        File file = new File(filePath);
        this.root = new DefaultMutableTreeNode(file.getName());
        setRoot(this.root);
    }

    public void setRoot(DefaultMutableTreeNode root){
        DefaultTreeModel treeModel = (DefaultTreeModel) this.getModel();
        treeModel.setRoot(root);
    }

    public String getFilePath(){
        return filePath;
    }

    public DefaultMutableTreeNode getRoot (){
        return root;
    }
}
