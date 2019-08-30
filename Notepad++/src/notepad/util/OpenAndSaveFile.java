package notepad.util;

import notepad.ui.EditorWindow;
import notepad.ui.MainWindow;
import notepad.ui.TextEditor;
import notepad.ui.Tree;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenAndSaveFile {

    private JFileChooser fileChooser;
    private EditorWindow editorWindow;
    private MainWindow parentFrame;
    private Tree tree;

    /**
     * Use for save file
     */
    public OpenAndSaveFile(JFileChooser fileChooser, EditorWindow editorWindow, MainWindow parentFrame){
        this.fileChooser = fileChooser;
        this.editorWindow = editorWindow;
        this.parentFrame = parentFrame;
    }

    /**
     * Use for open file and folder
     */
    public OpenAndSaveFile(JFileChooser fileChooser, EditorWindow editorWindow, Tree tree, MainWindow parentFrame){
        this.fileChooser = fileChooser;
        this.editorWindow = editorWindow;
        this.parentFrame = parentFrame;
        this.tree = tree;
    }

    public void openDirectory(){
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(parentFrame);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            tree.setRootWithFile(file);
            parentFrame.resetSlitPane();
        }
    }

    public void openFile(){
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = fileChooser.showOpenDialog(parentFrame);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();

            editorWindow.addNewTab(file.getName());
            int index = editorWindow.getTabCount() - 1;
            editorWindow.setFilePathForTab(file.getAbsolutePath(), index);
            TextEditor textEditor = editorWindow.getTextEditor(index);
            RSyntaxTextArea textArea = textEditor.getTextArea();


            CategoryOfFile categoryOfFile = CategoryOfFile.getInstance();
            String extension = categoryOfFile.getExtensionOfFile(file.getName());
            Language language = categoryOfFile.getLanguage(extension);
            editorWindow.setEditorStyle(language.getKeyStyle(), textEditor);

            MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter(textArea);
            try{
                /*
                 * set isOpened = true để tránh undo manager gọi hàm addEdit
                 */
                textEditor.setIsOpened(true);
                adapter.read(file.getAbsolutePath());
                textEditor.setIsChanged(false); //set isChanged = false vi trong qua trinh doc file de hien thi tren textarea se lam bien isChanged = true
                textEditor.setIsOpened(false);
                /*
                 * set isOpened = false để undo manager gọi hàm addEdit
                 */
            }
            catch(FileNotFoundException fe){
                System.err.println(fe.getMessage());
            }
            catch(IOException ioe){
                System.err.println(ioe.getMessage());
            }

            editorWindow.setSelectedIndex(index);
            parentFrame.addItem(editorWindow.getTitleOfTab(index));
        }
    }

    public void saveFile(TextEditor textEditor, int index){
        if (textEditor.getIsChanged()) {
            if (!textEditor.getFilePath().equalsIgnoreCase("")) {
                MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter(textEditor.getTextArea());
                try {
                    adapter.write(textEditor.getFilePath());
                    textEditor.setIsChanged(false);
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
            } else {
                saveAsFile(textEditor, index);
            }
        }
    }

    public void saveAsFile(TextEditor textEditor, int index){
        String fileType = textEditor.getFileType();
        String fileName = editorWindow.getTitleOfTab(index);
        setFileChooser(fileType);
        fileChooser.setSelectedFile(new File(fileName));
        int result = fileChooser.showSaveDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            editorWindow.setTitleForTab(file.getName(), index);
            MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter(textEditor.getTextArea());
            try{
                adapter.write(file.getAbsolutePath());
                textEditor.setFilePath(file.getAbsolutePath());
                textEditor.setIsChanged(false);
            }
            catch (IOException ioe){
                System.err.println(ioe.getMessage());
            }
        }
    }

    public void saveAllFile(){
        for (int i = 0 ; i < editorWindow.getTabCount(); i++){
            TextEditor textEditor = editorWindow.getTextEditor(i);
            saveFile(textEditor, i);
        }
    }

    public void setFileChooser(String fileType){
        fileChooser.resetChoosableFileFilters();
        if (fileType.equalsIgnoreCase(CategoryOfFile.C_FILE))
            fileChooser.setFileFilter(new FileNameExtensionFilter("C file", fileType));
        else if (fileType.equalsIgnoreCase(CategoryOfFile.CPLUSPLUS_FILE))
            fileChooser.setFileFilter(new FileNameExtensionFilter("C++ file", fileType));
        else if (fileType.equalsIgnoreCase(CategoryOfFile.CSHARP_FILE))
            fileChooser.setFileFilter(new FileNameExtensionFilter("C# file", fileType));
        else if (fileType.equalsIgnoreCase(CategoryOfFile.PHP_FILE))
            fileChooser.setFileFilter(new FileNameExtensionFilter("PHP file", fileType));
        else if (fileType.equalsIgnoreCase(CategoryOfFile.PYTHON_FILE))
            fileChooser.setFileFilter(new FileNameExtensionFilter("Python file", fileType));
        else if (fileType.equalsIgnoreCase(CategoryOfFile.JAVA_FILE))
            fileChooser.setFileFilter(new FileNameExtensionFilter("Java file", fileType));
        else if (fileType.equalsIgnoreCase(CategoryOfFile.JAVASCRIPT_FILE))
            fileChooser.setFileFilter(new FileNameExtensionFilter("JavaScript file", fileType));
        else if (fileType.equalsIgnoreCase(CategoryOfFile.JSON_FILE))
            fileChooser.setFileFilter(new FileNameExtensionFilter("JSON file", fileType));
        else
            fileChooser.setFileFilter(new FileNameExtensionFilter("Normal text",fileType));
    }
}
