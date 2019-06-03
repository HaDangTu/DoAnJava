package notepad.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class CloseTreeViewPanel extends JPanel{
    private JButton closeButton;
    private JLabel label;

    public CloseTreeViewPanel(){
        super();
        closeButton = new JButton(new ImageIcon("icon\\close.png"));
        closeButton.setPreferredSize(new Dimension(16, 16));
        label = new JLabel("Workspace");

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        add(label, BorderLayout.LINE_START);
        add(closeButton, BorderLayout.LINE_END);
    }

    public JButton getCloseButton(){
        return closeButton;
    }
}
