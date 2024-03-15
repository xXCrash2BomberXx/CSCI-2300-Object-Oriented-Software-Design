import java.util.ArrayList;

public class Driver{
   public static void main(String []args){
      Robot robot = new Robot();
      // make the robot move
      for (int i = 0; i < 10; i++)
      {
         if (i % 2 == 0){
            robot.move(1,1);
         }
         else{
            robot.move(1,-1);
         }
         System.out.println("Current location is " + robot.getCurrentLocation());
      }

      // get and printed the robot's path
      ArrayList<Point2D> path = robot.getVisitedPath();
      String pathString = "";
      for (Point2D point: path){
         pathString+=point.toString();
      }
      System.out.println("Robot visited "+pathString);
   }
}
