package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.wishlistmanagement.WishlistItemFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistItemResourceImpl extends WishlistItemResourceComponent{
	
	private WishlistItemServiceImpl wishlistitemimplServiceImpl = new WishlistItemServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement")
    public HashMap<String,Object> createwishlistitemimpl(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			WishlistItemImpl result = wishlistitemimplServiceImpl.createWishlistItemImpl(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/update")
    public HashMap<String, Object> updateWishlistItemImpl(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return wishlistitemimplServiceImpl.updateWishlistItemImpl(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/detail")
    public HashMap<String, Object> getWishlistItemImpl(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishlistitemimplServiceImpl.getWishlistItemImpl(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/list")
    public List<HashMap<String,Object>> getAllWishlistItemImpl(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishlistitemimplServiceImpl.getAllWishlistItemImpl(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/wishlistmanagement/delete")
    public List<HashMap<String,Object>> deleteWishlistItemImpl(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return wishlistitemimplServiceImpl.deleteWishlistItemImpl(requestBody);
	}

}
