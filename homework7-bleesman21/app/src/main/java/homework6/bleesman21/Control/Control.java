package homework6.bleesman21.Control;

import homework6.bleesman21.Model.Model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Control implements ActionListener {
    private Model model = new Model(this);
    public void actionPerformed (ActionEvent event) {
        JButton button = (JButton) event.getSource();
        button.setEnabled(false);
        model.guess(button.getText().charAt(0));
    }
}
