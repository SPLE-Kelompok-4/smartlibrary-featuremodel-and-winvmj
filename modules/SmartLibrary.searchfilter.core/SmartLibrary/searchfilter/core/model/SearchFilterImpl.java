package SmartLibrary.searchfilter.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="searchfilter_impl")
@Table(name="searchfilter_impl")
public class SearchFilterImpl extends SearchFilterComponent {

	public SearchFilterImpl(EBookImpl ebookimpl) {
		this.ebookimpl = ebookimpl;
	}

	public SearchFilterImpl(EBookImpl ebookimpl) {
		this. =  .randomUUID();;
		this.ebookimpl = ebookimpl;
	}

	public SearchFilterImpl() { }


	public EEList apply(EEList EBooks) {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> searchfilterMap = new HashMap<String,Object>();
		searchfilterMap.put("ebookimpl",getEbookimpl());

        return searchfilterMap;
    }

}
