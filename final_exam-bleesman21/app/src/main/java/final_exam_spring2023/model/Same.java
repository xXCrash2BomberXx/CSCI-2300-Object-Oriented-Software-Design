package final_exam_spring2023.model;

public class Same implements Combination {
	public String getDescription() {
		return "Same value";
	}

	public boolean goalMet(Dice dice) {
		return sameValue(dice);
	}

	public int getScore(Dice dice) {
		return sameValueScore(dice);
	}

	/*
	 * Determines if the given Dice object reached the SAME goal.
	 */
	private boolean sameValue(Dice dice) {
		int value = dice.getValue(0);
		for (int i = 1; i < dice.getNumDice(); i++) {
			if (dice.getValue(i) != value) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Returns the score based on SAME goal, if goal is reached. Returns zero
	 * otherwise.
	 */
	private int sameValueScore(Dice dice) {
		int score = 0;
		if (sameValue(dice)) {
			score = dice.getValue(0) * 100;
		}
		return score;
	}
}
