/*
 * Class that defines a point in 2D
 */

public class Point2D
{
   private int x;
   private int y;

   public Point2D()
   {
      this.x = 0;
      this.y = 0;
   }

   public Point2D(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   int getX()
   {
      return x;
   }

   int getY()
   {
      return y;
   }

   public String toString()
   {
      String val = "(" + x + ", " + y + ")";
      return val; 
   }
}
