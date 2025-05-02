package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.wishlistmanagement.WishlistManagementFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class WishlistManagementResourceImpl extends WishlistManagementResourceComponent{
	
	private WishlistManagementServiceImpl wishlishmanagementServiceImpl = new WishlistManagementServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/save")
    public List<HashMap<String,Object>> saveWishlishManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		WishlishManagement wishlishmanagement = createWishlishManagement(vmjExchange);
		wishlishmanagementRepository.saveObject(wishlishmanagement);
		return getAllWishlishManagement(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement")
    public HashMap<String,Object> wishlishmanagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlishManagement result = wishlishmanagementServiceImpl.createWishlishManagement(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public WishlishManagement createWishlishManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlishManagement result = wishlishmanagementServiceImpl.createWishlishManagement(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public WishlishManagement createWishlishManagement(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlishManagement result = wishlishmanagementServiceImpl.createWishlishManagement(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/update")
    public HashMap<String, Object> updateWishlishManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return wishlishmanagementServiceImpl.updateWishlishManagement(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/detail")
    public HashMap<String, Object> getWishlishManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishlishmanagementServiceImpl.getWishlishManagement(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/list")
    public List<HashMap<String,Object>> getAllWishlishManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishlishmanagementServiceImpl.getAllWishlishManagement(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/delete")
    public List<HashMap<String,Object>> deleteWishlishManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return wishlishmanagementServiceImpl.deleteWishlishManagement(requestBody);
	}


	
	public void addItem(Item ) {
		// TODO: implement this method
	}

	
	public void removeItem(UUID itemId) {
		// TODO: implement this method
	}

	
	public void getItems() {
		// TODO: implement this method
	}
}
