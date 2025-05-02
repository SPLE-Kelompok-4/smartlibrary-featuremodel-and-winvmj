package SmartLibrary.reviewmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="reviewitemimpl_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReviewItemComponent implements ReviewItemImpl{
	@Id
	public UUID reviewItemId; public UUID reviewId; public UUID itemId; 
	public UUID reviewItemId;
	public UUID reviewId;
	public UUID itemId;
	public EDate addedAt;
	protected String objectName = ReviewItemComponent.class.getName();

	public ReviewItemComponent() {

	} 

	public ReviewItemComponent(
        UUID reviewItemId, UUID reviewId, UUID itemId, EDate addedAt
    ) {
        this.reviewItemId = reviewItemId;
        this.reviewId = reviewId;
        this.itemId = itemId;
        this.addedAt = addedAt;
    }

	public abstract UUID getReviewItemId();
	public abstract void setReviewItemId(UUID reviewItemId);
	
	public abstract UUID getReviewId();
	public abstract void setReviewId(UUID reviewId);
	
	public abstract UUID getItemId();
	public abstract void setItemId(UUID itemId);
	
	public abstract EDate getAddedAt();
	public abstract void setAddedAt(EDate addedAt);
	
 

	@Override
    public String toString() {
        return "{" +
            " reviewItemId='" + getReviewItemId() + "'" +
            " reviewId='" + getReviewId() + "'" +
            " itemId='" + getItemId() + "'" +
            " addedAt='" + getAddedAt() + "'" +
            "}";
    }
	
}
