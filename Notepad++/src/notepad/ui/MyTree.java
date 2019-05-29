package notepad.ui;
import notepad.util.MyTreeCellRenderer;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;

public class MyTree extends JTree {
    private String location1;
    private DefaultMutableTreeNode root;

    public MyTree(DefaultMutableTreeNode root){
        super(root);
        MyTreeCellRenderer renderer = new MyTreeCellRenderer();
        setCellRenderer(renderer);
        setEditable(true);
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

    public void setLocation1(String location1){
        this.location1 = location1;
    }

    public void setRootWithFile(File file){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.getName());
        setLocation1(file.getAbsolutePath());
        createTree(file, root);
        setRoot(root);
    }

    public void setRoot(DefaultMutableTreeNode root){
        DefaultTreeModel treeModel = (DefaultTreeModel) getModel();
        treeModel.setRoot(root);
    }

    /**
     * Get location of root
     * @return location
     */
    public String getLocation1(){
        return location1;
    }

    public DefaultMutableTreeNode getRoot (){
        return root;
    }

    public void reloadTree(){
        File rootFile = new File(location1);
        DefaultMutableTreeNode root1 = new DefaultMutableTreeNode();
        createTree(rootFile, root1);
        setRoot(root1);
    }
}
