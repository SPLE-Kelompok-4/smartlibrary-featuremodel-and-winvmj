package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistItemService {
    HashMap<String,Object> saveWishlistItem(Map<String, Object> requestBody);
    HashMap<String, Object> updateWishlistItem(Map<String, Object> requestBody);
	HashMap<String, Object> getWishlistItem(String wishlistItemId);
    WishlistItem getWishlistItemById(UUID wishlistItemId);
    List<HashMap<String,Object>> getAllWishlistItem();
    List<HashMap<String,Object>> deleteWishlistItem(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<WishlistItem> wishlistItemList);
}
