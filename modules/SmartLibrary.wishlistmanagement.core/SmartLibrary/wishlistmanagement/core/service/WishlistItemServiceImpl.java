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
	private WishlistItemFactory wishlistItemFactory = new WishlistItemFactory();

    public HashMap<String,Object> saveWishlistItem(Map<String, Object> requestBody){
		String itemName = (String) requestBody.get("itemName");
		
		UUID wishlistItemId = UUID.randomUUID();

		WishlistItem wishlistItem = wishlistItemFactory.createWishlistItem(
			"SmartLibrary.wishlistmanagement.core.WishlistItemImpl",
			wishlistItemId, itemName
		);
		wishlistItemRepository.saveObject(wishlistItem);

		return wishlistItem.toHashMap();
	}

    public HashMap<String, Object> updateWishlistItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("wishlistItemId");
		UUID id = UUID.fromString(idStr); 
		WishlistItem wishlistItem = wishlistItemRepository.getObject(id);
		
		if (wishlistItem == null) {
            throw new NoSuchElementException("WishlistItem with ID " + id + " not found for update.");
        }
        
        if (requestBody.containsKey("itemName")) {
            wishlistItem.setItemName((String) requestBody.get("itemName"));
        }
		
		wishlistItemRepository.updateObject(wishlistItem);
		
		return wishlistItem.toHashMap();
		
	}

    public HashMap<String, Object> getWishlistItem(String wishlistItemIdStr){
		UUID id = UUID.fromString(wishlistItemIdStr);
		WishlistItem wishlistItem = wishlistItemRepository.getObject(id);
		if (wishlistItem == null) {
            throw new NotFoundException("WishlistItem with ID " + id + " not found."); // Atau NoSuchElementException
        }
        return wishlistItem.toHashMap();
	}

	public WishlistItem getWishlistItemById(UUID id){
		WishlistItem wishlistItem = wishlistItemRepository.getObject(id);
		if (wishlistItem == null) {
            throw new NotFoundException("WishlistItem with ID " + id + " not found."); // Atau NoSuchElementException
        }
		return wishlistItem;
	}

    public List<HashMap<String,Object>> getAllWishlistItem(){
		List<WishlistItem> List = wishlistItemRepository.getAllObject("wishlistitem_impl");
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
		UUID id = UUID.fromString(idStr);
		wishlistItemRepository.deleteObject(id);
		return getAllWishlistItem();
	}

}
