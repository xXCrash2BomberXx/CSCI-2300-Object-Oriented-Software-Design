package homework8.bleesman21.View;

import homework8.bleesman21.Model.Dice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class RepeatTimer implements ActionListener {
    protected JTextField text;
    protected Dice die;

    RepeatTimer(Dice die, JTextField text) {
        this.text = text;
        this.die = die;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text.setText(Character.toString(UI.faces[die.roll() - 1]));
    }
}
