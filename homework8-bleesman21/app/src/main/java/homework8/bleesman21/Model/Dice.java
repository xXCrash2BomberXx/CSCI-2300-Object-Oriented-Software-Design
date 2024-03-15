package homework8.bleesman21.Model;

import homework8.bleesman21.View.UI;

import java.util.Random;

public class Dice {
    protected UI ui;
    protected int dice;
    protected Random random = new Random();

    public Dice(int dice) {
        this.dice = dice;
        ui = new UI(this);
    }

    public int[] rolls() {
        int[] vals = new int[dice];
        for (int i = 0; i < dice; i++) {
            vals[i] = roll();
        }
        return vals;
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }

    public int size() {
        return dice;
    }

    public UI getUI() {
        return ui;
    }
}
