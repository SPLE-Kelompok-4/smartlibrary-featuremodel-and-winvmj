package SmartLibrary.reviewmanagement.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ReviewItemDecorator extends ReviewItemComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ReviewItemComponent record;

	public ReviewItemDecorator () {
		super();
		this.record = record;
		this.reviewId =  UUID.randomUUID();
		this.itemId =  UUID.randomUUID();
	
	}

	public ReviewItemDecorator (ReviewItemComponent record) {
		this.itemId =  UUID.randomUUID();
		this.record = record;
	}

	public ReviewItemDecorator (UUID reviewId, UUID itemId, ReviewItemComponent record) {
		this.itemId =  UUID.randomUUID();
		this.reviewId = reviewId;
		this.record = record;
	}
	
	public ReviewItemDecorator (ReviewItemComponent record, String objectName) {
		this.reviewId =  UUID.randomUUID();
		this.itemId =  UUID.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
