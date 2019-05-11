package notepad.listener;
import notepad.ui.NewFileDialog;
import notepad.util.CategoryOfFile;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class NewFileItemListener implements ItemListener{

    protected NewFileDialog dialog;

    public NewFileItemListener(NewFileDialog dialog){
        this.dialog = dialog;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            if (e.getItem().equals("Normal text"))
                dialog.setName(CategoryOfFile.NORMAL_TEXT_FILE);
            else if (e.getItem().equals("C file"))
                dialog.setName(CategoryOfFile.C_FILE);
            else if (e.getItem().equals("C++ file"))
                dialog.setName(CategoryOfFile.CPLUSPLUS_FILE);
            else if (e.getItem().equals("C# file"))
                dialog.setName(CategoryOfFile.CSHARP_FILE);
            else if (e.getItem().equals("PHP file"))
                dialog.setName(CategoryOfFile.PHP_FILE);
            else if (e.getItem().equals("Python file"))
                dialog.setName(CategoryOfFile.PYTHON_FILE);
            else if (e.getItem().equals("Java file"))
                dialog.setName(CategoryOfFile.JAVA_FILE);
            else if (e.getItem().equals("JavaScript file"))
                dialog.setName(CategoryOfFile.JAVASCRIPT_FILE);
            else if (e.getItem().equals("JSON file"))
                dialog.setName(CategoryOfFile.JSON_FILE);
        }
    }

}
