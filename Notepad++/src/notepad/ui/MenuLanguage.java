package notepad.ui;

import notepad.listener.MenuLanguageActionListener;

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

        JCheckBoxMenuItem normalText = new JCheckBoxMenuItem("Normal text");
        normalText.setSelected(true);
        normalText.addActionListener(langListener);
        buttonGroup.add(normalText);

        add(menuC);
        add(normalText);
        add(menuJ);
        add(menuP);
        add(menuH);
        add(menuS);
        add(menuX);
    }
    
    private void createMenuC(){
        menuC = new JMenu("C");
        JCheckBoxMenuItem languageC = new JCheckBoxMenuItem("C");
        languageC.addActionListener(langListener);
        JCheckBoxMenuItem languageCplusplus = new JCheckBoxMenuItem("C++");
        languageCplusplus.addActionListener(langListener);
        JCheckBoxMenuItem languageCSharp = new JCheckBoxMenuItem("C#");
        languageCSharp.addActionListener(langListener);
        JCheckBoxMenuItem languageCSS = new JCheckBoxMenuItem("CSS");
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
        JCheckBoxMenuItem languageJava = new JCheckBoxMenuItem("Java");
        languageJava.addActionListener(langListener);
        JCheckBoxMenuItem languageJavaScript = new JCheckBoxMenuItem("Java Script");
        languageJavaScript.addActionListener(langListener);
        JCheckBoxMenuItem languageJson = new JCheckBoxMenuItem("JSON");
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
        JCheckBoxMenuItem languagePython= new JCheckBoxMenuItem("Python");
        languagePython.addActionListener(langListener);
        JCheckBoxMenuItem languagePhp = new JCheckBoxMenuItem("PHP");
        languagePhp.addActionListener(langListener);

        buttonGroup.add(languagePhp);
        buttonGroup.add(languagePython);

        menuP.add(languagePhp);
        menuP.add(languagePython);
    }
    
    private void createMenuH(){
        menuH = new JMenu("H");
        JCheckBoxMenuItem languageHTML = new JCheckBoxMenuItem("HTML");
        languageHTML.addActionListener(langListener);

        buttonGroup.add(languageHTML);

        menuH.add(languageHTML);
    }
    
    private void createMenuS(){
        menuS = new JMenu("S");
        JCheckBoxMenuItem languageSQL = new JCheckBoxMenuItem("SQL");
        languageSQL.addActionListener(langListener);

        buttonGroup.add(languageSQL);

        menuS.add(languageSQL);
    }
    
    private void createMenuX(){
        menuX = new JMenu("X");
        JCheckBoxMenuItem languageXML = new JCheckBoxMenuItem("XML");
        languageXML.addActionListener(langListener);

        buttonGroup.add(languageXML);

        menuX.add(languageXML);
    }
}
