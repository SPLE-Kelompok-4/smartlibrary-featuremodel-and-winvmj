package SmartLibrary.communitycontent.core;

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

/**
 * Implementation of CommunityContentComponent
 * Represents a concrete community content entity
 */
@Entity(name="communitycontent_impl")
@Table(name="communitycontent_impl")
public class CommunityContentImpl extends CommunityContentComponent {

    /**
     * Constructor with explicit id
     */
    public CommunityContentImpl( String contentAuthor, UUID contentID, EDate createdAt, EDate updatedAt) {
        super();
        this.contentAuthor = contentAuthor;
        this.contentID = contentID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Constructor that generates a random UUID
     */
    public CommunityContentImpl(String contentAuthor) {
        super();
        this.contentAuthor = contentAuthor;
        this.contentID = UUID.randomUUID();
        this.createdAt = new EDate();
        this.updatedAt = new EDate();
    }

    /**
     * Default constructor required by JPA
     */
    public CommunityContentImpl() {
        super();
    }

    @Override
    public String getContentAuthor() {
        return this.contentAuthor;
    }

    @Override
    public void setContentAuthor(String contentAuthor) {
        this.contentAuthor = contentAuthor;
    }
    
    @Override
    public UUID getContentID() {
        return this.contentID;
    }

    @Override
    public void setContentID(UUID contentID) {
        this.contentID = contentID;
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
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> communitycontentMap = new HashMap<String, Object>();
        communitycontentMap.put("contentAuthor", getContentAuthor());
        communitycontentMap.put("contentID", getContentID());
        communitycontentMap.put("createdAt", getCreatedAt());
        communitycontentMap.put("updatedAt", getUpdatedAt());
        
        return communitycontentMap;
    }
}