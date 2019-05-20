package notepad.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import notepad.listener.DocumentUndoableEditListener;
import notepad.listener.MyDocumentListener;
import javax.swing.undo.UndoManager;

import notepad.listener.TextAreaMouseClickListener;
import notepad.util.CategoryOfFile;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.*;

public class TextEditor extends JPanel{

    private RSyntaxTextArea textArea;
    private String filePath;
    private String fileType;
    private boolean isChanged;
    private DocumentUndoableEditListener undoableEditListener;
    private int numberOfTab;

    public TextEditor(){
        this.numberOfTab = -1;
        filePath = "";
        setLayout(new BorderLayout());
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
        filePath = "";
        fileType = CategoryOfFile.NORMAL_TEXT_FILE;

        textArea.setCodeFoldingEnabled(true);
        textArea.getDocument().addDocumentListener(new MyDocumentListener(this));

        undoableEditListener = new DocumentUndoableEditListener();
        textArea.getDocument().addUndoableEditListener(undoableEditListener);

        RTextScrollPane scrollPane = new RTextScrollPane(textArea); //tạo scroll bar cho text area
        add(scrollPane);
        isChanged = false;
    }

    public TextEditor(int numberOfTab){
        this.numberOfTab = numberOfTab;
        filePath = "";
        setLayout(new BorderLayout());
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
        filePath = "";
        fileType = CategoryOfFile.NORMAL_TEXT_FILE;


        textArea.setCodeFoldingEnabled(true); //set code folding

        textArea.getDocument().addDocumentListener(new MyDocumentListener(this));
        textArea.addMouseListener(new TextAreaMouseClickListener(textArea));

        //Undo and redo listener
        undoableEditListener = new DocumentUndoableEditListener();
        textArea.getDocument().addUndoableEditListener(undoableEditListener);

        RTextScrollPane scrollPane = new RTextScrollPane(textArea); //tạo scroll bar cho text area
        add(scrollPane);
        isChanged = false;
    }


    public void setEditingStyle(String keyStyle){
        textArea.setSyntaxEditingStyle(keyStyle);
    }

    public String getFilePath(){return filePath;}

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public RSyntaxTextArea getTextArea() {
        return textArea;
    }

    public String getFileType(){return fileType;}

    public void setFileType(String fileType){
        this.fileType = fileType;
    }

    public void setIsChanged(boolean isChanged){
        this.isChanged  = isChanged;
    }

    public boolean getIsChanged(){
        return this.isChanged;
    }

    public UndoManager getUndoManger(){
        return undoableEditListener.getUndoManger();
    }

    public int getNumberOfTab() {
        return numberOfTab;
    }

    public void setNumberOfTab(int numberOfTab){
       this.numberOfTab = numberOfTab;
    }
}
