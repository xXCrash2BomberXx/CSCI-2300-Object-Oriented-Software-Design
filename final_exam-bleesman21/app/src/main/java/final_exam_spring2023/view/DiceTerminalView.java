package final_exam_spring2023.view;

import final_exam_spring2023.model.Dice;
import final_exam_spring2023.model.DiceObserver;

public class DiceTerminalView implements DiceObserver {
	public static String[] UnicodeValues = { "0", "1", "2", "3", "4", "5", "6" };
	DiceControllerInterface controller;
	Dice dice;

	public DiceTerminalView(Dice dice, DiceControllerInterface controller) {
		this.dice = dice;
		this.controller = controller;
		this.dice.register(this);
	}

	@Override
	public void update() {
		System.out.println(dice.toString());
	}
}
