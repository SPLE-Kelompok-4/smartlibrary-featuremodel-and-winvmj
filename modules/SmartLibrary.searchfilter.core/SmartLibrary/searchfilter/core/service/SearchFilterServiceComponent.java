package SmartLibrary.searchfilter.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SearchFilterServiceComponent implements SearchFilterService{
	protected RepositoryUtil<SearchFilter> Repository;

    public SearchFilterServiceComponent(){
        this.Repository = new RepositoryUtil<SearchFilter>(SmartLibrary.searchfilter.core.SearchFilterComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveSearchFilter(VMJExchange vmjExchange);
    public abstract SearchFilter createSearchFilter(Map<String, Object> requestBodye);
	public abstract SearchFilter createSearchFilter(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateSearchFilter(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getSearchFilter(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllSearchFilter(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<SearchFilter> List);
    public abstract List<HashMap<String,Object>> deleteSearchFilter(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getSearchFilterById(int id);

	public abstract EEList apply(EEList EBooks);
}
