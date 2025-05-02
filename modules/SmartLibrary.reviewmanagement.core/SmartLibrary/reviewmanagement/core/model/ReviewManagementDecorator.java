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
		this.reviewIduserId =  reviewIduserId.randomUUID();
		
	public ReviewManagementDecorator (ReviewManagementComponent record) {
		this.reviewIduserId =  reviewIduserId.randomUUID();
		this.record = record;
	}

	public ReviewManagementDecorator (UUID reviewIdUUID userId, ReviewManagementComponent record) {
		this.reviewIduserId =  reviewIduserId;
		this.record = record;
	}
	
	public ReviewManagementDecorator (ReviewManagementComponent record, String objectName) {
		this.reviewIduserId =  reviewIduserId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public ReviewManagementDecorator() { }


	public void addReview(Item ) {
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
