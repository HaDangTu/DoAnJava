package notepad.ui;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

import java.awt.GridLayout;
public class EditorView extends JPanel{

    private EditorWindow editorWindow;

    public EditorView(){
        editorWindow = new EditorWindow();

        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        setLayout(new GridLayout(1, 1));
        setBorder(border);

        add(editorWindow);
    }

    public EditorWindow getEditorWindow() {
        return editorWindow;
    }
}
