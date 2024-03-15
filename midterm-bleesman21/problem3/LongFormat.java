import java.util.ArrayList;

public class LongFormat implements CatalogItemFormat {
    public String toString(ArrayList<CatalogItem> catalogItems) {
        String retValue = "";
        for (CatalogItem item: catalogItems){
           retValue+=item.getId()+": "+item.getBook().toString()+"\n";
        }
        return retValue;
    }
}
