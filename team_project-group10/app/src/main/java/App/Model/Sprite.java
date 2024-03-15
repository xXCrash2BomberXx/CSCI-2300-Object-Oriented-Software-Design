package App.Model;

import java.lang.Math;

public class Sprite implements Renderable {
	protected double[][][] coords = new double[1][1][3]; // [faces][lines][coordinates]
	protected double center_x = 0;
	protected double center_y = 0;
	protected double center_z = 0;
	protected double theta_x = 0;
	protected double theta_y = 0;
	protected double theta_z = 0;
	protected double[] irotated = new double[] {0, 0, 0};
	protected Boolean auto = true;

	public static double[][][] cube(double x, double y, double z,
			double width, double height, double depth) {
		return new double[][][] {
				{
						{ x, y, z },
						{ x + width, y, z },
						{ x + width, y + height, z },
						{ x, y + height, z }
				},
				{
						{ x, y, z },
						{ x, y, z + depth },
						{ x, y + height, z + depth },
						{ x, y + height, z }
				},
				{
						{ x, y + height, z },
						{ x, y + height, z + depth },
						{ x + width, y + height, z + depth },
						{ x + width, y + height, z }
				},
				{
						{ x + width, y + height, z },
						{ x + width, y + height, z + depth },
						{ x + width, y, z + depth },
						{ x + width, y, z }
				},
				{
						{ x + width, y, z },
						{ x, y, z },
						{ x, y, z + depth },
						{ x + width, y, z + depth }
				},
				{
						{ x + width, y, z + depth },
						{ x + width, y + height, z + depth },
						{ x, y + height, z + depth },
						{ x, y, z + depth }
				}
		};
	}

	public static double[][][] clone(double[][][] coords) {
		double[][][] coords2 = new double[coords.length][coords[0].length][3];
		for (int i = 0; i < coords.length; i++)
			for (int j = 0; j < coords[i].length; j++) {
				coords2[i][j][0] = coords[i][j][0];
				coords2[i][j][1] = coords[i][j][1];
				coords2[i][j][2] = coords[i][j][2];
			}
		return coords2;
	}

	public Sprite(String obj, double x, double y, double z, double width, double height, double depth) {
		generate(obj, x, y, z, width, height, depth);
	}

	public Sprite(String obj, double x, double y, double z, double width, double height, double depth,
			double x_axis,
			double y_axis, double z_axis) {
		auto = false;
		center_x = x_axis;
		center_y = y_axis;
		center_z = z_axis;
		generate(obj, x, y, z, width, height, depth);
	}

	public Sprite(double[][][] obj) {
		coords = obj;
		autoCenter();
	}

	protected void generate(String obj, double x, double y, double z, double width, double height, double depth) {
		switch (obj) {
			case "cube":
				coords = Sprite.cube(x, y, z, width, height, depth);
				break;
			default:
				System.out.println("Incorrect String Argument");
				break;
		}
		if (auto)
			autoCenter();
	}

	protected static double calcCenterInd(int index, double[][]face) {
		double center = 0;
		int vertices = 0;
		for (double[] point : face)
			if (point instanceof double[]) {
				center += point[index];
				vertices++;
			}
		return center / vertices;
	}

	public static double calcCenterX(double[][] face) {
		return calcCenterInd(0, face);
	}

	public static double calcCenterY(double[][] face) {
		return calcCenterInd(1, face);
	}

	public static double calcCenterZ(double[][] face) {
		return calcCenterInd(2, face);
	}

	protected static double calcCenterInd(int index, double[][][] source) {
		double center = 0;
		int vertices = 0;
		for (double[][] face : source)
			if (face instanceof double[][]) {
				center += calcCenterInd(index, face);
				vertices++;
			}
		return center / vertices;
	}

	protected double calcCenterInd(int index) {
		return calcCenterInd(index, coords);
	}

	public double calcCenterX() {
		return calcCenterInd(0);
	}

	public double calcCenterY() {
		return calcCenterInd(1);
	}

	public double calcCenterZ() {
		return calcCenterInd(2);
	}

	protected double calcRotatedCenterInd(int index) {
		return calcCenterInd(index, getRotated());
	}

	public double calcRotatedCenterX() {
		return calcRotatedCenterInd(0);
	}

	public double calcRotatedCenterY() {
		return calcRotatedCenterInd(1);
	}

	public double calcRotatedCenterZ() {
		return calcRotatedCenterInd(2);
	}

	// Degrees
	public static double[] rotatePoint(double[] vec, double[] theta) {
		return rotatePoint(vec, theta[0], theta[1], theta[2]);
	}

	// Degrees
	public static double[] rotatePoint(double[] vec, double theta_x, double theta_y, double theta_z) {
		double x = vec[0] * Math.cos(theta_z * Math.PI / 180) * Math.cos(theta_y * Math.PI / 180) +
				vec[1] * Math.cos(theta_z * Math.PI / 180) * Math.sin(theta_y * Math.PI / 180)
						* Math.sin(theta_x * Math.PI / 180)
				-
				vec[1] * Math.sin(theta_z * Math.PI / 180) * Math.cos(theta_x * Math.PI / 180) +
				vec[2] * Math.cos(theta_z * Math.PI / 180) * Math.sin(theta_y * Math.PI / 180)
						* Math.cos(theta_x * Math.PI / 180)
				+
				vec[2] * Math.sin(theta_z * Math.PI / 180) * Math.sin(theta_x * Math.PI / 180);
		double y = vec[0] * Math.sin(theta_z * Math.PI / 180) * Math.cos(theta_y * Math.PI / 180) +
				vec[1] * Math.sin(theta_z * Math.PI / 180) * Math.sin(theta_y * Math.PI / 180)
						* Math.sin(theta_x * Math.PI / 180)
				+
				vec[1] * Math.cos(theta_z * Math.PI / 180) * Math.cos(theta_x * Math.PI / 180) +
				vec[2] * Math.sin(theta_z * Math.PI / 180) * Math.sin(theta_y * Math.PI / 180)
						* Math.cos(theta_x * Math.PI / 180)
				-
				vec[2] * Math.cos(theta_z * Math.PI / 180) * Math.sin(theta_x * Math.PI / 180);
		double z = -vec[0] * Math.sin(theta_y * Math.PI / 180) +
				vec[1] * Math.cos(theta_y * Math.PI / 180) * Math.sin(theta_x * Math.PI / 180) +
				vec[2] * Math.cos(theta_y * Math.PI / 180) * Math.cos(theta_x * Math.PI / 180);
		return new double[] { x, y, z };
	}

	protected void increaseFaces() {
		double[][][] coords2 = new double[coords.length * 2][coords.length == 0 ? 1 : coords[0].length][3];
		for (int face = 0; face < coords.length; face++)
			coords2[face] = coords[face];
		coords = coords2;
	}

	protected void increasePoints() {
		double[][][] coords2 = new double[coords.length][coords[0].length * 2][3];
		for (int face = 0; face < coords.length; face++) {
			double[][] face2 = new double[coords[0].length * 2][3];
			for (int point = 0; point < coords[face].length; point++)
				face2[point] = coords[face][point];
			coords2[face] = face2;
		}
		coords = coords2;
	}

	public void setPoint(int face, int index, double[] position) {
		setPoint(face, index, position[0], position[1], position[2]);
	}

	public void setPoint(int face, int index, double x, double y, double z) {
		if (face >= coords.length)
			increaseFaces();
		if (index >= coords[0].length)
			increasePoints();
		coords[face][index][0] = x;
		coords[face][index][1] = y;
		coords[face][index][2] = z;
		if (auto)
			autoCenter();
	}

	public void addPoint(int face, double[] position) {
		addPoint(face, position[0], position[1], position[2]);
	}

	public void addPoint(int face, double x, double y, double z) {
		setPoint(face, (coords.length == 0 || coords.length <= face ? 0 : coords[face].length), x, y, z);
	}

	public void setPosition(double[] position) {
		setPosition(position[0], position[1], position[2]);
	}

	public void setPosition(double x, double y, double z) {
		for (int face = 0; face < coords.length; face++)
			for (int point = 0; point < coords[face].length; point++) {
				coords[face][point][0] += (x - center_x);
				coords[face][point][1] += (y - center_y);
				coords[face][point][2] += (z - center_z);
			}
		center_x = x;
		center_y = y;
		center_z = z;
	}

	public void movePosition(double[] position) {
		movePosition(position[0], position[1], position[2]);
	}

	public void movePosition(double x, double y, double z) {
		for (int face = 0; face < coords.length; face++)
			for (int point = 0; point < coords[face].length; point++) {
				coords[face][point][0] += x;
				coords[face][point][1] += y;
				coords[face][point][2] += z;
			}
		center_x += x;
		center_y += y;
		center_z += z;
	}

	public void autoCenter() {
		center_x = 0;
		center_y = 0;
		center_z = 0;
		int vertices = 0;
		for (double[][] face : coords)
			if (face instanceof double[][])
				for (double[] point : face)
					if (point instanceof double[]) {
						center_x += point[0];
						center_y += point[1];
						center_z += point[2];
						vertices++;
					}
		center_x /= vertices;
		center_y /= vertices;
		center_z /= vertices;
	}

	// Degrees
	public static double[][][] rotate(double[][][] coords, double theta_x, double theta_y, double theta_z) {
		return Sprite.rotate(clone(coords), theta_x, theta_y, theta_z, 0, 0, 0);
	}

	// Degrees
	public static double[][][] rotate(double[][][] coords, double theta_x, double theta_y, double theta_z,
			double center_x, double center_y, double center_z) {
		double[][][] rotated = new double[coords.length][coords[0].length][3];
		for (int face = 0; face < coords.length; face++)
			for (int side = 0; side < coords[face].length; side++) {
				if (coords[face][side] instanceof double[]) {
					coords[face][side][0] -= center_x;
					coords[face][side][1] -= center_y;
					coords[face][side][2] -= center_z;
					rotated[face][side] = rotatePoint(coords[face][side], theta_x, theta_y,
							theta_z);
					coords[face][side][0] += center_x;
					coords[face][side][1] += center_y;
					coords[face][side][2] += center_z;
					rotated[face][side][0] += center_x;
					rotated[face][side][1] += center_y;
					rotated[face][side][2] += center_z;
				}
			}
		return rotated;
	}

	// Degrees
	public static double[] joinRotations(double[] theta1, double[] theta2) {
		double c1 = Math.cos(theta1[0]*Math.PI/180);
		double c2 = Math.cos(theta1[1]*Math.PI/180);
		double c3 = Math.cos(theta1[2]*Math.PI/180);
		double s1 = Math.sin(theta1[0]*Math.PI/180);
		double s2 = Math.sin(theta1[1]*Math.PI/180);
		double s3 = Math.sin(theta1[2]*Math.PI/180);
		double Rx1[][] = {{1, 0, 0}, {0, c1, -s1}, {0, s1, c1}};
		double Ry1[][] = {{c2, 0, s2}, {0, 1, 0}, {-s2, 0, c2}};
		double Rz1[][] = {{c3, -s3, 0}, {s3, c3, 0}, {0, 0, 1}};
		double R1[][] = multiplyMatrices(multiplyMatrices(Rz1, Ry1), Rx1);
		double c4 = Math.cos(theta2[0]*Math.PI/180);
		double c5 = Math.cos(theta2[1]*Math.PI/180);
		double c6 = Math.cos(theta2[2]*Math.PI/180);
		double s4 = Math.sin(theta2[0]*Math.PI/180);
		double s5 = Math.sin(theta2[1]*Math.PI/180);
		double s6 = Math.sin(theta2[2]*Math.PI/180);
		double Rx2[][] = {{1, 0, 0}, {0, c4, -s4}, {0, s4, c4}};
		double Ry2[][] = {{c5, 0, s5}, {0, 1, 0}, {-s5, 0, c5}};
		double Rz2[][] = {{c6, -s6, 0}, {s6, c6, 0}, {0, 0, 1}};
		double R2[][] = multiplyMatrices(multiplyMatrices(Rz2, Ry2), Rx2);
		double R3[][] = multiplyMatrices(R2, R1);
		double theta_x = Math.atan2(R3[2][1], R3[2][2]);
		double theta_y = Math.atan2(-R3[2][0], Math.sqrt(R3[2][1] * R3[2][1] + R3[2][2] * R3[2][2]));
		double theta_z = Math.atan2(R3[1][0], R3[0][0]);

		return new double[] {(theta_x*180/Math.PI + 360) % 360, 
			(theta_y*180/Math.PI + 360) % 360, 
			(theta_z*180/Math.PI + 360) % 360};
	}

	// Radians
	protected static double[][] multiplyMatrices(double[][] A, double[][] B) {
		double[][] C = new double[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				C[i][j] = 0;
				for (int k = 0; k < 3; k++)
					C[i][j] += A[i][k] * B[k][j];
			}
		return C;
	}

	// Degrees
	protected static double distance(double[] theta) {
		return distance(theta[0], theta[1], theta[2]);
	}

	// Degrees
	protected static double distance(double theta) {
		if (theta > 180)
			return Math.abs(theta-360);
		return theta;
	}

	// Degrees
	protected static double distance(double theta_x, double theta_y, double theta_z) {
		theta_x = distance(theta_x);
		theta_y = distance(theta_y);
		theta_z = distance(theta_z);
		return Math.sqrt(theta_x*theta_x+theta_y*theta_y+theta_z*theta_z);
	}

	// Degrees
	public void rotate(double[] theta) {
		rotate(theta[0], theta[1], theta[2]);
	}
	
	// Degrees
	public void rotate(double theta_x, double theta_y, double theta_z) {
		double[] joined = joinRotations(new double[] {this.theta_x, this.theta_y, this.theta_z}, 
						new double[] {(theta_x+360)%360, (theta_y+360)%360, (theta_z+360)%360});

		double dist = distance(joined);
		double[] bestJoined = joined;
		if (dist >= 45) {
			double dist2;
			double[] joined2;
			double[] bestRotation = new double[] {0, 0, 0};
			for (double[] rotation : new double[][] {{90, 0, 0}, {0, 90, 0}, {0, 0, 90}, 
													{270, 0, 0}, {0, 270, 0}, {0, 0, 270}}) {
				joined2 = joinRotations(joined, rotation);
				dist2 = distance(joined2);
				if (dist2 < dist) {
					dist = dist2;
					bestRotation = rotation;
					bestJoined = joined2;
				}
			}
			irotate(bestRotation[0]==0?0:(bestRotation[0]+180)%360, 
					bestRotation[1]==0?0:(bestRotation[1]+180)%360, 
					bestRotation[2]==0?0:(bestRotation[2]+180)%360);
		}

		this.theta_x = bestJoined[0];
		this.theta_y = bestJoined[1];
		this.theta_z = bestJoined[2];
	}

	// Degrees
	public void irotate(double theta_x, double theta_y, double theta_z, Model model) {
		irotate(theta_x, theta_y, theta_z);
	}

	// Degrees
	public void irotate(double[] theta) {
		irotate(theta[0], theta[1], theta[2]);
	}

	// Degrees
	public void irotate(double theta_x, double theta_y, double theta_z) {
		if (theta_x != 0 || theta_y != 0 || theta_z != 0) {
			//irotated = joinRotations(irotated, new double[] {(theta_x+360)%360, (theta_y+360)%360, (theta_z+360)%360});
			irotated[0] = (irotated[0] + theta_x + 360) % 360;
			irotated[1] = (irotated[1] + theta_y + 360) % 360;
			irotated[2] = (irotated[2] + theta_z + 360) % 360;
			coords = Sprite.rotate(coords, theta_x, theta_y, theta_z, center_x, center_y, center_z);
		}
	}

	public double[][][] getCoords() {
		return coords;
	}

	public double[][][] getRotated() {
		return Sprite.rotate(clone(coords), theta_x, theta_y, theta_z, center_x, center_y, center_z);
	}

	public double[] calcRotatedRoundedCenter() {
		return calcRotatedRoundedCenter(90, 90, 90);
	}

	// Degrees
	public double[] calcRotatedRoundedCenter(double[] theta) {
		return calcRotatedRoundedCenter(theta[0], theta[1], theta[2]);
	}

	// Degrees
	public double[] calcRotatedRoundedCenter(double x, double y, double z) {
		double[][][] coords1 = coords;
		double[] center1 = new double[] {center_x, center_y, center_z};
		coords = Sprite.rotate(clone(coords), Math.round(theta_x/x)*x, Math.round(theta_y/y)*y, Math.round(theta_z/z)*z,
		center_x, center_y, center_z);
		autoCenter();
		double[] center2 = new double[] {center_x, center_y, center_z};
		coords = coords1;
		center_x = center1[0];
		center_y = center1[1];
		center_z = center1[2];
		return center2;
	}

	public double[] getTheta() {
		return new double[] { theta_x, theta_y, theta_z };
	}

	public double[] getIRotated() {
		return irotated;
	}

	public double[] getCenter() {
		return new double[] { center_x, center_y, center_z };
	}

	protected double[] calcCenter(double[][][] source) {
		double[] center = new double[] {0, 0, 0};
		int vertices = 0;
		for (double[][] face : source)
			if (face instanceof double[][])
				for (double[] point : face)
					if (point instanceof double[]) {
						center[0] += point[0];
						center[1] += point[1];
						center[2] += point[2];
						vertices++;
					}
		center[0] /= vertices;
		center[1] /= vertices;
		center[2] /= vertices;
		return center;
	}

	public double[] calcCenter() {
		return calcCenter(coords);
	}

	public double[] calcRotatedCenter() {
		return calcCenter(getRotated());
	}

	public void setCenter(double x, double y, double z) {
		setCenter(new double[] {x, y, z});
	}

	public void setCenter(double[] center) {
		center_x = center[0];
		center_y = center[1];
		center_z = center[2];
	}

	public boolean isSolved(double x, double y, double z) {
		return isSolved(new double[] {x, y, z});
	}

	public boolean isSolved(double[] irotated) {
		return this.irotated[0] == irotated[0] && this.irotated[1] == irotated[1] && this.irotated[2] == irotated[2];
	}
}
