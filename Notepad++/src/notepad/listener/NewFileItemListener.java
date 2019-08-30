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
            CategoryOfFile category = CategoryOfFile.getInstance();
            String extension = category.getKey(e.getItem().toString());
            String name = dialog.getName().substring(0, dialog.getName().indexOf("."));
            dialog.setName(name + extension);
        }
    }

}
