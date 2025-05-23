package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.wishlistmanagement.WishlistItemFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistItemResourceImpl extends WishlistItemResourceComponent{
	
	private WishlistItemServiceImpl wishListItemServiceImpl = new WishlistItemServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/save")
    public List<HashMap<String,Object>> saveWishlistItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return wishListItemServiceImpl.saveWishlistItem(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement")
    public HashMap<String,Object> WishlistItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlistItem result = wishListItemServiceImpl.createWishlistItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public HashMap<String, Object> createWishlistItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlistItem result = wishListItemServiceImpl.createWishlistItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public HashMap<String, Object> createWishlistItem(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlistItem result = wishListItemServiceImpl.createWishlistItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/update")
    public HashMap<String, Object> updateWishlistItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return wishListItemServiceImpl.updateWishlistItem(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/detail")
    public HashMap<String, Object> getWishlistItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishListItemServiceImpl.getWishlistItem(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/list")
    public List<HashMap<String,Object>> getAllWishlistItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishListItemServiceImpl.getAllWishlistItem(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/delete")
    public List<HashMap<String,Object>> deleteWishlistItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return wishListItemServiceImpl.deleteWishlistItem(requestBody);
	}

}
