package notepad.ui;

import javax.swing.JMenu;

import notepad.util.ImageManager;


public abstract class Menu extends JMenu{

    protected ImageManager imageManager;

    public Menu(String name, MainWindow parentFrame){
        super(name);
        imageManager = parentFrame.getImageManager();
    }
}
