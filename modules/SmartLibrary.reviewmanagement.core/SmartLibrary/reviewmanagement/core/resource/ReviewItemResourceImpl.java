package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.reviewmanagement.ReviewItemFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class ReviewItemResourceImpl extends ReviewItemResourceComponent{
	
	private ReviewItemServiceImpl reviewitemimplServiceImpl = new ReviewItemServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/save")
    public List<HashMap<String,Object>> saveReviewItemImpl(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ReviewItemImpl reviewitemimpl = createReviewItemImpl(vmjExchange);
		reviewitemimplRepository.saveObject(reviewitemimpl);
		return getAllReviewItemImpl(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement")
    public HashMap<String,Object> reviewitemimpl(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewItemImpl result = reviewitemimplServiceImpl.createReviewItemImpl(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public ReviewItemImpl createReviewItemImpl(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewItemImpl result = reviewitemimplServiceImpl.createReviewItemImpl(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public ReviewItemImpl createReviewItemImpl(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewItemImpl result = reviewitemimplServiceImpl.createReviewItemImpl(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/update")
    public HashMap<String, Object> updateReviewItemImpl(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reviewitemimplServiceImpl.updateReviewItemImpl(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/detail")
    public HashMap<String, Object> getReviewItemImpl(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewitemimplServiceImpl.getReviewItemImpl(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/list")
    public List<HashMap<String,Object>> getAllReviewItemImpl(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewitemimplServiceImpl.getAllReviewItemImpl(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewmanagement/delete")
    public List<HashMap<String,Object>> deleteReviewItemImpl(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reviewitemimplServiceImpl.deleteReviewItemImpl(requestBody);
	}


}
