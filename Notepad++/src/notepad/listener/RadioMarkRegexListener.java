package notepad.listener;

import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioMarkRegexListener implements ActionListener {
    private JCheckBox chbWholeWord;

    public RadioMarkRegexListener(JCheckBox chbWholeWord){
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
