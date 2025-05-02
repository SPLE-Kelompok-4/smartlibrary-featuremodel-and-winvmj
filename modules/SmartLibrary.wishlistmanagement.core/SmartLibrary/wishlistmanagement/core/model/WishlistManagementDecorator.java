package SmartLibrary.wishlistmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class WishlistManagementDecorator extends WishlistManagementComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected WishlistManagementComponent record;

	public WishlistManagementDecorator () {
		super();
		this.record = record;
		this.wishlistIduserId =  wishlistIduserId.randomUUID();
		
	public WishlistManagementDecorator (WishlistManagementComponent record) {
		this.wishlistIduserId =  wishlistIduserId.randomUUID();
		this.record = record;
	}

	public WishlistManagementDecorator (UUID wishlistIdUUID userId, WishlistManagementComponent record) {
		this.wishlistIduserId =  wishlistIduserId;
		this.record = record;
	}
	
	public WishlistManagementDecorator (WishlistManagementComponent record, String objectName) {
		this.wishlistIduserId =  wishlistIduserId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public WishlistManagementDecorator() { }


	public void addItem(Item ) {
		return record.addItem();
	}

	public void removeItem(UUID itemId) {
		return record.removeItem(itemId);
	}

	public void getItems() {
		return record.getItems();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
