package App.Model;

import java.awt.Color;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class Model {
	protected ArrayList<Observer> Observer = new ArrayList<Observer>();
	protected Renderable[] objs;
	protected Renderable[] center;
	protected Renderable[] needRotated;
	protected int[] size, csize;

	public Model(int x, int y, int z, int cwidth, int cheight) {
		init(x, y, z, cwidth, cheight);
	}

	public Model(int x, int y, int z) {
		init(x, y, z, 250, 250);
	}

	public Model(int cwidth, int cheight) {
		init(3, 3, 3, cwidth, cheight);
	}

	public Model() {
		init(3, 3, 3, 250, 250);
	}

	protected void init(int x_size, int y_size, int z_size, int cwidth, int cheight) {
		size = new int[] {x_size, y_size, z_size};
		needRotated = new Renderable[Math.max(Math.max(size[0]*size[1], size[0]*size[2]), size[1]*size[2])];
		csize = new int[] {cwidth, cheight};
		center = new Renderable[6];
		int c = 0;
		objs = new Renderable[x_size*y_size*z_size-(x_size-2)*(y_size-2)*(z_size-2)];
		int i = 0;
		for (int x = 0; x < x_size; x++)
			for (int y = 0; y < y_size; y++)
				for (int z = 0; z < z_size; z++)
					if (x == 0 || x == x_size-1 || y == 0 || y == y_size-1 || z == 0 || z == z_size-1) {
						objs[i] = new SpriteObject("cube", cwidth - x_size * 25 + x * 50,
								cheight - y_size * 25 + y * 50,
								z * 50 - z_size * 25,
								50, 50, 50,
								cwidth, cheight, 0, new Color[] {
									Color.RED, Color.WHITE, Color.GREEN,
									Color.YELLOW, Color.BLUE, Color.ORANGE
								}, new Color[] {Color.BLACK});
						if ((x == 1 && y == 1) || (y == 1 && z == 1) || (x == 1 && z == 1))
							center[c++] = objs[i];
						i++;
					}
	}

	public Model(Renderable[] objs) {
		this.objs = objs;
	}

	public Renderable[] getObjs() {
		return objs;
	}

	public void register(Observer Observer) {
		this.Observer.add(Observer);
		Observer.addSprites(this);
	}

	public void rotate(double[] e) {  // Mouse Moved
		for (Renderable o : objs)
			o.rotate(e[0], e[1], e[2]);
		update();
	}

	public void rotateColumnDown(double x, double y, boolean shuffle) {
		rotateColumn(x, y, true, shuffle);
	}

	public void rotateColumnUp(double x, double y, boolean shuffle) {
		rotateColumn(x, y, false, shuffle);
	}

	public void rotateColumnDown(double x, double y) {
		rotateColumn(x, y, true, false);
	}

	public void rotateColumnUp(double x, double y) {
		rotateColumn(x, y, false, false);
	}

	public void rotateRowLeft(double x, double y, boolean shuffle) {
		rotateRow(x, y, true, shuffle);
	}

	public void rotateRowRight(double x, double y, boolean shuffle) {
		rotateRow(x, y, false, shuffle);
	}

	public void rotateRowLeft(double x, double y) {
		rotateRow(x, y, true, false);
	}

	public void rotateRowRight(double x, double y) {
		rotateRow(x, y, false, false);
	}

	protected void rotateColumn(double x, double y, boolean direction, boolean shuffle) {
		// direction = true: down, direction = false: up
		if ((isSolved() && !shuffle) || AnimationControl.active)
			return;
		
		int n = direction ? -90 : 90;
        double[] point = new double[] {x-csize[0]/2, y-csize[1]/2, 0};
        double[] theta = center[0].getTheta();
        Sprite.rotatePoint(point, -theta[1], -theta[0], 0);

        double[] temp = new double[] {point[0]-csize[0]/2, point[1]-csize[1]/2};
        point[0] = temp[0]*Math.cos(-theta[2]*Math.PI/180)-temp[1]*Math.sin(theta[2]*Math.PI/180)+csize[0]/2;
        point[1] = temp[1]*Math.cos(-theta[2]*Math.PI/180)+temp[0]*Math.sin(theta[2]*Math.PI/180)+csize[1]/2;
        theta[0] = (int) Math.round(theta[0]/90)*90;
        theta[1] = (int) Math.round(theta[1]/90)*90;
        theta[2] = (int) Math.round(theta[2]/90)*90;

		//double[] point = new double[] {x, y, 0};
		//double[] theta = center[0].getTheta();
		//point = Sprite.rotatePoint(point, -theta[0], -theta[1], -theta[2]);

		int column = (int) (Math.round(x/50))*50;

		int i = 0;
		for (Renderable o : objs) {
			if (o.calcCenterX() == column)
				if (shuffle)
					o.irotate(n, 0, 0);
				else
					needRotated[i++] = o;
			if (i == needRotated.length)
				break;
		}
		if (!shuffle)
			AnimationControl.animateRotateFace(this, needRotated, n, 0, 0);
		update();
	}

	protected void rotateRow(double x, double y, boolean direction, boolean shuffle) {
		// direction = true: left, direction = false: right
		if (isSolved() && !shuffle)
			return;
		int n = direction ? -90 : 90;

		//double[] point = new double[] {x, y, 0};
		//double[] theta = center[0].getTheta();
		//point = Sprite.rotatePoint(point, -theta[0], -theta[1], -theta[2]);
		
		int row = (int) (Math.floor(y/50))*50;

		int i = 0;
		for (Renderable o : objs) {
			if (o.calcCenterY() == row)
				if (shuffle)
					o.irotate(0, n, 0);
				else
					needRotated[i++] = o;
			if (i == needRotated.length)
				break;
		}
		if (!shuffle)
			AnimationControl.animateRotateFace(this, needRotated, 0, n, 0);
		update();
	}

	protected double calcFrontCenter() {
		double d = center[0].calcCenter()[2];
		double d2;
		for (int i = 1; i < center.length; i++) {
			d2 = center[i].calcCenter()[2];
			if (d2 < d)
				d = d2;
		}
		return d;
	}

	public void rotateFrontCounterClockwise(boolean shuffle) {
		rotateFront(true, shuffle);
	}

	public void rotateFrontCounterClockwise() {
		rotateFrontCounterClockwise(false);
	}

	public void rotateFrontClockwise(boolean shuffle) {
		rotateFront(false, shuffle);
	}

	public void rotateFrontClockwise() {
		rotateFrontClockwise(false);
	}

	protected void rotateFront(boolean direction) {
		rotateFront(direction, false);
	}

	protected void rotateFront(boolean direction, boolean shuffle) {
		// direction = true: counterclockwise, direction = false: clockwise
		if (isSolved() && !shuffle)
			return;
		int n = direction ? -90 : 90;

		double depth = calcFrontCenter();

		int i = 0;
		for (Renderable o : objs) {
			if (o.calcCenterZ() == depth)
				if (shuffle)
					o.irotate(0, 0, n);
				else
					needRotated[i++] = o;
			if (i == needRotated.length)
				break;
		}
		if (!shuffle)
			AnimationControl.animateRotateFace(this, needRotated, 0, 0, n);
		update();
	}

	public void update() {
		for (Observer v : Observer)
			v.draw(this);
	}

	public boolean isSolved() {
		for (Renderable o : objs)
			if (!o.isSolved(objs[0].getIRotated()))
				return false;
		return true;
	}

	public void randomizeCube() {
		Random random = new Random();
		int direction;
		int x, y;

		for (int i = 0; i < 100; i++) {
			direction = random.nextInt(6);
			x = random.nextInt(size[0])*50 + csize[0] - size[0]*25;
			y = random.nextInt(size[1])*50 + csize[1] - size[1]*25;

			switch (direction) {
				case 0:
					rotateColumnUp(x, y, true);
					break;
				case 1:
					rotateColumnDown(x, y, true);
					break;
				case 2:
					rotateRowLeft(x, y, true);
					break;
				case 3:
					rotateRowRight(x, y, true);
					break;
				case 4:
					rotateFrontClockwise(true);
					break;
				case 5:
					rotateFrontCounterClockwise(true);
					break;
			}
		}
	}

	public void dispose() {
		for (Observer v : Observer)
			v.dispose();
	}
}