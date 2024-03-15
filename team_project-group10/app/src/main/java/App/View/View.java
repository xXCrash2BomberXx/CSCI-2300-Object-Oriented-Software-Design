package App.View;

import App.Model.Renderable;
import App.Model.SpriteObject;
import App.Model.Sprite;

import App.Model.Model;
import App.Model.Renderable;
import App.Model.Observer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import App.Control.Control;

public class View extends JFrame implements Observer {
	protected Container container;
	protected JButton homeButton;
	protected JButton instructionsButton;
	protected JButton shuffleButton;
	protected int width;
	protected int height;
	protected JLabel timeLabel;
    protected Timer timer;

	public static Container fromSpriteObject(SpriteObject SpriteObject) {
		Container panel = new Container() {
			@Override
			public void paint(Graphics g) {
				super.paint(g); // Clear the canvas
				Sprite[] sprites = SpriteObject.getSprites();
				Color[] colors = SpriteObject.getInner();
				Color[] colors2 = SpriteObject.getOuter();
				Graphics2D g2D = (Graphics2D) g;
				Boolean[] indeces = new Boolean[sprites.length];
				for (int loop = 0; loop < sprites.length; loop++) {
					int current = -1;
					for (int index = 0; index < sprites.length; index++)
						if (indeces[index] == null && (current == -1
								|| sprites[index].calcRotatedCenterZ() > sprites[current].calcRotatedCenterZ()))
							current = index;
					Path2D.Double sprite = View.fromSprite(sprites[current]);
					if (SpriteObject.inner) {
						if (colors.length > 0)
								g2D.setColor(colors[current % colors.length]);
						else
								g2D.setColor(Color.BLACK);
						g2D.fill(sprite);
					}
					if (SpriteObject.outer) {
						if (colors2.length > 0)
								g2D.setColor(colors2[current % colors2.length]);
						else
								g2D.setColor(Color.BLACK);
						g2D.draw(sprite);
					}
					indeces[current] = true;
				}
			}
		};
		panel.setLocation(0, 0);
		return panel;
	}

	public static Path2D.Double fromSprite(Sprite sprite) {
		Path2D.Double path = new Path2D.Double();
		double[][][] rotated = sprite.getRotated();
		Boolean[] indeces = new Boolean[rotated.length];
		for (int loop = 0; loop < rotated.length; loop++) {
				int current = -1;
				for (int index = 0; index < rotated.length; index++)
						if (indeces[index] == null && (current == -1
										|| sprite.calcCenterZ(rotated[index]) >= sprite.calcCenterZ(rotated[current])))
								current = index;
				path.moveTo(rotated[current][0][0], rotated[current][0][1]);
				for (int i = 1; i < rotated[current].length; i++)
						try {
								path.lineTo(rotated[current][i][0], rotated[current][i][1]);
						} catch (NullPointerException e) {}
				path.closePath();
				indeces[current] = true;
		}
		return path;
	}

	public View(Control control) {
		super();
		init(control, 500, 500);
	}

	public View(Control control, int width, int height) {
		super();
		init(control, width, height);
	}

	protected void init(Control control, int width, int height) {
		this.width = width;
		this.height = height;
		setLayout(null);
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(control);
		addMouseMotionListener(control);
		addMouseWheelListener(control);
		addKeyListener(control);
		homeButton = new JButton("Home");
		homeButton.setLocation(10, 0);
		homeButton.setSize(110, 30);
		homeButton.addActionListener(e -> control.homeButton());
		instructionsButton = new JButton("Instructions");
		instructionsButton.setLocation(125, 0);
		instructionsButton.setSize(110, 30);
		instructionsButton.addActionListener(e -> control.instructionsButton());
		shuffleButton = new JButton("Shuffle");
		shuffleButton.setLocation(240, 0);
		shuffleButton.setSize(110, 30);
		shuffleButton.addActionListener(e -> control.shuffleButton());
		timeLabel = new JLabel();
        timeLabel.setLocation(width - 100, 0);
        timeLabel.setSize(100, 30);
		timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLabel.setText(control.getTime());
            }
        });
        timer.start();
	}

	public void addSprites(Model model) {
		container = new Container() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				for (Renderable o : model.getObjs())
					if (o instanceof Sprite)
						g2.draw(View.fromSprite((Sprite) o));
			}
		};
		container.setSize(width, height);
	}

	public void draw(Model model) {
		getContentPane().removeAll();
		repaint();
		Arrays.sort(model.getObjs(), (a, b) -> (int) (a.calcRotatedCenterZ() - b.calcRotatedCenterZ()));
		for (Renderable o : model.getObjs()) {
			if (o instanceof SpriteObject) {
				Container o2 = View.fromSpriteObject((SpriteObject) o);
				add(o2);
				o2.setSize(width, height);
			}
		}
		add(container);
		container.repaint();
		add(homeButton);
		add(instructionsButton);
		add(shuffleButton);
		add(timeLabel);
		requestFocus();
	}
}
