package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ReviewItemResourceDecorator extends ReviewItemResourceComponent{
	protected ReviewItemResourceComponent record;

    public ReviewItemResourceDecorator(ReviewItemResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveReviewItemImpl(VMJExchange vmjExchange){
		return record.saveReviewItemImpl(vmjExchange);
	}

    public ReviewItemImpl createReviewItemImpl(VMJExchange vmjExchange){
		return record.createReviewItemImpl(vmjExchange);
	}

    public ReviewItemImpl createReviewItemImpl(VMJExchange vmjExchange, int id){
		return record.createReviewItemImpl(vmjExchange, id);
	}

    public HashMap<String, Object> updateReviewItemImpl(VMJExchange vmjExchange){
		return record.updateReviewItemImpl(vmjExchange);
	}

    public HashMap<String, Object> getReviewItemImpl(VMJExchange vmjExchange){
		return record.getReviewItemImpl(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllReviewItemImpl(VMJExchange vmjExchange){
		return record.getAllReviewItemImpl(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteReviewItemImpl(VMJExchange vmjExchange){
		return record.deleteReviewItemImpl(vmjExchange);
	}

}
