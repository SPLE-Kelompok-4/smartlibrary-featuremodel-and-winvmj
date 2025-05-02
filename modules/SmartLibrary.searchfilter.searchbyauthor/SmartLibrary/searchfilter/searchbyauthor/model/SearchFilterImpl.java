package SmartLibrary.searchfilter.searchbyauthor;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.searchfilter.core.SearchFilterDecorator;
import SmartLibrary.searchfilter.core.SearchFilter;
import SmartLibrary.searchfilter.core.SearchFilterComponent;

@Entity(name="searchfilter_searchbyauthor")
@Table(name="searchfilter_searchbyauthor")
public class SearchFilterImpl extends SearchFilterDecorator {

	protected String author;
	public SearchFilterImpl(
        super();
        this.objectName = SearchFilterImpl.class.getName();
    }
    
    public SearchFilterImpl(String author) {
    	super();
		this.author = author;
		this.objectName = SearchFilterImpl.class.getName();
    }
	
	public SearchFilterImpl(SearchFilterComponent record, String author) {
		super(record);
		this.author = author;
		this.objectName = SearchFilterImpl.class.getName();
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public EEList search(EEList EBooks, String author) {
		// TODO: implement this method
	}

	public EEList apply(EEList EBooks) {
		// TODO: implement this method
	}

}
