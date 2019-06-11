package notepad.ui;

import notepad.listener.MenuLanguageActionListener;
import notepad.util.CategoryOfFile;

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

    private MenuLanguageActionListener langListener;


    public MenuLanguage(EditorWindow editorWindow){
        super("Language");
        langListener = new MenuLanguageActionListener(editorWindow);
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
        normalText.setActionCommand(CategoryOfFile.NORMAL_TEXT_FILE);
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
        languageActionScript.setActionCommand(CategoryOfFile.ACTIONSCRIPT_FILE);

        JCheckBoxMenuItem languageAssembler = new JCheckBoxMenuItem("Assembler");
        languageAssembler.addActionListener(langListener);
        languageAssembler.setActionCommand(CategoryOfFile.ASSEMBLER_X86_FILE);



        buttonGroup.add(languageActionScript);
        buttonGroup.add(languageAssembler);


        menuA.add(languageActionScript);
        menuA.add(languageAssembler);

    }
    private void createMenuC(){
        menuC = new JMenu("C");
        JCheckBoxMenuItem languageC = new JCheckBoxMenuItem("C");
        languageC.addActionListener(langListener);
        languageC.setActionCommand(CategoryOfFile.C_FILE);

        JCheckBoxMenuItem languageCplusplus = new JCheckBoxMenuItem("C++");
        languageCplusplus.addActionListener(langListener);
        languageCplusplus.setActionCommand(CategoryOfFile.CPLUSPLUS_FILE);

        JCheckBoxMenuItem languageCSharp = new JCheckBoxMenuItem("C#");
        languageCSharp.addActionListener(langListener);
        languageCSharp.setActionCommand(CategoryOfFile.CSHARP_FILE);

        JCheckBoxMenuItem languageCSS = new JCheckBoxMenuItem("CSS");
        languageCSS.addActionListener(langListener);
        languageCSS.setActionCommand(CategoryOfFile.CSS_FILE);
        JCheckBoxMenuItem languageCSV = new JCheckBoxMenuItem("CSV");
        languageCSV.addActionListener(langListener);
        languageCSV.setActionCommand(CategoryOfFile.CSV_FILE);


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
        languageD.setActionCommand(CategoryOfFile.D_FILE);

        JCheckBoxMenuItem languageDart = new JCheckBoxMenuItem("Dart");
        languageDart.addActionListener(langListener);
        languageDart.setActionCommand(CategoryOfFile.DART_FILE);

        JCheckBoxMenuItem languageDTD = new JCheckBoxMenuItem("DTD");
        languageDTD.addActionListener(langListener);
        languageDTD.setActionCommand(CategoryOfFile.DTD_FILE);


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
        languageGroovy.setActionCommand(CategoryOfFile.GROOVY_FILE);

        buttonGroup.add(languageGroovy);

        menuG.add(languageGroovy);

    }
    private void createMenuH(){
        menuH = new JMenu("H");
        JCheckBoxMenuItem languageHTML = new JCheckBoxMenuItem("HTML");
        languageHTML.addActionListener(langListener);
        languageHTML.setActionCommand(CategoryOfFile.HTML_FILE);

        JCheckBoxMenuItem languageHTAcess = new JCheckBoxMenuItem("HTAccess");
        languageHTAcess.addActionListener(langListener);
        languageHTAcess.setActionCommand(CategoryOfFile.HTACCESS_FILE);


        buttonGroup.add(languageHTML);
        buttonGroup.add(languageHTAcess);

        menuH.add(languageHTML);
        menuH.add(languageHTAcess);

    }
    private void createMenuI(){
        menuI = new JMenu("I");
        JCheckBoxMenuItem languageINI = new JCheckBoxMenuItem("INI");
        languageINI.addActionListener(langListener);
        languageINI.setActionCommand(CategoryOfFile.INI_FILE);

        buttonGroup.add(languageINI);

        menuI.add(languageINI);

    }
    private void createMenuJ(){
        menuJ = new JMenu("J");
        JCheckBoxMenuItem languageJava = new JCheckBoxMenuItem("Java");
        languageJava.addActionListener(langListener);
        languageJava.setActionCommand(CategoryOfFile.JAVA_FILE);

        JCheckBoxMenuItem languageJavaScript = new JCheckBoxMenuItem("Java Script");
        languageJavaScript.addActionListener(langListener);
        languageJavaScript.setActionCommand(CategoryOfFile.JAVASCRIPT_FILE);

        JCheckBoxMenuItem languageJson = new JCheckBoxMenuItem("JSON");
        languageJson.addActionListener(langListener);
        languageJson.setActionCommand(CategoryOfFile.JSON_FILE);

        JCheckBoxMenuItem languageJSP = new JCheckBoxMenuItem("JSP");
        languageJSP.addActionListener(langListener);
        languageJSP.setActionCommand(CategoryOfFile.JSP_FILE);

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
        languageLatex.setActionCommand(CategoryOfFile.LATEX_FILE);

        JCheckBoxMenuItem languageLess = new JCheckBoxMenuItem("Less");
        languageLess.addActionListener(langListener);
        languageLess.setActionCommand(CategoryOfFile.LESS_FILE);

        JCheckBoxMenuItem languageLisp = new JCheckBoxMenuItem("Lisp");
        languageLisp.addActionListener(langListener);
        languageLisp.setActionCommand(CategoryOfFile.LISP_FILE);

        JCheckBoxMenuItem languageLua = new JCheckBoxMenuItem("Lua");
        languageLua.addActionListener(langListener);
        languageLua.setActionCommand(CategoryOfFile.LUA_FILE);

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
        languagePython.setActionCommand(CategoryOfFile.PYTHON_FILE);

        JCheckBoxMenuItem languagePhp = new JCheckBoxMenuItem("PHP");
        languagePhp.addActionListener(langListener);
        languagePhp.setActionCommand(CategoryOfFile.PYTHON_FILE);

        JCheckBoxMenuItem languagePerl = new JCheckBoxMenuItem("Perl");
        languagePerl.addActionListener(langListener);
        languagePerl.setActionCommand(CategoryOfFile.PERL_FILE);

        JCheckBoxMenuItem languageProperties = new JCheckBoxMenuItem("Properties");
        languageProperties.addActionListener(langListener);
        languageProperties.setActionCommand(CategoryOfFile.PROPERTIES_FILE);

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
        languageRuby.setActionCommand(CategoryOfFile.RUBY_FILE);

        buttonGroup.add(languageRuby);

        menuR.add(languageRuby);
    }
    private void createMenuS(){
        menuS = new JMenu("S");
        JCheckBoxMenuItem languageSQL = new JCheckBoxMenuItem("SQL");
        languageSQL.addActionListener(langListener);
        languageSQL.setActionCommand(CategoryOfFile.SQL_FILE);

        JCheckBoxMenuItem languageSAS = new JCheckBoxMenuItem("SAS");
        languageSAS.addActionListener(langListener);
        languageSAS.setActionCommand(CategoryOfFile.SAS_FILE);

        JCheckBoxMenuItem languageScala = new JCheckBoxMenuItem("Scala");
        languageScala.addActionListener(langListener);
        languageScala.setActionCommand(CategoryOfFile.SCALA_FILE);

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
        languageTCL.setActionCommand(CategoryOfFile.TCL_FILE);

        JCheckBoxMenuItem languageTypeScript = new JCheckBoxMenuItem("TypeScript");
        languageTypeScript.addActionListener(langListener);
        languageTypeScript.setActionCommand(CategoryOfFile.TYPESCRIPT_FILE);

        buttonGroup.add(languageTCL);
        buttonGroup.add(languageTypeScript);

        menuT.add(languageTCL);
        menuT.add(languageTypeScript);

    }
    private void createMenuV(){
        menuV = new JMenu("V");
        JCheckBoxMenuItem languageVisualBasic = new JCheckBoxMenuItem("Visual Basic");
        languageVisualBasic.addActionListener(langListener);
        languageVisualBasic.setActionCommand(CategoryOfFile.VISUAL_BASIC_FILE);

        buttonGroup.add(languageVisualBasic);

        menuV.add(languageVisualBasic);

    }
    private void createMenuW(){
        menuW = new JMenu("W");
        JCheckBoxMenuItem languageWindowsBatch = new JCheckBoxMenuItem("Windows Batch");
        languageWindowsBatch.addActionListener(langListener);
        languageWindowsBatch.setActionCommand(CategoryOfFile.WINDOWS_BATCH_FILE);

        buttonGroup.add(languageWindowsBatch);

        menuW.add(languageWindowsBatch);

    }
    private void createMenuX(){
        menuX = new JMenu("X");
        JCheckBoxMenuItem languageXML = new JCheckBoxMenuItem("XML");
        languageXML.addActionListener(langListener);
        languageXML.setActionCommand(CategoryOfFile.XML_FILE);

        buttonGroup.add(languageXML);

        menuX.add(languageXML);
    }
    private void createMenuY(){
        menuY = new JMenu("Y");
        JCheckBoxMenuItem languageYAML = new JCheckBoxMenuItem("YAML");
        languageYAML.addActionListener(langListener);
        languageYAML.setActionCommand(CategoryOfFile.YAML_FILE);

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
