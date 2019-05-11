package notepad.listener;
import notepad.ui.EditorWindow;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import java.awt.event.ActionEvent;
public class MenuLanguageActionListener  extends MenuMainWindowListener {
    public MenuLanguageActionListener(EditorWindow editorWindow){
        super(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("C")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_C);
        }
        else if (command.equalsIgnoreCase("C++")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
        }
        else if (command.equalsIgnoreCase("C#")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
        }
        else if (command.equalsIgnoreCase("CSS")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSS);
        }
        else if (command.equalsIgnoreCase("Normal text")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
        }
        else if (command.equalsIgnoreCase("PHP")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PHP);
        }
        else if (command.equalsIgnoreCase("Python")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
        }
        else if (command.equalsIgnoreCase("Java")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        }
        else if (command.equalsIgnoreCase("Java Script")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
        }
        else if (command.equalsIgnoreCase("JSON")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
        }
        else if (command.equalsIgnoreCase("HTML")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
        }
        else if (command.equalsIgnoreCase("XML")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_XML);
        }
    }

}
