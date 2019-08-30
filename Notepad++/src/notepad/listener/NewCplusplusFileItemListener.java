package notepad.listener;
import notepad.util.CategoryOfFile;
import notepad.ui.NewFileDialog;


import java.awt.event.ItemEvent;
public class NewCplusplusFileItemListener extends NewFileItemListener {
    public NewCplusplusFileItemListener(NewFileDialog dialog){
        super(dialog);
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            CategoryOfFile category = CategoryOfFile.getInstance();
            String extension = category.getKey(e.getItem().toString());
            String name = dialog.getName().substring(0, dialog.getName().indexOf("."));
            dialog.setName(name + extension);
        }
    }

}
