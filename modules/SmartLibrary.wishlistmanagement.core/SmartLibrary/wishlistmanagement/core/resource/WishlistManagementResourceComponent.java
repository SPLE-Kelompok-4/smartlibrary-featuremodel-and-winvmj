package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistManagementResourceComponent implements WishlistManagementResource{
	
	public WishlistManagementResourceComponent() { }
 
	public abstract List<HashMap<String,Object>> saveWishlistManagement(VMJExchange vmjExchange);
  	public abstract HashMap<String,Object> createWishlistManagement(VMJExchange vmjExchange);
	public abstract HashMap<String,Object> createWishlistManagement(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateWishlistManagement(VMJExchange vmjExchange);
  	public abstract HashMap<String, Object> getWishlistManagement(VMJExchange vmjExchange);
  	public abstract List<HashMap<String,Object>> getAllWishlistManagement(VMJExchange vmjExchange);
  	public abstract List<HashMap<String,Object>> deleteWishlistManagement(VMJExchange vmjExchange);
}
