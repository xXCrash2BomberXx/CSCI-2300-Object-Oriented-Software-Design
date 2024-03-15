public class Book {
    private String title;
    private String firstName;
    private String lastName;
    public Book (String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getTitle () {
        return title;
    }
    public String getAuthorFirstName () {
        return firstName;
    }
    public String getAuthorLastName () {
        return lastName;
    }
    public String toString () {
        return title+", "+lastName+", "+firstName;
    }
}
