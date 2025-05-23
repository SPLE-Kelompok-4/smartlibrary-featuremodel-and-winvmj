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

    public WishlistItemDecorator() {
        super();
    }

    public WishlistItemDecorator(WishlistItemComponent record) {
        super();
        this.wishlistItemId = UUID.randomUUID();
        this.record = record;
    }

    public WishlistItemDecorator(UUID id, WishlistItemComponent record) {
        super();
        this.wishlistItemId = id;
        this.record = record;
    }

    public WishlistItemDecorator(WishlistItemComponent record, String objectName) {
        super();
        this.wishlistItemId = UUID.randomUUID();
        this.record = record;
        this.objectName = objectName;
    }

    @Override
    public UUID getWishlistId() {
        return record.getWishlistId();
    }

    @Override
    public void setWishlistId(UUID wishlistId) {
        record.setWishlistId(wishlistId);
    }

    @Override
    public UUID getItemId() {
        return record.getItemId();
    }

    @Override
    public void setItemId(UUID itemId) {
        record.setItemId(itemId);
    }

    @Override
    public EDate getAddedAt() {
        return record.getAddedAt();
    }

    @Override
    public void setAddedAt(EDate addedAt) {
        record.setAddedAt(addedAt);
    }

    public UUID getWishlistItemId() {
        return record.getWishlistItemId();
    }

    public void setWishlistItemId(UUID wishlistItemId) {
        record.setWishlistItemId(wishlistItemId);
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}