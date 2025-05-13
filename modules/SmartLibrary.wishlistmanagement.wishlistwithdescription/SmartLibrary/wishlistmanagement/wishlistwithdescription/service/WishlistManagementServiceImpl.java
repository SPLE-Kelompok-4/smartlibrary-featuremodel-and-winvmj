package SmartLibrary.wishlistmanagement.wishlistwithdescription;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.wishlistmanagement.core.WishlistManagementServiceDecorator;
import SmartLibrary.wishlistmanagement.core.WishlistManagementImpl;
import SmartLibrary.wishlistmanagement.core.WishlistManagementServiceComponent;

public class WishlistManagementServiceImpl extends WishlistManagementServiceDecorator {
    public WishlistManagementServiceImpl (WishlistManagementServiceComponent record) {
        super(record);
    }

    
}
