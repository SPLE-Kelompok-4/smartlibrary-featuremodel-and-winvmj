package SmartLibrary.wishlistmanagement.core;
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
import SmartLibrary.wishlistmanagement.WishlistItemFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistItemServiceImpl extends WishlistItemServiceComponent{

    public List<HashMap<String,Object>> saveWishlistItemImpl(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		WishlistItemImpl wishlistitemimpl = createWishlistItemImpl(vmjExchange);
		wishlistitemimplRepository.saveObject(wishlistitemimpl);
		return getAllWishlistItemImpl(vmjExchange);
	}

    public WishlistItemImpl createWishlistItemImpl(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		WishlistItemImpl WishlistItemImpl = WishlistItemImplFactory.createWishlistItemImpl(
			"SmartLibrary.wishlistmanagement.core.WishlistItemImpl",
		wishlistItemId
		, wishlistId
		, itemId
		, addedItem
		);
		Repository.saveObject(wishlistitemimpl);
		return wishlistitemimpl;
	}

    public WishlistItemImpl createWishlistItemImpl(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		WishlistItemImpl wishlistitemimpl = WishlistItemImplFactory.createWishlistItemImpl("SmartLibrary.wishlistmanagement.core.WishlistItemImpl", wishlistItemId, wishlistId, itemId, addedItem);
		return wishlistitemimpl;
	}

    public HashMap<String, Object> updateWishlistItemImpl(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("wishlistItemIdwishlistIditemId");
		int id = Integer.parseInt(idStr);
		WishlistItemImpl wishlistitemimpl = Repository.getObject(id);
		
		
		Repository.updateObject(wishlistitemimpl);
		
		//to do: fix association attributes
		
		return wishlistitemimpl.toHashMap();
		
	}

    public HashMap<String, Object> getWishlistItemImpl(Map<String, Object> requestBody){
		List<HashMap<String, Object>> wishlistitemimplList = getAllWishlistItemImpl("wishlistitemimpl_impl");
		for (HashMap<String, Object> wishlistitemimpl : wishlistitemimplList){
			int record_id = ((Double) wishlistitemimpl.get("record_id")).intValue();
			if (record_id == id){
				return wishlistitemimpl;
			}
		}
		return null;
	}

	public HashMap<String, Object> getWishlistItemImplById(int id){
		String idStr = vmjExchange.getGETParam("wishlistItemIdwishlistIditemId"); 
		int id = Integer.parseInt(idStr);
		WishlistItemImpl wishlistitemimpl = wishlistitemimplRepository.getObject(id);
		return wishlistitemimpl.toHashMap();
	}

    public List<HashMap<String,Object>> getAllWishlistItemImpl(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<WishlistItemImpl> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<WishlistItemImpl> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteWishlistItemImpl(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllWishlistItemImpl(requestBody);
	}

}
