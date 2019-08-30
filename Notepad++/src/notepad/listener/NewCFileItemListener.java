package notepad.listener;

import notepad.ui.NewFileDialog;
import notepad.util.CategoryOfFile;
import notepad.util.Language;

import java.awt.event.ItemEvent;

public class NewCFileItemListener extends NewFileItemListener {

    public NewCFileItemListener(NewFileDialog dialog){
        super(dialog);
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            CategoryOfFile category = CategoryOfFile.getInstance();
            Language language = category.getLanguage(e.getItem().toString());
            String name = dialog.getName().substring(0, dialog.getName().indexOf("."));
            dialog.setName(name + language.getExtension());
        }
    }
}
