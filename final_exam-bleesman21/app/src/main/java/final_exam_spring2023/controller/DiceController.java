package final_exam_spring2023.controller;

import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import final_exam_spring2023.model.Combination;
import final_exam_spring2023.model.Pairs;
import final_exam_spring2023.model.Same;
import final_exam_spring2023.model.Straight;

import final_exam_spring2023.model.Dice;
import final_exam_spring2023.view.DiceControllerInterface;
import final_exam_spring2023.view.DiceTerminalView;
import final_exam_spring2023.view.DiceView;

public class DiceController implements DiceControllerInterface {

	private Dice dice;
	private DiceView ui;
	private Combination goal;
	private Combination[] levels = { new Pairs(), new Same(), new Straight() };

	private int numRolls;
	private int maxRolls = 3;
	Random randomizer = new Random();

	public DiceController(Dice dice) {
		this.dice = dice;
		this.ui = new DiceView(dice, this);
		new DiceTerminalView(dice, this);
		resetGame();
	}

	/*
	 * This method controls what happens when a particular die is clicked
	 * If the die is currently unlocked, it tells the model to lock the die
	 * If the die is currently locked, it tells the model to unlock the die
	 */
	@Override
	public void dieSelected(int index) {
		if (dice.isLocked(index)) {
			dice.unlock(index);
		} else {
			dice.lock(index);
		}
	}

	/*
	 * Dice roll action happens here: dice are rolled and then various conditions
	 * are checked to see if the game is over.
	 * When the game is over, the user is given an option to play again.
	 */
	@Override
	public void rollDice() {
		dice.roll();
		this.numRolls++;
		int answer = JOptionPane.CANCEL_OPTION;
		if (this.goal.goalMet(dice)) {
			answer = JOptionPane.showConfirmDialog(ui,
					"Your score is " + goal.getScore(dice) + ". Do you want to play again?",
					"Goal reached",
					JOptionPane.YES_NO_OPTION);
		} else if (this.numRolls == this.maxRolls) {
			answer = JOptionPane.showConfirmDialog(ui,
					"Your score is " + goal.getScore(dice) + ". Do you want to play again?",
					"Max rolls reached",
					JOptionPane.YES_NO_OPTION);
		}

		if (answer == JOptionPane.YES_OPTION) {
			resetGame();
		} else if (answer == JOptionPane.NO_OPTION || answer == JOptionPane.CLOSED_OPTION) {
			ui.dispatchEvent(new WindowEvent(ui, WindowEvent.WINDOW_CLOSING));
		}
	}

	/*
	 * This method is called at the start of each new round of the game
	 * It picks a combination that will be used, resets all dice to zero, and resets
	 * the number of rolls used
	 */
	private void resetGame() {
		dice.reset();
		this.numRolls = 0;
		int randomLevel = randomizer.nextInt(levels.length);
		this.goal = levels[randomLevel];
		this.numRolls = 0;
		ui.setGoal(this.goal.getDescription());
	}

}
