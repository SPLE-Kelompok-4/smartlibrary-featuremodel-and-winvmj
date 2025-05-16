package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistItemServiceComponent implements WishlistItemImplService{
	protected RepositoryUtil<WishlistItemImpl> Repository;

    public WishlistItemServiceComponent(){
        this.Repository = new RepositoryUtil<WishlistItemImpl>(SmartLibrary.wishlistmanagement.core.WishlistItemComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveWishlistItemImpl(VMJExchange vmjExchange);
    public abstract WishlistItemImpl createWishlistItemImpl(Map<String, Object> requestBodye);
	public abstract WishlistItemImpl createWishlistItemImpl(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateWishlistItemImpl(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getWishlistItemImpl(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllWishlistItemImpl(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<WishlistItemImpl> List);
    public abstract List<HashMap<String,Object>> deleteWishlistItemImpl(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getWishlistItemImplById(int id);

}
