package SmartLibrary.searchfilter.searchbytitle;
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
    @Route(url="call/searchbytitle/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SearchFilterSearchByTitle searchfiltersearchbytitle = createSearchFilterSearchByTitle(vmjExchange);
		searchfiltersearchbytitleRepository.saveObject(searchfiltersearchbytitle);
		return getAllSearchFilterSearchByTitle(vmjExchange);
	}

    public SearchFilter createSearchFilterSearchByTitle(VMJExchange vmjExchange){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		
		SearchFilterSearchByTitle searchfiltersearchbytitle = record.createSearchFilterSearchByTitle(vmjExchange);
		SearchFilterSearchByTitle searchfiltersearchbytitledeco = SearchFilterSearchByTitleFactory.createSearchFilterSearchByTitle("SmartLibrary.searchbytitle.core.SearchFilterImpl", searchfiltersearchbytitle, ebookimpl
		title
		);
			return searchfiltersearchbytitledeco;
	}


    public SearchFilter createSearchFilterSearchByTitle(VMJExchange vmjExchange, int id){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		SearchFilterSearchByTitle searchfiltersearchbytitle = searchfiltersearchbytitleRepository.getObject(id);
		int recordSearchFilterSearchByTitleId = (((SearchFilterSearchByTitleDecorator) savedSearchFilterSearchByTitle.getRecord()).getId();
		
		SearchFilterSearchByTitle searchfiltersearchbytitle = record.createSearchFilterSearchByTitle(vmjExchange);
		SearchFilterSearchByTitle searchfiltersearchbytitledeco = SearchFilterSearchByTitleFactory.createSearchFilterSearchByTitle("SmartLibrary.searchbytitle.core.SearchFilterImpl", id, searchfiltersearchbytitle, ebookimpl
		title
		);
			return searchfiltersearchbytitledeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/searchbytitle/update")
    public HashMap<String, Object> updateSearchFilterSearchByTitle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		SearchFilterSearchByTitle searchfiltersearchbytitle = searchfiltersearchbytitleRepository.getObject(id);
		searchfiltersearchbytitle = createSearchFilterSearchByTitle(vmjExchange, id);
		
		searchfiltersearchbytitleRepository.updateObject(searchfiltersearchbytitle);
		searchfiltersearchbytitle = searchfiltersearchbytitleRepository.getObject(id);
		//to do: fix association attributes
		
		return searchfiltersearchbytitle.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/searchbytitle/detail")
    public HashMap<String, Object> getSearchFilterSearchByTitle(VMJExchange vmjExchange){
		return record.getSearchFilterSearchByTitle(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/searchbytitle/list")
    public List<HashMap<String,Object>> getAllSearchFilterSearchByTitle(VMJExchange vmjExchange){
		List<SearchFilterSearchByTitle> searchfiltersearchbytitleList = searchfiltersearchbytitleRepository.getAllObject("searchfiltersearchbytitle_impl");
		return transformSearchFilterSearchByTitleListToHashMap(searchfiltersearchbytitleList);
	}

    public List<HashMap<String,Object>> transformSearchFilterSearchByTitleListToHashMap(List<SearchFilterSearchByTitle> SearchFilterSearchByTitleList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < SearchFilterSearchByTitleList.size(); i++) {
            resultList.add(SearchFilterSearchByTitleList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/searchbytitle/delete")
    public List<HashMap<String,Object>> deleteSearchFilterSearchByTitle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		searchfiltersearchbytitleRepository.deleteObject(id);
		return getAllSearchFilterSearchByTitle(vmjExchange);
	}

	public EEList search(EEList EBooks, String title) {
		// TODO: implement this method
	}

	public EEList apply(EEList EBooks) {
		// TODO: implement this method
	}
	
}
