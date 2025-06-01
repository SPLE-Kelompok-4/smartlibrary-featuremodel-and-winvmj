package SmartLibrary.wishlistmanagement.core;

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

@Entity(name="wishlistmanagement_impl")
@Table(name="wishlistmanagement_impl")
public class WishlistManagementImpl extends WishlistManagementComponent {

    public WishlistManagementImpl(String name) {
        super();
        this.name = name;
        this.wishlistId = UUID.randomUUID();
        this.createdAt = new EDate();
        this.updatedAt = new EDate();
    }

    public WishlistManagementImpl() {
        super();
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
    public EDate getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public void setUpdatedAt(EDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public EDate getUpdateAt() {
        return this.updatedAt;
    }

    public void setUpdateAt(EDate updateAt) {
        this.updatedAt = updateAt;
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistManagementMap = new HashMap<String, Object>();
        wishlistManagementMap.put("wishlistId", getWishlistId());
        wishlistManagementMap.put("name", getName());
        wishlistManagementMap.put("createdAt", getCreatedAt());
        wishlistManagementMap.put("updatedAt", getUpdatedAt());
        
        return wishlistManagementMap;
    }
}