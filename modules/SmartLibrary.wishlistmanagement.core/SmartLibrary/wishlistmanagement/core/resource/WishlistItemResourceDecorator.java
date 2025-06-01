package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class WishlistItemResourceDecorator extends WishlistItemResourceComponent{
	protected WishlistItemResourceComponent record;

    public WishlistItemResourceDecorator(WishlistItemResourceComponent record) {
        this.record = record;
    }

    public HashMap<String, Object> saveWishlistItem(VMJExchange vmjExchange){
		return record.saveWishlistItem(vmjExchange);
	}

    public HashMap<String, Object> updateWishlistItem(VMJExchange vmjExchange){
		return record.updateWishlistItem(vmjExchange);
	}

    public HashMap<String, Object> getWishlistItem(VMJExchange vmjExchange){
		return record.getWishlistItem(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllWishlistItem(VMJExchange vmjExchange){
		return record.getAllWishlistItem(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteWishlistItem(VMJExchange vmjExchange){
		return record.deleteWishlistItem(vmjExchange);
	}

}
