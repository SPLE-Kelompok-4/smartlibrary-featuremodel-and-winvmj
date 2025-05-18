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
// import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistItemServiceImpl extends WishlistItemServiceComponent{

    public List<HashMap<String,Object>> saveWishlistItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		WishlistItem wishlistitem = createWishlistItem(requestBody);
		Repository.saveObject(wishlistitem);
		return getAllWishlistItem(requestBody);
	}

	public List<HashMap<String, Object>> saveWishlistItem(Map<String, Object> requestBody) {
		WishlistItem wishlistItem = createWishlistItem(requestBody);
		Repository.saveObject(wishlistItem);
		return getAllWishlistItem(requestBody);
	}

    public WishlistItem createWishlistItem(Map<String, Object> requestBody){
		String wishlistId = (String) requestBody.get("WishlistId");
		String itemId = (String) requestBody.get("itemId");
		String addedAt = (String) requestBody.get("addedAt");
		
		WishlistItem wishlistItem = WishlistItemFactory.createWishlistItem(
			"SmartLibrary.wishlistmanagement.core.WishlistItemImpl",
			wishlistId, itemId, addedAt
		);

		return wishlistItem;
	}

    public HashMap<String, Object> updateWishlistItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("wishlistItemId");
		int id = Integer.parseInt(idStr);
		WishlistItem wishlistItem = Repository.getObject(id);
		
		
		Repository.updateObject(wishlistItem);
		
		return wishlistItem.toHashMap();
		
	}

    public HashMap<String, Object> getWishlistItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("wishlistItemId");
		int id = Integer.parseInt(idStr);
		WishlistItem wishlistItem = Repository.getObject(id);
		return wishlistItem.toHashMap();
	}

	public HashMap<String, Object> getWishlistItemById(int id){
		WishlistItem wishlistItem = Repository.getObject(id);
		return wishlistItem.toHashMap();
	}

    public List<HashMap<String,Object>> getAllWishlistItem(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<WishlistItem> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<WishlistItem> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteWishlistItem(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllWishlistItem(requestBody);
	}

}
