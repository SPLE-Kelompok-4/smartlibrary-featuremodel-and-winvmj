package SmartLibrary.reviewmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ReviewManagementDecorator extends ReviewManagementComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ReviewManagementComponent record;

	public ReviewManagementDecorator () {
		super();
		this.record = record;
		this.reviewId =  UUID.randomUUID();
		this.userId =  UUID.randomUUID();
	}
		
	public ReviewManagementDecorator (ReviewManagementComponent record) {
		this.reviewId =  UUID.randomUUID();
		this.record = record;
	}

	public ReviewManagementDecorator (UUID reviewId, UUID userId, ReviewManagementComponent record) {
		this.reviewId = reviewId;
		this.userId = userId;
		this.record = record;
	}
	
	public ReviewManagementDecorator (ReviewManagementComponent record, String objectName) {
		this.reviewId =  UUID.randomUUID();
		this.userId =  UUID.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public void addReview(ReviewItem reviewItem) {
		record.addReview(reviewItem);
	}

	public void removeReview(UUID itemId) {
		record.removeReview(itemId);
	}

	public void getReviews() {
		record.getReviews();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
