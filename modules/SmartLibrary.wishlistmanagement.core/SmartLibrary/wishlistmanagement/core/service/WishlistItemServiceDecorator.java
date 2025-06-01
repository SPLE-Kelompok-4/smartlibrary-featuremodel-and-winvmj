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

	public HashMap<String, Object> getWishlistItem(Map<String, Object> requestBody){
		return record.getWishlistItem(requestBody);
	}

	public List<HashMap<String,Object>> getAllWishlistItem(Map<String, Object> requestBody){
		return record.getAllWishlistItem(requestBody);
	}

    public HashMap<String, Object> updateWishlistItem(Map<String, Object> requestBody){
		return record.updateWishlistItem(requestBody);
	}

    @Override
    public List<HashMap<String, Object>> transformListToHashMap(List<WishlistItem> items) {
        return record.transformListToHashMap(items);
    }

    public List<HashMap<String,Object>> deleteWishlistItem(Map<String, Object> requestBody){
		return record.deleteWishlistItem(requestBody);
	}

	public HashMap<String, Object> getWishlistItemById(UUID id){
        return record.getWishlistItemById(id);
    }

}
