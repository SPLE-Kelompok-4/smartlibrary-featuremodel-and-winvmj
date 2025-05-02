package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ReviewManagementResourceDecorator extends ReviewManagementResourceComponent{
	protected ReviewManagementResourceComponent record;

    public ReviewManagementResourceDecorator(ReviewManagementResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveReviewManagement(VMJExchange vmjExchange){
		return record.saveReviewManagement(vmjExchange);
	}

    public ReviewManagement createReviewManagement(VMJExchange vmjExchange){
		return record.createReviewManagement(vmjExchange);
	}

    public ReviewManagement createReviewManagement(VMJExchange vmjExchange, int id){
		return record.createReviewManagement(vmjExchange, id);
	}

    public HashMap<String, Object> updateReviewManagement(VMJExchange vmjExchange){
		return record.updateReviewManagement(vmjExchange);
	}

    public HashMap<String, Object> getReviewManagement(VMJExchange vmjExchange){
		return record.getReviewManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllReviewManagement(VMJExchange vmjExchange){
		return record.getAllReviewManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteReviewManagement(VMJExchange vmjExchange){
		return record.deleteReviewManagement(vmjExchange);
	}

	public void addReview(Item ) {
		return record.addReview();
	}

	public void removeReview(UUID itemId) {
		return record.removeReview(itemId);
	}

	public void getReviews() {
		return record.getReviews();
	}
}
