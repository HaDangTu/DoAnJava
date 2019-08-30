package notepad.ui;

import notepad.listener.MenuLanguageActionActionListener;
import notepad.util.CategoryOfFile;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import javax.swing.*;
import java.util.Enumeration;

class MenuLanguage extends JMenu{
    private JMenu menuA;
    private JMenu menuC;
    private JMenu menuD;
    private JMenu menuG;
    private JMenu menuH;
    private JMenu menuI;
    private JMenu menuJ;
    private JMenu menuL;
    private JMenu menuP;
    private JMenu menuR;
    private JMenu menuS;
    private JMenu menuT;
    private JMenu menuV;
    private JMenu menuW;
    private JMenu menuX;
    private JMenu menuY;



    private ButtonGroup buttonGroup;

    private MenuLanguageActionActionListener langListener;


    public MenuLanguage(EditorWindow editorWindow){
        super("Language");
        langListener = new MenuLanguageActionActionListener(editorWindow);
        buttonGroup = new ButtonGroup();

        createMenuA();
        createMenuC();
        createMenuD();
        createMenuG();
        createMenuH();
        createMenuI();
        createMenuJ();
        createMenuL();
        createMenuP();
        createMenuR();
        createMenuS();
        createMenuT();
        createMenuV();
        createMenuW();
        createMenuX();
        createMenuY();


        JCheckBoxMenuItem normalText = new JCheckBoxMenuItem("Normal text");
        normalText.setActionCommand(SyntaxConstants.SYNTAX_STYLE_NONE);
        normalText.setSelected(true);
        normalText.addActionListener(langListener);
        buttonGroup.add(normalText);

        add(normalText);
        add(menuA);
        add(menuC);
        add(menuD);
        add(menuG);
        add(menuH);
        add(menuI);
        add(menuJ);
        add(menuL);
        add(menuP);
        add(menuR);
        add(menuS);
        add(menuT);
        add(menuV);
        add(menuW);
        add(menuX);
        add(menuY);
    }
    private void createMenuA(){
        menuA = new JMenu("A");
        JCheckBoxMenuItem languageActionScript = new JCheckBoxMenuItem("ActionScript");
        languageActionScript.addActionListener(langListener);
        languageActionScript.setActionCommand(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT);

        JCheckBoxMenuItem languageAssembler = new JCheckBoxMenuItem("Assembler");
        languageAssembler.addActionListener(langListener);
        languageAssembler.setActionCommand(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86);



        buttonGroup.add(languageActionScript);
        buttonGroup.add(languageAssembler);


        menuA.add(languageActionScript);
        menuA.add(languageAssembler);

    }
    private void createMenuC(){
        menuC = new JMenu("C");
        JCheckBoxMenuItem languageC = new JCheckBoxMenuItem("C");
        languageC.addActionListener(langListener);
        languageC.setActionCommand(SyntaxConstants.SYNTAX_STYLE_C);

        JCheckBoxMenuItem languageCplusplus = new JCheckBoxMenuItem("C++");
        languageCplusplus.addActionListener(langListener);
        languageCplusplus.setActionCommand(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);

        JCheckBoxMenuItem languageCSharp = new JCheckBoxMenuItem("C#");
        languageCSharp.addActionListener(langListener);
        languageCSharp.setActionCommand(SyntaxConstants.SYNTAX_STYLE_CSHARP);

        JCheckBoxMenuItem languageCSS = new JCheckBoxMenuItem("CSS");
        languageCSS.addActionListener(langListener);
        languageCSS.setActionCommand(SyntaxConstants.SYNTAX_STYLE_CSS);
        JCheckBoxMenuItem languageCSV = new JCheckBoxMenuItem("CSV");
        languageCSV.addActionListener(langListener);
        languageCSV.setActionCommand(SyntaxConstants.SYNTAX_STYLE_CSV);


        buttonGroup.add(languageC);
        buttonGroup.add(languageCplusplus);
        buttonGroup.add(languageCSharp);
        buttonGroup.add(languageCSS);
        buttonGroup.add(languageCSV);

        menuC.add(languageC);
        menuC.add(languageCplusplus);
        menuC.add(languageCSharp);
        menuC.add(languageCSS);
        menuC.add(languageCSV);

    }
    private void createMenuD(){
        menuD = new JMenu("D");
        JCheckBoxMenuItem languageD = new JCheckBoxMenuItem("D");
        languageD.addActionListener(langListener);
        languageD.setActionCommand(SyntaxConstants.SYNTAX_STYLE_D);

        JCheckBoxMenuItem languageDart = new JCheckBoxMenuItem("Dart");
        languageDart.addActionListener(langListener);
        languageDart.setActionCommand(SyntaxConstants.SYNTAX_STYLE_DART);

        JCheckBoxMenuItem languageDTD = new JCheckBoxMenuItem("DTD");
        languageDTD.addActionListener(langListener);
        languageDTD.setActionCommand(SyntaxConstants.SYNTAX_STYLE_DTD);


        buttonGroup.add(languageD);
        buttonGroup.add(languageDart);
        buttonGroup.add(languageDTD);


        menuD.add(languageD);
        menuD.add(languageDart);
        menuD.add(languageDTD);

    }
    private void createMenuG(){
        menuG = new JMenu("G");
        JCheckBoxMenuItem languageGroovy = new JCheckBoxMenuItem("Groovy");
        languageGroovy.addActionListener(langListener);
        languageGroovy.setActionCommand(SyntaxConstants.SYNTAX_STYLE_GROOVY);

        buttonGroup.add(languageGroovy);

        menuG.add(languageGroovy);

    }
    private void createMenuH(){
        menuH = new JMenu("H");
        JCheckBoxMenuItem languageHTML = new JCheckBoxMenuItem("HTML");
        languageHTML.addActionListener(langListener);
        languageHTML.setActionCommand(SyntaxConstants.SYNTAX_STYLE_HTML);

        JCheckBoxMenuItem languageHTAccess = new JCheckBoxMenuItem("HTAccess");
        languageHTAccess.addActionListener(langListener);
        languageHTAccess.setActionCommand(SyntaxConstants.SYNTAX_STYLE_HTACCESS);


        buttonGroup.add(languageHTML);
        buttonGroup.add(languageHTAccess);

        menuH.add(languageHTML);
        menuH.add(languageHTAccess);

    }
    private void createMenuI(){
        menuI = new JMenu("I");
        JCheckBoxMenuItem languageINI = new JCheckBoxMenuItem("INI");
        languageINI.addActionListener(langListener);
        languageINI.setActionCommand(SyntaxConstants.SYNTAX_STYLE_INI);

        buttonGroup.add(languageINI);

        menuI.add(languageINI);

    }
    private void createMenuJ(){
        menuJ = new JMenu("J");
        JCheckBoxMenuItem languageJava = new JCheckBoxMenuItem("Java");
        languageJava.addActionListener(langListener);
        languageJava.setActionCommand(SyntaxConstants.SYNTAX_STYLE_JAVA);

        JCheckBoxMenuItem languageJavaScript = new JCheckBoxMenuItem("Java Script");
        languageJavaScript.addActionListener(langListener);
        languageJavaScript.setActionCommand(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);

        JCheckBoxMenuItem languageJson = new JCheckBoxMenuItem("JSON");
        languageJson.addActionListener(langListener);
        languageJson.setActionCommand(SyntaxConstants.SYNTAX_STYLE_JSON);

        JCheckBoxMenuItem languageJSP = new JCheckBoxMenuItem("JSP");
        languageJSP.addActionListener(langListener);
        languageJSP.setActionCommand(SyntaxConstants.SYNTAX_STYLE_JSP);

        buttonGroup.add(languageJava);
        buttonGroup.add(languageJavaScript);
        buttonGroup.add(languageJson);
        buttonGroup.add(languageJSP);

        menuJ.add(languageJava);
        menuJ.add(languageJavaScript);
        menuJ.add(languageJson);
        menuJ.add(languageJSP);

    }
    private void createMenuL(){
        menuL = new JMenu("L");
        JCheckBoxMenuItem languageLatex = new JCheckBoxMenuItem("Latex");
        languageLatex.addActionListener(langListener);
        languageLatex.setActionCommand(SyntaxConstants.SYNTAX_STYLE_LATEX);

        JCheckBoxMenuItem languageLess = new JCheckBoxMenuItem("Less");
        languageLess.addActionListener(langListener);
        languageLess.setActionCommand(SyntaxConstants.SYNTAX_STYLE_LESS);

        JCheckBoxMenuItem languageLisp = new JCheckBoxMenuItem("Lisp");
        languageLisp.addActionListener(langListener);
        languageLisp.setActionCommand(SyntaxConstants.SYNTAX_STYLE_LISP);

        JCheckBoxMenuItem languageLua = new JCheckBoxMenuItem("Lua");
        languageLua.addActionListener(langListener);
        languageLua.setActionCommand(SyntaxConstants.SYNTAX_STYLE_LUA);

        buttonGroup.add(languageLatex);
        buttonGroup.add(languageLess);
        buttonGroup.add(languageLisp);
        buttonGroup.add(languageLua);

        menuL.add(languageLatex);
        menuL.add(languageLess);
        menuL.add(languageLisp);
        menuL.add(languageLua);

    }
    private void createMenuP(){
        menuP = new JMenu("P");
        JCheckBoxMenuItem languagePython = new JCheckBoxMenuItem("Python");
        languagePython.addActionListener(langListener);
        languagePython.setActionCommand(SyntaxConstants.SYNTAX_STYLE_PYTHON);

        JCheckBoxMenuItem languagePhp = new JCheckBoxMenuItem("PHP");
        languagePhp.addActionListener(langListener);
        languagePhp.setActionCommand(SyntaxConstants.SYNTAX_STYLE_PHP);

        JCheckBoxMenuItem languagePerl = new JCheckBoxMenuItem("Perl");
        languagePerl.addActionListener(langListener);
        languagePerl.setActionCommand(SyntaxConstants.SYNTAX_STYLE_PERL);

        JCheckBoxMenuItem languageProperties = new JCheckBoxMenuItem("Properties");
        languageProperties.addActionListener(langListener);
        languageProperties.setActionCommand(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE);

        buttonGroup.add(languagePhp);
        buttonGroup.add(languagePython);
        buttonGroup.add(languagePerl);
        buttonGroup.add(languageProperties);

        menuP.add(languagePhp);
        menuP.add(languagePython);
        menuP.add(languagePerl);
        menuP.add(languageProperties);

    }
    private void createMenuR(){
        menuR = new JMenu("R");
        JCheckBoxMenuItem languageRuby = new JCheckBoxMenuItem("Ruby");
        languageRuby.addActionListener(langListener);
        languageRuby.setActionCommand(SyntaxConstants.SYNTAX_STYLE_RUBY);

        buttonGroup.add(languageRuby);

        menuR.add(languageRuby);
    }
    private void createMenuS(){
        menuS = new JMenu("S");
        JCheckBoxMenuItem languageSQL = new JCheckBoxMenuItem("SQL");
        languageSQL.addActionListener(langListener);
        languageSQL.setActionCommand(SyntaxConstants.SYNTAX_STYLE_SQL);

        JCheckBoxMenuItem languageSAS = new JCheckBoxMenuItem("SAS");
        languageSAS.addActionListener(langListener);
        languageSAS.setActionCommand(SyntaxConstants.SYNTAX_STYLE_SAS);

        JCheckBoxMenuItem languageScala = new JCheckBoxMenuItem("Scala");
        languageScala.addActionListener(langListener);
        languageScala.setActionCommand(SyntaxConstants.SYNTAX_STYLE_SCALA);

        buttonGroup.add(languageSQL);
        buttonGroup.add(languageSAS);
        buttonGroup.add(languageScala);

        menuS.add(languageSQL);
        menuS.add(languageSAS);
        menuS.add(languageScala);

    }
    private void createMenuT(){
        menuT = new JMenu("T");
        JCheckBoxMenuItem languageTCL = new JCheckBoxMenuItem("TCL");
        languageTCL.addActionListener(langListener);
        languageTCL.setActionCommand(SyntaxConstants.SYNTAX_STYLE_TCL);

        JCheckBoxMenuItem languageTypeScript = new JCheckBoxMenuItem("TypeScript");
        languageTypeScript.addActionListener(langListener);
        languageTypeScript.setActionCommand(SyntaxConstants.SYNTAX_STYLE_TYPESCRIPT);

        buttonGroup.add(languageTCL);
        buttonGroup.add(languageTypeScript);

        menuT.add(languageTCL);
        menuT.add(languageTypeScript);

    }
    private void createMenuV(){
        menuV = new JMenu("V");
        JCheckBoxMenuItem languageVisualBasic = new JCheckBoxMenuItem("Visual Basic");
        languageVisualBasic.addActionListener(langListener);
        languageVisualBasic.setActionCommand(SyntaxConstants.SYNTAX_STYLE_VISUAL_BASIC);

        buttonGroup.add(languageVisualBasic);

        menuV.add(languageVisualBasic);

    }
    private void createMenuW(){
        menuW = new JMenu("W");
        JCheckBoxMenuItem languageWindowsBatch = new JCheckBoxMenuItem("Windows Batch");
        languageWindowsBatch.addActionListener(langListener);
        languageWindowsBatch.setActionCommand(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH);

        buttonGroup.add(languageWindowsBatch);

        menuW.add(languageWindowsBatch);

    }
    private void createMenuX(){
        menuX = new JMenu("X");
        JCheckBoxMenuItem languageXML = new JCheckBoxMenuItem("XML");
        languageXML.addActionListener(langListener);
        languageXML.setActionCommand(SyntaxConstants.SYNTAX_STYLE_XML);

        buttonGroup.add(languageXML);

        menuX.add(languageXML);
    }
    private void createMenuY(){
        menuY = new JMenu("Y");
        JCheckBoxMenuItem languageYAML = new JCheckBoxMenuItem("YAML");
        languageYAML.addActionListener(langListener);
        languageYAML.setActionCommand(SyntaxConstants.SYNTAX_STYLE_YAML);

        buttonGroup.add(languageYAML);

        menuY.add(languageYAML);
    }
    public void setSelectedItem(String extension){
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while(buttons.hasMoreElements()){
            JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) buttons.nextElement();
            if (menuItem.getActionCommand().equalsIgnoreCase(extension)){
                menuItem.setSelected(true);
                return;
            }
        }
    }
}
