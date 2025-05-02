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
		this.reviewItemIdreviewIditemId =  reviewItemIdreviewIditemId.randomUUID();
		
	public ReviewItemDecorator (ReviewItemComponent record) {
		this.reviewItemIdreviewIditemId =  reviewItemIdreviewIditemId.randomUUID();
		this.record = record;
	}

	public ReviewItemDecorator (UUID reviewItemIdUUID reviewIdUUID itemId, ReviewItemComponent record) {
		this.reviewItemIdreviewIditemId =  reviewItemIdreviewIditemId;
		this.record = record;
	}
	
	public ReviewItemDecorator (ReviewItemComponent record, String objectName) {
		this.reviewItemIdreviewIditemId =  reviewItemIdreviewIditemId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public ReviewItemDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
