package notepad.util;

import org.fife.ui.autocomplete.Completion;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.CompletionProvider;

public class MyAutoCompletion extends AutoCompletion{
    private boolean flag; //true if is inserted, false if is not inserted

    public MyAutoCompletion(CompletionProvider provider) {
        super(provider);
        super.setListCellRenderer(new MyCompletionCellRenderer());
        super.setAutoCompleteEnabled(true);
        super.setAutoCompleteSingleChoices(true);
        super.setParameterAssistanceEnabled(true);
        super.setAutoActivationEnabled(true);
        super.setShowDescWindow(true);
        flag = false;
    }

    @Override
    protected void insertCompletion (Completion c, boolean typedParamListStartChar){
        super.insertCompletion(c, typedParamListStartChar);
        flag = true;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
}
