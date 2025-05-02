package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.reviewmanagement.ReviewManagementFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class ReviewManagementResourceImpl extends ReviewManagementResourceComponent{
	
	private ReviewManagementServiceImpl reviewmanagementServiceImpl = new ReviewManagementServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/save")
    public List<HashMap<String,Object>> saveReviewManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ReviewManagement reviewmanagement = createReviewManagement(vmjExchange);
		reviewmanagementRepository.saveObject(reviewmanagement);
		return getAllReviewManagement(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement")
    public HashMap<String,Object> reviewmanagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewManagement result = reviewmanagementServiceImpl.createReviewManagement(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public ReviewManagement createReviewManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewManagement result = reviewmanagementServiceImpl.createReviewManagement(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public ReviewManagement createReviewManagement(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewManagement result = reviewmanagementServiceImpl.createReviewManagement(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/update")
    public HashMap<String, Object> updateReviewManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reviewmanagementServiceImpl.updateReviewManagement(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/detail")
    public HashMap<String, Object> getReviewManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewmanagementServiceImpl.getReviewManagement(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/list")
    public List<HashMap<String,Object>> getAllReviewManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewmanagementServiceImpl.getAllReviewManagement(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/delete")
    public List<HashMap<String,Object>> deleteReviewManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reviewmanagementServiceImpl.deleteReviewManagement(requestBody);
	}


	
	public void addReview(Item ) {
		// TODO: implement this method
	}

	
	public void removeReview(UUID itemId) {
		// TODO: implement this method
	}

	
	public void getReviews() {
		// TODO: implement this method
	}
}
