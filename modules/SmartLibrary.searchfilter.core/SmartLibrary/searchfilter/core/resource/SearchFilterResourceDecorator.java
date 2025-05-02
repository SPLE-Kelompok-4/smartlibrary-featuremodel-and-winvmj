package SmartLibrary.searchfilter.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class SearchFilterResourceDecorator extends SearchFilterResourceComponent{
	protected SearchFilterResourceComponent record;

    public SearchFilterResourceDecorator(SearchFilterResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveSearchFilter(VMJExchange vmjExchange){
		return record.saveSearchFilter(vmjExchange);
	}

    public SearchFilter createSearchFilter(VMJExchange vmjExchange){
		return record.createSearchFilter(vmjExchange);
	}

    public SearchFilter createSearchFilter(VMJExchange vmjExchange, int id){
		return record.createSearchFilter(vmjExchange, id);
	}

    public HashMap<String, Object> updateSearchFilter(VMJExchange vmjExchange){
		return record.updateSearchFilter(vmjExchange);
	}

    public HashMap<String, Object> getSearchFilter(VMJExchange vmjExchange){
		return record.getSearchFilter(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllSearchFilter(VMJExchange vmjExchange){
		return record.getAllSearchFilter(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteSearchFilter(VMJExchange vmjExchange){
		return record.deleteSearchFilter(vmjExchange);
	}

	public EEList apply(EEList EBooks) {
		return record.apply(EBooks);
	}
}
