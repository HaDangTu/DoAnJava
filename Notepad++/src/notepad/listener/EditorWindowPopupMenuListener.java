package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.MainWindow;
import notepad.ui.TextEditor;
import notepad.ui.RenameDialog;

import notepad.util.OpenAndSaveFile;
import notepad.util.PrintText;

import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;

public class EditorWindowPopupMenuListener extends BaseActionListener{

    private JFileChooser fileChooser;
    private OpenAndSaveFile openAndSaveFile;

    public EditorWindowPopupMenuListener(EditorWindow editorWindow){
        super(editorWindow);

        fileChooser = new JFileChooser();
        mainWindow = (MainWindow) editorWindow.getRootPane().getParent();
        openAndSaveFile = new OpenAndSaveFile(fileChooser, editorWindow, mainWindow);
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int index = editorWindow.getSelectedIndex();
        if (command.equalsIgnoreCase("Close"))
            editorWindow.closeTabAt(fileChooser, index);
        else if (command.equalsIgnoreCase("Close all but this"))
            editorWindow.closeAllButThis(fileChooser);
        else if (command.equalsIgnoreCase("Close left tab"))
            editorWindow.closeLeftTab(fileChooser);
        else if (command.equalsIgnoreCase("Close right tab"))
            editorWindow.closeRightTab(fileChooser);
        else if (command.equalsIgnoreCase("Save")){
            TextEditor textEditor = editorWindow.getTextEditor(index);
            openAndSaveFile.saveFile(textEditor, index);
        }
        else if (command.equalsIgnoreCase("Save as")){
            TextEditor textEditor = editorWindow.getTextEditor(index);
            openAndSaveFile.saveAsFile(textEditor, index);
        }
        else if (command.equalsIgnoreCase("Rename")){
            RenameDialog dialog = new RenameDialog(editorWindow);
            dialog.showDialog();
        }
        else if (command.equalsIgnoreCase("Print")){
            PrintText printText = new PrintText(editorWindow);
            try {
                printText.print();
            }
            catch (PrinterException pe){
                System.err.println(pe.getMessage());
            }
        }
    }
}
