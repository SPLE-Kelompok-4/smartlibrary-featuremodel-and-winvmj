package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.wishlistmanagement.WishlistManagementFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistManagementResourceImpl extends WishlistManagementResourceComponent{
	
	private WishlistManagementServiceImpl wishlistManagementServiceImpl = new WishlistManagementServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/Wishlistmanagement/save")
    public List<HashMap<String,Object>> saveWishlistManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return wishlistManagementServiceImpl.saveWishlistManagement(vmjExchange);
	}


		@Route(url="call/wishlistManagement")
    public HashMap<String,Object> createWishlistManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlistManagement result = wishlistManagementServiceImpl.createWishlistManagement(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public HashMap<String,Object> createWishlistManagement(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlistManagement result = wishlistManagementServiceImpl.createWishlistManagement(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistManagement/update")
    public HashMap<String, Object> updateWishlistManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return wishlistManagementServiceImpl.updateWishlistManagement(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistManagement/detail")
    public HashMap<String, Object> getWishlistManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishlistManagementServiceImpl.getWishlistManagement(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistManagement/list")
    public List<HashMap<String,Object>> getAllWishlistManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishlistManagementServiceImpl.getAllWishlistManagement(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistManagement/delete")
    public List<HashMap<String,Object>> deleteWishlistManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return wishlistManagementServiceImpl.deleteWishlistManagement(requestBody);
	}
}
