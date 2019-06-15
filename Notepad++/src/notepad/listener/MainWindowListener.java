package notepad.listener;

import notepad.ui.EditorWindow;

import notepad.ui.MainWindow;
import notepad.ui.TextEditor;
import notepad.util.MyComparator;
import notepad.util.OpenAndSaveFile;
import notepad.util.TabInteraction;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class MainWindowListener implements WindowListener {
    private TabInteraction tabInteraction;
    private EditorWindow editorWindow;
    public MainWindowListener(EditorWindow editorWindow){
        this.editorWindow = editorWindow;
        tabInteraction = new TabInteraction(editorWindow);
    }
    @Override
    public void windowOpened(WindowEvent e) {
        //textArea.setCaretPosition(0);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int tabCount = editorWindow.getTabCount();
        MainWindow mainWindow = (MainWindow) editorWindow.getRootPane().getParent();
        int index = 0;
        for (int i = 0; i < tabCount; i++){
            TextEditor textEditor = editorWindow.getTextEditor(index);
            if (!textEditor.getIsChanged()){
                if (editorWindow.getFilePathOfTab(index).equalsIgnoreCase(""))
                    editorWindow.addDeletedTab(textEditor.getNumberOfTab());
                editorWindow.removeTabAt(index);
            }
            else{
                int result = JOptionPane.showConfirmDialog(null,
                        "Do you want to save change of file " + editorWindow.getTitleOfTab(0) + "?",
                        "Save file",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                if (result == 0){
                    OpenAndSaveFile openAndSaveFile = new OpenAndSaveFile(new JFileChooser(), editorWindow, null);
                    openAndSaveFile.saveFile(textEditor, index);
                    if (textEditor.getNumberOfTab() != -1)
                        editorWindow.addDeletedTab(textEditor.getNumberOfTab());
                    editorWindow.removeTabAt(index);
                }
                else if (result == 1)
                    editorWindow.removeTabAt(index);
                else
                    return;
            }

            if (editorWindow.getTabCount() == 0) {
                editorWindow.addTabEditor();
                mainWindow.addItem(editorWindow.getTitleOfTab(0));
            }

            editorWindow.getDeletedTab().sort(new MyComparator());

            mainWindow.removeItem(index);
        }

        mainWindow.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
