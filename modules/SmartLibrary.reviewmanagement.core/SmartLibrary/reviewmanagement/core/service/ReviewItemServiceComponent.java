package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewItemServiceComponent implements ReviewItemImplService{
	protected RepositoryUtil<ReviewItemImpl> Repository;

    public ReviewItemServiceComponent(){
        this.Repository = new RepositoryUtil<ReviewItemImpl>(SmartLibrary.reviewmanagement.core.ReviewItemComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveReviewItemImpl(VMJExchange vmjExchange);
    public abstract ReviewItemImpl createReviewItemImpl(Map<String, Object> requestBodye);
	public abstract ReviewItemImpl createReviewItemImpl(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateReviewItemImpl(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReviewItemImpl(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllReviewItemImpl(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<ReviewItemImpl> List);
    public abstract List<HashMap<String,Object>> deleteReviewItemImpl(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReviewItemImplById(int id);

}
