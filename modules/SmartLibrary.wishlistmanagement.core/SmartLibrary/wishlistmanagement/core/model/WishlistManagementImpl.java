package SmartLibrary.wishlistmanagement.core;

import SmartLibrary.wishlistmanagement.core.*;
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

@Entity(name="wishlistmanagement_impl")
@Table(name="wishlistmanagement_impl")
public class WishlistManagementImpl extends WishlistManagementComponent {
    
    @Id
    @Column(name="wishlist_id")
    private UUID wishlistId;
    
    @Column(name="user_id")
    private UUID userId;
    
    @Column(name="name")
    private String name;
    
    @Column(name="created_at")
    private EDate createdAt;
    
    @Column(name="update_at")
    private EDate updateAt;
    
    @ManyToOne
    @JoinColumn(name="wishlistitem_id")
    private WishlistItemImpl wishlistitemimpl;

    public WishlistManagementImpl(UUID wishlistId, UUID userId, String name, EDate createdAt, EDate updateAt, WishlistItemImpl wishlistitemimpl) {
        this.wishlistId = wishlistId;
        this.userId = userId;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.wishlistitemimpl = wishlistitemimpl;
    }

    public WishlistManagementImpl() { }

    public void addItem(WishlistItem item) {
        // TODO: implement this method
    }

    public void removeItem(UUID itemId) {
        // TODO: implement this method
    }

    public void getItems() {
        // TODO: implement this method
    }

    @Override
    public UUID getWishlistId() {
        return this.wishlistId;
    }

    @Override
    public void setWishlistId(UUID wishlistId) {
        this.wishlistId = wishlistId;
    }

    @Override
    public UUID getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public EDate getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public void setCreatedAt(EDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public WishlistItemImpl getWishlistitemimpl() {
        return this.wishlistitemimpl;
    }

    @Override
    public void setWishlistitemimpl(WishlistItemImpl wishlistitemimpl) {
        this.wishlistitemimpl = wishlistitemimpl;
    }

    @Override
    public EDate getUpdateAt() {
        return this.updateAt;
    }

    @Override
    public void setUpdateAt(EDate updateAt) {
        this.updateAt = updateAt;
    }
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistmanagementMap = new HashMap<String, Object>();
        wishlistmanagementMap.put("wishlistId", getWishlistId());
        wishlistmanagementMap.put("userId", getUserId());
        wishlistmanagementMap.put("name", getName());
        wishlistmanagementMap.put("createdAt", getCreatedAt());
        wishlistmanagementMap.put("updateAt", getUpdateAt());
        wishlistmanagementMap.put("wishlistitemimpl", getWishlistitemimpl());

        return wishlistmanagementMap;
    }
}