import java.util.ArrayList;

public class Catalog {
    private ArrayList<CatalogItem> catalog = new ArrayList<CatalogItem>();
    public String add (Book book) {
        String str = String.valueOf(catalog.size());
        catalog.add(new CatalogItem(book, str, true));
        return str;
    }
    public boolean checkout (String id) {
        int i = Integer.valueOf(id);
        if (i < catalog.size() && catalog.get(i) != null && catalog.get(i).isAvailable()) {
            catalog.get(i).setUnavailable();
            return true;
        }
        return false;
    }
    public boolean checkin (String id) {
        int i = Integer.valueOf(id);
        if (i < catalog.size() && catalog.get(i) != null && !catalog.get(i).isAvailable()) {
            catalog.get(i).setAvailable();
            return true;
        }
        return false;
    }
    public ArrayList<String> search (String searchTerm)  {
        ArrayList<String> ids = new ArrayList<String>();
        for (CatalogItem item : catalog) {
            if (item != null) {
                Book book = item.getBook();
                if (book.getTitle().equals(searchTerm) || book.getAuthorFirstName().equals(searchTerm) || book.getAuthorLastName().equals(searchTerm)) {
                    ids.add(item.getId());
                }
            }
        }
        return ids;
    }
    public Book getBook (String id) {
        return catalog.get(Integer.valueOf(id)).getBook();
    }
    public boolean remove (String id) {
        int i = Integer.valueOf(id);
        if (i < catalog.size() && catalog.get(i) != null) {
            catalog.set(i, null);
            return true;
        }
        return false;
    }
}
