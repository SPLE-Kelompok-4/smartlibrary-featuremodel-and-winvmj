package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistItemImplService {
	WishlistItemImpl createWishlistItemImpl(Map<String, Object> requestBody);
	WishlistItemImpl createWishlistItemImpl(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getWishlistItemImpl(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveWishlistItemImpl(Map<String, Object> requestBody);
    HashMap<String, Object> updateWishlistItemImpl(Map<String, Object> requestBody);
    HashMap<String, Object> getWishlistItemImplById(int id);
    List<HashMap<String,Object>> getAllWishlistItemImpl(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteWishlistItemImpl(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
