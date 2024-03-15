package homework6.bleesman21.View;

import homework6.bleesman21.Control.Control;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class View extends JFrame {
    private JPanel panel = new JPanel();
    private JLabel text = new JLabel();
    private JButton[] buttons = new JButton[26];
    private JLabel wrong = new JLabel();

    public View (Control control) {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.CYAN);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel textPanel = new JPanel();
        textPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        textPanel.setOpaque(false);
        textPanel.add(text);
        panel.add(textPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 9, 5, 5));
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttonPanel.setOpaque(false);
        int i = 0;
        for (char letter = 'a'; letter <= 'z'; letter++) {
            buttons[i] = new JButton(Character.toString(letter));
            buttons[i].addActionListener(control);
            buttonPanel.add(buttons[i++]);
        }
        panel.add(buttonPanel);
        
        JPanel wrongPanel = new JPanel();
        wrongPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        wrongPanel.setOpaque(false);
        wrongPanel.add(wrong);
        panel.add(wrongPanel);

        add(panel);
        pack();
        setSize(500, 200);
    }
    public void update (String guessed, int left) {
        text.setText(guessed);
        wrong.setText("Allowed incorrect guesses: "+String.valueOf(left));
    }
    public void reveal (boolean win, String word) {
        for (int i=0; i < 26; i++) {
            buttons[i].setEnabled(false);
        }
        if (win)
            text.setText("Congratulations, you revealed the hidden word: "+word);
        else
            text.setText("Sorry, you lost. The word was: "+word);
    }
}
