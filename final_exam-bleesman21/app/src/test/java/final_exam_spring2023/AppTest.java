/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package final_exam_spring2023;

import final_exam_spring2023.model.Dice;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

	// add your tests here or create new test classes in new files
	@Test
	public void roll() {
		Dice dice = new Dice(2);
		dice.roll();
		int d1 = dice.getValue(0);
		int d2 = dice.getValue(1);
		dice.lock(0);
		dice.roll();
		assertEquals(d1, dice.getValue(0));
		assertNotEquals(d2, dice.getValue(1));
	}
}
