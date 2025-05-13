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

	public ReviewManagementDecorator() {
        super();
    }
    
    public ReviewManagementDecorator(ReviewManagementComponent record) {
        super();
        this.record = record;
        this.reviewId = UUID.randomUUID();
    }

    public ReviewManagementDecorator(UUID reviewId, UUID userId, ReviewManagementComponent record) {
        super();
        this.reviewId = reviewId;
        this.userId = userId;
        this.record = record;
    }
    
    public ReviewManagementDecorator(ReviewManagementComponent record, String objectName) {
        super();
        this.record = record;
        this.reviewId = UUID.randomUUID();
        this.objectName = objectName;
    }

	public void addReview(Item item) {
		return record.addReview();
	}

	public void removeReview(UUID itemId) {
		return record.removeReview(itemId);
	}

	public void getReviews() {
		return record.getReviews();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
