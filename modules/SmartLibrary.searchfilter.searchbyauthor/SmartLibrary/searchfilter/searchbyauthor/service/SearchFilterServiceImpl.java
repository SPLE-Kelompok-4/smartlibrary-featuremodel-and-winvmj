package SmartLibrary.searchfilter.searchbyauthor;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.searchfilter.core.SearchFilterServiceDecorator;
import SmartLibrary.searchfilter.core.SearchFilterImpl;
import SmartLibrary.searchfilter.core.SearchFilterServiceComponent;

public class SearchFilterServiceImpl extends SearchFilterServiceDecorator {
    public SearchFilterServiceImpl (SearchFilterServiceComponent record) {
        super(record);
    }

    
	public EEList search(EEList EBooks, String author) {
		// TODO: implement this method
	}

	public EEList apply(EEList EBooks) {
		// TODO: implement this method
	}
}
