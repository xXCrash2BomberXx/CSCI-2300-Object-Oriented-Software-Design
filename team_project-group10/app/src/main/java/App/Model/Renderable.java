package App.Model;

public interface Renderable {
	public void rotate(double theta_x, double theta_y, double theta_z);

	public void irotate(double theta_x, double theta_y, double theta_z);
	public void irotate(double theta_x, double theta_y, double theta_z, Model model);

	public double calcCenterX();

	public double calcCenterY();

	public double calcCenterZ();

	public double calcRotatedCenterX();

	public double calcRotatedCenterY();
	
	public double calcRotatedCenterZ();

	public double[] getCenter();

	public double[] calcCenter();

	public double[] calcRotatedCenter();

	public double[] getTheta();

	public double[] getIRotated();

	public double[] calcRotatedRoundedCenter();

	public boolean isSolved(double[] irotated);
}
