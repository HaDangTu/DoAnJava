package notepad.listener;
import notepad.ui.EditorWindow;
import notepad.ui.MainWindow;
import notepad.ui.Tree;
import notepad.ui.NewFileDialog;
import notepad.ui.TextEditor;

import notepad.util.MyReadAndWriteAdapter;
import notepad.util.OpenAndSaveFile;
import notepad.util.PrintText;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.io.IOException;

public class MenuFileActionActionListener extends MenuMainWindowActionListener {
    private JFileChooser fileChooser;
    private Tree tree;
    private OpenAndSaveFile openAndSaveFile;
    private PrintText printText;

    public MenuFileActionActionListener(EditorWindow editorWindow, Tree tree, MainWindow mainWindow){
        super(editorWindow, mainWindow);
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        this.tree = tree;

        openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, mainWindow);
        printText = new PrintText(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //System.out.println(command);

        if (command.equalsIgnoreCase("New file")){
            editorWindow.addNewTab();
            int pos = editorWindow.getTabCount() - 1;
            editorWindow.setSelectedIndex(pos);
            editorWindow.getTextEditor(pos).getTextArea().requestFocusInWindow();
            mainWindow.addItem(editorWindow.getTitleOfTab(pos));
        }
        else if (command.equalsIgnoreCase("C file")){
            String[] kind = {"Header file", "C source file"};
            NewFileDialog dialog = new NewFileDialog(mainWindow, kind, editorWindow);
            dialog.setItemListener(new NewCFileItemListener(dialog));
            dialog.setName(".h");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("C++ file")){
            String[] kind = {"Header file", "C++ source file"};
            NewFileDialog dialog = new NewFileDialog(mainWindow, kind, editorWindow);
            dialog.setItemListener(new NewCplusplusFileItemListener(dialog));
            dialog.setName(".h");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("C# file")){
            NewFileDialog dialog = new NewFileDialog(mainWindow, editorWindow);
            dialog.setName(".cs");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("PHP file")){
            NewFileDialog dialog = new NewFileDialog(mainWindow, editorWindow);
            dialog.setName(".php");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Python file")){
            NewFileDialog dialog = new NewFileDialog(mainWindow, editorWindow);
            dialog.setName(".py");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Java file")){
            NewFileDialog dialog = new NewFileDialog(mainWindow, editorWindow);
            dialog.setName(".java");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("JavaScript file")){
            NewFileDialog dialog = new NewFileDialog(mainWindow, editorWindow);
            dialog.setName(".js");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("JSON file")){
            NewFileDialog dialog = new NewFileDialog(mainWindow, editorWindow);
            dialog.setName(".json");
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Other file")){
            MyReadAndWriteAdapter adapter = new MyReadAndWriteAdapter();
            try{
                final String[] kind = adapter.readToStringArray("lang\\file_type.txt");
                NewFileDialog dialog = new NewFileDialog(mainWindow, kind, editorWindow);
                dialog.showDialog();
            }
            catch (IOException ioe){
                System.err.println(ioe.getMessage());
            }
        }
        else if (command.equalsIgnoreCase("Open directory")){
            OpenAndSaveFile openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, tree, mainWindow);
            openAndSaveFile.openDirectory();
        }
        else if (command.equalsIgnoreCase("Open file")){
            OpenAndSaveFile openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, tree, mainWindow);
            openAndSaveFile.openFile();
        }
        else if (command.equalsIgnoreCase("Save")){
           int index = editorWindow.getSelectedIndex();
           TextEditor textEditor = editorWindow.getTextEditor(index);
           openAndSaveFile.saveFile(textEditor, index);

           mainWindow.setMenuItemSaveEnabled(false);
           mainWindow.setButtonSaveEnabled(false);
           if (editorWindow.isSavedAll()){
               mainWindow.setButtonSaveAllEnabled(false);
               mainWindow.setMenuItemSaveAllEnabled(false);
           }
        }
        else if (command.equalsIgnoreCase("Save As...")){
            int index = editorWindow.getSelectedIndex();
            TextEditor textEditor = editorWindow.getTextEditor(index);
            openAndSaveFile.saveAsFile(textEditor, index);
            mainWindow.setMenuItemSaveEnabled(false);
            mainWindow.setButtonSaveEnabled(false);
            if (editorWindow.isSavedAll()) {
                mainWindow.setButtonSaveAllEnabled(false);
                mainWindow.setMenuItemSaveAllEnabled(false);
            }
        }
        else if (command.equalsIgnoreCase("Save All")){
            openAndSaveFile.saveAllFile();
            mainWindow.setMenuItemSaveEnabled(false);
            mainWindow.setButtonSaveEnabled(false);
            mainWindow.setButtonSaveAllEnabled(false);
            mainWindow.setMenuItemSaveAllEnabled(false);
        }
        else if (command.equalsIgnoreCase("Page setup")){
            printText.pageSetup();
        }
        else if (command.equalsIgnoreCase("Print now")){

            try{
                printText.printNow();
            }
            catch (PrinterException pe){
                System.err.println(pe.getMessage());
            }
        }
        else if (command.equalsIgnoreCase("Print...")){
            try {
                printText.print();
            }
            catch (PrinterException pe){
                System.err.println(pe.getMessage());
            }
        }
        else if (command.equalsIgnoreCase("Close tab")){
            int index = editorWindow.getSelectedIndex();
            editorWindow.closeTabAt(fileChooser, index);
        }
        else if (command.equalsIgnoreCase("Close all tab")){
            editorWindow.closeAllTab(fileChooser);
        }
        else if (command.equalsIgnoreCase("Close all but this..."))
            editorWindow.closeAllButThis(fileChooser);
        else if (command.equalsIgnoreCase("Close right tab..."))
            editorWindow.closeRightTab(fileChooser);
        else if (command.equalsIgnoreCase("Close left tab..."))
            editorWindow.closeLeftTab(fileChooser);
        else if (command.equalsIgnoreCase("Exit")){
            mainWindow.dispose();
        }
    }

    public JFileChooser getFileChooser(){
        return fileChooser;
    }
}
