package notepad.listener;
import notepad.ui.EditorWindow;
import notepad.ui.MainWindow;
import notepad.ui.Tree;
import notepad.ui.NewFileDialog;
import notepad.ui.TextEditor;

import notepad.util.OpenAndSaveFile;
import notepad.util.TabInteraction;
import notepad.util.PrintText;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;

public class MenuFileActionListener extends MenuMainWindowListener {
    private JFileChooser fileChooser;
    private MainWindow parentFrame;
    private Tree tree;
    private OpenAndSaveFile openAndSaveFile;
    private TabInteraction tabInteraction;
    private PrintText printText;

    public MenuFileActionListener(EditorWindow editorWindow, Tree tree, MainWindow parentFrame){
        super(editorWindow);
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        this.tree = tree;
        this.parentFrame = parentFrame;

        openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, parentFrame);
        tabInteraction = new TabInteraction(editorWindow);
        printText = new PrintText(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //System.out.println(command);

        if (command.equalsIgnoreCase("New file")){
            editorWindow.addTabEditor();
            int pos = editorWindow.getTabCount() - 1;
            editorWindow.setSelectedIndex(pos);
            editorWindow.getTextEditor(pos).getTextArea().requestFocusInWindow();
            parentFrame.addItem(editorWindow.getTitleOfTab(pos));
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
            OpenAndSaveFile openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, tree, parentFrame);
            openAndSaveFile.openDirectory();
        }
        else if (command.equalsIgnoreCase("Open file")){
            OpenAndSaveFile openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, tree, parentFrame);
            openAndSaveFile.openFile();
        }
        else if (command.equalsIgnoreCase("Save")){
           int index = editorWindow.getSelectedIndex();
           TextEditor textEditor = editorWindow.getTextEditor(index);
           openAndSaveFile.saveFile(textEditor, index);

           parentFrame.setMenuItemSaveEnabled(false);
           parentFrame.setButtonSaveEnabled(false);
           if (editorWindow.isSavedAll()){
               parentFrame.setButtonSaveAllEnabled(false);
               parentFrame.setMenuItemSaveAllEnabled(false);
           }
        }
        else if (command.equalsIgnoreCase("Save As...")){
            int index = editorWindow.getSelectedIndex();
            TextEditor textEditor = editorWindow.getTextEditor(index);
            openAndSaveFile.saveAsFile(textEditor, index);
            parentFrame.setMenuItemSaveEnabled(false);
            parentFrame.setButtonSaveEnabled(false);
            if (editorWindow.isSavedAll()) {
                parentFrame.setButtonSaveAllEnabled(false);
                parentFrame.setMenuItemSaveAllEnabled(false);
            }
        }
        else if (command.equalsIgnoreCase("Save All")){
            openAndSaveFile.saveAllFile();
            parentFrame.setMenuItemSaveEnabled(false);
            parentFrame.setButtonSaveEnabled(false);
            parentFrame.setButtonSaveAllEnabled(false);
            parentFrame.setMenuItemSaveAllEnabled(false);
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
                System.err.println(pe);
            }
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

    public JFileChooser getFileChooser(){
        return fileChooser;
    }
}
