package SmartLibrary.wishlistmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="wishlistitemimpl_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistItemComponent implements WishlistItemImpl{
	@Id
	public UUID wishlistItemId; public UUID wishlistId; public UUID itemId; 
	public UUID wishlistItemId;
	public UUID wishlistId;
	public UUID itemId;
	public EDate addedItem;
	protected String objectName = WishlistItemComponent.class.getName();

	public WishlistItemComponent() {

	} 

	public WishlistItemComponent(
        UUID wishlistItemId, UUID wishlistId, UUID itemId, EDate addedItem
    ) {
        this.wishlistItemId = wishlistItemId;
        this.wishlistId = wishlistId;
        this.itemId = itemId;
        this.addedItem = addedItem;
    }

	public abstract UUID getWishlistItemId();
	public abstract void setWishlistItemId(UUID wishlistItemId);
	
	public abstract UUID getWishlistId();
	public abstract void setWishlistId(UUID wishlistId);
	
	public abstract UUID getItemId();
	public abstract void setItemId(UUID itemId);
	
	public abstract EDate getAddedItem();
	public abstract void setAddedItem(EDate addedItem);
	
 

	@Override
    public String toString() {
        return "{" +
            " wishlistItemId='" + getWishlistItemId() + "'" +
            " wishlistId='" + getWishlistId() + "'" +
            " itemId='" + getItemId() + "'" +
            " addedItem='" + getAddedItem() + "'" +
            "}";
    }
	
}
