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

	public WishlistItemDecorator () {
		super();
		this.record = record;
		this.wishlistItemIdwishlistIditemId =  wishlistItemIdwishlistIditemId.randomUUID();
		
	public WishlistItemDecorator (WishlistItemComponent record) {
		this.wishlistItemIdwishlistIditemId =  wishlistItemIdwishlistIditemId.randomUUID();
		this.record = record;
	}

	public WishlistItemDecorator (UUID wishlistItemIdUUID wishlistIdUUID itemId, WishlistItemComponent record) {
		this.wishlistItemIdwishlistIditemId =  wishlistItemIdwishlistIditemId;
		this.record = record;
	}
	
	public WishlistItemDecorator (WishlistItemComponent record, String objectName) {
		this.wishlistItemIdwishlistIditemId =  wishlistItemIdwishlistIditemId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public WishlistItemDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
