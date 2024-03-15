public class CatalogItem {
    private Book book;
    private String id;
    private boolean availability;
    public CatalogItem(Book book, String id, boolean availability) {
        this.book = book;
        this.id = id;
        this.availability = availability;
    }
    public Book getBook () {
        return book;
    }
    public String getId () {
        return id;
    }
    public boolean isAvailable () {
        return availability;
    }
    public void setAvailable() {
        availability = true;
    }
    public void setUnavailable () {
        availability = false;
    }
}
