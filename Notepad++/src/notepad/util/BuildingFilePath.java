package notepad.util;

import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;

public class BuildingFilePath {

    public static String buildFilePath(TreePath treePath){
        String path = "";
        Object[] objects = treePath.getPath();
        for (int i = 1; i < objects.length; i++){
            path = path.concat("\\" + objects[i].toString());
        }
        return path;
    }

    public static String buildFilePath(DefaultMutableTreeNode node){
        String path = "";
        Object[] objects = node.getUserObjectPath();
        for (int i = 1 ; i < objects.length; i++)
            path = path.concat("\\" + objects[i].toString());
        return path;
    }
}
