import java.util.ArrayList;

public class Driver {
   public static int testAdd () {
      Catalog catalog = new Catalog();
      int numErrors = 0;
      boolean status = false;
      Book book = new Book("Introduction to Java", "Kate", "Holdener");
      String bookId = catalog.add(book);
      ArrayList<String> foundBooks = catalog.search("Kate");

      if (foundBooks.size() != 1) {
         System.out.println("Error: search method should have found one book");
         numErrors++;
      }
      return numErrors;
   }
   public static int testCheckoutCheckin () {
    Catalog catalog = new Catalog();
    int numErrors = 0;
    Book book = new Book("Introduction to Java", "Kate", "Holdener");
    catalog.add(book);
    if (catalog.checkin("0")) {
        numErrors++;
        System.out.println("Error: checkin should not checkin an available book");
    }
    if (!catalog.checkout("0")) {
        numErrors++;
        System.out.println("Error: checkout could not checkout available book");
    }
    if (catalog.checkout("0")) {
        numErrors++;
        System.out.println("Error: checkout should not checkout an unavailable book");
    }
    if (!catalog.checkin("0")) {
        numErrors++;
        System.out.println("Error: checkin could not checkin unavailable book");
    }
    if (catalog.checkout("1")) {
        numErrors++;
        System.out.println("Error: checkout should not checkout non-existent book");
    }
    if (catalog.checkin("1")) {
        numErrors++;
        System.out.println("Error: checkin should not checkin non-existent book");
    }
        return numErrors;
    }
    public static int testGetBook () {
        Catalog catalog = new Catalog();
        Book book = new Book("Introduction to Java", "Kate", "Holdener");
        catalog.add(book);
        if (catalog.getBook("0") != book) {
            System.out.println("Error: getBook should return the same instance as was provided to add");
            return 1;
        }
        return 0;
    }
    public static int testRemove () {
        Catalog catalog = new Catalog();
        int numErrors = 0;
        Book book = new Book("Introduction to Java", "Kate", "Holdener");
        catalog.add(book);
        if (catalog.remove("1")) {
            numErrors++;
            System.out.println("Error: remove should not remove a non-existent book");
        }
        if (!catalog.remove("0")) {
            numErrors++;
            System.out.println("Error: remove could not remove a book");
        }
        if (catalog.remove("0")) {
            numErrors++;
            System.out.println("Error: remove should not re-remove a book");
        }
        return numErrors;
    }

   // TODO: MORE STATIC TEST METHODS HERE


   public static void main (String []args) { 
      int numErrors = 0;
      numErrors += testAdd();
      numErrors += testCheckoutCheckin();
      numErrors += testGetBook();
      numErrors += testRemove();

      // TODO: Call more test methods here

      if (numErrors > 0) {
         System.out.println("Fix your errors");
      } else {
         System.out.println("No errors were found");
      }
   }
}
