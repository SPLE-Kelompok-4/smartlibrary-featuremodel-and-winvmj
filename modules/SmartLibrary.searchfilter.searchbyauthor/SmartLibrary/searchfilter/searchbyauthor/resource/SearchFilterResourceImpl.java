package SmartLibrary.searchfilter.searchbyauthor;
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
    @Route(url="call/searchbyauthor/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SearchFilterSearchByAuthor searchfiltersearchbyauthor = createSearchFilterSearchByAuthor(vmjExchange);
		searchfiltersearchbyauthorRepository.saveObject(searchfiltersearchbyauthor);
		return getAllSearchFilterSearchByAuthor(vmjExchange);
	}

    public SearchFilter createSearchFilterSearchByAuthor(VMJExchange vmjExchange){
		String author = (String) vmjExchange.getRequestBodyForm("author");
		
		SearchFilterSearchByAuthor searchfiltersearchbyauthor = record.createSearchFilterSearchByAuthor(vmjExchange);
		SearchFilterSearchByAuthor searchfiltersearchbyauthordeco = SearchFilterSearchByAuthorFactory.createSearchFilterSearchByAuthor("SmartLibrary.searchbyauthor.core.SearchFilterImpl", searchfiltersearchbyauthor, ebookimpl
		author
		);
			return searchfiltersearchbyauthordeco;
	}


    public SearchFilter createSearchFilterSearchByAuthor(VMJExchange vmjExchange, int id){
		String author = (String) vmjExchange.getRequestBodyForm("author");
		SearchFilterSearchByAuthor searchfiltersearchbyauthor = searchfiltersearchbyauthorRepository.getObject(id);
		int recordSearchFilterSearchByAuthorId = (((SearchFilterSearchByAuthorDecorator) savedSearchFilterSearchByAuthor.getRecord()).getId();
		
		SearchFilterSearchByAuthor searchfiltersearchbyauthor = record.createSearchFilterSearchByAuthor(vmjExchange);
		SearchFilterSearchByAuthor searchfiltersearchbyauthordeco = SearchFilterSearchByAuthorFactory.createSearchFilterSearchByAuthor("SmartLibrary.searchbyauthor.core.SearchFilterImpl", id, searchfiltersearchbyauthor, ebookimpl
		author
		);
			return searchfiltersearchbyauthordeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/searchbyauthor/update")
    public HashMap<String, Object> updateSearchFilterSearchByAuthor(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		SearchFilterSearchByAuthor searchfiltersearchbyauthor = searchfiltersearchbyauthorRepository.getObject(id);
		searchfiltersearchbyauthor = createSearchFilterSearchByAuthor(vmjExchange, id);
		
		searchfiltersearchbyauthorRepository.updateObject(searchfiltersearchbyauthor);
		searchfiltersearchbyauthor = searchfiltersearchbyauthorRepository.getObject(id);
		//to do: fix association attributes
		
		return searchfiltersearchbyauthor.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/searchbyauthor/detail")
    public HashMap<String, Object> getSearchFilterSearchByAuthor(VMJExchange vmjExchange){
		return record.getSearchFilterSearchByAuthor(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/searchbyauthor/list")
    public List<HashMap<String,Object>> getAllSearchFilterSearchByAuthor(VMJExchange vmjExchange){
		List<SearchFilterSearchByAuthor> searchfiltersearchbyauthorList = searchfiltersearchbyauthorRepository.getAllObject("searchfiltersearchbyauthor_impl");
		return transformSearchFilterSearchByAuthorListToHashMap(searchfiltersearchbyauthorList);
	}

    public List<HashMap<String,Object>> transformSearchFilterSearchByAuthorListToHashMap(List<SearchFilterSearchByAuthor> SearchFilterSearchByAuthorList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < SearchFilterSearchByAuthorList.size(); i++) {
            resultList.add(SearchFilterSearchByAuthorList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/searchbyauthor/delete")
    public List<HashMap<String,Object>> deleteSearchFilterSearchByAuthor(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		searchfiltersearchbyauthorRepository.deleteObject(id);
		return getAllSearchFilterSearchByAuthor(vmjExchange);
	}

	public EEList search(EEList EBooks, String author) {
		// TODO: implement this method
	}

	public EEList apply(EEList EBooks) {
		// TODO: implement this method
	}
	
}
