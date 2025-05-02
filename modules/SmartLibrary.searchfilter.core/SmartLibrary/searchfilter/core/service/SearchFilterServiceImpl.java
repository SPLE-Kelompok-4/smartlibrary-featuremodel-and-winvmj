package SmartLibrary.searchfilter.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.searchfilter.SearchFilterFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class SearchFilterServiceImpl extends SearchFilterServiceComponent{

    public List<HashMap<String,Object>> saveSearchFilter(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SearchFilter searchfilter = createSearchFilter(vmjExchange);
		searchfilterRepository.saveObject(searchfilter);
		return getAllSearchFilter(vmjExchange);
	}

    public SearchFilter createSearchFilter(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		SearchFilter SearchFilter = SearchFilterFactory.createSearchFilter(
			"SmartLibrary.searchfilter.core.SearchFilterImpl",
		ebookimpl
		);
		Repository.saveObject(searchfilter);
		return searchfilter;
	}

    public SearchFilter createSearchFilter(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		SearchFilter searchfilter = SearchFilterFactory.createSearchFilter("SmartLibrary.searchfilter.core.SearchFilterImpl", ebookimpl);
		return searchfilter;
	}

    public HashMap<String, Object> updateSearchFilter(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		SearchFilter searchfilter = Repository.getObject(id);
		
		
		Repository.updateObject(searchfilter);
		
		//to do: fix association attributes
		
		return searchfilter.toHashMap();
		
	}

    public HashMap<String, Object> getSearchFilter(Map<String, Object> requestBody){
		List<HashMap<String, Object>> searchfilterList = getAllSearchFilter("searchfilter_impl");
		for (HashMap<String, Object> searchfilter : searchfilterList){
			int record_id = ((Double) searchfilter.get("record_id")).intValue();
			if (record_id == id){
				return searchfilter;
			}
		}
		return null;
	}

	public HashMap<String, Object> getSearchFilterById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		SearchFilter searchfilter = searchfilterRepository.getObject(id);
		return searchfilter.toHashMap();
	}

    public List<HashMap<String,Object>> getAllSearchFilter(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<SearchFilter> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<SearchFilter> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteSearchFilter(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllSearchFilter(requestBody);
	}

	public EEList apply(EEList EBooks) {
		// TODO: implement this method
	}
}
