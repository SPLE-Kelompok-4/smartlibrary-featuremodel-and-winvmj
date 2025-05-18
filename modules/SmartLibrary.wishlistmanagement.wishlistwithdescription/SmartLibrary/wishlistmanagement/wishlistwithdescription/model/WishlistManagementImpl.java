package SmartLibrary.wishlistmanagement.wishlistwithdescription;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.wishlistmanagement.core.WishlistManagementDecorator;
import SmartLibrary.wishlistmanagement.core.WishlistManagement;
import SmartLibrary.wishlistmanagement.core.WishlistManagementComponent;
import SmartLibrary.wishlistmanagement.core.WishlistItem;
import SmartLibrary.wishlistmanagement.core.WishlistItemImpl;
import SmartLibrary.wishlistmanagement.core.EDate;

@Entity(name="wishlistmanagement_wishlistwithdescription")
@Table(name="wishlistmanagement_wishlistwithdescription")
public class WishlistManagementImpl extends WishlistManagementDecorator {

    @Column(name="description")
    protected String description;
    
    public WishlistManagementImpl() {
        super();
        this.objectName = WishlistManagementImpl.class.getName();
    }
    
    public WishlistManagementImpl(String description) {
        super();
        this.description = description;
        this.objectName = WishlistManagementImpl.class.getName();
    }
    
    public WishlistManagementImpl(WishlistManagementComponent record, String description) {
        super(record);
        this.description = description;
        this.objectName = WishlistManagementImpl.class.getName();
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    // Implementasi method abstract yang wajib dari WishlistManagementComponent
    @Override
    public UUID getWishlistId() {
        if (record != null) {
            return record.getWishlistId();
        }
        return this.wishlistId;
    }

    @Override
    public void setWishlistId(UUID wishlistId) {
        if (record != null) {
            record.setWishlistId(wishlistId);
        } else {
            this.wishlistId = wishlistId;
        }
    }

    @Override
    public UUID getUserId() {
        if (record != null) {
            return record.getUserId();
        }
        return this.userId;
    }

    @Override
    public void setUserId(UUID userId) {
        if (record != null) {
            record.setUserId(userId);
        } else {
            this.userId = userId;
        }
    }

    @Override
    public String getName() {
        if (record != null) {
            return record.getName();
        }
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (record != null) {
            record.setName(name);
        } else {
            this.name = name;
        }
    }

    @Override
    public EDate getCreatedAt() {
        if (record != null) {
            return record.getCreatedAt();
        }
        return this.createdAt;
    }

    @Override
    public void setCreatedAt(EDate createdAt) {
        if (record != null) {
            record.setCreatedAt(createdAt);
        } else {
            this.createdAt = createdAt;
        }
    }

    @Override
    public EDate getUpdateAt() {
        if (record != null) {
            return record.getUpdateAt();
        }
        return this.updateAt;
    }

    @Override
    public void setUpdateAt(EDate updateAt) {
        if (record != null) {
            record.setUpdateAt(updateAt);
        } else {
            this.updateAt = updateAt;
        }
    }

    @Override
    public WishlistItemImpl getWishlistitemimpl() {
        if (record != null) {
            return record.getWishlistitemimpl();
        }
        return this.wishlistitemimpl;
    }

    @Override
    public void setWishlistitemimpl(WishlistItemImpl wishlistitemimpl) {
        if (record != null) {
            record.setWishlistitemimpl(wishlistitemimpl);
        } else {
            this.wishlistitemimpl = wishlistitemimpl;
        }
    }
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> result = new HashMap<>();
        
        if (record != null) {
            result = record.toHashMap();
        } else {
            result.put("wishlistId", this.wishlistId);
            result.put("userId", this.userId);
        }
        
        result.put("description", this.description);
        result.put("objectName", this.objectName);
        
        return result;
    }
    
    @Override
    public void addItem(WishlistItem wishlistItem) {
        if (record != null) {
            record.addItem(wishlistItem);
        } else {
            super.addItem(wishlistItem);
        }
    }
    
    @Override
    public void removeItem(UUID itemId) {
        if (record != null) {
            record.removeItem(itemId);
        } else {
            super.removeItem(itemId);
        }
    }
    
    @Override
    public void getItems() {
        if (record != null) {
            record.getItems();
        } else {
            super.getItems();
        }
    }
}