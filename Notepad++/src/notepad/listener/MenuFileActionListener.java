package notepad.listener;
import notepad.ui.*;
import notepad.util.MyReadAndWriteAdapter;
import notepad.util.CategoryOfFile;
import notepad.util.OpenAndSaveFile;
import notepad.util.TabInteraction;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MenuFileActionListener extends MenuMainWindowListener {
    private JFileChooser fileChooser;
    private MainWindow parentFrame;
    private MyTree tree;
    private OpenAndSaveFile openAndSaveFile;
    private TabInteraction tabInteraction;

    public MenuFileActionListener(EditorWindow editorWindow, MyTree tree, MainWindow parentFrame){
        super(editorWindow);
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        this.tree = tree;
        this.parentFrame = parentFrame;

        openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, parentFrame);
        tabInteraction = new TabInteraction(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //System.out.println(command);
        if (command.equalsIgnoreCase("New file")){
            editorWindow.addTabEditor();
        }
        else if (command.equalsIgnoreCase("C file")){
            String[] kind = {"Header file", "Class file"};
            NewFileDialog dialog = new NewFileDialog(parentFrame, kind, editorWindow);
            dialog.setItemListener(new NewCFileItemListener(dialog));
            dialog.setName(".h");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("C++ file")){
            String[] kind = {"Header file", "Class file"};
            NewFileDialog dialog = new NewFileDialog(parentFrame, kind, editorWindow);
            dialog.setItemListener(new NewCplusplusFileItemListener(dialog));
            dialog.setName(".h");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("C# file")){
            NewFileDialog dialog = new NewFileDialog(parentFrame, editorWindow);
            dialog.setName(".cs");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("PHP file")){
            NewFileDialog dialog = new NewFileDialog(parentFrame, editorWindow);
            dialog.setName(".php");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Python file")){
            NewFileDialog dialog = new NewFileDialog(parentFrame, editorWindow);
            dialog.setName(".py");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Java file")){
            NewFileDialog dialog = new NewFileDialog(parentFrame, editorWindow);
            dialog.setName(".java");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("JavaScript file")){
            NewFileDialog dialog = new NewFileDialog(parentFrame, editorWindow);
            dialog.setName(".js");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("JSON file")){
            NewFileDialog dialog = new NewFileDialog(parentFrame, editorWindow);
            dialog.setName(".json");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Other file")){
            final String[] kind = {"Normal text", "C file", "C++ file", "C# file", "PHP file",
                    "Python file", "Java file", "JavaScript file", "JSON file"};
            NewFileDialog dialog = new NewFileDialog(parentFrame, kind, editorWindow);
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Open directory")){
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnValue = fileChooser.showOpenDialog(parentFrame);
            if (returnValue == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                tree.setFilePath(file.getAbsolutePath());
                tree.setRootWithFilePath(tree.getFilePath());
                tree.createTree(file, tree.getRoot());
                tree.setRoot(tree.getRoot());
            }
        }
        else if (command.equalsIgnoreCase("Open file")){
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnValue = fileChooser.showOpenDialog(parentFrame);
            if (returnValue == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();

                editorWindow.addTabEditor(file.getName());
                int index = editorWindow.getTabCount() - 1;
                editorWindow.setFilePathForTab(file.getAbsolutePath(), index);
                TextEditor textEditor = editorWindow.getTextEditor(index);
                RSyntaxTextArea textArea = textEditor.getTextArea();

                CategoryOfFile categoryOfFile = new CategoryOfFile();
                String extension = categoryOfFile.getExtensionOfFile(file.getName());
                categoryOfFile.ChangeStyleEditorForFile(extension, editorWindow);

                MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter(textArea);
                try{
                    adapter.read(file.getAbsolutePath());
                    textEditor.setIsChanged(false); //set isChanged = false vi trong qua trinh doc file de hien thi tren textarea se lam bien isChanged = true
                }
                catch(FileNotFoundException fe){
                    System.err.println(fe.getMessage());
                }
                catch(IOException ioe){
                    System.err.println(ioe.getMessage());
                }
            }
        }
        else if (command.equalsIgnoreCase("Save")){
           int index = editorWindow.getSelectedIndex();
           TextEditor textEditor = editorWindow.getTextEditor(index);
           openAndSaveFile.saveFile(textEditor, index);
        }
        else if (command.equalsIgnoreCase("Save As...")){
            int index = editorWindow.getSelectedIndex();
            TextEditor textEditor = editorWindow.getTextEditor(index);
            openAndSaveFile.saveAsFile(textEditor, index);
        }
        else if (command.equalsIgnoreCase("Save All")){
            openAndSaveFile.saveAllFile();
        }
        else if (command.equalsIgnoreCase("Close tab")){
            int index = editorWindow.getSelectedIndex();
            tabInteraction.closeTabAt(fileChooser, index);
        }
        else if (command.equalsIgnoreCase("Close all tab")){
            tabInteraction.closeAllTab(fileChooser);
        }
        else if (command.equalsIgnoreCase("Close all but this..."))
            tabInteraction.closeAllButThis(fileChooser);
        else if (command.equalsIgnoreCase("Close right tab..."))
            tabInteraction.closeRightTab(fileChooser);
        else if (command.equalsIgnoreCase("Close left tab..."))
            tabInteraction.closeLeftTab(fileChooser);
        else if (command.equalsIgnoreCase("Exit")){
            parentFrame.dispose();
        }
    }
}
