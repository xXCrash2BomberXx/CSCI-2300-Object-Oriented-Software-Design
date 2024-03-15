public class CatalogItem
{
   private Book    book;
   private String  uniqueId;
   private boolean available;

   public CatalogItem(Book book, String id, boolean availability)
   {
      this.book = book;
      this.uniqueId = id;
      this.available = availability;
   }

   public Book getBook()
   {
      return this.book;
   }

   public String getId()
   {
      return this.uniqueId;
   }

   public boolean isAvailable()
   {
      return this.available;
   }

   public void setAvailable()
   {
      this.available = true;
   }

   public void setUnavailable()
   {
      this.available = false;
   }
}
