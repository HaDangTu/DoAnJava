package notepad.listener;

import notepad.ui.TextEditor;
import notepad.util.CategoryOfFile;
import notepad.ui.EditorWindow;
import notepad.ui.MyTree;
import notepad.util.MyReadAndWriteAdapter;
import org.fife.ui.rsyntaxtextarea.*;
import javax.swing.tree.TreePath;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TreeMouseListener implements MouseListener {
    private EditorWindow editorWindow;
    private MyTree tree;

    public TreeMouseListener(MyTree tree, EditorWindow editorWindow){
        this.tree = tree;
        this.editorWindow = editorWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            TreePath treePath = tree.getSelectionPath();
            String location = createPathName(treePath);
            String filePath = tree.getFilePath() + "\\" + location;

            int result = editorWindow.isExist(filePath);
            if (result < 0) {
                File file = new File(filePath);
                if (!file.isDirectory()) {
                    editorWindow.addTabEditor(file.getName());
                    int index = editorWindow.getTabCount() - 1;
                    editorWindow.setFilePathForTab(filePath, index);

                    CategoryOfFile category = new CategoryOfFile();
                    String extension = category.getExtensionOfFile(file.getName());
                    category.ChangeStyleEditorForFile(extension, editorWindow);

                    RSyntaxTextArea textArea = editorWindow.getTextEditor(editorWindow.getTabCount() - 1).getTextArea();
                    MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter(textArea);
                    try {
                        adapter.read(filePath);
                        TextEditor textEditor = editorWindow.getTextEditor(index);
                        textEditor.setIsChanged(false); //set isChanged = false vi trong qua trinh doc file de hien thi tren textarea se lam bien isChanged = tru
                        editorWindow.setSelectedIndex(index);
                    } catch (FileNotFoundException fe) {
                        System.err.println(fe.getMessage());
                    } catch (IOException ioe) {
                        System.err.println(ioe.getMessage());
                    }
                }
            }
            else
                editorWindow.setSelectedIndex(result);
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

    public String createPathName(TreePath treePath){
        String path = "";
        Object[] objects = treePath.getPath();
        for (int i = 1; i < objects.length; i++){
            path = path.concat(objects[i].toString() + "\\");
        }
        return path;
    }
}
