package final_exam_spring2023.model;

import java.util.Arrays;

public class Straight implements Combination {
	public String getDescription() {
		return "Straight";
	}

	public boolean goalMet(Dice dice) {
		return straight(dice);
	}

	public int getScore(Dice dice) {
		return straightScore(dice);
	}

	/*
	 * Determines if the given Dice object reached the STRAIGHT goal.
	 */
	private boolean straight(Dice dice) {
		Integer[] values = new Integer[dice.getNumDice()];
		for (int i = 0; i < dice.getNumDice(); i++) {
			values[i] = dice.getValue(i);
		}
		Arrays.sort(values);
		for (int i = 0; i < dice.getNumDice(); i++) {
			if (values[i] != i + 1) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Returns the score based on STRAIGHT goal, if goal is reached. Returns zero
	 * otherwise.
	 */
	private int straightScore(Dice dice) {
		int score = 0;
		if (straight(dice)) {
			score = 200;
		}
		return score;
	}
}
