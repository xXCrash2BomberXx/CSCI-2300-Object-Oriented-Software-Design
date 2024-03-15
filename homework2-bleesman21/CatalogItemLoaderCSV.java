import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class CatalogItemLoaderCSV
{
    private ArrayList<CatalogItem> catalog = new ArrayList<CatalogItem>();

    public void loadItems(String fileName) throws IOException
    {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine())
        {
            String[] line = scanner.nextLine().split(",");
            if (line.length >= 5)
            {
                switch (line[4])
                {
                    case "book":
                        catalog.add(new CatalogItem(new Book(line[2], Integer.valueOf(line[3]), line[5], line[6], line[7], line[8]), line[0], line[1].equals("1")));
                        break;
                    case "movie":
                        catalog.add(new CatalogItem(new Movie(line[2], Integer.valueOf(line[3]), line[5], line[6], line[7]), line[0], line[1].equals("1")));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public ArrayList<CatalogItem> getItems()
    {
        return catalog;
    }
}
