package final_exam_spring2023.model;

import java.util.Arrays;

public class Pairs implements Combination {
	public String getDescription() {
		return "Pairs";
	}

	public boolean goalMet(Dice dice) {
		return pairs(dice);
	}

	public int getScore(Dice dice) {
		return pairsScore(dice);
	}

	/*
	 * Determines if the given Dice object reached the PAIRS goal.
	 */
	private boolean pairs(Dice dice) {
		Integer[] counts = new Integer[] { 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < dice.getNumDice(); i++)
			counts[dice.getValue(i) - 1] += 1;
		Arrays.sort(counts); // Should be one of [0, 0, 0, 2, 2, 2], [0, 0, 0, 0, 2, 4], [0, 0, 0, 0, 0, 6]
		// False positives [0, 0, 0, 1, 2, 3] countered with additional conditional
		return counts[3] == 2 || (counts[4] == 2 && counts[5] == 4) || counts[5] == 6;
	}

	/*
	 * Returns the score based on PAIRS goal, if goal is reached. Returns zero
	 * otherwise.
	 */
	private int pairsScore(Dice dice) {
		if (pairs(dice)) {
			int score = 0;
			for (int i = 0; i < dice.getNumDice(); i++)
				score += 5 * dice.getValue(i);
			return score;
		}
		return 0;
	}

}
