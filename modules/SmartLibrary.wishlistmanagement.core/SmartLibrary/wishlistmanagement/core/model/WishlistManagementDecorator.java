package SmartLibrary.wishlistmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
import java.util.UUID;
import SmartLibrary.wishlistmanagement.core.EDate;

@MappedSuperclass
public abstract class WishlistManagementDecorator extends WishlistManagementComponent {
    @OneToOne(cascade=CascadeType.ALL)
    protected WishlistManagementComponent record;

    public WishlistManagementDecorator() {
        super();
    }

    public WishlistManagementDecorator(WishlistManagementComponent record) {
        super();
        this.wishlistId = UUID.randomUUID();
        this.record = record;
    }

    public WishlistManagementDecorator(UUID id, WishlistManagementComponent record) {
        super();
        this.wishlistId = id;
        this.record = record;
    }

    public WishlistManagementDecorator(WishlistManagementComponent record, String objectName) {
        super();
        this.wishlistId = UUID.randomUUID();
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
    public UUID getUserId() {
        return record.getUserId();
    }

    @Override
    public void setUserId(UUID userId) {
        record.setUserId(userId);
    }

    @Override
    public String getName() {
        return record.getName();
    }

    @Override
    public void setName(String name) {
        record.setName(name);
    }

    @Override
    public EDate getCreatedAt() {
        return record.getCreatedAt();
    }

    @Override
    public void setCreatedAt(EDate createdAt) {
        record.setCreatedAt(createdAt);
    }

    @Override
    public EDate getUpdatedAt() {
        return record.getUpdatedAt();
    }

    @Override
    public void setUpdatedAt(EDate updatedAt) {
        record.setUpdatedAt(updatedAt);
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}