package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class WishlistItemServiceDecorator extends WishlistItemServiceComponent{
	protected WishlistItemServiceComponent record;

    public WishlistItemServiceDecorator(WishlistItemServiceComponent record) {
        this.record = record;
    }

	public HashMap<String, Object> saveWishlistItem(Map<String, Object> requestBody){
		return record.saveWishlistItem(requestBody);
	}

	public HashMap<String, Object> updateWishlistItem(Map<String, Object> requestBody){
		return record.updateWishlistItem(requestBody);
	}

	public HashMap<String, Object> getWishlistItem(String wishlistItemIdStr){
		return record.getWishlistItem(wishlistItemIdStr);
	}

	public WishlistItem getWishlistItemById(UUID wishlistItemId){
        return record.getWishlistItemById(wishlistItemId);
    }

	public List<HashMap<String,Object>> getAllWishlistItem(){
		return record.getAllWishlistItem();
	}
	
	public List<HashMap<String,Object>> deleteWishlistItem(Map<String, Object> requestBody){
		return record.deleteWishlistItem(requestBody);
	}

    public List<HashMap<String, Object>> transformListToHashMap(List<WishlistItem> wishlistItemsList) {
        return record.transformListToHashMap(wishlistItemsList);
    }


}
