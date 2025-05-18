package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistManagementService {
	WishlistManagement createWishlistManagement(Map<String, Object> requestBody);
	HashMap<String, Object> getWishlistManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveWishlistManagement(Map<String, Object> requestBody);
    HashMap<String, Object> updateWishlistManagement(Map<String, Object> requestBody);
    HashMap<String, Object> getWishlistManagementById(int id);
    List<HashMap<String,Object>> getAllWishlistManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteWishlistManagement(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<WishlistManagement> List);
}
