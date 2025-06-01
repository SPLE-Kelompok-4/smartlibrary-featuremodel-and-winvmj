package SmartLibrary.wishlistmanagement.wishlistwithdescription;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.wishlistmanagement.core.WishlistItemServiceDecorator;
import SmartLibrary.wishlistmanagement.core.WishlistItemImpl;
import SmartLibrary.wishlistmanagement.core.WishlistItemServiceComponent;

public class WishlistItemServiceImpl extends WishlistItemServiceDecorator {
    public WishlistItemServiceImpl (WishlistItemServiceComponent record) {
        super(record);
    }

    
}
