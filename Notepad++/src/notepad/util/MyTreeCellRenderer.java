package notepad.util;

import notepad.ui.Tree;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.ImageIcon;
import java.io.File;
public class MyTreeCellRenderer extends DefaultTreeCellRenderer{

    private String location;
    ImageManager imageManager ;

    public MyTreeCellRenderer(){
        imageManager = ImageManager.getInstance();
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
        Tree mytree = (Tree) tree;
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
                setIcon(imageManager.get("folder"));
            else setIcon(imageManager.get("close_folder"));
        }
        else {
            String extension = category.getExtensionOfFile(file.getName());
            if (category.detectCFile(extension))
                setIcon(imageManager.get("c"));
            else if (category.detectCplusplusFile(extension))
                setIcon(imageManager.get("cplusplus"));
            else if (category.detectCSharpFile(extension))
                setIcon(imageManager.get("csharp"));
            else if (category.detectCSSFile(extension))
                setIcon(imageManager.get("css"));
            else if (category.detectCSVFile(extension))
                setIcon(imageManager.get("csv"));
            else if (category.detectPHPFile(extension))
                setIcon(imageManager.get("php"));
            else if (category.detectPythonFile(extension))
                setIcon(imageManager.get("python"));
            else if (category.detectPerlFile(extension))
                setIcon(imageManager.get("perl"));
            else if (category.detectJavaFile(extension))
                setIcon(imageManager.get("java"));
            else if (category.detectJavaScriptFile(extension))
                setIcon(imageManager.get("javascript"));
            else if (category.detectJsonFile(extension))
                setIcon(imageManager.get("json"));
            else if (category.detectJSPFile(extension))
                setIcon(imageManager.get("jsp"));
            else if (category.detectRubyFile(extension))
                setIcon(imageManager.get("ruby"));
            else if (category.detectVisualBasicFile(extension))
                setIcon(imageManager.get("visual-basic"));
            else if (category.detectNormalTextFile(extension))
                setIcon(imageManager.get("normal"));
            else if (category.detectHTMLFile(extension))
                setIcon(imageManager.get("html"));
            else if (category.detectTypeScriptFile(extension))
                setIcon(imageManager.get("typescript"));
            else if (category.detectSQLFile(extension))
                setIcon(imageManager.get("sql"));
            else if (category.detectXMLFile(extension))
                setIcon(imageManager.get("xml"));
            else
                setIcon(imageManager.get("other_file"));
        }
    }
}
