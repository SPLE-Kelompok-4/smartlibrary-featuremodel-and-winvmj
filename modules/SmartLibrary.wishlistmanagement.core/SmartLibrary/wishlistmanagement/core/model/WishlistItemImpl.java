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

    public WishlistItemImpl(UUID wishlistItemId, String itemName) {
        this.itemName = itemName;
        this.wishlistItemId = wishlistItemId;
    }

    public WishlistItemImpl(String itemName) {
        this.itemName = itemName;
        this.wishlistItemId = UUID.randomUUID();
    }

    public WishlistItemImpl() {
        this.itemName = "";
        this.wishlistItemId = UUID.randomUUID();
    }
}