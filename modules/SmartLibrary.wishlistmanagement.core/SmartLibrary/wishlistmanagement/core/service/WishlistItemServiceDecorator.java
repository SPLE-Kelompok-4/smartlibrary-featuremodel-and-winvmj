package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class WishlistItemServiceDecorator extends WishlistItemServiceComponent{
	protected WishlistItemServiceComponent record;

    public WishlistItemServiceDecorator(WishlistItemServiceComponent record) {
        this.record = record;
    }

	public WishlistItemImpl createWishlistItemImpl(Map<String, Object> requestBody){
		return record.createWishlistItemImpl(requestBody);
	}

    public WishlistItemImpl createWishlistItemImpl(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createWishlistItemImpl(requestBody, response);
	}

	public HashMap<String, Object> getWishlistItemImpl(Map<String, Object> requestBody){
		return record.getWishlistItemImpl(requestBody);
	}

	public List<HashMap<String,Object>> getAllWishlistItemImpl(Map<String, Object> requestBody){
		return record.getAllWishlistItemImpl(requestBody);
	}

    public List<HashMap<String,Object>> saveWishlistItemImpl(VMJExchange vmjExchange){
		return record.saveWishlistItemImpl(vmjExchange);
	}

    public HashMap<String, Object> updateWishlistItemImpl(Map<String, Object> requestBody){
		return record.updateWishlistItemImpl(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<WishlistItemImpl> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteWishlistItemImpl(Map<String, Object> requestBody){
		return record.deleteWishlistItemImpl(requestBody);
	}

	public HashMap<String, Object> getWishlistItemImplById(int id){
        return record.getWishlistItemImplById(id);
    }

}
