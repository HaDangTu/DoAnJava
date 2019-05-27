package notepad.util;

import notepad.ui.MyTree;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.ImageIcon;
import java.io.File;
public class MyTreeCellRenderer extends DefaultTreeCellRenderer{

    private String location;
    private ImageIcon folderIcon;
    private ImageIcon javaFileIcon;
    private ImageIcon cFileIcon;
    private ImageIcon cplusplusFileIcon;
    private ImageIcon csharpFileIcon;
    private ImageIcon cssFileIcon;
    private ImageIcon phpFileIcon;
    private ImageIcon pythonFileIcon;
    private ImageIcon javascripFileIcon;
    private ImageIcon jsonFileIcon;
    private ImageIcon htmlFileIcon;
    private ImageIcon sqlFileIcon;
    private ImageIcon xmlFileIcon;
    private ImageIcon normalTextFileIcon;
    private ImageIcon closeFolderIcon;

    public MyTreeCellRenderer(){
        folderIcon = new ImageIcon("icon\\folder.png");
        cFileIcon = new ImageIcon("icon\\c.png");
        cplusplusFileIcon = new ImageIcon("icon\\cplusplus.png");
        csharpFileIcon = new ImageIcon("icon\\csharp.png");
        cssFileIcon = new ImageIcon("icon\\css.png");
        phpFileIcon = new ImageIcon("icon\\php.png");
        pythonFileIcon = new ImageIcon("icon\\python.png");
        javaFileIcon = new ImageIcon("icon\\java.png");
        javascripFileIcon = new ImageIcon("icon\\javascript.png");
        jsonFileIcon = new ImageIcon("icon\\json.png");
        htmlFileIcon = new ImageIcon("icon\\html.png");
        sqlFileIcon = new ImageIcon("icon\\sql.png");
        xmlFileIcon = new ImageIcon("icon\\xml.png");
        normalTextFileIcon = new ImageIcon("icon\\normal_text.png");
        closeFolderIcon = new ImageIcon("icon\\close_folder.png");
    }
    @Override
    public JComponent getTreeCellRendererComponent(JTree tree,
                                                  Object value,
                                                  boolean selected,
                                                  boolean expanded,
                                                  boolean leaf,
                                                  int row,
                                                  boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        MyTree mytree = (MyTree) tree;
        location = mytree.getLocation1();
        setIconForFile(value, expanded);
        return this;
    }

    private File getFile(Object value){
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        String path = BuildingFilePath.buildFilePath(node);
        File file = new File(location + path);
        return file;
    }

    private void setIconForFile(Object value, boolean expanded){
        CategoryOfFile category = new CategoryOfFile();
        File file = getFile(value);
        if (file.isDirectory()){
            if (expanded)
                setIcon(folderIcon);
            else setIcon(closeFolderIcon);
        }
        else {
            String extension = category.getExtensionOfFile(file.getName());
            if (category.detectCFile(extension))
                setIcon(cFileIcon);
            else if (category.detectCplusplusFile(extension))
                setIcon(cplusplusFileIcon);
            else if (category.detectCSharpFile(extension))
                setIcon(csharpFileIcon);
            else if (category.detectPHPFile(extension))
                setIcon(phpFileIcon);
            else if (category.detectPythonFile(extension))
                setIcon(pythonFileIcon);
            else if (category.detectJavaFile(extension))
                setIcon(javaFileIcon);
            else if (category.detectJavaScriptFile(extension))
                setIcon(javascripFileIcon);
            else if (category.detectJsonFile(extension))
                setIcon(jsonFileIcon);
            else if (category.detectNormalTextFile(extension))
                setIcon(normalTextFileIcon);
            else if (category.detectHTMLFile(extension))
                setIcon(htmlFileIcon);
            else if (category.detectSQLFile(extension))
                setIcon(sqlFileIcon);
            else if (category.detectXMLFile(extension))
                setIcon(xmlFileIcon);
        }
    }
}
