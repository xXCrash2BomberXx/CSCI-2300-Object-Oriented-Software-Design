import java.util.ArrayList;

public class Robot {
    private Point2D position;
    private ArrayList<Point2D> previous;
    Robot () {
        position = new Point2D(0, 0);
        previous = new ArrayList<Point2D>();
        previous.add(new Point2D(0, 0));
    }
    public void move(int distanceX, int distanceY) {
        position.setXValue(position.getXValue()+distanceX);
        position.setYValue(position.getYValue()+distanceY);
        previous.add(new Point2D(position.getXValue(), position.getYValue()));
        return;
    }
    public Point2D getCurrentLocation() {
        return position;
    }
    public ArrayList<Point2D> getVisitedPath() {
        return previous;
    }
}
