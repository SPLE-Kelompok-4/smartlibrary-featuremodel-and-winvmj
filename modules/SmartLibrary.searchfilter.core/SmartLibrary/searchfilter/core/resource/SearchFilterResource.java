package SmartLibrary.searchfilter.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SearchFilterResource {
    List<HashMap<String,Object>> saveSearchFilter(VMJExchange vmjExchange);
    HashMap<String, Object> updateSearchFilter(VMJExchange vmjExchange);
    HashMap<String, Object> getSearchFilter(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSearchFilter(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteSearchFilter(VMJExchange vmjExchange);
	HashMap<String, Object> SearchFilter(VMJExchange vmjExhange);
}
