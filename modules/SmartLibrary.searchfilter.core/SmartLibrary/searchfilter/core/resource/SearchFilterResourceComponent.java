package SmartLibrary.searchfilter.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SearchFilterResourceComponent implements SearchFilterResource{
	
	public SearchFilterResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveSearchFilter(VMJExchange vmjExchange);
    public abstract SearchFilter createSearchFilter(VMJExchange vmjExchange);
	public abstract SearchFilter createSearchFilter(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateSearchFilter(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getSearchFilter(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllSearchFilter(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteSearchFilter(VMJExchange vmjExchange);

	public abstract EEList apply(EEList EBooks);
}
