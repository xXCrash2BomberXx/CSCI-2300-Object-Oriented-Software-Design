

public class ShortFormat implements CatalogItemFormat {
    public String toString(ArrayList<CatalogItem> catalogItems) {
        String retValue = "";
        for (CatalogItem item: catalogItems){
            retValue+=item.getId()+": "+item.getBook().getTitle()+"\n";
        }
        return retValue;
    }
}
