package SmartLibrary.searchfilter.filterbycategory;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.searchfilter.core.SearchFilterDecorator;
import SmartLibrary.searchfilter.core.SearchFilter;
import SmartLibrary.searchfilter.core.SearchFilterComponent;

@Entity(name="searchfilter_filterbycategory")
@Table(name="searchfilter_filterbycategory")
public class SearchFilterImpl extends SearchFilterDecorator {

	protected String category;
	public SearchFilterImpl(
        super();
        this.objectName = SearchFilterImpl.class.getName();
    }
    
    public SearchFilterImpl(String category) {
    	super();
		this.category = category;
		this.objectName = SearchFilterImpl.class.getName();
    }
	
	public SearchFilterImpl(SearchFilterComponent record, String category) {
		super(record);
		this.category = category;
		this.objectName = SearchFilterImpl.class.getName();
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void apply(EEList EBooks) {
		// TODO: implement this method
	}

	public EEList filter(EEList EBooks, String category) {
		// TODO: implement this method
	}

}
