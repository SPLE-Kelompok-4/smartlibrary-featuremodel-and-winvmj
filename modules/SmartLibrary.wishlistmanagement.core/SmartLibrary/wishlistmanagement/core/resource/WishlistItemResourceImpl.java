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
   	@Route(url="call/wishlistitem/save") 
    @Override 
    public HashMap<String,Object> saveWishlistItem(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload(); 
            HashMap<String,Object> result = wishListItemServiceImpl.saveWishlistItem(requestBody);
            return result;
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

	// @Restriced(permission = "")
    @Route(url="call/wishlistitem/update")
	@Override
    public HashMap<String, Object> updateWishlistItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		if (vmjExchange.getHttpMethod().equals("PUT")) {
            Map<String, Object> requestBody = vmjExchange.getPayload(); 
            return wishListItemServiceImpl.updateWishlistItem(requestBody);
        }
		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistitem/detail")
	@Override
    public HashMap<String, Object> getWishlistItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
            return null;
        }
        if (vmjExchange.getHttpMethod().equals("GET")) { 
            Map<String, Object> requestBody = vmjExchange.getPayload();
            return wishListItemServiceImpl.getWishlistItem(requestBody);
        }
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistitem/list")
    public List<HashMap<String,Object>> getAllWishlistItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
            return null;
        }
        if (vmjExchange.getHttpMethod().equals("GET")) { 
            Map<String, Object> requestBody = vmjExchange.getPayload(); 
            return wishListItemServiceImpl.getAllWishlistItem(requestBody);
        }
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistitem/delete")
    public List<HashMap<String,Object>> deleteWishlistItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        if (vmjExchange.getHttpMethod().equals("DELETE")) { 
            Map<String, Object> requestBody = vmjExchange.getPayload(); 
            return wishListItemServiceImpl.deleteWishlistItem(requestBody);
        }
		throw new NotFoundException("Route tidak ditemukan");
	}

}
