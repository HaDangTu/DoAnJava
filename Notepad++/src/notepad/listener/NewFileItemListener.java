package notepad.listener;
import notepad.ui.NewFileDialog;
import notepad.util.CategoryOfFile;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;

public class NewFileItemListener implements ItemListener{

    protected NewFileDialog dialog;
    protected Hashtable<String, String> hashtable;

    public NewFileItemListener(NewFileDialog dialog){
        this.dialog = dialog;
        if (hashtable == null)
            prepareHashtable();
    }

    public void prepareHashtable(){
        hashtable = new Hashtable<>();
        hashtable.put("Normal text file", CategoryOfFile.NORMAL_TEXT_FILE);
        hashtable.put("Action Script file", CategoryOfFile.ACTIONSCRIPT_FILE);
        hashtable.put("Assembler file", CategoryOfFile.ASSEMBLER_X86_FILE);
        hashtable.put("C file", CategoryOfFile.C_FILE);
        hashtable.put("C++ file", CategoryOfFile.CPLUSPLUS_FILE);
        hashtable.put("C# file", CategoryOfFile.CSHARP_FILE);
        hashtable.put("CSS file", CategoryOfFile.CSS_FILE);
        hashtable.put("CSV file", CategoryOfFile.CSV_FILE);
        hashtable.put("D file", CategoryOfFile.D_FILE);
        hashtable.put("Dart file", CategoryOfFile.DART_FILE);
        hashtable.put("Dtd file", CategoryOfFile.DTD_FILE);
        hashtable.put("Groovy file", CategoryOfFile.GROOVY_FILE);
        hashtable.put("HTML file", CategoryOfFile.HTML_FILE);
        hashtable.put("HTAccess file", CategoryOfFile.HTACCESS_FILE);
        hashtable.put("INI file", CategoryOfFile.INI_FILE);
        hashtable.put("Java file", CategoryOfFile.JAVA_FILE);
        hashtable.put("JavaScript file", CategoryOfFile.JAVASCRIPT_FILE);
        hashtable.put("JSON file", CategoryOfFile.JSON_FILE);
        hashtable.put("JSP file", CategoryOfFile.JSP_FILE);
        hashtable.put("Latex file", CategoryOfFile.LATEX_FILE);
        hashtable.put("Less file", CategoryOfFile.LESS_FILE);
        hashtable.put("Lisp file", CategoryOfFile.LISP_FILE);
        hashtable.put("Lua file", CategoryOfFile.LUA_FILE);
        hashtable.put("PHP file", CategoryOfFile.PHP_FILE);
        hashtable.put("Python file", CategoryOfFile.PYTHON_FILE);
        hashtable.put("Perl file", CategoryOfFile.PERL_FILE);
        hashtable.put("Properties file", CategoryOfFile.PROPERTIES_FILE);
        hashtable.put("Ruby file", CategoryOfFile.RUBY_FILE);
        hashtable.put("Sql file", CategoryOfFile.SQL_FILE);
        hashtable.put("Sas file", CategoryOfFile.SAS_FILE);
        hashtable.put("Scala file", CategoryOfFile.SCALA_FILE);
        hashtable.put("TCL file", CategoryOfFile.TCL_FILE);
        hashtable.put("TypeScript file", CategoryOfFile.TYPESCRIPT_FILE);
        hashtable.put("Visual Basic file", CategoryOfFile.VISUAL_BASIC_FILE);
        hashtable.put("Window batch file", CategoryOfFile.WINDOWS_BATCH_FILE);
        hashtable.put("XML file", CategoryOfFile.XML_FILE);
        hashtable.put("YAML file", CategoryOfFile.YAML_FILE);
        hashtable.put("Header file", CategoryOfFile.C_HEADER_FILE);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            String extension = hashtable.get(e.getItem().toString());
            String name = dialog.getName().substring(0, dialog.getName().indexOf("."));
            dialog.setName(name + extension);
        }
    }

}
