package notepad.util;
import notepad.ui.MyTree;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;

import javax.swing.tree.TreePath;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class TreeInteraction {

    public void openFile(EditorWindow editorWindow, MyTree tree) throws FileNotFoundException, IOException{
        TreePath treePath = tree.getSelectionPath();
        String directory = FilePath.buildFilePath(treePath);
        String filePath = tree.getLocation1() + "\\" + directory;

        int result = editorWindow.isExist(filePath);
        if (result < 0) {
            File file = new File(filePath);

            //Nếu file được chọn không phải là thư mục thì tiến hành mở file
            if (!file.isDirectory()) {
                editorWindow.addTabEditor(file.getName());
                int index = editorWindow.getTabCount() - 1;
                editorWindow.setFilePathForTab(filePath, index);

                CategoryOfFile category = new CategoryOfFile();
                String extension = category.getExtensionOfFile(file.getName());
                category.ChangeStyleEditorForFile(extension, editorWindow);

                RSyntaxTextArea textArea = editorWindow.getTextEditor(index).getTextArea();

                MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter(textArea);
                adapter.read(filePath);
                TextEditor textEditor = editorWindow.getTextEditor(index);
                textEditor.setIsChanged(false); //set isChanged = false vi trong qua trinh doc file de hien thi tren textarea se lam bien isChanged = tru
                editorWindow.setSelectedIndex(index);
            }
        }
        else
            editorWindow.setSelectedIndex(result);
    }

    public void addNewFile(MyTree tree, String newFileName){

    }
}
