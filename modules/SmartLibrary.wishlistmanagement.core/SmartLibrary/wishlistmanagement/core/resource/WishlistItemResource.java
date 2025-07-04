package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistItemResource {
    HashMap<String,Object> saveWishlistItem(VMJExchange vmjExchange);
    HashMap<String, Object> updateWishlistItem(VMJExchange vmjExchange);
    HashMap<String, Object> getWishlistItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllWishlistItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteWishlistItem(VMJExchange vmjExchange);
}
