package App.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class AnimationControl {
	public static boolean active = false;

	public static void animateRotateFace(Model model, Renderable sprite, double theta_x, double theta_y, double theta_z) {
		animateRotateFace(model, new Renderable[] {sprite}, theta_x, theta_y, theta_z);
	}

	public static void animateRotateFace(Model model, Renderable[] sprites, double theta_x, double theta_y, double theta_z) {
		ActionListener animation = new ActionListener() {
			private int steps = 5;
			private int stepsLeft = steps;
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stepsLeft > 0) {
					for (Renderable o : sprites)
						if (o instanceof Renderable)
							o.irotate(theta_x/steps, theta_y/steps, theta_z/steps);
					stepsLeft--;
				} else {
					((Timer) e.getSource()).stop();
					active = false;
				}
				model.update();
			}
		};
		active = true;
		Timer timer = new Timer(1, animation);
		timer.start();
	}
}