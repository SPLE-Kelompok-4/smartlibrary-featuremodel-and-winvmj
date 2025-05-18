package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistManagementServiceComponent implements WishlistManagementService{
	protected RepositoryUtil<WishlistManagement> Repository;

    public WishlistManagementServiceComponent(){
        this.Repository = new RepositoryUtil<WishlistManagement>(SmartLibrary.wishlistmanagement.core.WishlistManagementComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveWishlistManagement(VMJExchange vmjExchange);
    public abstract WishlistManagement createWishlistManagement(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateWishlistManagement(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getWishlistManagement(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllWishlistManagement(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<WishlistManagement> List);
    public abstract List<HashMap<String,Object>> deleteWishlistManagement(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getWishlistManagementById(int id);

	public abstract void addWishlist(WishlistItem item);

	public abstract void removeWishlist(UUID itemId);

	public abstract void getWishlists();
}
