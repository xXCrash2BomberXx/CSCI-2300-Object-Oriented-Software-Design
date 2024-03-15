public class Movie extends LibraryItem
{
    private String firstName;
    private String lastName;
    private String rating;

    public Movie(String title, int year, String firstName, String lastName, String rating)
    {
        super(title, year);
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getRating()
    {
        return this.rating;
    }

    public boolean matches(String searchTerm)
    {
       return (super.matches(searchTerm) || this.firstName.matches(searchTerm) ||
          this.lastName.matches(searchTerm) || this.rating.matches(searchTerm));
    }

    public String toString()
    {
       return new String(super.toString()+" "+this.firstName+", "+this.lastName+", "+this.rating);
    }
}
