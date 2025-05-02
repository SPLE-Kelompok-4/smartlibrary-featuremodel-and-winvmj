package SmartLibrary.reviewmanagement.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.reviewmanagement.ReviewItemFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ReviewItemServiceImpl extends ReviewItemServiceComponent{

    public List<HashMap<String,Object>> saveReviewItemImpl(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ReviewItemImpl reviewitemimpl = createReviewItemImpl(vmjExchange);
		reviewitemimplRepository.saveObject(reviewitemimpl);
		return getAllReviewItemImpl(vmjExchange);
	}

    public ReviewItemImpl createReviewItemImpl(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		ReviewItemImpl ReviewItemImpl = ReviewItemImplFactory.createReviewItemImpl(
			"SmartLibrary.reviewmanagement.core.ReviewItemImpl",
		reviewItemId
		, reviewId
		, itemId
		, addedAt
		);
		Repository.saveObject(reviewitemimpl);
		return reviewitemimpl;
	}

    public ReviewItemImpl createReviewItemImpl(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		ReviewItemImpl reviewitemimpl = ReviewItemImplFactory.createReviewItemImpl("SmartLibrary.reviewmanagement.core.ReviewItemImpl", reviewItemId, reviewId, itemId, addedAt);
		return reviewitemimpl;
	}

    public HashMap<String, Object> updateReviewItemImpl(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reviewItemIdreviewIditemId");
		int id = Integer.parseInt(idStr);
		ReviewItemImpl reviewitemimpl = Repository.getObject(id);
		
		
		Repository.updateObject(reviewitemimpl);
		
		//to do: fix association attributes
		
		return reviewitemimpl.toHashMap();
		
	}

    public HashMap<String, Object> getReviewItemImpl(Map<String, Object> requestBody){
		List<HashMap<String, Object>> reviewitemimplList = getAllReviewItemImpl("reviewitemimpl_impl");
		for (HashMap<String, Object> reviewitemimpl : reviewitemimplList){
			int record_id = ((Double) reviewitemimpl.get("record_id")).intValue();
			if (record_id == id){
				return reviewitemimpl;
			}
		}
		return null;
	}

	public HashMap<String, Object> getReviewItemImplById(int id){
		String idStr = vmjExchange.getGETParam("reviewItemIdreviewIditemId"); 
		int id = Integer.parseInt(idStr);
		ReviewItemImpl reviewitemimpl = reviewitemimplRepository.getObject(id);
		return reviewitemimpl.toHashMap();
	}

    public List<HashMap<String,Object>> getAllReviewItemImpl(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<ReviewItemImpl> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ReviewItemImpl> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReviewItemImpl(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReviewItemImpl(requestBody);
	}

}
