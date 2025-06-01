package SmartLibrary.wishlistmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

@MappedSuperclass
public abstract class WishlistItemDecorator extends WishlistItemComponent {
    @OneToOne(cascade=CascadeType.ALL)
    protected WishlistItemComponent record;

    public WishlistItemDecorator(WishlistItemComponent record) {
        this.record = record;
    }

    public WishlistItemDecorator(UUID wishlistItemId, WishlistItemComponent record) {
        this.wishlistItemId = wishlistItemId;
        this.record = record;
    }

    public WishlistItemDecorator() {
        super();
        this.wishlistItemId = UUID.randomUUID();
    }

    public String getItemName() {
        return record.getItemName();
    }

    public void setItemName(String itemName) {
        record.setItemName(itemName);
    }

    public EDate getAddedAt() {
        return record.getAddedAt();
    }

    public void setAddedAt(EDate addedAt) {
        record.setAddedAt(addedAt);
    }

    public UUID getWishlistItemId() {
        return record.getWishlistItemId();
    }

    public void setWishlistItemId(UUID wishlistItemId) {
        record.setWishlistItemId(wishlistItemId);
    }

    public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}