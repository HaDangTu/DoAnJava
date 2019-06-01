package notepad.listener;
import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import notepad.util.CategoryOfFile;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import java.awt.event.ActionEvent;
public class MenuLanguageActionListener  extends MenuMainWindowListener {
    public MenuLanguageActionListener(EditorWindow editorWindow){
        super(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase(CategoryOfFile.C_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_C);
            resetFileType(CategoryOfFile.C_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.CPLUSPLUS_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
            resetFileType(CategoryOfFile.CPLUSPLUS_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.CSHARP_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
            resetFileType(CategoryOfFile.CSHARP_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.CSS_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSS);
            resetFileType(CategoryOfFile.CSS_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.NORMAL_TEXT_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
            resetFileType(CategoryOfFile.NORMAL_TEXT_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.PHP_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PHP);
            resetFileType(CategoryOfFile.PHP_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.PYTHON_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
            resetFileType(CategoryOfFile.PYTHON_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.JAVA_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
            resetFileType(CategoryOfFile.JAVA_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.JAVASCRIPT_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
            resetFileType(CategoryOfFile.JAVASCRIPT_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.JSON_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
            resetFileType(CategoryOfFile.JSON_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.HTML_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
            resetFileType(CategoryOfFile.HTML_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.XML_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_XML);
            resetFileType(CategoryOfFile.XML_FILE);
        }
    }

    public void resetFileType(String fileType){
        int index = editorWindow.getSelectedIndex();
        editorWindow.setFileTypeForTab(fileType, index);
    }
}
