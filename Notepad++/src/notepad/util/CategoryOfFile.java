package notepad.util;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

public class CategoryOfFile {
    public static String C_FILE = ".c";
    public static String CPLUSPLUS_FILE = ".cpp";
    public static String CSHARP_FILE = ".cs";
    public static String C_HEADER_FILE = ".h";
    public static String CSS_FILE = ".css";

    public static String HTML_FILE = ".html";

    public static String NORMAL_TEXT_FILE = ".txt";

    public static String PHP_FILE = ".php";
    public static String PYTHON_FILE = ".py";

    public static String JAVA_FILE = ".java";
    public static String JAVASCRIPT_FILE = ".js";
    public static String JSON_FILE = ".json";

    public static String SQL_FILE = ".sql";

    public static String XML_FILE = ".xml";

    public boolean detectCFile(String ext){
        return ext.equalsIgnoreCase(C_FILE);
    }

    public boolean detectCplusplusFile(String ext){
        return ext.equalsIgnoreCase(CPLUSPLUS_FILE);
    }

    public boolean detectCSharpFile(String ext){
        return ext.equalsIgnoreCase(CSHARP_FILE);
    }

    public boolean detectCSSFile(String ext){
        return ext.equalsIgnoreCase(CSS_FILE);
    }

    public boolean detectJavaFile(String ext){
        return ext.equalsIgnoreCase(JAVA_FILE);
    }

    public boolean detectJavaScriptFile(String ext){
        return ext.equalsIgnoreCase(JAVASCRIPT_FILE);
    }

    public boolean detectJsonFile(String ext){
        return ext.equalsIgnoreCase(JSON_FILE);
    }

    public boolean detectNormalTextFile(String ext){
        return ext.equalsIgnoreCase(NORMAL_TEXT_FILE);
    }

    public boolean detectPHPFile(String ext){
        return ext.equalsIgnoreCase(PHP_FILE);
    }

    public boolean detectPythonFile(String ext){
        return ext.equalsIgnoreCase(PYTHON_FILE);
    }

    public boolean detectHTMLFile(String ext) {
        return ext.equalsIgnoreCase(HTML_FILE);
    }

    public boolean detectHeaderFile(String ext) {
        return ext.equalsIgnoreCase(C_HEADER_FILE);
    }

    public boolean detectSQLFile(String ext) {
        return ext.equalsIgnoreCase(SQL_FILE);
    }

    public boolean detectXMLFile (String ext) {
        return ext.equalsIgnoreCase(XML_FILE);
    }

    public String ChangeStyleEditorForFile(String fileExtension, EditorWindow editorWindow){
        CategoryOfFile category = new CategoryOfFile();
        TextEditor textEditor = editorWindow.getTextEditor(editorWindow.getTabCount() - 1);
        if(category.detectCFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_C, textEditor);
            return C_FILE;
        }
        else if(category.detectCplusplusFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS, textEditor);
            return CPLUSPLUS_FILE;
        }
        else if (category.detectCSharpFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP, textEditor);
            return CSHARP_FILE;
        }
        else if (category.detectCSSFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSS, textEditor);
            return CSS_FILE;
        }
        else if (category.detectPHPFile(fileExtension)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PHP, textEditor);
            return PHP_FILE;
        }
        else if (category.detectPythonFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON, textEditor);
            return PYTHON_FILE;
        }
        else if (category.detectJavaFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JAVA, textEditor);
            return JAVA_FILE;
        }
        else if (category.detectJavaScriptFile(fileExtension)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT, textEditor);
            return JAVASCRIPT_FILE;
        }
        else if(category.detectJsonFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JSON, textEditor);
            return JSON_FILE;
        }
        else if (category.detectHTMLFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_HTML, textEditor);
            return HTML_FILE;
        }
        else if (category.detectHeaderFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_C, textEditor);
            return C_HEADER_FILE;
        }
        else if (category.detectSQLFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_SQL, textEditor);
            return SQL_FILE;
        }
        else if (category.detectXMLFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_XML, textEditor);
            return XML_FILE;
        }
        else {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_NONE, textEditor);
            return NORMAL_TEXT_FILE;
        }
    }

    public String getExtensionOfFile(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
