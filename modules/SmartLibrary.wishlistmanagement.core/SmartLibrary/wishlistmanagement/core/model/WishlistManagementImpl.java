package SmartLibrary.wishlistmanagement.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="wishlishmanagement_impl")
@Table(name="wishlishmanagement_impl")
public class WishlistManagementImpl extends WishlistManagementComponent {

	public WishlistManagementImpl(UUID wishlistId, UUID userId, String name, EDate createdAt, EDate updateAt, WishlistItemImpl wishlistitemimpl) {
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.name = name;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.wishlistitemimpl = wishlistitemimpl;
	}

	public WishlistManagementImpl(UUID wishlistId, UUID userId, String name, EDate createdAt, EDate updateAt, WishlistItemImpl wishlistitemimpl) {
		this.wishlistIduserId =  wishlistIduserId.randomUUID();;
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.name = name;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.wishlistitemimpl = wishlistitemimpl;
	}

	public WishlistManagementImpl() { }


	public void addItem(Item ) {
		// TODO: implement this method
	}

	public void removeItem(UUID itemId) {
		// TODO: implement this method
	}

	public void getItems() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlishmanagementMap = new HashMap<String,Object>();
		wishlishmanagementMap.put("wishlistId",getWishlistId());
		wishlishmanagementMap.put("userId",getUserId());
		wishlishmanagementMap.put("name",getName());
		wishlishmanagementMap.put("createdAt",getCreatedAt());
		wishlishmanagementMap.put("updateAt",getUpdateAt());
		wishlishmanagementMap.put("wishlistitemimpl",getWishlistitemimpl());

        return wishlishmanagementMap;
    }

}
