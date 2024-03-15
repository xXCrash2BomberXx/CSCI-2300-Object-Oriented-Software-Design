public class Point2D
{
   private int x;
   private int y;

   public Point2D(){
      this.x = 0;
      this.y = 0;
   }

   public Point2D(int x, int y){
      this.x = x;
      this.y = y;
   }

   public void setXValue(int x){
      this.x = x;
   }
   public void setYValue(int y){
      this.y = y;
   }
   public int getXValue(){
      return this.x;
   }
   public int getYValue(){
      return this.y;
   }

   public String toString(){
      String retValue = "(" + this.x + "," + this.y + ")";
      return retValue;
   }
}
