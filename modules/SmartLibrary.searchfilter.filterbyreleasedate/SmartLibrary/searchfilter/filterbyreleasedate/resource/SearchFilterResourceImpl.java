package SmartLibrary.searchfilter.filterbyreleasedate;
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
    @Route(url="call/filterbyreleasedate/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SearchFilterFilterByReleaseDate searchfilterfilterbyreleasedate = createSearchFilterFilterByReleaseDate(vmjExchange);
		searchfilterfilterbyreleasedateRepository.saveObject(searchfilterfilterbyreleasedate);
		return getAllSearchFilterFilterByReleaseDate(vmjExchange);
	}

    public SearchFilter createSearchFilterFilterByReleaseDate(VMJExchange vmjExchange){
		
		SearchFilterFilterByReleaseDate searchfilterfilterbyreleasedate = record.createSearchFilterFilterByReleaseDate(vmjExchange);
		SearchFilterFilterByReleaseDate searchfilterfilterbyreleasedatedeco = SearchFilterFilterByReleaseDateFactory.createSearchFilterFilterByReleaseDate("SmartLibrary.filterbyreleasedate.core.SearchFilterImpl", searchfilterfilterbyreleasedate, ebookimpl
		releaseDateFrom, releaseDateTo
		);
			return searchfilterfilterbyreleasedatedeco;
	}


    public SearchFilter createSearchFilterFilterByReleaseDate(VMJExchange vmjExchange, int id){
		SearchFilterFilterByReleaseDate searchfilterfilterbyreleasedate = searchfilterfilterbyreleasedateRepository.getObject(id);
		int recordSearchFilterFilterByReleaseDateId = (((SearchFilterFilterByReleaseDateDecorator) savedSearchFilterFilterByReleaseDate.getRecord()).getId();
		
		SearchFilterFilterByReleaseDate searchfilterfilterbyreleasedate = record.createSearchFilterFilterByReleaseDate(vmjExchange);
		SearchFilterFilterByReleaseDate searchfilterfilterbyreleasedatedeco = SearchFilterFilterByReleaseDateFactory.createSearchFilterFilterByReleaseDate("SmartLibrary.filterbyreleasedate.core.SearchFilterImpl", id, searchfilterfilterbyreleasedate, ebookimpl
		releaseDateFrom, releaseDateTo
		);
			return searchfilterfilterbyreleasedatedeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/filterbyreleasedate/update")
    public HashMap<String, Object> updateSearchFilterFilterByReleaseDate(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		SearchFilterFilterByReleaseDate searchfilterfilterbyreleasedate = searchfilterfilterbyreleasedateRepository.getObject(id);
		searchfilterfilterbyreleasedate = createSearchFilterFilterByReleaseDate(vmjExchange, id);
		
		searchfilterfilterbyreleasedateRepository.updateObject(searchfilterfilterbyreleasedate);
		searchfilterfilterbyreleasedate = searchfilterfilterbyreleasedateRepository.getObject(id);
		//to do: fix association attributes
		
		return searchfilterfilterbyreleasedate.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/filterbyreleasedate/detail")
    public HashMap<String, Object> getSearchFilterFilterByReleaseDate(VMJExchange vmjExchange){
		return record.getSearchFilterFilterByReleaseDate(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/filterbyreleasedate/list")
    public List<HashMap<String,Object>> getAllSearchFilterFilterByReleaseDate(VMJExchange vmjExchange){
		List<SearchFilterFilterByReleaseDate> searchfilterfilterbyreleasedateList = searchfilterfilterbyreleasedateRepository.getAllObject("searchfilterfilterbyreleasedate_impl");
		return transformSearchFilterFilterByReleaseDateListToHashMap(searchfilterfilterbyreleasedateList);
	}

    public List<HashMap<String,Object>> transformSearchFilterFilterByReleaseDateListToHashMap(List<SearchFilterFilterByReleaseDate> SearchFilterFilterByReleaseDateList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < SearchFilterFilterByReleaseDateList.size(); i++) {
            resultList.add(SearchFilterFilterByReleaseDateList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/filterbyreleasedate/delete")
    public List<HashMap<String,Object>> deleteSearchFilterFilterByReleaseDate(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		searchfilterfilterbyreleasedateRepository.deleteObject(id);
		return getAllSearchFilterFilterByReleaseDate(vmjExchange);
	}

	public EEList filter(EEList EBooks, EDate releaseDateFrom, EDate releaseDateTo) {
		// TODO: implement this method
	}

	public void apply(EEList EBooks) {
		// TODO: implement this method
	}
	
}
