package SmartLibrary.searchfilter.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SearchFilterService {
	SearchFilter createSearchFilter(Map<String, Object> requestBody);
	SearchFilter createSearchFilter(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getSearchFilter(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveSearchFilter(Map<String, Object> requestBody);
    HashMap<String, Object> updateSearchFilter(Map<String, Object> requestBody);
    HashMap<String, Object> getSearchFilterById(int id);
    List<HashMap<String,Object>> getAllSearchFilter(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteSearchFilter(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
