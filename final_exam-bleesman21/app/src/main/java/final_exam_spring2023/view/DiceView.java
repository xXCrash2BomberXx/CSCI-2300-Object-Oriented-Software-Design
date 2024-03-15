package final_exam_spring2023.view;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;

import final_exam_spring2023.model.Dice;
import final_exam_spring2023.model.DiceObserver;

public class DiceView extends JFrame implements DiceObserver {
	public static String[] UnicodeValues = { "0", "1", "2", "3", "4", "5", "6" };
	JPanel mainPanel;
	DiceControllerInterface controller;
	DiceLabel[] diceLabels;
	JLabel goalLabel;
	Dice dice;

	public DiceView(Dice dice, DiceControllerInterface controller) {
		this.dice = dice;
		this.controller = controller;
		this.dice.register(this);

		this.setTitle("Dice Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		// Area where we display the game's goal
		JPanel goalPanel = new JPanel();
		goalLabel = new JLabel("YOUR GOAL");
		goalLabel.setHorizontalAlignment(JLabel.CENTER);
		goalPanel.add(goalLabel);
		mainPanel.add(goalPanel);

		// Area where we display the dice
		JPanel dicePanel = createDicePanel(this.controller);
		mainPanel.add(dicePanel);

		// Area where we display the roll button
		JPanel buttonPanel = createRollButtonPanel(this.controller);
		mainPanel.add(buttonPanel);

		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}

	public void setGoal(String goal) {
		goalLabel.setText("YOUR GOAL IS: " + goal);
	}

	@Override
	public void update() {
		for (int i = 0; i < dice.getNumDice(); i++) {
			int value = dice.getValue(i);
			diceLabels[i].setText(UnicodeValues[value]);
			if (dice.isLocked(i)) {
				diceLabels[i].setBorder(BorderFactory.createLineBorder(Color.RED));
			} else {
				diceLabels[i].setBorder(BorderFactory.createEmptyBorder());
			}
		}
	}

	private JPanel createDicePanel(DiceControllerInterface controller) {
		JPanel dicePanel = new JPanel();
		int numLabels = dice.getNumDice();
		diceLabels = new DiceLabel[numLabels];
		for (int i = 0; i < numLabels; i++) {
			diceLabels[i] = new DiceLabel(i, controller);
			diceLabels[i].setFont(new Font("Arial", Font.PLAIN, 60));
			dicePanel.add(diceLabels[i]);
		}
		dicePanel.setPreferredSize(new Dimension(500, 300));
		update();
		return dicePanel;
	}

	private JPanel createRollButtonPanel(DiceControllerInterface controller) {
		JPanel buttonPanel = new JPanel();
		JButton rollButton = new JButton("ROLL DICE");
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.rollDice();
			}
		});
		buttonPanel.add(rollButton);
		return buttonPanel;
	}

}
