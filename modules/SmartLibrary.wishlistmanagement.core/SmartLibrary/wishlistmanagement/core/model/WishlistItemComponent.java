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
@Table(name="wishlistitem_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistItemComponent implements WishlistItem {
    @Id
    protected UUID wishlistItemId;

    protected UUID wishlistId;
    protected UUID itemId;
    protected EDate addedAt;
    protected String objectName = WishlistItemComponent.class.getName();

    public WishlistItemComponent(UUID wishlistId, UUID itemId) {
        this.wishlistId = wishlistId;
        this.itemId = itemId;
        this.wishlistItemId = UUID.randomUUID();
        this.addedAt = new EDate();
    }

    public WishlistItemComponent() {

    }

    public UUID getWishlistItemId() {
        return this.wishlistItemId;
    }

    public void setWishlistItemId(UUID wishlistItemId) {
        this.wishlistItemId = wishlistItemId;
    }

    public UUID getWishlistId() {
        return this.wishlistId;
    }

    public void setWishlistId(UUID wishlistId) {
        this.wishlistId = wishlistId;
    }

    public UUID getItemId() {
        return this.itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public EDate getAddedAt() {
        return this.addedAt;
    }

    public void setAddedAt(EDate addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "{" +
            " wishlistItemId='" + getWishlistItemId() + "'" +
            " wishlistId='" + getWishlistId() + "'" +
            " itemId='" + getItemId() + "'" +
            " addedAt='" + getAddedAt() + "'" +
            "}";
    }
}