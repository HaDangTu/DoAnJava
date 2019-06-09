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
    public static String RUBY_FILE = ".rb";
    public static String CSV_FILE = ".csv";
    public static String D_FILE = ".d";
    public static String DOCKER_FILE = "";
    public static String DART_FILE = ".dart";
    public static String DTD_FILE = ".dtd";
    public static String GROOVY_FILE = ".groovy";
    public static String HTACCESS_FILE = ".htaccess";
    public static String ACTIONSCRIPT_FILE = ".asc";
    public static String ASSEMBLER_X86_FILE = ".asm";
    public static String INI_FILE = ".ini";
    public static String JSP_FILE = ".jsp";
    public static String LATEX_FILE = ".tex";
    public static String LESS_FILE = ".less";
    public static String LISP_FILE = ".lsp";
    public static String LUA_FILE = ".lua";
    public static String PERL_FILE = ".pl";
    public static String PROPERTIES_FILE = ".properties";
    public static String SAS_FILE = ".sas";
    public static String SCALA_FILE = ".scala";
    public static String TCL_FILE = ".tcl";
    public static String TYPESCRIPT_FILE = ".ts";
    public static String VISUAL_BASIC_FILE = ".vb";
    public static String WINDOWS_BATCH_FILE = ".bat";
    public static String YAML_FILE = ".yaml ";


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
    public boolean detectRubyFile (String ext) {
        return ext.equalsIgnoreCase(RUBY_FILE);
    }
    public boolean detectCSVFile (String ext) {
        return ext.equalsIgnoreCase(CSV_FILE);
    }
    public boolean detectDFile (String ext) {
        return ext.equalsIgnoreCase(D_FILE);
    }
    public boolean detectDartFile (String ext) {
        return ext.equalsIgnoreCase(DART_FILE);
    }
    public boolean detectDockerFile (String ext) {
        return ext.equalsIgnoreCase(DOCKER_FILE);
    }
    public boolean detectDTDFile (String ext) {
        return ext.equalsIgnoreCase(DTD_FILE);
    }
    public boolean detectGroovyFile (String ext) {
        return ext.equalsIgnoreCase(GROOVY_FILE);
    }
    public boolean detectHTAccessFile (String ext) {
        return ext.equalsIgnoreCase(HTACCESS_FILE);
    }
    public boolean detectAssemblerFile (String ext) {
        return ext.equalsIgnoreCase(ASSEMBLER_X86_FILE);
    }
    public boolean detectActionScriptFile (String ext) {
        return ext.equalsIgnoreCase(ACTIONSCRIPT_FILE);
    }
    public boolean detectINIFile (String ext) {
        return ext.equalsIgnoreCase(INI_FILE);
    }
    public boolean detectJSPFile (String ext) {
        return ext.equalsIgnoreCase(JSP_FILE);
    }
    public boolean detectLatexFile (String ext) {
        return ext.equalsIgnoreCase(LATEX_FILE);
    }
    public boolean detectLessFile (String ext) {
        return ext.equalsIgnoreCase(LESS_FILE);
    }
    public boolean detectLispFile (String ext) {
        return ext.equalsIgnoreCase(LISP_FILE);
    }
    public boolean detectLuaFile (String ext) {
        return ext.equalsIgnoreCase(LUA_FILE);
    }
    public boolean detectPerlFile (String ext) {
        return ext.equalsIgnoreCase(PERL_FILE);
    }
    public boolean detectPropertiesFile (String ext) {
        return ext.equalsIgnoreCase(PROPERTIES_FILE);
    }
    public boolean detectSASFile (String ext) {
        return ext.equalsIgnoreCase(SAS_FILE);
    }
    public boolean detectScalaFile (String ext) {
        return ext.equalsIgnoreCase(SCALA_FILE);
    }
    public boolean detectTCLFile (String ext) {
        return ext.equalsIgnoreCase(TCL_FILE);
    }
    public boolean detectTypeScriptFile (String ext) {
        return ext.equalsIgnoreCase(TYPESCRIPT_FILE);
    }
    public boolean detectVisualBasicFile (String ext) {
        return ext.equalsIgnoreCase(VISUAL_BASIC_FILE);
    }
    public boolean detectWindowsBatchFile (String ext) {
        return ext.equalsIgnoreCase(WINDOWS_BATCH_FILE);
    }
    public boolean detectYamlFile (String ext) {
        return ext.equalsIgnoreCase(YAML_FILE);
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
        else if (category.detectRubyFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_RUBY, textEditor);
            return RUBY_FILE;
        }
        else if (category.detectCSVFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSV, textEditor);
            return CSV_FILE;
        }
        else if (category.detectDFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_D, textEditor);
            return D_FILE;
        }
        else if (category.detectDockerFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_DOCKERFILE, textEditor);
            return DOCKER_FILE;
        }
        else if (category.detectDartFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_DART, textEditor);
            return DART_FILE;
        }
        else if (category.detectDTDFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_DTD, textEditor);
            return DTD_FILE;
        }
        else if (category.detectGroovyFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_GROOVY, textEditor);
            return GROOVY_FILE;
        }
        else if (category.detectHTAccessFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_HTACCESS, textEditor);
            return HTACCESS_FILE;
        }
        else if (category.detectAssemblerFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86, textEditor);
            return ASSEMBLER_X86_FILE;
        }
        else if (category.detectActionScriptFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT, textEditor);
            return ACTIONSCRIPT_FILE;
        }
        else if (category.detectINIFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_INI, textEditor);
            return INI_FILE;
        }
        else if (category.detectJSPFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JSP, textEditor);
            return JSP_FILE;
        }
        else if (category.detectLatexFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_LATEX, textEditor);
            return LATEX_FILE;
        }
        else if (category.detectLessFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_LESS, textEditor);
            return LESS_FILE;
        }
        else if (category.detectLispFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_LISP, textEditor);
            return LISP_FILE;
        }
        else if (category.detectLuaFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_LUA, textEditor);
            return LUA_FILE;
        }
        else if (category.detectPerlFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PERL, textEditor);
            return PERL_FILE;
        }
        else if (category.detectPropertiesFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE, textEditor);
            return PROPERTIES_FILE;
        }
        else if (category.detectSASFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_SAS, textEditor);
            return SAS_FILE;
        }
        else if (category.detectScalaFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_SCALA, textEditor);
            return SCALA_FILE;
        }
        else if (category.detectTCLFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_TCL, textEditor);
            return TCL_FILE;
        }
        else if (category.detectTypeScriptFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_TYPESCRIPT, textEditor);
            return TYPESCRIPT_FILE;
        }
        else if (category.detectVisualBasicFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_VISUAL_BASIC, textEditor);
            return VISUAL_BASIC_FILE;
        }
        else if (category.detectWindowsBatchFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH, textEditor);
            return WINDOWS_BATCH_FILE;
        }
        else if (category.detectYamlFile(fileExtension)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_YAML, textEditor);
            return YAML_FILE;
        }
        else {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_NONE, textEditor);
            return NORMAL_TEXT_FILE;
        }
    }

    public String getExtensionOfFile(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public String CovertFileExtensionToFileType(String extension){
        if (extension.equalsIgnoreCase(CategoryOfFile.C_FILE))
            return "C source file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.C_HEADER_FILE))
            return "C header source file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.CPLUSPLUS_FILE))
            return "C++ source file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.CSHARP_FILE))
            return "C# source file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.JAVA_FILE))
            return "Java source file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.JAVASCRIPT_FILE))
            return "Javascript file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.JSON_FILE))
            return "JSON  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.PHP_FILE))
            return "PHP Hypertext Preprocessor file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.PYTHON_FILE))
            return "Python file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.CSS_FILE))
            return "Cascades Style Sheets file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.HTML_FILE))
            return "Hyper Text Markup Language file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.SQL_FILE))
            return "Structured Query Language file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.XML_FILE))
            return "Extensible Markup Language file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.RUBY_FILE))
            return "Ruby  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.D_FILE))
            return "D  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.DOCKER_FILE))
            return "DOCKER file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.DART_FILE))
            return "DART  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.DTD_FILE))
            return "DTD  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.GROOVY_FILE))
            return "Groovy  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.HTACCESS_FILE))
            return "HTAccess  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.ACTIONSCRIPT_FILE))
            return "ActionScriprt  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.ASSEMBLER_X86_FILE))
            return "ASSEMBLER  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.INI_FILE))
            return "INI  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.JSP_FILE))
            return "JSP  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.LATEX_FILE))
            return "LATEX  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.LESS_FILE))
            return "LESS  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.LISP_FILE))
            return "LISP  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.LUA_FILE))
            return "LUA  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.PERL_FILE))
            return "PERL  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.PROPERTIES_FILE))
            return "PROPERTIES  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.SAS_FILE))
            return "SAS  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.SCALA_FILE))
            return "SCALA  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.TCL_FILE))
            return "TCL  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.TYPESCRIPT_FILE))
            return "TYPESCRIPT  file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.VISUAL_BASIC_FILE))
            return "VISUAL_BASIC file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.WINDOWS_BATCH_FILE))
            return "WINDOWS_BATCH file";
        else if (extension.equalsIgnoreCase(CategoryOfFile.YAML_FILE))
            return "YAML file";
        return "Normal text";
    }
}
