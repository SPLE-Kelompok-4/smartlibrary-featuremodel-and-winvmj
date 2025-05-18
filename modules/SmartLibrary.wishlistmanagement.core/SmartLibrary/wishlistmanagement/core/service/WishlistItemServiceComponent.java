package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistItemServiceComponent implements WishlistItemService{
	protected RepositoryUtil<WishlistItem> Repository;

    public WishlistItemServiceComponent(){
        this.Repository = new RepositoryUtil<WishlistItem>(WishlistItem.class);
    }	

    public abstract List<HashMap<String,Object>> saveWishlistItem(VMJExchange vmjExchange);
    public abstract WishlistItem createWishlistItem(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateWishlistItem(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getWishlistItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllWishlistItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<WishlistItem> List);
    public abstract List<HashMap<String,Object>> deleteWishlistItem(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getWishlistItemById(int id);

}
