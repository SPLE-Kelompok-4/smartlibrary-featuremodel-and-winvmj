package SmartLibrary.communitycontent.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CommunityContentDecorator extends CommunityContentComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CommunityContentComponent record;

	public CommunityContentDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public CommunityContentDecorator (CommunityContentComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public CommunityContentDecorator (, CommunityContentComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public CommunityContentDecorator (CommunityContentComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public CommunityContentDecorator() { }

	public String getContentAuthor() {
		return record.getContentAuthor();
	}
	public void setContentAuthor(String contentAuthor) {
		record.setContentAuthor(contentAuthor);
	}
	public UUID getContentID() {
		return record.getContentID();
	}
	public void setContentID(UUID contentID) {
		record.setContentID(contentID);
	}
	public EDate getCreatedAt() {
		return record.getCreatedAt();
	}
	public void setCreatedAt(EDate createdAt) {
		record.setCreatedAt(createdAt);
	}
	public EDate getUpdatedAt() {
		return record.getUpdatedAt();
	}
	public void setUpdatedAt(EDate updatedAt) {
		record.setUpdatedAt(updatedAt);
	}

	public void createContent() {
		return record.createContent();
	}

	public void readContent() {
		return record.readContent();
	}

	public void updateContent() {
		return record.updateContent();
	}

	public void deleteContent() {
		return record.deleteContent();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
