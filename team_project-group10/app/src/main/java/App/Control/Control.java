package App.Control;

import App.View.View;
import App.Model.Model;
import App.Model.Renderable;

import App.Control.MainMenuControl;
import App.View.MainMenuView;
import App.Model.LeaderboardModel;
import App.Control.LeaderboardControl;
import App.Model.LeaderboardEntry;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Control implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	protected Model model;
	protected double[] lastPoint = null;
	protected int sensitivity = 10;
	Boolean space = false;
	protected long startTime;
	Boolean solvedCube = false;
	private LeaderboardModel leaderboardModel;
	private int x,y,z;
	private String formattedTime;

	public Control() {
		model = new Model();
		model.register(new View(this));
		model.update();
		leaderboardModel = new LeaderboardModel();
	}

	public Control(int width, int height) {
		model = new Model(width, height);
		model.register(new View(this, width, height));
		model.update();
		leaderboardModel = new LeaderboardModel();
	}

	public Control(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		model = new Model(x, y, z);
		model.register(new View(this));
		model.update();
		leaderboardModel = new LeaderboardModel();
	}

	public Control(int x, int y, int z, int width, int height) {
		this.x = x;
		this.y = y;
		this.z = z;
		model = new Model(x, y, z, width, height);
		model.register(new View(this, width, height));
		model.update();
		leaderboardModel = new LeaderboardModel();
	}

	public Control(Renderable[] objs) {
		model = new Model(objs);
		model.register(new View(this));
		model.update();
		leaderboardModel = new LeaderboardModel();
	}

	public Control(Renderable[] objs, int width, int height) {
		model = new Model(objs);
		model.register(new View(this, width, height));
		model.update();
		leaderboardModel = new LeaderboardModel();
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {
		switch (e.getButton()) {
			case MouseEvent.NOBUTTON:
				mouseMoved(e);
				break;
			case MouseEvent.BUTTON1:  // Left Click
				if (space) {
					model.rotateColumnDown(e.getX(), e.getY());
				} else {
					model.rotateColumnUp(e.getX(), e.getY());
				}
				break;
			case MouseEvent.BUTTON2:  // Middle Click
				space = !space;
				break;
			case MouseEvent.BUTTON3:  // Right Click
				if (space) {
					model.rotateRowLeft(e.getX(), e.getY());
				} else {
					model.rotateRowRight(e.getX(), e.getY());
				}
				break;
			default:
				break;
		}
		recordTimer();
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		double[] point = new double[] {e.getX(), e.getY(), 0};
		if (lastPoint != null && !space)
			model.rotate(new double[] {point[1]-lastPoint[1], -point[0]+lastPoint[0], 0});
		lastPoint = point;
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		if (!space)
			model.rotate(new double[] {0, 0, e.getPreciseWheelRotation() * sensitivity});
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		switch (Character.toLowerCase(e.getKeyChar())) {
			case 'a':
				model.rotateFrontCounterClockwise();
				break;
			case 'd':
				model.rotateFrontClockwise();
				break;
			case 's':
				model.randomizeCube();
				System.out.println("Cube has been randomized. Timer begins now.");
				startTime = System.currentTimeMillis();
				solvedCube = false;
				break;
			case ' ':
				space = true;
				break;
			case 'q':
				model.rotateColumnUp(200, 0, true);
				startTime = System.currentTimeMillis();
				solvedCube = false;
				break;
			default:
				System.out.println("Key '"+e.getKeyChar()+"' does not have a set command");
				break;
		}
		recordTimer();
	}

	public void keyReleased(KeyEvent e) {
		switch (Character.toLowerCase(e.getKeyChar())) {
			case ' ':
				space = false;
				break;
			default:
				break;
		}
		recordTimer();
	}

	public void recordTimer() {
		if (model.isSolved() && !solvedCube) {
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime);
			long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) % 60;
			long milliseconds = elapsedTime % 1000;
			formattedTime = String.format("%02d:%02d.%03d", minutes, seconds, milliseconds);
			if (minutes <= 100) {
				System.out.println("Elapsed time: " + formattedTime);
				Object[] options = {"OK", "Save to Leaderboard"};
				int choice = JOptionPane.showOptionDialog(null, "Congratulations! You solved the " + x + "x" + y + "x" + z + " Rubik's Cube in " + formattedTime + ".", "Solved!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if (choice == 1) {
					leaderboardModel.addEntry(new LeaderboardEntry(x, y, z, formattedTime));
					Object[] options2 = {"OK", "Go to Leaderboard"};
					int choice2 = JOptionPane.showOptionDialog(null, "Time saved to leaderboard!", "Leaderboard", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
					if (choice2 == 1) {
						LeaderboardModel leaderboardModel = new LeaderboardModel();
						LeaderboardControl leaderboardControl = new LeaderboardControl(leaderboardModel);
					}
				}
			}
			solvedCube = true;
		}
	}

	public String getTime() {
		return formattedTime;
	}

	public void homeButton() {
		new MainMenuControl(new MainMenuView());
		startTime = System.currentTimeMillis();
		model.dispose();
	}
	
	public void instructionsButton() {
		JFrame instructionsFrame = new JFrame("Instructions and Key-Bindings");
		instructionsFrame.setSize(300, 200);
		instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JTextArea instructionsTextArea = new JTextArea("Rubik's Cube Instructions\nKey Bindings:\n 'S' = Shuffle\n 'Space Bar' = Holding Down Space Bar While Moving Mouse Freezes Cube Position\n 'A' = Rotate Front Counter Clockwise\n 'D' = Rotate Front Clockwise\n\nClick Bindings:\n 'Right Click' = Rotate Column Up\n 'Right Click + Space' = Rotate Column Down\n 'Left Click' = Rotate Row Right\n 'Left Click + Space' = Rotate Row Left\n 'Mouse Scroll Wheel' = Z-Rotation");
		instructionsTextArea.setEditable(false);
		instructionsTextArea.setLineWrap(true); 
		instructionsTextArea.setWrapStyleWord(true); 
		JScrollPane instructionsScrollPane = new JScrollPane(instructionsTextArea);
		instructionsFrame.add(instructionsScrollPane);
		instructionsFrame.setLocationRelativeTo(null);
		instructionsFrame.setVisible(true);
	}
	
	public void shuffleButton() {
		model.randomizeCube();
		System.out.println("Cube has been randomized. Timer begins now.");
		startTime = System.currentTimeMillis();
	}	
}