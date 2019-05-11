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
            if (e.getItem().equals("Header file"))
                dialog.setName(CategoryOfFile.C_HEADER_FILE);
            else
                dialog.setName(CategoryOfFile.CPLUSPLUS_FILE);
        }
    }

}
