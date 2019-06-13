package notepad.util;

import org.fife.ui.autocomplete.Completion;
import org.fife.ui.autocomplete.CompletionCellRenderer;
import org.fife.ui.autocomplete.FunctionCompletion;
import org.fife.ui.autocomplete.VariableCompletion;

import javax.swing.ImageIcon;
import javax.swing.JList;

class MyCompletionCellRenderer extends CompletionCellRenderer {
    ImageIcon variable;
    ImageIcon function;
    ImageIcon other;

    public MyCompletionCellRenderer(){
        variable = new ImageIcon("icon\\var.png");
        function = new ImageIcon("icon\\function.png");
        other = new ImageIcon("icon\\macro.png");
    }

    @Override
    protected void prepareForOtherCompletion(JList list,
                                             Completion c, int index, boolean selected, boolean hasFocus) {
        super.prepareForOtherCompletion(list, c, index, selected, hasFocus);
        setIcon(other);
    }

    @Override
    protected void prepareForVariableCompletion(JList list,
                                                VariableCompletion vc, int index, boolean selected,
                                                boolean hasFocus) {
        super.prepareForVariableCompletion(list, vc, index, selected,
                hasFocus);
        setIcon(variable);
    }

    @Override
    protected void prepareForFunctionCompletion(JList list,
                                                FunctionCompletion fc, int index, boolean selected,
                                                boolean hasFocus) {
        super.prepareForFunctionCompletion(list, fc, index, selected,
                hasFocus);
        setIcon(function);
    }
}
