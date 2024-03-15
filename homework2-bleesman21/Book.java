public class Book extends LibraryItem
{
   private String firstName;
   private String lastName;
   private String isbn;
   private String publisher;

   public Book(String title, int year, String firstName, String lastName, String publisher, String isbn)
   {
      super(title, year);
      this.firstName = firstName;
      this.lastName = lastName;
      this.publisher = publisher;
      this.isbn = isbn;
   }

   public String getAuthorFirstName()
   {
      return this.firstName;
   }

   public String getAuthorLastName()
   {
      return this.lastName;
   }

   public String getISBN()
   {
      return this.isbn;
   }

   public String getPublisher()
   {
      return this.publisher;
   }

   public String toString()
   {
      return new String(super.toString()+" "+this.firstName+", "+this.lastName+", "+this.publisher+", "+this.isbn);
   }

   public boolean matches(String searchTerm)
   {
      return (super.matches(searchTerm) || this.firstName.matches(searchTerm) ||
         this.lastName.matches(searchTerm) || this.publisher.matches(searchTerm) ||
         this.isbn.matches(searchTerm));
   }
}
