package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewManagementServiceComponent implements ReviewManagementService{
	protected RepositoryUtil<ReviewManagement> Repository;

    public ReviewManagementServiceComponent(){
        this.Repository = new RepositoryUtil<ReviewManagement>(SmartLibrary.reviewmanagement.core.ReviewManagementComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveReviewManagement(VMJExchange vmjExchange);
    public abstract ReviewManagement createReviewManagement(Map<String, Object> requestBodye);
	public abstract ReviewManagement createReviewManagement(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateReviewManagement(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReviewManagement(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllReviewManagement(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<ReviewManagement> List);
    public abstract List<HashMap<String,Object>> deleteReviewManagement(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReviewManagementById(int id);

	public abstract void addReview(Item );

	public abstract void removeReview(UUID itemId);

	public abstract void getReviews();
}
