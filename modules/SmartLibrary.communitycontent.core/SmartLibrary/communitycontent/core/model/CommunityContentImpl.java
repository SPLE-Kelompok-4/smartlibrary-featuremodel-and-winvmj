package SmartLibrary.communitycontent.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="communitycontent_impl")
@Table(name="communitycontent_impl")
public class CommunityContentImpl extends CommunityContentComponent {

	public CommunityContentImpl(String contentAuthor, UUID contentID, EDate createdAt, EDate updatedAt) {
		this.contentAuthor = contentAuthor;
		this.contentID = contentID;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public CommunityContentImpl(String contentAuthor, UUID contentID, EDate createdAt, EDate updatedAt) {
		this. =  .randomUUID();;
		this.contentAuthor = contentAuthor;
		this.contentID = contentID;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public CommunityContentImpl() { }

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

	public void createContent() {
		// TODO: implement this method
	}

	public void readContent() {
		// TODO: implement this method
	}

	public void updateContent() {
		// TODO: implement this method
	}

	public void deleteContent() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> communitycontentMap = new HashMap<String,Object>();
		communitycontentMap.put("contentAuthor",getContentAuthor());
		communitycontentMap.put("contentID",getContentID());
		communitycontentMap.put("createdAt",getCreatedAt());
		communitycontentMap.put("updatedAt",getUpdatedAt());

        return communitycontentMap;
    }

}
