package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewManagementResourceComponent implements ReviewManagementResource{
	
	public ReviewManagementResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveReviewManagement(VMJExchange vmjExchange);
    public abstract ReviewManagement createReviewManagement(VMJExchange vmjExchange);
	public abstract ReviewManagement createReviewManagement(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateReviewManagement(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReviewManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReviewManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReviewManagement(VMJExchange vmjExchange);

	public abstract void addReview(Item );

	public abstract void removeReview(UUID itemId);

	public abstract void getReviews();
}
