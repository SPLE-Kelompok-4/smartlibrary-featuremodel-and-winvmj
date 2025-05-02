package SmartLibrary.searchfilter.filterbyreleasedate;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.searchfilter.core.SearchFilterDecorator;
import SmartLibrary.searchfilter.core.SearchFilter;
import SmartLibrary.searchfilter.core.SearchFilterComponent;

@Entity(name="searchfilter_filterbyreleasedate")
@Table(name="searchfilter_filterbyreleasedate")
public class SearchFilterImpl extends SearchFilterDecorator {

	protected EDate releaseDateFrom;
	protected EDate releaseDateTo;
	public SearchFilterImpl(
        super();
        this.objectName = SearchFilterImpl.class.getName();
    }
    
    public SearchFilterImpl(EDate releaseDateFrom, EDate releaseDateTo) {
    	super();
		this.releaseDateFrom = releaseDateFrom;
		this.releaseDateTo = releaseDateTo;
		this.objectName = SearchFilterImpl.class.getName();
    }
	
	public SearchFilterImpl(SearchFilterComponent record, EDate releaseDateFrom, EDate releaseDateTo) {
		super(record);
		this.releaseDateFrom = releaseDateFrom;
		this.releaseDateTo = releaseDateTo;
		this.objectName = SearchFilterImpl.class.getName();
	}

	public EDate getReleaseDateFrom() {
		return this.releaseDateFrom;
	}

	public void setReleaseDateFrom(EDate releaseDateFrom) {
		this.releaseDateFrom = releaseDateFrom;
	}
	public EDate getReleaseDateTo() {
		return this.releaseDateTo;
	}

	public void setReleaseDateTo(EDate releaseDateTo) {
		this.releaseDateTo = releaseDateTo;
	}

	public EEList filter(EEList EBooks, EDate releaseDateFrom, EDate releaseDateTo) {
		// TODO: implement this method
	}

	public void apply(EEList EBooks) {
		// TODO: implement this method
	}

}
