package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class WishlistManagementResourceDecorator extends WishlistManagementResourceComponent{
	protected WishlistManagementResourceComponent record;

    public List<HashMap<String,Object>> saveWishlistManagement(VMJExchange vmjExchange){
		return record.saveWishlistManagement(vmjExchange);
	}

    public HashMap<String,Object> createWishlistManagement(VMJExchange vmjExchange){
		return record.createWishlistManagement(vmjExchange);
	}

    public HashMap<String,Object> createWishlistManagement(VMJExchange vmjExchange, int id){
		return record.createWishlistManagement(vmjExchange, id);
	}

    public HashMap<String, Object> updateWishlistManagement(VMJExchange vmjExchange){
		return record.updateWishlistManagement(vmjExchange);
	}

    public HashMap<String, Object> getWishlistManagement(VMJExchange vmjExchange){
		return record.getWishlistManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllWishlistManagement(VMJExchange vmjExchange){
		return record.getAllWishlistManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteWishlistManagement(VMJExchange vmjExchange){
		return record.deleteWishlistManagement(vmjExchange);
	}

	public void addWishlist(WishlistItem wishlistItem) {
		 record.addWishlist(wishlistItem);
	}

	public void removeWishlist(UUID itemId) {
		 record.removeWishlist(itemId);
	}

	public void getWishlists() {
		 record.getWishlists();
	}
}
