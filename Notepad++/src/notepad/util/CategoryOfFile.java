package notepad.util;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import java.util.Hashtable;

public class CategoryOfFile {
    public static String ACTIONSCRIPT_FILE = ".asc";
    public static String ASSEMBLER_X86_FILE = ".asm";

    public static String C_FILE = ".c";
    public static String CPLUSPLUS_FILE = ".cpp";
    public static String CSHARP_FILE = ".cs";
    public static String C_HEADER_FILE = ".h";
    public static String CSS_FILE = ".css";
    public static String CSV_FILE = ".csv";

    public static String D_FILE = ".d";
    public static String DART_FILE = ".dart";
    public static String DTD_FILE = ".dtd";

    public static String GROOVY_FILE = ".groovy";

    public static String HTML_FILE = ".html";
    public static String HTACCESS_FILE = ".htaccess";

    public static String INI_FILE = ".ini";

    public static String JAVA_FILE = ".java";
    public static String JAVASCRIPT_FILE = ".js";
    public static String JSON_FILE = ".json";
    public static String JSP_FILE = ".jsp";

    public static String LATEX_FILE = ".tex";
    public static String LESS_FILE = ".less";
    public static String LISP_FILE = ".lsp";
    public static String LUA_FILE = ".lua";

    public static String NORMAL_TEXT_FILE = ".txt";

    public static String PHP_FILE = ".php";
    public static String PYTHON_FILE = ".py";
    public static String PERL_FILE = ".pl";
    public static String PROPERTIES_FILE = ".properties";

    public static String RUBY_FILE = ".rb";

    public static String SQL_FILE = ".sql";
    public static String SAS_FILE = ".sas";
    public static String SCALA_FILE = ".scala";

    public static String TCL_FILE = ".tcl";
    public static String TYPESCRIPT_FILE = ".ts";

    public static String VISUAL_BASIC_FILE = ".vb";

    public static String WINDOWS_BATCH_FILE = ".bat";

    public static String XML_FILE = ".xml";

    public static String YAML_FILE = ".yaml ";

    private Hashtable<String, String> fileTypeName;

    public void initFileTypeName(){
        fileTypeName = new Hashtable<>();

        fileTypeName.put(C_FILE, "C source file");
        fileTypeName.put(C_HEADER_FILE, "C header source file");
        fileTypeName.put(CPLUSPLUS_FILE, "C++ source file");
        fileTypeName.put(CSHARP_FILE, "C# source file");
        fileTypeName.put(CSS_FILE, "Cascades Style Sheets file");
        fileTypeName.put(CSV_FILE, "Comma Separated Values file");

        fileTypeName.put(D_FILE, "D  file");
        fileTypeName.put(DART_FILE, "Dart  file");
        fileTypeName.put(DTD_FILE, "DTD  file");

        fileTypeName.put(GROOVY_FILE, "Groovy  file");

        fileTypeName.put(HTML_FILE, "Hyper Text Markup Language file");
        fileTypeName.put(HTML_FILE, "HTAccess  file");

        fileTypeName.put(JAVA_FILE, "Java source file");
        fileTypeName.put(JAVASCRIPT_FILE, "Javascript file");
        fileTypeName.put(JSON_FILE, "JSON  file");
        fileTypeName.put(JSP_FILE, "JSP  file");

        fileTypeName.put(LATEX_FILE, "LATEX file");
        fileTypeName.put(LESS_FILE, "LESS file");
        fileTypeName.put(LISP_FILE, "LISP file");
        fileTypeName.put(LUA_FILE, "LUA file");

        fileTypeName.put(NORMAL_TEXT_FILE, "Normal text");

        fileTypeName.put(PHP_FILE, "PHP Hypertext Preprocessor file");
        fileTypeName.put(PYTHON_FILE, "Python file");
        fileTypeName.put(PERL_FILE, "Perl  file");
        fileTypeName.put(PROPERTIES_FILE, "PROPERTIES file");

        fileTypeName.put(RUBY_FILE, "Ruby file");

        fileTypeName.put(SQL_FILE, "Structured Query Language file");
        fileTypeName.put(SCALA_FILE, "SCALA  file");
        fileTypeName.put(SAS_FILE, "SAS  file");

        fileTypeName.put(TCL_FILE, "TCL  file");
        fileTypeName.put(TYPESCRIPT_FILE, "TYPESCRIPT  file");

        fileTypeName.put(VISUAL_BASIC_FILE, "Visual Basic source file");
        fileTypeName.put(WINDOWS_BATCH_FILE, "Windows batch file");

        fileTypeName.put(XML_FILE, "Extensible Markup Language file");

        fileTypeName.put(YAML_FILE, "YAML file");
    }

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
        return fileTypeName.get(extension);
    }
}
