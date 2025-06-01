package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistItemServiceComponent implements WishlistItemService{
	protected RepositoryUtil<WishlistItem> wishlistItemRepository;

    public WishlistItemServiceComponent(){
        this.wishlistItemRepository = new RepositoryUtil<WishlistItem>(SmartLibrary.wishlistmanagement.core.WishlistItemComponent.class);
    }   	

    
    public abstract HashMap<String, Object> saveWishlistItem(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> updateWishlistItem(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getWishlistItem(String wishlistItemId);
    public abstract WishlistItem getWishlistItemById(UUID wishlistItemId);
    public abstract List<HashMap<String,Object>> getAllWishlistItem();
    public abstract List<HashMap<String,Object>> deleteWishlistItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<WishlistItem> List);

}
