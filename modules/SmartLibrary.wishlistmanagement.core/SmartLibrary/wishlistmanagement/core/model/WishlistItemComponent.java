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
    protected String itemName;
    protected EDate addedAt;
    protected String objectName = WishlistItemComponent.class.getName();

    public WishlistItemComponent() {

    }

    public WishlistItemComponent(UUID wishlistItemId, String itemName) {
        this.itemName = itemName;
        this.wishlistItemId = wishlistItemId;
        this.addedAt = new EDate();
    }

    public UUID getWishlistItemId() {
        return this.wishlistItemId;
    }

    public void setWishlistItemId(UUID wishlistItemId) {
        this.wishlistItemId = wishlistItemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
            " itemName='" + getItemName() + "'" +
            " addedAt='" + getAddedAt() + "'" +
            "}";
    }
     public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistItemMap = new HashMap<String, Object>();
        wishlistItemMap.put("wishlistItemId", getWishlistItemId());
        wishlistItemMap.put("itemName", getItemName());
        wishlistItemMap.put("addedAt", getAddedAt());

        return wishlistItemMap;
    }
}