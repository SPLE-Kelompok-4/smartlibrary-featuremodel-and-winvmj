package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistItemResourceComponent implements WishlistItemResource{
	
	protected RepositoryUtil<WishlistItem> wishlistItemRepository;
	
	public WishlistItemResourceComponent() {
        this.wishlistItemRepository = new RepositoryUtil<WishlistItem>(SmartLibrary.wishlistmanagement.core.WishlistItemComponent.class);
    }
 
    public abstract HashMap<String, Object> saveWishlistItem(VMJExchange vmjExchange);   
	public abstract HashMap<String, Object> updateWishlistItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getWishlistItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllWishlistItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteWishlistItem(VMJExchange vmjExchange);

}
