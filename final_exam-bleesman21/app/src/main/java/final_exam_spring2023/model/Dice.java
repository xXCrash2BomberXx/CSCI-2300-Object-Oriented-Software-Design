package final_exam_spring2023.model;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
	protected int numDice;
	protected int[] values;
	protected boolean[] locked;
	Random randomizer;
	ArrayList<DiceObserver> observers;

	public Dice(int numDice) {
		this.numDice = numDice;
		randomizer = new Random();
		this.values = new int[numDice];
		this.locked = new boolean[numDice];
		observers = new ArrayList<DiceObserver>();
	}

	/*
	 * Resets all dice values to zero and unlocks them.
	 */
	public void reset() {
		for (int i = 0; i < numDice; i++) {
			values[i] = 0;
			unlock(i);
		}
		notifyObservers();
	}

	/*
	 * Locks a die at a given index. diceIndex must be less than numDice.
	 * Only valid dice values can be locked.
	 */
	public void lock(int diceIndex) {
		if (this.values[diceIndex] > 0) {
			this.locked[diceIndex] = true;
			notifyObservers();
		}
	}

	/*
	 * Unlocks a die at a given index. diceIndex must be less than numDice.
	 */
	public void unlock(int diceIndex) {
		this.locked[diceIndex] = false;
		notifyObservers();
	}

	/*
	 * Rolls all unlocked dice. Locked dice should have the same value after the
	 * roll
	 * as they did before the roll. Unlocked dice might have new values after the
	 * roll.
	 */
	public void roll() {
		for (int i = 0; i < numDice; i++) {
			if (!this.locked[i])
				this.rollOne(i);
		}
		notifyObservers();
	}

	/*
	 * Returns the number of dice used
	 */
	public int getNumDice() {
		return this.numDice;
	}

	/*
	 * Returns a die value at a given index. Index i must be less than numDice.
	 */
	public int getValue(int i) {
		return this.values[i];
	}

	/*
	 * Returns true if a die at index i is locked, false otherwise. Index i must be
	 * less than numDice.
	 */
	public boolean isLocked(int i) {
		return this.locked[i];
	}

	/*
	 * Returns a human readable state of the Dice object
	 */
	public String toString() {
		String diceString = "";
		for (int i = 0; i < this.numDice; i++) {
			diceString += this.values[i];
			if (this.locked[i]) {
				diceString += "[L] ";
			} else {
				diceString += "[U] ";
			}
		}
		return diceString;
	}

	/*
	 * Register a new DiceObserver. All registered DiceObservers will get notified
	 * when the object state changes.
	 */
	public void register(DiceObserver observer) {
		this.observers.add(observer);
	}

	private void rollOne(int diceIndex) {
		int randValue = randomizer.nextInt(this.numDice) + 1;
		this.values[diceIndex] = randValue;
	}

	private void notifyObservers() {
		for (DiceObserver o : observers) {
			o.update();
		}
	}
}