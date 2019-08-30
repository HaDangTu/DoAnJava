package notepad.util;

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

    private CategoryOfFile(){
        initFileType();
    }

    private static CategoryOfFile __instance;

    public static CategoryOfFile getInstance(){
        if (__instance == null) __instance = new CategoryOfFile();
        return __instance;
    }

    private void initFileType(){
        fileType = new Hashtable<>();
        fileType.put(ACTIONSCRIPT_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT, "Action script file"));
        fileType.put(ASSEMBLER_X86_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86, "Assembler x86 file"));

        fileType.put(C_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_C, "C source file"));
        fileType.put(C_HEADER_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_C, "Header file"));
        fileType.put(CPLUSPLUS_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS, "C++ source file"));
        fileType.put(CSHARP_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_CSHARP, "C# source file"));
        fileType.put(CSS_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_CSS, "Cascades Style Sheets file"));
        fileType.put(CSV_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_CSV, "Comma Separated Values file"));

        fileType.put(D_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_D, "D file"));
        fileType.put(DART_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_DART, "Dart file"));
        fileType.put(DTD_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_DTD, "DTD file"));

        fileType.put(GROOVY_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_GROOVY, "Groovy file"));

        fileType.put(HTML_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_HTML, "Hyper Text Markup Language file"));
        fileType.put(HTACCESS_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_HTACCESS, "HTAccess  file"));

        fileType.put(INI_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_INI, "INI  file"));

        fileType.put(JAVA_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_JAVA, "Java source file"));
        fileType.put(JAVASCRIPT_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT, "Javascript file"));
        fileType.put(JSON_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_JSON, "JSON file"));
        fileType.put(JSP_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_JSP, "JSP file"));

        fileType.put(LATEX_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_LATEX, "LATEX file"));
        fileType.put(LESS_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_LESS, "LESS file"));
        fileType.put(LISP_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_LISP, "LISP file"));
        fileType.put(LUA_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_LUA, "LUA file"));

        fileType.put(NORMAL_TEXT_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_NONE, "Normal text file"));

        fileType.put(PHP_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_PHP, "PHP Hypertext Preprocessor file"));
        fileType.put(PYTHON_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_PYTHON, "Python file"));
        fileType.put(PERL_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_PERL, "Perl  file"));
        fileType.put(PROPERTIES_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE, "PROPERTIES file"));

        fileType.put(RUBY_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_RUBY, "Ruby file"));

        fileType.put(SQL_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_SQL, "Structured Query Language file"));
        fileType.put(SCALA_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_SCALA, "SCALA file"));
        fileType.put(SAS_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_SAS, "SAS file"));

        fileType.put(TCL_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_TCL, "TCL file"));
        fileType.put(TYPESCRIPT_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_TYPESCRIPT, "TYPESCRIPT file"));

        fileType.put(VISUAL_BASIC_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_VISUAL_BASIC, "Visual Basic source file"));
        fileType.put(WINDOWS_BATCH_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH, "Windows batch file"));

        fileType.put(XML_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_XML, "Extensible Markup Language file"));

        fileType.put(YAML_FILE, new Language(SyntaxConstants.SYNTAX_STYLE_YAML, "YAML file"));
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

    /**
     *
     * @param fileTypeName ex C source file, C++ source file
     * @return file extension
     */
    public String getKey(String fileTypeName){
        Enumeration<String> keys = fileType.keys();
        String currentKey;
        while ((currentKey = keys.nextElement()) != null){
            Language language = fileType.get(currentKey);
            if (language.getFileType().equalsIgnoreCase(fileTypeName))
                return currentKey;
        }
        return null;
    }

    public Language getLanguage(String extension){
        return fileType.get(extension);
    }
}
