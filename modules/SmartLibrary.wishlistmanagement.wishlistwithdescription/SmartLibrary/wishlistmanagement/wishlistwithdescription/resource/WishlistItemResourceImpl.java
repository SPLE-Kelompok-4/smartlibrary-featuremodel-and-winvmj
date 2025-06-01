package SmartLibrary.wishlistmanagement.wishlistwithdescription;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import SmartLibrary.wishlistmanagement.core.WishlistItemResourceDecorator;
import SmartLibrary.wishlistmanagement.core.WishlistItemResourceComponent;

public class WishlistItemResourceImpl extends WishlistItemResourceDecorator {
    
    public WishlistItemResourceImpl(WishlistItemResourceComponent record) {
        super(record);
    }

    // @Restricted(permission = "")
    @Route(url="call/wishlistwithdescription/save")
    @Override
    public HashMap<String, Object> saveWishlistItem(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload();
            
            String description = (String) requestBody.get("description");
            
            HashMap<String, Object> result = record.saveWishlistItem(vmjExchange);
            
            if (result != null && description != null) {
                WishlistItemImpl wishlistWithDescription = new WishlistItemImpl(description);
                result.put("description", description);
            }
            
            return result;
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restricted(permission = "")
    @Route(url="call/wishlistwithdescription/update")
    @Override
    public HashMap<String, Object> updateWishlistItem(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        if (vmjExchange.getHttpMethod().equals("PUT")) {
            Map<String, Object> requestBody = vmjExchange.getPayload();
            String description = (String) requestBody.get("description");
            HashMap<String, Object> result = record.updateWishlistItem(vmjExchange);
            
            if (result != null && description != null) {
                result.put("description", description);
            }
            
            return result;
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restricted(permission = "")
    @Route(url="call/wishlistwithdescription/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
        return record.getWishlistItem(vmjExchange);
    }

    // @Restricted(permission = "")
    @Route(url="call/wishlistwithdescription/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
        return record.getAllWishlistItem(vmjExchange);
    }

    // @Restricted(permission = "")
    @Route(url="call/wishlistwithdescription/delete")
    @Override
    public List<HashMap<String,Object>> deleteWishlistItem(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        if (vmjExchange.getHttpMethod().equals("DELETE")) {
            List<HashMap<String,Object>> result = record.deleteWishlistItem(vmjExchange);
            return result;
        }
        throw new NotFoundException("Route tidak ditemukan");
    }
}