public class LibraryItem
{
    protected String title;
    protected int year;

    public LibraryItem(String title, int year)
    {
        this.title = title;
        this.year = year;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getYear()
    {
        return this.year;
    }

    public boolean matches(String searchTerm)
    {
        return this.title.equals(searchTerm);
    }

    public String toString()
    {
       return new String(this.title+", "+this.year);
    }
}
