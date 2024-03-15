import java.io.IOException;
import java.util.ArrayList;

public class Driver
{
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            CatalogItemLoaderCSV loader = new CatalogItemLoaderCSV();
            loader.loadItems(args[0]);
            ArrayList<CatalogItem> items = loader.getItems();
            Catalog catalog = new Catalog(items);
            ArrayList<String> search = catalog.search("Mike");
            for (String item: search)
            {
                System.out.println(catalog.getLibraryItem(item));
            }
        }
        else
        {
            System.out.println("Usage: java Driver <CSV FILE>Submitting Your Assignment");
        }
    }
}
