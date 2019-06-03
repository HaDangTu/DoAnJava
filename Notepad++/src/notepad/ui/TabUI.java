package notepad.ui;

import notepad.listener.CloseTabButtonListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class TabUI extends JPanel {
    private CloseTabButton button;
    private JLabel label;
    private ImageIcon icon;

    public TabUI (){
        super();
        //setLayout
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setVgap(0);
        setLayout(flowLayout);
        setOpaque(false);

        //close button
        icon = new ImageIcon("icon/close.png");
        button = new CloseTabButton(icon);
        //label of tab
        label = new JLabel();

        add(label);
        add(button);

    }

    public void setLabel(String content){
        label.setText(content);
    }

    public String getLabel() {return label.getText();}

    public void setListener(CloseTabButtonListener listener){
        button.addActionListener(listener);
    }


}
