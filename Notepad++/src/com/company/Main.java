package com.company;
import notepad.ui.MainWindow;

import javax.swing.SwingUtilities;
public class Main {

    public static void main(String[] args) {
	// write your code here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.getEditorWindow().requestFocusInWindow();
                mainWindow.setVisible(true);
            }
        });
    }
}
