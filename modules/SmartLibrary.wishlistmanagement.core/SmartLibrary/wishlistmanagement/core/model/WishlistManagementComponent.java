package SmartLibrary.wishlistmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name="wishlistmanagement_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistManagementComponent implements WishlistManagement {
    @Id
    protected UUID wishlistId;

    protected String name;
    protected EDate createdAt;
    protected EDate updatedAt;
    protected String objectName = WishlistManagementComponent.class.getName();

    public WishlistManagementComponent(String name) {
        this.name = name;
        this.wishlistId = UUID.randomUUID();
        this.createdAt = new EDate();
        this.updatedAt = new EDate();
    }

    public WishlistManagementComponent() {

    }

    public UUID getWishlistId() {
        return this.wishlistId;
    }

    public void setWishlistId(UUID wishlistId) {
        this.wishlistId = wishlistId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EDate getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(EDate createdAt) {
        this.createdAt = createdAt;
    }

    public EDate getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(EDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "{" +
            " wishlistId='" + getWishlistId() + "'" +
            " name='" + getName() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}