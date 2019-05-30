package notepad.util;

import notepad.ui.StatusBar;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import java.util.Timer;
import java.util.TimerTask;

public class StatusBarTimer  extends  Timer{
    private StatusBar statusBar;
    private EditorWindow editorWindow;

    public StatusBarTimer (StatusBar statusBar, EditorWindow editorWindow) {
        super();
        this.statusBar = statusBar;
        this.editorWindow = editorWindow;

        this.schedule(new StatusBarTask(), 800, 800);
    }

    public class StatusBarTask extends TimerTask{

        @Override
        public void run() {
            int index = editorWindow.getSelectedIndex();
            TextEditor textEditor = editorWindow.getTextEditor(index);
            RSyntaxTextArea textArea = textEditor.getTextArea();

            statusBar.setFileType(textEditor);
            statusBar.setLengthAndLine(textArea);
            statusBar.setLineColumnSelect(textArea);
        }
    }
}
