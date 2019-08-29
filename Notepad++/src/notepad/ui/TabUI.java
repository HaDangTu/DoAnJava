package notepad.ui;

import notepad.listener.CloseTabButtonActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabUI extends JPanel {
    private CloseTabButton button;
    private JLabel label;

    public TabUI(EditorWindow editorWindow){
        //setLayout
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setVgap(0);
        flowLayout.setHgap(0);
        setLayout(flowLayout);
        setOpaque(false);

        //close button
        ImageIcon icon = new ImageIcon("icon/close.png");
        button = new CloseTabButton(icon);
        button.addActionListener(new CloseTabButtonActionListener(editorWindow, button));
        //label of tab
        label = new JLabel();

        add(label);
        add(button);
    }

    public void setLabel(String content){
        label.setText(content);
    }

    public String getLabel() {return label.getText();}
}
