public class Circle2D {
    private Point2D center = new Point2D(0, 0);
    private double radius = 1d;
    public Circle2D () {}
    public Circle2D (Point2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    public String toString () {
        return "Circle with radius "+radius+" centered at "+center.toString();
    }
}
