package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewItemResourceComponent implements ReviewItemResource{
	
	public ReviewItemResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveReviewItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> createReviewItem(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> createReviewItem(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateReviewItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReviewItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReviewItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReviewItem(VMJExchange vmjExchange);

}
