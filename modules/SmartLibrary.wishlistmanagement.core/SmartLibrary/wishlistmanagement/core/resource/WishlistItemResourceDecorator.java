package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class WishlistItemResourceDecorator extends WishlistItemResourceComponent{
	protected WishlistItemResourceComponent record;

    public WishlistItemResourceDecorator(WishlistItemResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveWishlistItemImpl(VMJExchange vmjExchange){
		return record.saveWishlistItemImpl(vmjExchange);
	}

    public WishlistItemImpl createWishlistItemImpl(VMJExchange vmjExchange){
		return record.createWishlistItemImpl(vmjExchange);
	}

    public WishlistItemImpl createWishlistItemImpl(VMJExchange vmjExchange, int id){
		return record.createWishlistItemImpl(vmjExchange, id);
	}

    public HashMap<String, Object> updateWishlistItemImpl(VMJExchange vmjExchange){
		return record.updateWishlistItemImpl(vmjExchange);
	}

    public HashMap<String, Object> getWishlistItemImpl(VMJExchange vmjExchange){
		return record.getWishlistItemImpl(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllWishlistItemImpl(VMJExchange vmjExchange){
		return record.getAllWishlistItemImpl(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteWishlistItemImpl(VMJExchange vmjExchange){
		return record.deleteWishlistItemImpl(vmjExchange);
	}

}
