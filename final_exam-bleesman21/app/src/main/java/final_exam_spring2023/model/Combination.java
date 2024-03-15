package final_exam_spring2023.model;

public interface Combination {
	public String getDescription();

	public boolean goalMet(Dice dice);

	public int getScore(Dice dice);
}
