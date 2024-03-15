package homework8.bleesman21.Control;

import homework8.bleesman21.View.UI;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class ButtonListener implements MouseInputListener {
    protected UI ui;

    public ButtonListener(UI ui) {
        this.ui = ui;
    }

    public void mouseClicked(MouseEvent e) {
        ui.update();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }
}
