package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewItemResourceComponent implements ReviewItemImplResource{
	
	public ReviewItemResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveReviewItemImpl(VMJExchange vmjExchange);
    public abstract ReviewItemImpl createReviewItemImpl(VMJExchange vmjExchange);
	public abstract ReviewItemImpl createReviewItemImpl(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateReviewItemImpl(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReviewItemImpl(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReviewItemImpl(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReviewItemImpl(VMJExchange vmjExchange);

}
