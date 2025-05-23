package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistItemResourceComponent implements WishlistItemResource{
	
	public WishlistItemResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveWishlistItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> createWishlistItem(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> createWishlistItem(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateWishlistItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getWishlistItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllWishlistItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteWishlistItem(VMJExchange vmjExchange);

}
