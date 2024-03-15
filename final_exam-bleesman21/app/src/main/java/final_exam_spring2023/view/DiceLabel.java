package final_exam_spring2023.view;

import javax.swing.JLabel;
import java.awt.event.*;

public class DiceLabel extends JLabel implements MouseListener{
    private int index;
    private DiceControllerInterface controller;
    public DiceLabel(int index, DiceControllerInterface controller){
        this.index = index;
        this.controller = controller;
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        controller.dieSelected(index);
    }

    /*
     * Unused MouseListener methods
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
