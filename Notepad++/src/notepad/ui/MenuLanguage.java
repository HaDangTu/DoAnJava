package notepad.ui;

import notepad.listener.MenuLanguageActionListener;
import notepad.util.CategoryOfFile;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import javax.swing.AbstractButton;

import java.util.Enumeration;

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
        normalText.setActionCommand(CategoryOfFile.NORMAL_TEXT_FILE);
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
        languageJava.setActionCommand(CategoryOfFile.JAVA_FILE);

        JCheckBoxMenuItem languageJavaScript = new JCheckBoxMenuItem("Java Script");
        languageJavaScript.addActionListener(langListener);
        languageJavaScript.setActionCommand(CategoryOfFile.JAVASCRIPT_FILE);

        JCheckBoxMenuItem languageJson = new JCheckBoxMenuItem("JSON");
        languageJson.addActionListener(langListener);
        languageJson.setActionCommand(CategoryOfFile.JSON_FILE);

        buttonGroup.add(languageJava);
        buttonGroup.add(languageJavaScript);
        buttonGroup.add(languageJson);

        menuJ.add(languageJava);
        menuJ.add(languageJavaScript);
        menuJ.add(languageJson);
    }
    
    private void createMenuP(){
        menuP = new JMenu("P");
        JCheckBoxMenuItem languagePython = new JCheckBoxMenuItem("Python");
        languagePython.addActionListener(langListener);
        languagePython.setActionCommand(CategoryOfFile.PYTHON_FILE);

        JCheckBoxMenuItem languagePhp = new JCheckBoxMenuItem("PHP");
        languagePhp.addActionListener(langListener);
        languagePhp.setActionCommand(CategoryOfFile.PYTHON_FILE);

        buttonGroup.add(languagePhp);
        buttonGroup.add(languagePython);

        menuP.add(languagePhp);
        menuP.add(languagePython);
    }
    
    private void createMenuH(){
        menuH = new JMenu("H");
        JCheckBoxMenuItem languageHTML = new JCheckBoxMenuItem("HTML");
        languageHTML.addActionListener(langListener);
        languageHTML.setActionCommand(CategoryOfFile.HTML_FILE);

        buttonGroup.add(languageHTML);

        menuH.add(languageHTML);
    }
    
    private void createMenuS(){
        menuS = new JMenu("S");
        JCheckBoxMenuItem languageSQL = new JCheckBoxMenuItem("SQL");
        languageSQL.addActionListener(langListener);
        languageSQL.setActionCommand(CategoryOfFile.SQL_FILE);

        buttonGroup.add(languageSQL);

        menuS.add(languageSQL);
    }
    
    private void createMenuX(){
        menuX = new JMenu("X");
        JCheckBoxMenuItem languageXML = new JCheckBoxMenuItem("XML");
        languageXML.addActionListener(langListener);
        languageXML.setActionCommand(CategoryOfFile.XML_FILE);

        buttonGroup.add(languageXML);

        menuX.add(languageXML);
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
