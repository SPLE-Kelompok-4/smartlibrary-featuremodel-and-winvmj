package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewItemServiceComponent implements ReviewItemService{
	protected RepositoryUtil<ReviewItem> Repository;

    public ReviewItemServiceComponent(){
        this.Repository = new RepositoryUtil<ReviewItem>(SmartLibrary.reviewmanagement.core.ReviewItemComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveReviewItem(VMJExchange vmjExchange);
    public abstract ReviewItem createReviewItem(Map<String, Object> requestBodye);
	public abstract HashMap<String, Object> updateReviewItem(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReviewItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllReviewItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<ReviewItem> List);
    public abstract List<HashMap<String,Object>> deleteReviewItem(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReviewItemById(int id);

}
