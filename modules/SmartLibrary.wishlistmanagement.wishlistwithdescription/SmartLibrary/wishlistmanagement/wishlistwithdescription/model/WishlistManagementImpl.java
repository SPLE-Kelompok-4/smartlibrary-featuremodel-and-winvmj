package SmartLibrary.wishlistmanagement.wishlistwithdescription;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.wishlistmanagement.core.WishlistManagementDecorator;
import SmartLibrary.wishlistmanagement.core.WishlistManagement;
import SmartLibrary.wishlistmanagement.core.WishlistManagementComponent;

@Entity(name="wishlistmanagement_wishlistwithdescription")
@Table(name="wishlistmanagement_wishlistwithdescription")
public class WishlistManagementImpl extends WishlistManagementDecorator {

	protected String Description;
	public WishlistManagementImpl(){
        super();
        this.objectName = WishlistManagementImpl.class.getName();
    }
    
    public WishlistManagementImpl(String Description) {
    	super();
		this.Description = Description;
		this.objectName = WishlistManagementImpl.class.getName();
    }
	
	public WishlistManagementImpl(WishlistManagementComponent record, String Description) {
		super(record);
		this.Description = Description;
		this.objectName = WishlistManagementImpl.class.getName();
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}


}
