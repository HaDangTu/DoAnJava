package notepad.ui;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class EditorView extends JPanel{

    private EditorWindow editorWindow;

    public EditorView(){
        super();
        editorWindow = new EditorWindow();

        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        setLayout(new BorderLayout(0,0));
        setBorder(border);
        //setPreferredSize(new Dimension(800, 600));
        add(editorWindow, BorderLayout.CENTER);
    }

    public EditorWindow getEditorWindow() {
        return editorWindow;
    }
}
