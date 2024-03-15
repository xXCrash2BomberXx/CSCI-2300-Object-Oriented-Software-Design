package homework8.bleesman21;

import homework8.bleesman21.Model.Dice;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Dice(3).getUI());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
