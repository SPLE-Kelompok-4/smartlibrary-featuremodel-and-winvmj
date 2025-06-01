package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.wishlistmanagement.WishlistItemFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistItemResourceImpl extends WishlistItemResourceComponent{
	
	private WishlistItemService wishlistItemService = new WishlistItemServiceImpl();

	// @Restriced(permission = "")
   	@Route(url="call/wishlistitem/save") 
    @Override 
    public HashMap<String,Object> saveWishlistItem(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload(); 
            return wishlistItemService.saveWishlistItem(requestBody);
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
            return wishlistItemService.updateWishlistItem(requestBody);
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
             String id = vmjExchange.getGETParam("wishlistItemId");
            return wishlistItemService.getWishlistItem(id);
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
            return wishlistItemService.getAllWishlistItem();
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
            return wishlistItemService.deleteWishlistItem(requestBody);
        }
		throw new NotFoundException("Route tidak ditemukan");
	}

}
