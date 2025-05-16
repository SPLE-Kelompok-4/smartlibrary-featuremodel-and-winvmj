package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistItemImplResource {
    List<HashMap<String,Object>> saveWishlistItemImpl(VMJExchange vmjExchange);
    HashMap<String, Object> updateWishlistItemImpl(VMJExchange vmjExchange);
    HashMap<String, Object> getWishlistItemImpl(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllWishlistItemImpl(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteWishlistItemImpl(VMJExchange vmjExchange);
	HashMap<String, Object> createWishlistItemImpl(VMJExchange vmjExhange);
}
