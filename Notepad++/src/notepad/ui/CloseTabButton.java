package notepad.ui;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

public class CloseTabButton  extends JButton{

    public CloseTabButton(ImageIcon icon){
        super(icon);
        setSize(icon.getIconWidth(), icon.getIconHeight());
        setBorder(BorderFactory.createEtchedBorder());
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
    }
}
