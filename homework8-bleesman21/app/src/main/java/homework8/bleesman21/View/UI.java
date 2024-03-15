package homework8.bleesman21.View;

import homework8.bleesman21.Control.DiceListener;
import homework8.bleesman21.Control.ButtonListener;
import homework8.bleesman21.Model.Dice;

import javax.swing.JPanel;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;

public class UI extends JPanel {
    public static char[] faces = { '⚀', '⚁', '⚂', '⚃', '⚄', '⚅' };
    protected ArrayList<JTextField> dice = new ArrayList<JTextField>();
    protected JButton roll = new JButton("Roll All");
    protected Dice die;
    protected int RENDER_DELAY = 100;
    protected int RENDER_FRAMES = 10;

    public UI(Dice die) {
        for (int i = 0; i < die.size(); i++) {
            JTextField dieUI = new JTextField(faces[0]);
            dieUI.setColumns(1);
            dieUI.setEditable(false);
            dieUI.setFont(new Font("SansSerif", Font.PLAIN, 124));
            this.dice.add(dieUI);
            add(dieUI);
            dieUI.addMouseListener(new DiceListener(this));
        }
        this.die = die;
        add(roll);
        roll.addMouseListener(new ButtonListener(this));
    }

    public void update(JTextField die) {
        for (int i = 0; i < RENDER_FRAMES; i++) {
            Timer timer = new Timer(i * RENDER_DELAY, new RepeatTimer(this.die, die));
            timer.setRepeats(false);
            timer.start();
        }
    }

    public void update() {
        for (int i = 0; i < this.dice.size(); i++) {
            update(this.dice.get(i));
        }
    }
}
