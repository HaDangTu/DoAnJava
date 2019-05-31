package notepad.ui;

import notepad.listener.MenuLanguageActionListener;
import notepad.util.CategoryOfFile;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;


class MenuLanguage extends JMenu{
    private JMenu menuC;
    private JMenu menuJ;
    private JMenu menuP;
    private JMenu menuH;
    private JMenu menuS;
    private JMenu menuX;


    private ButtonGroup buttonGroup;

    private MenuLanguageActionListener langListener;

    private JCheckBoxMenuItem languageC;
    private JCheckBoxMenuItem languageCplusplus;
    private JCheckBoxMenuItem languageCSharp;
    private JCheckBoxMenuItem languageCSS;
    private JCheckBoxMenuItem languageJava;
    private JCheckBoxMenuItem languageJavaScript;
    private JCheckBoxMenuItem languageJson;
    private JCheckBoxMenuItem languagePython;
    private JCheckBoxMenuItem languagePhp;
    private JCheckBoxMenuItem languageHTML;
    private JCheckBoxMenuItem languageSQL;
    private JCheckBoxMenuItem languageXML;
    private final JCheckBoxMenuItem normalText;

    public MenuLanguage (EditorWindow editorWindow){
        super("Language");
        langListener = new MenuLanguageActionListener(editorWindow);
        buttonGroup = new ButtonGroup();

        createMenuC();
        createMenuH();
        createMenuJ();
        createMenuP();
        createMenuS();
        createMenuX();

        normalText = new JCheckBoxMenuItem("Normal text");
        normalText.setSelected(true);
        normalText.addActionListener(langListener);
        buttonGroup.add(normalText);

        add(menuC);
        add(normalText);
        add(menuH);
        add(menuJ);
        add(menuP);
        add(menuS);
        add(menuX);
    }
    
    private void createMenuC(){
        menuC = new JMenu("C");
        languageC = new JCheckBoxMenuItem("C");
        languageC.addActionListener(langListener);
        languageCplusplus = new JCheckBoxMenuItem("C++");
        languageCplusplus.addActionListener(langListener);
        languageCSharp = new JCheckBoxMenuItem("C#");
        languageCSharp.addActionListener(langListener);
        languageCSS = new JCheckBoxMenuItem("CSS");
        languageCSS.addActionListener(langListener);

        buttonGroup.add(languageC);
        buttonGroup.add(languageCplusplus);
        buttonGroup.add(languageCSharp);
        buttonGroup.add(languageCSS);

        menuC.add(languageC);
        menuC.add(languageCplusplus);
        menuC.add(languageCSharp);
        menuC.add(languageCSS);
    }

    private void createMenuJ(){
        menuJ = new JMenu("J");
        languageJava = new JCheckBoxMenuItem("Java");
        languageJava.addActionListener(langListener);
        languageJavaScript = new JCheckBoxMenuItem("Java Script");
        languageJavaScript.addActionListener(langListener);
        languageJson = new JCheckBoxMenuItem("JSON");
        languageJavaScript.addActionListener(langListener);

        buttonGroup.add(languageJava);
        buttonGroup.add(languageJavaScript);
        buttonGroup.add(languageJson);

        menuJ.add(languageJava);
        menuJ.add(languageJavaScript);
        menuJ.add(languageJson);
    }
    
    private void createMenuP(){
        menuP = new JMenu("P");
        languagePython = new JCheckBoxMenuItem("Python");
        languagePython.addActionListener(langListener);
        languagePhp = new JCheckBoxMenuItem("PHP");
        languagePhp.addActionListener(langListener);

        buttonGroup.add(languagePhp);
        buttonGroup.add(languagePython);

        menuP.add(languagePhp);
        menuP.add(languagePython);
    }
    
    private void createMenuH(){
        menuH = new JMenu("H");
        languageHTML = new JCheckBoxMenuItem("HTML");
        languageHTML.addActionListener(langListener);

        buttonGroup.add(languageHTML);

        menuH.add(languageHTML);
    }
    
    private void createMenuS(){
        menuS = new JMenu("S");
        languageSQL = new JCheckBoxMenuItem("SQL");
        languageSQL.addActionListener(langListener);

        buttonGroup.add(languageSQL);

        menuS.add(languageSQL);
    }
    
    private void createMenuX(){
        menuX = new JMenu("X");
        languageXML = new JCheckBoxMenuItem("XML");
        languageXML.addActionListener(langListener);

        buttonGroup.add(languageXML);

        menuX.add(languageXML);
    }

    public void setSelectedItem(String extension){
        CategoryOfFile category = new CategoryOfFile();
        if (category.detectNormalTextFile(extension))
            normalText.setSelected(true);
        else if(category.detectCFile(extension))
            languageC.setSelected(true);
        else if(category.detectCplusplusFile(extension))
            languageCplusplus.setSelected(true);
        else if(category.detectCSharpFile(extension))
            languageCSharp.setSelected(true);
        else if(category.detectCSSFile(extension))
            languageCSS.setSelected(true);
        else if(category.detectHTMLFile(extension))
            languageHTML.setSelected(true);
        else if(category.detectJavaFile(extension))
            languageJava.setSelected(true);
        else if(category.detectJavaScriptFile(extension))
            languageJavaScript.setSelected(true);
        else if(category.detectJsonFile(extension))
            languageJson.setSelected(true);
        else if(category.detectPHPFile(extension))
            languagePhp.setSelected(true);
        else if(category.detectPythonFile(extension))
            languagePython.setSelected(true);
        else if(category.detectSQLFile(extension))
            languageSQL.setSelected(true);
        else if(category.detectXMLFile(extension))
            languageXML.setSelected(true);
    }
}
