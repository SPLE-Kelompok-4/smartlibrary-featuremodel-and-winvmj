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

	public WishlistManagementDecorator() {
        super();
    }
    
    public WishlistManagementDecorator(WishlistManagementComponent record) {
        super();
        this.record = record;
        this.wishlistId = UUID.randomUUID();
    }
    
    public WishlistManagementDecorator(UUID wishlistId, UUID userId, WishlistManagementComponent record) {
        super();
        this.wishlistId = wishlistId;
        this.userId = userId;
        this.record = record;
    }
    
    public WishlistManagementDecorator(WishlistManagementComponent record, String objectName) {
        super();
        this.record = record;
        this.wishlistId = UUID.randomUUID();
        this.objectName = objectName;
    }

	public void addItem(Item item) {
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
