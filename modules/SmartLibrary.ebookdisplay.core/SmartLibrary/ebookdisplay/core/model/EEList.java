package SmartLibrary.ebookdisplay.core;

import java.util.*;

/**
 * EEList (E-Book Entry List) is a simple list of E-Book entries.
 */
public class EEList extends ArrayList<String> {
    
    public EEList() {
        super();
    }
    
    public EEList(Collection<String> books) {
        super(books);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
