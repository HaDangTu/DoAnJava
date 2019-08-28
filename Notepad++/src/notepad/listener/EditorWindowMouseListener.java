package notepad.listener;

import notepad.ui.EditorWindow;
import notepad.ui.EditorWindowPopupMenu;

import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class EditorWindowMouseListener extends BaseMouseListener{
    private EditorWindowPopupMenu popupMenu;

    public EditorWindowMouseListener(EditorWindow editorWindow){
        super(editorWindow);
        this.popupMenu = new EditorWindowPopupMenu(editorWindow);
    }
    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     * if right click on tab then show popup menu
     * and select tab is clicked
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            int index = editorWindow.getUI().tabForCoordinate(editorWindow, e.getX(), e.getY());
            if (index > -1) {
                popupMenu.show(editorWindow, e.getX(), e.getY());
                editorWindow.setSelectedIndex(index);
            }
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
