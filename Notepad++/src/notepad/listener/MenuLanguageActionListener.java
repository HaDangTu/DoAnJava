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
        if (command.equalsIgnoreCase("C")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_C);
            resetFileType(CategoryOfFile.C_FILE);
        }
        else if (command.equalsIgnoreCase("C++")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
            resetFileType(CategoryOfFile.CPLUSPLUS_FILE);
        }
        else if (command.equalsIgnoreCase("C#")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
            resetFileType(CategoryOfFile.CSHARP_FILE);
        }
        else if (command.equalsIgnoreCase("CSS")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSS);
            resetFileType(CategoryOfFile.CSS_FILE);
        }
        else if (command.equalsIgnoreCase("Normal text")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
            resetFileType(CategoryOfFile.NORMAL_TEXT_FILE);
        }
        else if (command.equalsIgnoreCase("PHP")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PHP);
            resetFileType(CategoryOfFile.PHP_FILE);
        }
        else if (command.equalsIgnoreCase("Python")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
            resetFileType(CategoryOfFile.PYTHON_FILE);
        }
        else if (command.equalsIgnoreCase("Java")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
            resetFileType(CategoryOfFile.JAVA_FILE);
        }
        else if (command.equalsIgnoreCase("Java Script")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
            resetFileType(CategoryOfFile.JAVASCRIPT_FILE);
        }
        else if (command.equalsIgnoreCase("JSON")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
            resetFileType(CategoryOfFile.JSON_FILE);
        }
        else if (command.equalsIgnoreCase("HTML")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
            resetFileType(CategoryOfFile.HTML_FILE);
        }
        else if (command.equalsIgnoreCase("XML")){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_XML);
            resetFileType(CategoryOfFile.XML_FILE);
        }
    }

    public void resetFileType(String fileType){
        int index = editorWindow.getSelectedIndex();
        editorWindow.setFileTypeForTab(fileType, index);
    }
}
