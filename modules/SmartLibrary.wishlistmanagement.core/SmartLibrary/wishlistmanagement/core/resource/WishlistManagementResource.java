package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistManagementResource {
    List<HashMap<String,Object>> saveWishlistManagement(VMJExchange vmjExchange);
    HashMap<String, Object> updateWishlistManagement(VMJExchange vmjExchange);
    HashMap<String, Object> getWishlistManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllWishlistManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteWishlistManagement(VMJExchange vmjExchange);
	HashMap<String, Object> createWishlistManagement(VMJExchange vmjExhange);
}
