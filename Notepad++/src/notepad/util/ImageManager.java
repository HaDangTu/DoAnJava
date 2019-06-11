package notepad.util;

import javax.swing.ImageIcon;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class ImageManager extends Dictionary<String, ImageIcon> {
    private static ImageManager ourInstance;

    public static ImageManager getInstance() {
        if (ourInstance == null) ourInstance = new ImageManager();
        return ourInstance;
    }

    private Hashtable<String, ImageIcon> manager;

    private ImageManager() {
        manager = new Hashtable<>();

        manager.put("other_file", new ImageIcon("icon\\other_file.png"));
        manager.put("c", new ImageIcon("icon\\c.png"));
        manager.put("close", new ImageIcon("icon\\close.png"));
        manager.put("close_all", new ImageIcon("icon\\close_all.png"));
        manager.put("close_file", new ImageIcon("icon\\close_file.png"));
        manager.put("close_folder", new ImageIcon("icon\\close_folder.png"));
        manager.put("copy", new ImageIcon("icon\\copy.png"));
        manager.put("cplusplus", new ImageIcon("icon\\c++.png"));
        manager.put("csharp", new ImageIcon("icon\\c#.png"));
        manager.put("css", new ImageIcon("icon\\css.png"));
        manager.put("csv", new ImageIcon("icon\\csv.png"));
        manager.put("clojure", new ImageIcon("icon\\clojure.png"));
        manager.put("cut", new ImageIcon("icon\\cut.png"));
        manager.put("directory", new ImageIcon("icon\\directory.png"));
        manager.put("find", new ImageIcon("icon\\find.png"));
        manager.put("folder", new ImageIcon("icon\\folder.png"));
        manager.put("html", new ImageIcon("icon\\html.png"));
        manager.put("java", new ImageIcon("icon\\java.png"));
        manager.put("javascript", new ImageIcon("icon\\javascript.png"));
        manager.put("json", new ImageIcon("icon\\json.png"));
        manager.put("jsp", new ImageIcon("icon\\jsp.png"));
        manager.put("new", new ImageIcon("icon\\new.png"));
        manager.put("normal", new ImageIcon("icon\\normal_text.png"));
        manager.put("open", new ImageIcon("icon\\open.png"));
        manager.put("paste", new ImageIcon("icon\\paste.png"));
        manager.put("php", new ImageIcon("icon\\php.png"));
        manager.put("print", new ImageIcon("icon\\print.png"));
        manager.put("python", new ImageIcon("icon\\python.png"));
        manager.put("perl", new ImageIcon("icon\\perl.png"));
        manager.put("picture", new ImageIcon("icon\\picture.png"));
        manager.put("ruby", new ImageIcon("icon\\ruby.png"));
        manager.put("redo", new ImageIcon("icon\\redo.png"));
        manager.put("replace", new ImageIcon("icon\\replace.png"));
        manager.put("save", new ImageIcon("icon\\save.png"));
        manager.put("save_all", new ImageIcon("icon\\save_all.png"));
        manager.put("save_as", new ImageIcon("icon\\save_as.png"));
        manager.put("sql", new ImageIcon("icon\\sql.png"));
        manager.put("undo", new ImageIcon("icon\\undo.png"));
        manager.put("xml", new ImageIcon("icon\\xml.png"));
        manager.put("typescript", new ImageIcon("icon\\typescript.png"));
        manager.put("visual-basic", new ImageIcon("icon\\visual-basic.png"));
    }

    @Override
    public int size() {
        return manager.size();
    }

    @Override
    public boolean isEmpty() {
        return manager.isEmpty();
    }

    @Override
    public Enumeration<String> keys() {
        return manager.keys();
    }

    @Override
    public Enumeration<ImageIcon> elements() {
        return manager.elements();
    }

    @Override
    public ImageIcon get(Object key) {
        return manager.get(key);
    }

    @Override
    public ImageIcon put(String key, ImageIcon value) {
        return manager.put(key, value);
    }

    @Override
    public ImageIcon remove(Object key) {
        return manager.remove(key);
    }
}
