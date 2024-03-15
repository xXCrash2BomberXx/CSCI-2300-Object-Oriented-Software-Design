public class Book
{
   private String title;
   private String firstName;
   private String lastName;

   public Book(String title, String firstName, String lastName)
   {
      this.title = title;
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public String getTitle()
   {
      return this.title;
   }

   public String getAuthorFirstName()
   {
      return this.firstName;
   }

   public String getAuthorLastName()
   {
      return this.lastName;
   }

   public String toString()
   {
      return new String(this.title+", "+this.firstName+", "+this.lastName);
   }
}
