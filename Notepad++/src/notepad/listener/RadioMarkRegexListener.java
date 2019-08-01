package notepad.listener;

import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioMarkRegexListener extends BaseListener {
    private JCheckBox chbWholeWord;

    public RadioMarkRegexListener(JCheckBox chbWholeWord){
        super();
        this.chbWholeWord = chbWholeWord;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (!command.equalsIgnoreCase("Normal"))
            chbWholeWord.setSelected(false);
        chbWholeWord.setEnabled(command.equalsIgnoreCase("Normal"));
    }
}
