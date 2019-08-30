package notepad.util;

import notepad.ui.EditorWindow;
import notepad.ui.TextEditor;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import java.util.Enumeration;
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

    private Hashtable<String, Language> fileType;

    public CategoryOfFile(){
        initFileType();
    }

    private static CategoryOfFile __instance;

    public static CategoryOfFile getInstance(){
        if (__instance == null) __instance = new CategoryOfFile();
        return __instance;
    }

    private void initFileType(){
        fileType = new Hashtable<>();
        fileType.put("Action script file", new Language(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT, ACTIONSCRIPT_FILE));
        fileType.put("Assembler x86 file", new Language(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86, ASSEMBLER_X86_FILE));

        fileType.put("C source file", new Language(SyntaxConstants.SYNTAX_STYLE_C, C_FILE));
        fileType.put("C header source file", new Language(SyntaxConstants.SYNTAX_STYLE_C, C_HEADER_FILE));
        fileType.put("C++ source file", new Language(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS, CPLUSPLUS_FILE));
        fileType.put("C# source file", new Language(SyntaxConstants.SYNTAX_STYLE_CSHARP, CSHARP_FILE));
        fileType.put("Cascades Style Sheets file", new Language(SyntaxConstants.SYNTAX_STYLE_CSS, CSS_FILE));
        fileType.put("Comma Separated Values file", new Language(SyntaxConstants.SYNTAX_STYLE_CSV, CSV_FILE));

        fileType.put("D file", new Language(SyntaxConstants.SYNTAX_STYLE_D, D_FILE));
        fileType.put("Dart file", new Language(SyntaxConstants.SYNTAX_STYLE_DART, DART_FILE));
        fileType.put("DTD file", new Language(SyntaxConstants.SYNTAX_STYLE_DTD, DTD_FILE));

        fileType.put("Groovy file", new Language(SyntaxConstants.SYNTAX_STYLE_GROOVY, GROOVY_FILE));

        fileType.put("Hyper Text Markup Language file", new Language(SyntaxConstants.SYNTAX_STYLE_HTML, HTML_FILE));
        fileType.put("HTAccess  file", new Language(SyntaxConstants.SYNTAX_STYLE_HTACCESS, HTACCESS_FILE));

        fileType.put("INI  file", new Language(SyntaxConstants.SYNTAX_STYLE_INI, INI_FILE));

        fileType.put("Java source file", new Language(SyntaxConstants.SYNTAX_STYLE_JAVA, JAVA_FILE));
        fileType.put("Javascript file", new Language(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT, JAVASCRIPT_FILE));
        fileType.put("JSON file", new Language(SyntaxConstants.SYNTAX_STYLE_JSON, JSON_FILE));
        fileType.put("JSP file", new Language(SyntaxConstants.SYNTAX_STYLE_JSP, JSP_FILE));

        fileType.put("LATEX file", new Language(SyntaxConstants.SYNTAX_STYLE_LATEX, LATEX_FILE));
        fileType.put("LESS file", new Language(SyntaxConstants.SYNTAX_STYLE_LESS, LESS_FILE));
        fileType.put("LISP file", new Language(SyntaxConstants.SYNTAX_STYLE_LISP, LISP_FILE));
        fileType.put("LUA file", new Language(SyntaxConstants.SYNTAX_STYLE_LUA, LUA_FILE));

        fileType.put("Normal text", new Language(SyntaxConstants.SYNTAX_STYLE_NONE, NORMAL_TEXT_FILE));

        fileType.put("PHP Hypertext Preprocessor file", new Language(SyntaxConstants.SYNTAX_STYLE_PHP, PHP_FILE));
        fileType.put("Python file", new Language(SyntaxConstants.SYNTAX_STYLE_PYTHON, PYTHON_FILE));
        fileType.put("Perl  file", new Language(SyntaxConstants.SYNTAX_STYLE_PERL, PERL_FILE));
        fileType.put("PROPERTIES file", new Language(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE, PROPERTIES_FILE));

        fileType.put("Ruby file", new Language(SyntaxConstants.SYNTAX_STYLE_RUBY, RUBY_FILE));

        fileType.put("Structured Query Language file", new Language(SyntaxConstants.SYNTAX_STYLE_SQL, SQL_FILE));
        fileType.put("SCALA file", new Language(SyntaxConstants.SYNTAX_STYLE_SCALA, SCALA_FILE));
        fileType.put("SAS file", new Language(SyntaxConstants.SYNTAX_STYLE_SAS, SAS_FILE));

        fileType.put("TCL file", new Language(SyntaxConstants.SYNTAX_STYLE_TCL, TCL_FILE));
        fileType.put("TYPESCRIPT file", new Language(SyntaxConstants.SYNTAX_STYLE_TYPESCRIPT, TYPESCRIPT_FILE));

        fileType.put("Visual Basic source file", new Language(SyntaxConstants.SYNTAX_STYLE_VISUAL_BASIC, VISUAL_BASIC_FILE));
        fileType.put("Windows batch file", new Language(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH, WINDOWS_BATCH_FILE));

        fileType.put("Extensible Markup Language file", new Language(SyntaxConstants.SYNTAX_STYLE_XML, XML_FILE));

        fileType.put("YAML file", new Language(SyntaxConstants.SYNTAX_STYLE_YAML, YAML_FILE));
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

    public String getExtensionOfFile(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public String CovertFileExtensionToFileType(String extension){
        Enumeration<String> keys = fileType.keys();
        String currentKey;
        while ((currentKey = keys.nextElement()) != null){
            Language lang = fileType.get(currentKey);
            if (lang.getExtension().equalsIgnoreCase(extension))
                return currentKey;
        }
        return null;
    }

    public Language getLanguageByExtension(String extension){
        Enumeration<String> keys = fileType.keys();
        String currentKey;
        while ((currentKey = keys.nextElement()) != null){
            Language lang = fileType.get(currentKey);
            if (lang.getExtension().equalsIgnoreCase(extension))
                return lang;
        }
        return null;
    }

    public Language getLanguage(String fileTypeName){
        return fileType.get(fileTypeName);
    }
}
