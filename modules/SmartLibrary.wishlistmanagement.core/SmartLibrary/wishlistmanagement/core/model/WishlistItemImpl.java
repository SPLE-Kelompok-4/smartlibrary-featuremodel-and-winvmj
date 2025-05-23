package SmartLibrary.wishlistmanagement.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="wishlistitem_impl")
@Table(name="wishlistitem_impl")
public class WishlistItemImpl extends WishlistItemComponent {

    public WishlistItemImpl(UUID wishlistId, UUID itemId) {
        this.wishlistId = wishlistId;
        this.itemId = itemId;
        this.wishlistItemId = UUID.randomUUID();
        this.addedAt = new EDate();
    }

    public WishlistItemImpl() {
    }

    public UUID getWishlistItemId() {
        return this.wishlistItemId;
    }

    public void setWishlistItemId(UUID wishlistItemId) {
        this.wishlistItemId = wishlistItemId;
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
    public UUID getItemId() {
        return this.itemId;
    }

    @Override
    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    @Override
    public EDate getAddedAt() {
        return this.addedAt;
    }

    @Override
    public void setAddedAt(EDate addedAt) {
        this.addedAt = addedAt;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistItemMap = new HashMap<String, Object>();
        wishlistItemMap.put("wishlistItemId", getWishlistItemId());
        wishlistItemMap.put("wishlistId", getWishlistId());
        wishlistItemMap.put("itemId", getItemId());
        wishlistItemMap.put("addedAt", getAddedAt());

        return wishlistItemMap;
    }
}