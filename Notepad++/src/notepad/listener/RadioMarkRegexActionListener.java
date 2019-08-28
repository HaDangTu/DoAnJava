package notepad.listener;

import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;

public class RadioMarkRegexActionListener extends BaseActionListener {
    private JCheckBox chbWholeWord;

    public RadioMarkRegexActionListener(JCheckBox chbWholeWord){
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
