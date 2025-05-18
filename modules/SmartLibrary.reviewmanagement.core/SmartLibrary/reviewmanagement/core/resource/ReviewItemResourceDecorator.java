package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ReviewItemResourceDecorator extends ReviewItemResourceComponent{
	protected ReviewItemResourceComponent record;

    public ReviewItemResourceDecorator(ReviewItemResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveReviewItem(VMJExchange vmjExchange){
		return record.saveReviewItem(vmjExchange);
	}

    public HashMap<String, Object> createReviewItem(VMJExchange vmjExchange){
		return record.createReviewItem(vmjExchange);
	}

    public HashMap<String, Object> createReviewItem(VMJExchange vmjExchange, int id){
		return record.createReviewItem(vmjExchange, id);
	}

    public HashMap<String, Object> updateReviewItem(VMJExchange vmjExchange){
		return record.updateReviewItem(vmjExchange);
	}

    public HashMap<String, Object> getReviewItem(VMJExchange vmjExchange){
		return record.getReviewItem(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllReviewItem(VMJExchange vmjExchange){
		return record.getAllReviewItem(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteReviewItem(VMJExchange vmjExchange){
		return record.deleteReviewItem(vmjExchange);
	}

}
