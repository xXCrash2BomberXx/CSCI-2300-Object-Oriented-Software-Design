package App.Model;

import java.awt.Color;

public class SpriteObject implements Renderable {
	protected Sprite[] sprites = new Sprite[0];
	protected Color[] colors = new Color[0];
	protected Color[] colors2 = new Color[0];
	protected double center_x = 0;
	protected double center_y = 0;
	protected double center_z = 0;
	protected Boolean auto = true;
	public Boolean outer = false;
	public Boolean inner = true;

	public SpriteObject(String obj, double width, double height, double depth) {
		generate(obj, 0, 0, 0, width, height, depth);
	}

	public SpriteObject(String obj, double width, double height, double depth, Color[] colors) {
		generate(obj, 0, 0, 0, width, height, depth);
		this.colors = colors;
	}

	public SpriteObject(String obj, double width, double height, double depth, Color[] colors, Color[] colors2) {
		generate(obj, 0, 0, 0, width, height, depth);
		this.colors = colors;
		outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(String obj, double width, double height, double depth, Boolean inner) {
		generate(obj, 0, 0, 0, width, height, depth);
		this.inner = inner;
	}

	public SpriteObject(String obj, double width, double height, double depth, Boolean inner, Boolean outer) {
		generate(obj, 0, 0, 0, width, height, depth);
		this.inner = inner;
		this.outer = outer;
	}

	public SpriteObject(String obj, double width, double height, double depth, Color[] colors, Boolean outer) {
		generate(obj, 0, 0, 0, width, height, depth);
		this.colors = colors;
		this.outer = outer;
	}

	public SpriteObject(String obj, double width, double height, double depth, Boolean inner, Color[] colors2) {
		generate(obj, 0, 0, 0, width, height, depth);
		this.inner = inner;
		outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth) {
		generate(obj, x, y, z, width, height, depth);
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			Color[] colors) {
		generate(obj, x, y, z, width, height, depth);
		this.colors = colors;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth, 
			Color[] colors, Color[] colors2) {
		generate(obj, x, y, z, width, height, depth);
		this.colors = colors;
		this.outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			Boolean inner) {
		generate(obj, x, y, z, width, height, depth);
		this.inner = inner;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			Boolean inner, Boolean outer) {
		generate(obj, x, y, z, width, height, depth);
		this.inner = inner;
		this.outer = outer;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			Color[] colors, Boolean outer) {
		generate(obj, x, y, z, width, height, depth);
		this.colors = colors;
		this.outer = outer;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			Boolean inner, Color[] colors2) {
		generate(obj, x, y, z, width, height, depth);
		this.inner = inner;
		outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			double x_axis, double y_axis, double z_axis) {
		auto = false;
		center_x = x_axis;
		center_y = y_axis;
		center_z = z_axis;
		generate(obj, x, y, z, width, height, depth);
		for (Sprite sprite : sprites) {
			sprite.setCenter(new double[] { center_x, center_y, center_z });
		}
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			double x_axis, double y_axis, double z_axis, Color[] colors) {
		auto = false;
		center_x = x_axis;
		center_y = y_axis;
		center_z = z_axis;
		generate(obj, x, y, z, width, height, depth);
		for (Sprite sprite : sprites) {
			sprite.setCenter(new double[] { center_x, center_y, center_z });
		}
		this.colors = colors;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			double x_axis, double y_axis, double z_axis, Color[] colors, Color[] colors2) {
		auto = false;
		center_x = x_axis;
		center_y = y_axis;
		center_z = z_axis;
		generate(obj, x, y, z, width, height, depth);
		for (Sprite sprite : sprites) {
			sprite.setCenter(new double[] { center_x, center_y, center_z });
		}
		this.colors = colors;
		this.outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			double x_axis, double y_axis, double z_axis, Boolean inner) {
		auto = false;
		center_x = x_axis;
		center_y = y_axis;
		center_z = z_axis;
		generate(obj, x, y, z, width, height, depth);
		for (Sprite sprite : sprites) {
			sprite.setCenter(new double[] { center_x, center_y, center_z });
		}
		this.inner = inner;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			double x_axis, double y_axis, double z_axis, Boolean inner, Boolean outer) {
		auto = false;
		center_x = x_axis;
		center_y = y_axis;
		center_z = z_axis;
		generate(obj, x, y, z, width, height, depth);
		for (Sprite sprite : sprites) {
			sprite.setCenter(new double[] { center_x, center_y, center_z });
		}
		this.inner = inner;
		this.outer = outer;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			double x_axis, double y_axis, double z_axis, Color[] colors, Boolean outer) {
		auto = false;
		center_x = x_axis;
		center_y = y_axis;
		center_z = z_axis;
		generate(obj, x, y, z, width, height, depth);
		for (Sprite sprite : sprites) {
			sprite.setCenter(new double[] { center_x, center_y, center_z });
		}
		this.colors = colors;
		this.outer = outer;
	}

	public SpriteObject(String obj, double x, double y, double z, double width, double height, double depth,
			double x_axis, double y_axis, double z_axis, Boolean inner, Color[] colors2) {
		auto = false;
		center_x = x_axis;
		center_y = y_axis;
		center_z = z_axis;
		generate(obj, x, y, z, width, height, depth);
		for (Sprite sprite : sprites) {
			sprite.setCenter(new double[] { center_x, center_y, center_z });
		}
		this.inner = inner;
		outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(Sprite[] sprites) {
		this.sprites = sprites;
		autoCenter();
	}

	public SpriteObject(Sprite[] sprites, Color[] colors) {
		this.sprites = sprites;
		autoCenter();
		this.colors = colors;
	}

	public SpriteObject(Sprite[] sprites, Color[] colors, Color[] colors2) {
		this.sprites = sprites;
		autoCenter();
		this.colors = colors;
		outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(Sprite[] sprites, Boolean inner) {
		this.sprites = sprites;
		autoCenter();
		this.inner = inner;
	}

	public SpriteObject(Sprite[] sprites, Boolean inner, Boolean outer) {
		this.sprites = sprites;
		autoCenter();
		this.inner = inner;
		this.outer = outer;
	}

	public SpriteObject(Sprite[] sprites, Color[] colors, Boolean outer) {
		this.sprites = sprites;
		autoCenter();
		this.colors = colors;
		this.outer = outer;
	}

	public SpriteObject(Sprite[] sprites, Boolean inner, Color[] colors2) {
		this.sprites = sprites;
		autoCenter();
		this.inner = inner;
		outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(double[][][] obj) {
		this.sprites = new Sprite[] { new Sprite(obj) };
		autoCenter();
	}

	public SpriteObject(double[][][] obj, Color[] colors) {
		this.sprites = new Sprite[] { new Sprite(obj) };
		autoCenter();
		this.colors = colors;
	}

	public SpriteObject(double[][][] obj, Color[] colors, Color[] colors2) {
		this.sprites = new Sprite[] { new Sprite(obj) };
		autoCenter();
		this.colors = colors;
		outer = true;
		this.colors2 = colors2;
	}

	public SpriteObject(double[][][] obj, Boolean inner) {
		this.sprites = new Sprite[] { new Sprite(obj) };
		autoCenter();
		this.inner = inner;
	}

	public SpriteObject(double[][][] obj, Boolean inner, Boolean outer) {
		this.sprites = new Sprite[] { new Sprite(obj) };
		autoCenter();
		this.inner = inner;
		this.outer = outer;
	}

	public SpriteObject(double[][][] obj, Color[] colors, Boolean outer) {
		this.sprites = new Sprite[] { new Sprite(obj) };
		autoCenter();
		this.colors = colors;
		this.outer = outer;
	}

	public SpriteObject(double[][][] obj, Boolean inner, Color[] colors2) {
		this.sprites = new Sprite[] { new Sprite(obj) };
		autoCenter();
		this.inner = inner;
		outer = true;
		this.colors2 = colors2;
	}

	protected void generate(String obj, double x, double y, double z, double width, double height, double depth) {
		Sprite temp = new Sprite(obj, x, y, z, width, height, depth);
		sprites = new Sprite[temp.getCoords().length];
		for (int i = 0; i < temp.getCoords().length; i++) {
			sprites[i] = new Sprite(new double[][][] { temp.getCoords()[i] });
		}
		colors = new Color[] {
				Color.RED,
				Color.GREEN,
				Color.BLUE,
				Color.YELLOW,
				Color.CYAN,
				Color.MAGENTA,
				Color.BLACK,
				Color.GRAY,
				new Color(127, 0, 0, 255), // Dark Red
				new Color(0, 127, 0, 255), // Dark Green
				new Color(0, 0, 127, 255), // Dark Blue
				new Color(127, 127, 0, 255), // Dark Yellow
				new Color(0, 127, 127, 255), // Dark Cyan
				new Color(127, 0, 127, 255), // Dark Magenta
				new Color(255, 127, 127, 255), // Light Red
				new Color(127, 255, 127, 255), // Light Green
				new Color(127, 127, 255, 255), // Light Blue
				new Color(255, 255, 127, 255), // Light Yellow
				new Color(127, 255, 255, 255), // Light Cyan
				new Color(255, 127, 255, 255) // Light Magenta
		};
		colors2 = new Color[] {
				Color.RED,
				Color.GREEN,
				Color.BLUE,
				Color.YELLOW,
				Color.CYAN,
				Color.MAGENTA,
				Color.BLACK,
				Color.GRAY,
				new Color(127, 0, 0, 255), // Dark Red
				new Color(0, 127, 0, 255), // Dark Green
				new Color(0, 0, 127, 255), // Dark Blue
				new Color(127, 127, 0, 255), // Dark Yellow
				new Color(0, 127, 127, 255), // Dark Cyan
				new Color(127, 0, 127, 255), // Dark Magenta
				new Color(255, 127, 127, 255), // Light Red
				new Color(127, 255, 127, 255), // Light Green
				new Color(127, 127, 255, 255), // Light Blue
				new Color(255, 255, 127, 255), // Light Yellow
				new Color(127, 255, 255, 255), // Light Cyan
				new Color(255, 127, 255, 255) // Light Magenta
		};
		if (auto)
			autoCenter();
	}

	// Degrees
	public void rotate(double theta_x, double theta_y, double theta_z) {
		for (Sprite o : sprites)
			o.rotate(theta_x, theta_y, theta_z);
	}

	// Degrees
	public void irotate(double theta_x, double theta_y, double theta_z) {
		for (Sprite o : sprites)
			o.irotate(theta_x, theta_y, theta_z);
	}

	// Degrees
	public void irotate(double theta_x, double theta_y, double theta_z, Model model) {
		AnimationControl.animateRotateFace(model, sprites, theta_x, theta_y, theta_z);
	}

	public double calcCenterX() {
		double center = 0;
		for (Sprite sprite : sprites)
				center += sprite.calcCenterX();
		return center / sprites.length;
	}

	public double calcCenterY() {
		double center = 0;
		for (Sprite sprite : sprites)
				center += sprite.calcCenterY();
		return center / sprites.length;
	}

	public double calcCenterZ() {
		double center = 0;
		for (Sprite sprite : sprites)
				center += sprite.calcCenterZ();
		return center / sprites.length;
	}

	public double[] calcRotatedCenter() {
		double[] center = new double[] {0, 0, 0};
		int vertices = 0;
		double[] temp;
		for (Sprite sprite : sprites) {
			temp = sprite.calcRotatedCenter();
			center[0] += temp[0];
			center[1] += temp[1];
			center[2] += temp[2];
			vertices++;
		}
		center[0] /= vertices;
		center[1] /= vertices;
		center[2] /= vertices;
		return center;
	}

	public double calcRotatedCenterX() {
		double center = 0;
		for (Sprite sprite : sprites)
				center += sprite.calcRotatedCenterX();
		return center / sprites.length;
	}

	public double calcRotatedCenterY() {
		double center = 0;
		for (Sprite sprite : sprites)
				center += sprite.calcRotatedCenterZ();
		return center / sprites.length;
	}

	public double calcRotatedCenterZ() {
		double center = 0;
		for (Sprite sprite : sprites)
				center += sprite.calcRotatedCenterZ();
		return center / sprites.length;
	}

	public Sprite[] getSprites() {
		return sprites;
	}

	public Color[] getInner() {
		return colors;
	}

	public Color[] getOuter() {
		return colors2;
	}

	public double[] getCenter() {
		return new double[] { center_x, center_y, center_z };
	}

	public double[] getTheta() {
		return sprites[0].getTheta();
	}

	public double[] getIRotated() {
		return sprites[0].getIRotated();
	}

	public double[] calcRotatedRoundedCenter() {
		return sprites[0].calcRotatedRoundedCenter();
	}

	public double[] calcCenter() {
		double[] center = new double[] {0, 0, 0};
		double[] sprite_center;
		int vertices = 0;
		for (Sprite sprite : sprites)
			if (sprite instanceof Sprite) {
				sprite_center = sprite.calcCenter();
				center[0] += sprite_center[0];
				center[1] += sprite_center[1];
				center[2] += sprite_center[2];
				vertices++;
			}
		center[0] /= vertices;
		center[1] /= vertices;
		center[2] /= vertices;
		return center;
	}

	public void setPosition(double x, double y, double z) {
		for (Sprite sprite : sprites)
			sprite.setPosition(x, y, z);
	}

	public void movePosition(double x, double y, double z) {
		for (Sprite sprite : sprites)
			sprite.movePosition(x, y, z);
	}

	public void autoCenter() {
		center_x = 0;
		center_y = 0;
		center_z = 0;
		int vertices = 0;
		for (Sprite sprite : sprites) {
			sprite.autoCenter();
			double[] center = sprite.getCenter();
			center_x += center[0];
			center_y += center[1];
			center_z += center[2];
			vertices++;
		}
		center_x /= vertices;
		center_y /= vertices;
		center_z /= vertices;
		for (Sprite sprite : sprites) {
			sprite.setCenter(new double[] { center_x, center_y, center_z });
		}
	}

	public boolean isSolved(double[] irotated) {
		for (Sprite o : sprites)
			if (!o.isSolved(irotated))
				return false;
		return true;
	}
}
