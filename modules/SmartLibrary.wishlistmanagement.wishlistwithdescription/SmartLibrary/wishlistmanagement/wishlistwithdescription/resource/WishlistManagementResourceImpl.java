package SmartLibrary.wishlistmanagement.wishlistwithdescription;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.wishlistmanagement.core.WishlistManagementResourceDecorator;
import SmartLibrary.wishlistmanagement.core.WishlistManagementImpl;
import SmartLibrary.wishlistmanagement.core.WishlistManagementResourceComponent;

public class WishlistManagementResourceImpl extends WishlistManagementResourceDecorator {
    public WishlistManagementResourceImpl(WishlistManagementResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/wishlistwithdescription/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        WishlistManagement wishlist = create(vmjExchange);
        Repository.saveObject(wishlist);
        return getAll(vmjExchange);
    }

    public WishlistManagement create(VMJExchange vmjExchange){
        String description = (String) vmjExchange.getRequestBodyForm("Description");
        
        WishlistManagement baseWishlist = record.create(vmjExchange);
        WishlistManagement deco = Factory.create("SmartLibrary.wishlistwithdescription.core.WishlistManagementImpl", baseWishlist, description);
        return deco;
    }

    public WishlistManagement create(VMJExchange vmjExchange, int id){
        String description = (String) vmjExchange.getRequestBodyForm("Description");
        WishlistManagement saved = Repository.getObject(id);
        int recordId = ((Decorator) saved).getRecord().getId();
        
        WishlistManagement baseWishlist = record.create(vmjExchange);
        WishlistManagement deco = Factory.create("SmartLibrary.wishlistwithdescription.core.WishlistManagementImpl", id, baseWishlist, description);
        return deco;
    }

    // @Restriced(permission = "")
    @Route(url="call/wishlistwithdescription/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        String idStr = (String) vmjExchange.getRequestBodyForm("id");
        int id = Integer.parseInt(idStr);
        
        WishlistManagement wishlist = Repository.getObject(id);
        wishlist = create(vmjExchange, id);
        
        Repository.updateObject(wishlist);
        wishlist = Repository.getObject(id);
        //to do: fix association attributes
        
        return wishlist.toHashMap();
    }

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithdescription/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getWishlistManagement(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithdescription/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithdescription/delete")
    public List<HashMap<String,Object>> deleteWishlistManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
