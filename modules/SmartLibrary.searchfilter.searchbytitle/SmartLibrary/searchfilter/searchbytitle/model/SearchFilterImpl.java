package SmartLibrary.searchfilter.searchbytitle;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.searchfilter.core.SearchFilterDecorator;
import SmartLibrary.searchfilter.core.SearchFilter;
import SmartLibrary.searchfilter.core.SearchFilterComponent;

@Entity(name="searchfilter_searchbytitle")
@Table(name="searchfilter_searchbytitle")
public class SearchFilterImpl extends SearchFilterDecorator {

	protected String title;
	public SearchFilterImpl(
        super();
        this.objectName = SearchFilterImpl.class.getName();
    }
    
    public SearchFilterImpl(String title) {
    	super();
		this.title = title;
		this.objectName = SearchFilterImpl.class.getName();
    }
	
	public SearchFilterImpl(SearchFilterComponent record, String title) {
		super(record);
		this.title = title;
		this.objectName = SearchFilterImpl.class.getName();
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public EEList search(EEList EBooks, String title) {
		// TODO: implement this method
	}

	public EEList apply(EEList EBooks) {
		// TODO: implement this method
	}

}
