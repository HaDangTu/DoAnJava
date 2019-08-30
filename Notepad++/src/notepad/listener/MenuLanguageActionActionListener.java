package notepad.listener;
import notepad.ui.EditorWindow;
import notepad.util.CategoryOfFile;
import notepad.util.Language;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import java.awt.event.ActionEvent;

public class MenuLanguageActionActionListener extends MenuMainWindowActionListener {
    public MenuLanguageActionActionListener(EditorWindow editorWindow){
        super(editorWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        CategoryOfFile category = CategoryOfFile.getInstance();
        Language lang = category.getLanguage(command);
        editorWindow.setStyleForTab(lang.getKeyStyle(), lang.getExtension(), false);
    }
}
