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
@Table(name="reviewmanagement_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReviewManagementComponent implements ReviewManagement{
	@Id
	public UUID reviewId; public UUID userId; 
	public UUID reviewId;
	public UUID userId;
	public String name;
	public EDate createdAt;
	@ManyToOne(targetEntity=SmartLibrary..core.Component.class)
	public  reviewitemimpl;
	public EDate updateAt;
	protected String objectName = ReviewManagementComponent.class.getName();

	public ReviewManagementComponent() {

	} 

	public ReviewManagementComponent(
        UUID reviewId, UUID userId, String name, EDate createdAt, ReviewItemImpl reviewitemimpl, EDate updateAt
    ) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.name = name;
        this.createdAt = createdAt;
        this.reviewitemimpl = reviewitemimpl;
        this.updateAt = updateAt;
    }

	public abstract UUID getReviewId();
	public abstract void setReviewId(UUID reviewId);
	
	public abstract UUID getUserId();
	public abstract void setUserId(UUID userId);
	
	public abstract String getName();
	public abstract void setName(String name);
	
	public abstract EDate getCreatedAt();
	public abstract void setCreatedAt(EDate createdAt);
	
	public abstract ReviewItemImpl getReviewitemimpl();
	public abstract void setReviewitemimpl(ReviewItemImpl reviewitemimpl);
	
	public abstract EDate getUpdateAt();
	public abstract void setUpdateAt(EDate updateAt);
	
 
	public abstract void addReview(Item );

	public abstract void removeReview(UUID itemId);

	public abstract void getReviews();

	@Override
    public String toString() {
        return "{" +
            " reviewId='" + getReviewId() + "'" +
            " userId='" + getUserId() + "'" +
            " name='" + getName() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " reviewitemimpl='" + getReviewitemimpl() + "'" +
            " updateAt='" + getUpdateAt() + "'" +
            "}";
    }
	
}
