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
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_C,
                    CategoryOfFile.C_FILE, true);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.CPLUSPLUS_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS,
                    CategoryOfFile.CPLUSPLUS_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.CSHARP_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_CSHARP,
                    CategoryOfFile.CSHARP_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.CSS_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_CSS,
                    CategoryOfFile.CSS_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.NORMAL_TEXT_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_NONE,
                    CategoryOfFile.NORMAL_TEXT_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.PHP_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_PHP,
                    CategoryOfFile.PHP_FILE, true);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.PYTHON_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_PYTHON,
                    CategoryOfFile.PYTHON_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.JAVA_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_JAVA,
                    CategoryOfFile.JAVA_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.JAVASCRIPT_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT,
                    CategoryOfFile.JAVASCRIPT_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.JSON_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_JSON,
                    CategoryOfFile.JSON_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.HTML_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_HTML,
                    CategoryOfFile.HTML_FILE, true);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.XML_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_XML,
                    CategoryOfFile.XML_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.RUBY_FILE)){
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_RUBY,
                    CategoryOfFile.RUBY_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.CSV_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_CSV,
                    CategoryOfFile.CSV_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.D_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_D,
                    CategoryOfFile.D_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.DART_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_DART,
                    CategoryOfFile.DART_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.DTD_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_DTD,
                    CategoryOfFile.DTD_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.GROOVY_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    CategoryOfFile.GROOVY_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.HTACCESS_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_HTACCESS,
                    CategoryOfFile.HTACCESS_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.ACTIONSCRIPT_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT,
                    CategoryOfFile.ACTIONSCRIPT_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.ASSEMBLER_X86_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86,
                    CategoryOfFile.ASSEMBLER_X86_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.INI_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_INI,
                    CategoryOfFile.INI_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.JSP_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_JSP,
                    CategoryOfFile.JSP_FILE, true);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.LATEX_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_LATEX,
                    CategoryOfFile.LATEX_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.LESS_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_LESS,
                    CategoryOfFile.LESS_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.LISP_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_LISP,
                    CategoryOfFile.LISP_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.LUA_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_LUA,
                    CategoryOfFile.LUA_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.PERL_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_PERL,
                    CategoryOfFile.PERL_FILE, true);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.PROPERTIES_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE,
                    CategoryOfFile.PROPERTIES_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.SAS_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_SAS,
                    CategoryOfFile.SAS_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.SCALA_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_SCALA,
                    CategoryOfFile.SCALA_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.TCL_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_TCL,
                    CategoryOfFile.TCL_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.TYPESCRIPT_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_TYPESCRIPT,
                    CategoryOfFile.TYPESCRIPT_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.VISUAL_BASIC_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_VISUAL_BASIC,
                    CategoryOfFile.VISUAL_BASIC_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.WINDOWS_BATCH_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH,
                    CategoryOfFile.WINDOWS_BATCH_FILE, false);
        }
        else if (command.equalsIgnoreCase(CategoryOfFile.YAML_FILE)) {
            editorWindow.setStyleForTab(SyntaxConstants.SYNTAX_STYLE_YAML,
                    CategoryOfFile.YAML_FILE, false);
        }
    }
}
