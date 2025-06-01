package SmartLibrary.wishlistmanagement.core;

import SmartLibrary.wishlistmanagement.core.WishlistManagement;
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
import SmartLibrary.wishlistmanagement.WishlistManagementFactory;
// import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistManagementServiceImpl extends WishlistManagementServiceComponent{

    public List<HashMap<String,Object>> saveWishlistManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		WishlistManagement wishlistManagement = createWishlistManagement(requestBody);
		Repository.saveObject(wishlistManagement);
		return getAllWishlistManagement(requestBody);
	}

    public List<HashMap<String,Object>> saveWishlistManagement(Map<String, Object> requestBody){
		WishlistManagement wishlistManagement = createWishlistManagement(requestBody);
		Repository.saveObject(wishlistManagement);
		return getAllWishlistManagement(requestBody);
	}

    public WishlistManagement createWishlistManagement(Map<String, Object> requestBody){
		String wishlistId = (String) requestBody.get("wishlistId");
		String name = (String) requestBody.get("name");
		String createdAt = (String) requestBody.get("createdAt");
		String updateAt = (String) requestBody.get("updateAt");

		WishlistItemImpl wishListItemImpl = null;

		WishlistManagement Wishlistmanagement = WishlistManagementFactory.createWishlistManagement(
			"SmartLibrary.Wishlistmanagement.core.WishlistManagementImpl",
			wishlistId, name, createdAt, wishListItemImpl, updateAt
		);
		return Wishlistmanagement;
	}

    public WishlistManagement createWishlistManagement(Map<String, Object> requestBody, int id){
		return null;
	}

    public HashMap<String, Object> updateWishlistManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("wishlistId");
		int id = Integer.parseInt(idStr);
		WishlistManagement wishlistManagement = Repository.getObject(id);
		
		wishlistManagement.setName((String) requestBody.get("name"));
		
		Repository.updateObject(wishlistManagement);
		
		//to do: fix association attributes
		
		return wishlistManagement.toHashMap();
		
	}

    public HashMap<String, Object> getWishlistManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("WishlistId");
		int id = Integer.parseInt(idStr);
		WishlistManagement wishlistManagement = Repository.getObject(id);
		return wishlistManagement.toHashMap();
	}

	public HashMap<String, Object> getWishlistManagementById(int id){
		WishlistManagement wishlistManagement = Repository.getObject(id);
		return wishlistManagement.toHashMap();
	}

    public List<HashMap<String,Object>> getAllWishlistManagement(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<WishlistManagement> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<WishlistManagement> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteWishlistManagement(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllWishlistManagement(requestBody);
	}

	public void addWishlist(WishlistItem  wishlistItem) {
		// TODO: implement this method
	}

	public void removeWishlist(UUID itemId) {
		// TODO: implement this method
	}

	public void getWishlists() {
		// TODO: implement this method
	}
}
