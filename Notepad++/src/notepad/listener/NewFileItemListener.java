package notepad.listener;
import notepad.ui.NewFileDialog;
import notepad.util.CategoryOfFile;
import notepad.util.Language;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;
import java.util.Locale;

public class NewFileItemListener implements ItemListener{

    protected NewFileDialog dialog;

    public NewFileItemListener(NewFileDialog dialog){
        this.dialog = dialog;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            CategoryOfFile category = CategoryOfFile.getInstance();
            System.out.println(e.getItem().toString());
            Language language = category.getLanguage(e.getItem().toString());
            String name = dialog.getName().substring(0, dialog.getName().indexOf("."));
            dialog.setName(name + language.getExtension());
        }
    }

}
