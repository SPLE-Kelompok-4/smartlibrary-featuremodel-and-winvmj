package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistManagementServiceComponent implements WishlishManagementService{
	protected RepositoryUtil<WishlishManagement> Repository;

    public WishlistManagementServiceComponent(){
        this.Repository = new RepositoryUtil<WishlishManagement>(SmartLibrary.wishlistmanagement.core.WishlistManagementComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveWishlishManagement(VMJExchange vmjExchange);
    public abstract WishlishManagement createWishlishManagement(Map<String, Object> requestBodye);
	public abstract WishlishManagement createWishlishManagement(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateWishlishManagement(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getWishlishManagement(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllWishlishManagement(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<WishlishManagement> List);
    public abstract List<HashMap<String,Object>> deleteWishlishManagement(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getWishlishManagementById(int id);

	public abstract void addItem(Item );

	public abstract void removeItem(UUID itemId);

	public abstract void getItems();
}
