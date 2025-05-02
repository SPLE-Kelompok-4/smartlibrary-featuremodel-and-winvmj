package SmartLibrary.searchfilter.filterbycategory;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.searchfilter.core.SearchFilterResourceDecorator;
import SmartLibrary.searchfilter.core.SearchFilterImpl;
import SmartLibrary.searchfilter.core.SearchFilterResourceComponent;

public class SearchFilterResourceImpl extends SearchFilterResourceDecorator {
    public SearchFilterResourceImpl (SearchFilterResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/filterbycategory/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SearchFilterFilterByCategory searchfilterfilterbycategory = createSearchFilterFilterByCategory(vmjExchange);
		searchfilterfilterbycategoryRepository.saveObject(searchfilterfilterbycategory);
		return getAllSearchFilterFilterByCategory(vmjExchange);
	}

    public SearchFilter createSearchFilterFilterByCategory(VMJExchange vmjExchange){
		String category = (String) vmjExchange.getRequestBodyForm("category");
		
		SearchFilterFilterByCategory searchfilterfilterbycategory = record.createSearchFilterFilterByCategory(vmjExchange);
		SearchFilterFilterByCategory searchfilterfilterbycategorydeco = SearchFilterFilterByCategoryFactory.createSearchFilterFilterByCategory("SmartLibrary.filterbycategory.core.SearchFilterImpl", searchfilterfilterbycategory, ebookimpl
		category
		);
			return searchfilterfilterbycategorydeco;
	}


    public SearchFilter createSearchFilterFilterByCategory(VMJExchange vmjExchange, int id){
		String category = (String) vmjExchange.getRequestBodyForm("category");
		SearchFilterFilterByCategory searchfilterfilterbycategory = searchfilterfilterbycategoryRepository.getObject(id);
		int recordSearchFilterFilterByCategoryId = (((SearchFilterFilterByCategoryDecorator) savedSearchFilterFilterByCategory.getRecord()).getId();
		
		SearchFilterFilterByCategory searchfilterfilterbycategory = record.createSearchFilterFilterByCategory(vmjExchange);
		SearchFilterFilterByCategory searchfilterfilterbycategorydeco = SearchFilterFilterByCategoryFactory.createSearchFilterFilterByCategory("SmartLibrary.filterbycategory.core.SearchFilterImpl", id, searchfilterfilterbycategory, ebookimpl
		category
		);
			return searchfilterfilterbycategorydeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/filterbycategory/update")
    public HashMap<String, Object> updateSearchFilterFilterByCategory(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		SearchFilterFilterByCategory searchfilterfilterbycategory = searchfilterfilterbycategoryRepository.getObject(id);
		searchfilterfilterbycategory = createSearchFilterFilterByCategory(vmjExchange, id);
		
		searchfilterfilterbycategoryRepository.updateObject(searchfilterfilterbycategory);
		searchfilterfilterbycategory = searchfilterfilterbycategoryRepository.getObject(id);
		//to do: fix association attributes
		
		return searchfilterfilterbycategory.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/filterbycategory/detail")
    public HashMap<String, Object> getSearchFilterFilterByCategory(VMJExchange vmjExchange){
		return record.getSearchFilterFilterByCategory(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/filterbycategory/list")
    public List<HashMap<String,Object>> getAllSearchFilterFilterByCategory(VMJExchange vmjExchange){
		List<SearchFilterFilterByCategory> searchfilterfilterbycategoryList = searchfilterfilterbycategoryRepository.getAllObject("searchfilterfilterbycategory_impl");
		return transformSearchFilterFilterByCategoryListToHashMap(searchfilterfilterbycategoryList);
	}

    public List<HashMap<String,Object>> transformSearchFilterFilterByCategoryListToHashMap(List<SearchFilterFilterByCategory> SearchFilterFilterByCategoryList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < SearchFilterFilterByCategoryList.size(); i++) {
            resultList.add(SearchFilterFilterByCategoryList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/filterbycategory/delete")
    public List<HashMap<String,Object>> deleteSearchFilterFilterByCategory(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		searchfilterfilterbycategoryRepository.deleteObject(id);
		return getAllSearchFilterFilterByCategory(vmjExchange);
	}

	public void apply(EEList EBooks) {
		// TODO: implement this method
	}

	public EEList filter(EEList EBooks, String category) {
		// TODO: implement this method
	}
	
}
