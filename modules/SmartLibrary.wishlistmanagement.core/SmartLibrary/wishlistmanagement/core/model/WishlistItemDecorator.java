package SmartLibrary.wishlistmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class WishlistItemDecorator extends WishlistItemComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected WishlistItemComponent record;

	public WishlistItemDecorator() {
        super();
    }
    
    public WishlistItemDecorator(WishlistItemComponent record) {
        super();
        this.record = record;
        this.wishlistItemId = UUID.randomUUID();
    }

    public WishlistItemDecorator(UUID wishlistItemId, UUID wishlistId, UUID itemId, WishlistItemComponent record) {
        super();
        this.wishlistItemId = wishlistItemId;
        this.wishlistId = wishlistId;
        this.itemId = itemId;
        this.record = record;
    }
    
    public WishlistItemDecorator(WishlistItemComponent record, String objectName) {
        super();
        this.record = record;
        this.wishlistItemId = UUID.randomUUID();
        this.objectName = objectName;
    }


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
