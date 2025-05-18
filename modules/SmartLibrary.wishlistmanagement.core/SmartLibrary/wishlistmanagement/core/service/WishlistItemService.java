package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistItemService {
	WishlistItem createWishlistItem(Map<String, Object> requestBody);
	HashMap<String, Object> getWishlistItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveWishlistItem(Map<String, Object> requestBody);
    HashMap<String, Object> updateWishlistItem(Map<String, Object> requestBody);
    HashMap<String, Object> getWishlistItemById(int id);
    List<HashMap<String,Object>> getAllWishlistItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteWishlistItem(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<WishlistItem> List);
}
