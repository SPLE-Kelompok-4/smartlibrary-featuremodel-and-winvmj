package SmartLibrary.wishlistmanagement.core;
import java.util.*;
import SmartLibrary.wishlistmanagement.core.WishlistManagementImpl;

import vmj.routing.route.VMJExchange;

public abstract class WishlistManagementServiceDecorator extends WishlistManagementServiceComponent{
	protected WishlistManagementServiceComponent record;

    public WishlistManagementServiceDecorator(WishlistManagementServiceComponent record) {
        this.record = record;
    }

	public WishlistManagement createWishlistManagement(Map<String, Object> requestBody){
		return record.createWishlistManagement(requestBody);
	}

	public HashMap<String, Object> getWishlistManagement(Map<String, Object> requestBody){
		return record.getWishlistManagement(requestBody);
	}

	public List<HashMap<String,Object>> getAllWishlistManagement(Map<String, Object> requestBody){
		return record.getAllWishlistManagement(requestBody);
	}

    public List<HashMap<String,Object>> saveWishlistManagement(VMJExchange vmjExchange){
		return record.saveWishlistManagement(vmjExchange);
	}

    public HashMap<String, Object> updateWishlistManagement(Map<String, Object> requestBody){
		return record.updateWishlistManagement(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<WishlistManagement> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteWishlistManagement(Map<String, Object> requestBody){
		return record.deleteWishlistManagement(requestBody);
	}

	public HashMap<String, Object> getWishlistManagementById(int id){
        return record.getWishlistManagementById(id);
    }

	public void addWishlist(WishlistItem wishlistitem) {
		record.addWishlist(wishlistitem);
	}

	public void removeWishlist(UUID itemId) {
		record.removeWishlist(itemId);
	}

	public void getWishlists() {
		record.getWishlists();
	}
}
