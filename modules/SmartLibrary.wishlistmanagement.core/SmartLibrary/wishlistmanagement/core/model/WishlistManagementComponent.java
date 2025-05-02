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
@Table(name="wishlishmanagement_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistManagementComponent implements WishlishManagement{
	@Id
	public UUID wishlistId; public UUID userId; 
	public UUID wishlistId;
	public UUID userId;
	public String name;
	public EDate createdAt;
	public EDate updateAt;
	@ManyToOne(targetEntity=SmartLibrary.wishlistitemimpl.core.WishlistItemImplComponent.class)
	public WishlistItemImpl wishlistitemimpl;
	protected String objectName = WishlistManagementComponent.class.getName();

	public WishlistManagementComponent() {

	} 

	public WishlistManagementComponent(
        UUID wishlistId, UUID userId, String name, EDate createdAt, EDate updateAt, WishlistItemImpl wishlistitemimpl
    ) {
        this.wishlistId = wishlistId;
        this.userId = userId;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.wishlistitemimpl = wishlistitemimpl;
    }

	public abstract UUID getWishlistId();
	public abstract void setWishlistId(UUID wishlistId);
	
	public abstract UUID getUserId();
	public abstract void setUserId(UUID userId);
	
	public abstract String getName();
	public abstract void setName(String name);
	
	public abstract EDate getCreatedAt();
	public abstract void setCreatedAt(EDate createdAt);
	
	public abstract EDate getUpdateAt();
	public abstract void setUpdateAt(EDate updateAt);
	
	public abstract WishlistItemImpl getWishlistitemimpl();
	public abstract void setWishlistitemimpl(WishlistItemImpl wishlistitemimpl);
	
 
	public abstract void addItem(Item );

	public abstract void removeItem(UUID itemId);

	public abstract void getItems();

	@Override
    public String toString() {
        return "{" +
            " wishlistId='" + getWishlistId() + "'" +
            " userId='" + getUserId() + "'" +
            " name='" + getName() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " updateAt='" + getUpdateAt() + "'" +
            " wishlistitemimpl='" + getWishlistitemimpl() + "'" +
            "}";
    }
	
}
