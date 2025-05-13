package SmartLibrary.searchfilter.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class SearchFilterDecorator extends SearchFilterComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected SearchFilterComponent record;

	public SearchFilterDecorator() {
        super();
    }
    
    public SearchFilterDecorator(SearchFilterComponent record) {
        super();
        this.record = record;
        this.filterId = UUID.randomUUID();
    }
    
    public SearchFilterDecorator(UUID filterId, SearchFilterComponent record) {
        super();
        this.filterId = filterId;
        this.record = record;
    }
    
    public SearchFilterDecorator(SearchFilterComponent record, String objectName) {
        super();
        this.record = record;
        this.filterId = UUID.randomUUID();
        this.objectName = objectName;
    }


	public EEList apply(EEList EBooks) {
		return record.apply(EBooks);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
