package notepad.listener;
import notepad.ui.EditorWindow;
import notepad.util.CategoryOfFile;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import java.awt.event.ActionEvent;

public class MenuLanguageActionListener extends MenuMainWindowListener {
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
        else if (command.equalsIgnoreCase(CategoryOfFile.RUBY_FILE)){
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_RUBY);
            resetFileType(CategoryOfFile.RUBY_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.CSV_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_CSV);
            resetFileType(CategoryOfFile.CSV_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.D_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_D);
            resetFileType(CategoryOfFile.D_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.DART_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_DART);
            resetFileType(CategoryOfFile.DART_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.DTD_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_DTD);
            resetFileType(CategoryOfFile.DTD_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.GROOVY_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_GROOVY);
            resetFileType(CategoryOfFile.GROOVY_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.HTACCESS_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_HTACCESS);
            resetFileType(CategoryOfFile.HTACCESS_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.ACTIONSCRIPT_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT);
            resetFileType(CategoryOfFile.ACTIONSCRIPT_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.ASSEMBLER_X86_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86);
            resetFileType(CategoryOfFile.ASSEMBLER_X86_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.INI_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_INI);
            resetFileType(CategoryOfFile.INI_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.JSP_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_JSP);
            resetFileType(CategoryOfFile.JSP_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.LATEX_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_LATEX);
            resetFileType(CategoryOfFile.LATEX_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.LESS_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_LESS);
            resetFileType(CategoryOfFile.LESS_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.LISP_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_LISP);
            resetFileType(CategoryOfFile.LISP_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.LUA_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_LUA);
            resetFileType(CategoryOfFile.LUA_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.PERL_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PERL);
            resetFileType(CategoryOfFile.PERL_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.PROPERTIES_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE);
            resetFileType(CategoryOfFile.PROPERTIES_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.SAS_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_SAS);
            resetFileType(CategoryOfFile.SAS_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.SCALA_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_SCALA);
            resetFileType(CategoryOfFile.SCALA_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.TCL_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_TCL);
            resetFileType(CategoryOfFile.TCL_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.TYPESCRIPT_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_TYPESCRIPT);
            resetFileType(CategoryOfFile.TYPESCRIPT_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.VISUAL_BASIC_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_VISUAL_BASIC);
            resetFileType(CategoryOfFile.VISUAL_BASIC_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.WINDOWS_BATCH_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH);
            resetFileType(CategoryOfFile.WINDOWS_BATCH_FILE);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.YAML_FILE)) {
            editorWindow.setEditorStyle(SyntaxConstants.SYNTAX_STYLE_YAML);
            resetFileType(CategoryOfFile.YAML_FILE);
        }


    }

    public void resetFileType(String fileType){
        int index = editorWindow.getSelectedIndex();
        editorWindow.setFileTypeForTab(fileType, index);
    }
}
