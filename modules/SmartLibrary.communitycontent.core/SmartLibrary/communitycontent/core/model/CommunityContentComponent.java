package SmartLibrary.communitycontent.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="communitycontent_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CommunityContentComponent implements CommunityContent{
	@Id
	protected UUID contentID;
	
	protected String contentAuthor;
	protected EDate createdAt;
	protected EDate updatedAt;
	protected String objectName = CommunityContentComponent.class.getName();


	public CommunityContentComponent(String contentAuthor) {
		this.contentAuthor = contentAuthor;
		this.contentID = UUID.randomUUID();
		this.createdAt = new EDate();
		this.updatedAt = new EDate();
	} 

	public CommunityContentComponent() {
		
	} 
	

	public String getContentAuthor() {
		return this.contentAuthor;
	}

	public void setContentAuthor(String contentAuthor) {
		this.contentAuthor = contentAuthor;
	}
	public UUID getContentID() {
		return this.contentID;
	}

	public void setContentID(UUID contentID) {
		this.contentID = contentID;
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
            " contentAuthor='" + getContentAuthor() + "'" +
            " contentID='" + getContentID() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
	
}
