package notepad.ui;


import java.awt.BorderLayout;

import notepad.listener.DocumentUndoableEditListener;
import notepad.listener.EditorDocumentListener;
import notepad.listener.TextAreaMouseClickListener;

import javax.swing.undo.UndoManager;
import javax.swing.JPanel;

import notepad.util.LangManager;
import notepad.util.MyAutoCompletion;
import notepad.util.CategoryOfFile;

import org.fife.ui.autocomplete.DefaultCompletionProvider;
//import org.fife.ui.autocomplete.LanguageAwareCompletionProvider;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.autocomplete.CompletionProvider;

import java.io.IOException;

public class TextEditor extends JPanel{

    private RSyntaxTextArea textArea;

    private String filePath;
    private String fileType;

    private boolean isChanged;
    private boolean isOpened;

    private DocumentUndoableEditListener undoableEditListener;
    private int numberOfTab;
    private RTextScrollPane scrollPane;

    private MyAutoCompletion autoCompletion;

    public TextEditor(){
        super();
        this.numberOfTab = -1;
        filePath = "";
        setLayout(new BorderLayout());
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
        filePath = "";
        fileType = CategoryOfFile.NORMAL_TEXT_FILE;

        textArea.setCodeFoldingEnabled(true);

        //Undo and redo listener
        undoableEditListener = new DocumentUndoableEditListener(this);
        textArea.getDocument().addUndoableEditListener(undoableEditListener);

        textArea.getDocument().addDocumentListener(new EditorDocumentListener(this));
        textArea.addMouseListener(new TextAreaMouseClickListener(textArea));

        TextEditorPopupMenu textEditorPopupMenu = new TextEditorPopupMenu(this);
        textArea.setPopupMenu(textEditorPopupMenu);

        scrollPane = new RTextScrollPane(textArea); //tạo scroll bar cho text area

        add(scrollPane);
        isChanged = false;
        isOpened = false;

    }

    public TextEditor(int numberOfTab){
        super();
        this.numberOfTab = numberOfTab;
        filePath = "";
        setLayout(new BorderLayout());
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
        filePath = "";
        fileType = CategoryOfFile.NORMAL_TEXT_FILE;


        textArea.setCodeFoldingEnabled(true); //set code folding

        //Undo and redo listener
        undoableEditListener = new DocumentUndoableEditListener(this);
        textArea.getDocument().addUndoableEditListener(undoableEditListener);

        textArea.getDocument().addDocumentListener(new EditorDocumentListener(this));
        textArea.addMouseListener(new TextAreaMouseClickListener(textArea));

        TextEditorPopupMenu textEditorPopupMenu = new TextEditorPopupMenu(this);
        textArea.setPopupMenu(textEditorPopupMenu);

        scrollPane = new RTextScrollPane(textArea); //tạo scroll bar cho text area
        add(scrollPane);
        isChanged = false;
        isOpened = false;


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

    /**
     *
     * @return true if text editor is modified, false if text editor if not modified
     */
    public boolean getIsChanged(){
        return this.isChanged;
    }


    public void setIsOpened(boolean isOpened){
        this.isOpened = isOpened;
    }
    /**
     *
     * @return true if text editor is changed by reading data from a file on disk
     */
    public boolean getIsOpened(){
        return this.isOpened;
    }

    public UndoManager getUndoManager(){
        return undoableEditListener.getUndoManager();
    }

    public int getNumberOfTab() {
        return numberOfTab;
    }

    public void setNumberOfTab(int numberOfTab){
       this.numberOfTab = numberOfTab;
    }

    public void setLineNumberEnabled(boolean enabled){
        scrollPane.setLineNumbersEnabled(enabled);
    }

    /**
     * set auto complete for text editor
     */
    public void setAutoComplete(){
        try {
            CompletionProvider provider = createProvider();
            autoCompletion = new MyAutoCompletion(provider);
            autoCompletion.install(textArea);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public MyAutoCompletion getAutoCompletion(){
        return autoCompletion;
    }

    private CompletionProvider createProvider() throws IOException{
        LangManager manager = LangManager.getInstance();
        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        provider.loadFromXML(manager.get(fileType));

//        LanguageAwareCompletionProvider langProvider = new LanguageAwareCompletionProvider(provider);
        return provider;
    }
}
