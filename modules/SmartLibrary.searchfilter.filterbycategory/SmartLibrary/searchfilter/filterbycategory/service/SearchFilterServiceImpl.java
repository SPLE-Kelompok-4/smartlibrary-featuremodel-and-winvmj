package SmartLibrary.searchfilter.filterbycategory;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.searchfilter.core.SearchFilterServiceDecorator;
import SmartLibrary.searchfilter.core.SearchFilterImpl;
import SmartLibrary.searchfilter.core.SearchFilterServiceComponent;

public class SearchFilterServiceImpl extends SearchFilterServiceDecorator {
    public SearchFilterServiceImpl (SearchFilterServiceComponent record) {
        super(record);
    }

    
	public void apply(EEList EBooks) {
		// TODO: implement this method
	}

	public EEList filter(EEList EBooks, String category) {
		// TODO: implement this method
	}
}
