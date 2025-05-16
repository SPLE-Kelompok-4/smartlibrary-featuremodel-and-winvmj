package SmartLibrary.communitycontent.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
import java.util.UUID;
import SmartLibrary.communitycontent.core.EDate; 

@MappedSuperclass
public abstract class CommunityContentDecorator extends CommunityContentComponent {
    @OneToOne(cascade=CascadeType.ALL)
    protected CommunityContentComponent record;

    public CommunityContentDecorator() {
        super();
    }
        
    public CommunityContentDecorator(CommunityContentComponent record) {
        super();
        this.contentID = UUID.randomUUID();
        this.record = record;
    }

    public CommunityContentDecorator(UUID id, CommunityContentComponent record) {
        super();
        this.contentID = id;
        this.record = record;
    }
    
    public CommunityContentDecorator(CommunityContentComponent record, String objectName) {
        super();
        this.contentID = UUID.randomUUID();
        this.record = record;    
        this.objectName = objectName;
    }

    @Override
    public String getContentAuthor() {
        return record.getContentAuthor();
    }
    
    @Override
    public void setContentAuthor(String contentAuthor) {
        record.setContentAuthor(contentAuthor);
    }
    
    @Override
    public UUID getContentID() {
        return record.getContentID();
    }
    
    @Override
    public void setContentID(UUID contentID) {
        record.setContentID(contentID);
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