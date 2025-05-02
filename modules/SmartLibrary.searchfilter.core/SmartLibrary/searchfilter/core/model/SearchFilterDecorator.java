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

	public SearchFilterDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public SearchFilterDecorator (SearchFilterComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public SearchFilterDecorator (, SearchFilterComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public SearchFilterDecorator (SearchFilterComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public SearchFilterDecorator() { }


	public EEList apply(EEList EBooks) {
		return record.apply(EBooks);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
