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

	 public ReviewItemDecorator() {
        super();
    }
    
    public ReviewItemDecorator(ReviewItemComponent record) {
        super();
        this.record = record;
        this.reviewItemId = UUID.randomUUID();
    }
    
    public ReviewItemDecorator(UUID reviewItemId, UUID reviewId, UUID itemId, ReviewItemComponent record) {
        super();
        this.reviewItemId = reviewItemId;
        this.reviewId = reviewId;
        this.itemId = itemId;
        this.record = record;
    }
    
    public ReviewItemDecorator(ReviewItemComponent record, String objectName) {
        super();
        this.record = record;
        this.reviewItemId = UUID.randomUUID();
        this.objectName = objectName;
    }

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
