package SmartLibrary.searchfilter.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.searchfilter.SearchFilterFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class SearchFilterResourceImpl extends SearchFilterResourceComponent{
	
	private SearchFilterServiceImpl searchfilterServiceImpl = new SearchFilterServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/searchfilter/save")
    public List<HashMap<String,Object>> saveSearchFilter(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SearchFilter searchfilter = createSearchFilter(vmjExchange);
		searchfilterRepository.saveObject(searchfilter);
		return getAllSearchFilter(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/searchfilter")
    public HashMap<String,Object> searchfilter(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SearchFilter result = searchfilterServiceImpl.createSearchFilter(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public SearchFilter createSearchFilter(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SearchFilter result = searchfilterServiceImpl.createSearchFilter(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public SearchFilter createSearchFilter(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SearchFilter result = searchfilterServiceImpl.createSearchFilter(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/searchfilter/update")
    public HashMap<String, Object> updateSearchFilter(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return searchfilterServiceImpl.updateSearchFilter(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/searchfilter/detail")
    public HashMap<String, Object> getSearchFilter(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return searchfilterServiceImpl.getSearchFilter(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/searchfilter/list")
    public List<HashMap<String,Object>> getAllSearchFilter(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return searchfilterServiceImpl.getAllSearchFilter(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/searchfilter/delete")
    public List<HashMap<String,Object>> deleteSearchFilter(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return searchfilterServiceImpl.deleteSearchFilter(requestBody);
	}


	
	public EEList apply(EEList EBooks) {
		// TODO: implement this method
	}
}
