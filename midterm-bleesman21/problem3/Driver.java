public class Driver
{
   public static void main(String []args){
      Catalog catalog = new Catalog();
      catalog.add(new Book("Intro to OOP", "Alan", "Turing"));
      catalog.add(new Book("Hello world", "csci", "2300"));
      catalog.add(new Book("Are we ther yet?", "Nicholas", "Holdener"));

      // printing the catalog using non-verbose format
      System.out.println(catalog);

      // setting the print format to be verbose
      catalog.setPrintFormat(new LongFormat());

      // printing the catalog using verbose format
      System.out.println(catalog);
   }
}
