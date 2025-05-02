package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistItemResourceComponent implements WishlistItemImplResource{
	
	public WishlistItemResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveWishlistItemImpl(VMJExchange vmjExchange);
    public abstract WishlistItemImpl createWishlistItemImpl(VMJExchange vmjExchange);
	public abstract WishlistItemImpl createWishlistItemImpl(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateWishlistItemImpl(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getWishlistItemImpl(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllWishlistItemImpl(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteWishlistItemImpl(VMJExchange vmjExchange);

}
