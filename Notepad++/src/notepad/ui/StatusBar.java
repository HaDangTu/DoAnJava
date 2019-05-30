package notepad.ui;

import notepad.util.CategoryOfFile;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import java.awt.FlowLayout;
import java.awt.Dimension;

public class StatusBar  extends JPanel{
    private JLabel fileType;
    private JLabel lengthAndLine;
    private JLabel lineColumnSelect;

    public StatusBar(EditorWindow editorWindow){
        fileType = new JLabel();
        fileType.setPreferredSize(new Dimension(400, 15));

        lengthAndLine = new JLabel();
        lengthAndLine.setPreferredSize(new Dimension(200, 15));

        lineColumnSelect = new JLabel();
        lineColumnSelect.setPreferredSize(new Dimension(200,15));


        int index = editorWindow.getSelectedIndex();
        TextEditor textEditor = editorWindow.getTextEditor(index);

        setFileType(textEditor);
        setLengthAndLine(textEditor.getTextArea());
        setLineColumnSelect(textEditor.getTextArea());

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        setLayout(flowLayout);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        setPreferredSize(new Dimension(1000, 18));
        add(fileType);
        add(lengthAndLine);
        add(lineColumnSelect);
    }

    public void setFileType(TextEditor textEditor){
        System.out.println(textEditor.getFileType());
        CategoryOfFile category = new CategoryOfFile();
        fileType.setText("   " + category.CovertFileExtensionToFileType(textEditor.getFileType()));
    }

    public void setLengthAndLine(RSyntaxTextArea textArea){
        int length = textArea.getText().length();
        int line = textArea.getLineCount();

        lengthAndLine.setText(" length: " + length + " | lines: " + line);
    }

    public void setLineColumnSelect(RSyntaxTextArea textArea){
        int line = textArea.getCaretLineNumber() + 1;
        int column = textArea.getCaretPosition() + 1;
        int select = Math.abs(textArea.getSelectionStart() - textArea.getSelectionEnd());

        lineColumnSelect.setText(" ln: " + line + " | col: " + column + " | sel: " + select);
    }


}


