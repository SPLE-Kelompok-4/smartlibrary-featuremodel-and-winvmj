package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class WishlistManagementResourceComponent implements WishlishManagementResource{
	
	public WishlistManagementResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveWishlishManagement(VMJExchange vmjExchange);
    public abstract WishlishManagement createWishlishManagement(VMJExchange vmjExchange);
	public abstract WishlishManagement createWishlishManagement(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateWishlishManagement(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getWishlishManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllWishlishManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteWishlishManagement(VMJExchange vmjExchange);

	public abstract void addItem(Item );

	public abstract void removeItem(UUID itemId);

	public abstract void getItems();
}
