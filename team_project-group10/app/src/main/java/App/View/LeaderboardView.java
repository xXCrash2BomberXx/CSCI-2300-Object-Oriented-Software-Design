package App.View;

import App.Control.LeaderboardControl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderboardView extends JFrame {
    private JTextArea leaderboard;

    public LeaderboardView(ArrayList<String> leaderboardData, LeaderboardControl control) {
        setTitle("Leaderboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel leaderboardPanel = new JPanel(new BorderLayout(10, 10));
        leaderboardPanel.setBorder(BorderFactory.createTitledBorder("Leaderboard"));

        leaderboard = new JTextArea();
        leaderboard.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(leaderboard);
        leaderboardPanel.add(scrollPane, BorderLayout.CENTER);

        displayLeaderboardData(leaderboardData);

        JButton clearButton = new JButton("Clear Leaderboard");
        clearButton.addActionListener(control.getClearButtonListener());
        leaderboardPanel.add(clearButton, BorderLayout.SOUTH);

        add(leaderboardPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void displayLeaderboardData(ArrayList<String> leaderboardData) {
        leaderboard.setText("");
        for (String entry : leaderboardData) {
            leaderboard.append(entry + "\n");
        }
    }
}
