package SmartLibrary.wishlistmanagement.wishlistwithdescription;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.wishlistmanagement.core.WishlistItemDecorator;
import SmartLibrary.wishlistmanagement.core.WishlistItem;
import SmartLibrary.wishlistmanagement.core.WishlistItemComponent;

@Entity(name="wishlistmanagement_wishlistwithdescription")
@Table(name="wishlistmanagement_wishlistwithdescription")
public class WishlistItemImpl extends WishlistItemDecorator {

	public String description;
	public WishlistItemImpl(){
        super();
        this.objectName = WishlistItemImpl.class.getName();
    }
    
    public WishlistItemImpl(String description) {
    	super();
		this.description = description;
		this.objectName = WishlistItemImpl.class.getName();
    }
	
	public WishlistItemImpl(WishlistItemComponent record, String description) {
		super(record);
		this.description = description;
		this.objectName = WishlistItemImpl.class.getName();
	}



}
