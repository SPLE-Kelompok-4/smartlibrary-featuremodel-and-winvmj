package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.reviewmanagement.ReviewItemFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class ReviewItemResourceImpl extends ReviewItemResourceComponent{
	
	private ReviewItemServiceImpl reviewitemServiceImpl = new ReviewItemServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/save")
    public List<HashMap<String,Object>> saveReviewItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return reviewitemServiceImpl.saveReviewItem(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement")
    public HashMap<String,Object> ReviewItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewItem result = reviewitemServiceImpl.createReviewItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public HashMap<String, Object> createReviewItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewItem result = reviewitemServiceImpl.createReviewItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public HashMap<String, Object> createReviewItem(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewItem result = reviewitemServiceImpl.createReviewItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/update")
    public HashMap<String, Object> updateReviewItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reviewitemServiceImpl.updateReviewItem(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/detail")
    public HashMap<String, Object> getReviewItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewitemServiceImpl.getReviewItem(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/list")
    public List<HashMap<String,Object>> getAllReviewItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewitemServiceImpl.getAllReviewItem(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/delete")
    public List<HashMap<String,Object>> deleteReviewItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reviewitemServiceImpl.deleteReviewItem(requestBody);
	}


}
