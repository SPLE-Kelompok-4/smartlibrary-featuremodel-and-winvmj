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
import SmartLibrary.reviewmanagement.ReviewManagementFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ReviewManagementServiceImpl extends ReviewManagementServiceComponent{

    public List<HashMap<String,Object>> saveReviewManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ReviewManagement reviewmanagement = createReviewManagement(vmjExchange);
		reviewmanagementRepository.saveObject(reviewmanagement);
		return getAllReviewManagement(vmjExchange);
	}

    public ReviewManagement createReviewManagement(Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		
		//to do: fix association attributes
		ReviewManagement ReviewManagement = ReviewManagementFactory.createReviewManagement(
			"SmartLibrary.reviewmanagement.core.ReviewManagementImpl",
		reviewId
		, userId
		, name
		, createdAt
		, reviewitemimpl
		, updateAt
		);
		Repository.saveObject(reviewmanagement);
		return reviewmanagement;
	}

    public ReviewManagement createReviewManagement(Map<String, Object> requestBody, int id){
		String name = (String) vmjExchange.getRequestBodyForm("name");
		
		//to do: fix association attributes
		
		ReviewManagement reviewmanagement = ReviewManagementFactory.createReviewManagement("SmartLibrary.reviewmanagement.core.ReviewManagementImpl", reviewId, userId, name, createdAt, reviewitemimpl, updateAt);
		return reviewmanagement;
	}

    public HashMap<String, Object> updateReviewManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reviewIduserId");
		int id = Integer.parseInt(idStr);
		ReviewManagement reviewmanagement = Repository.getObject(id);
		
		reviewmanagement.setName((String) requestBody.get("name"));
		
		Repository.updateObject(reviewmanagement);
		
		//to do: fix association attributes
		
		return reviewmanagement.toHashMap();
		
	}

    public HashMap<String, Object> getReviewManagement(Map<String, Object> requestBody){
		List<HashMap<String, Object>> reviewmanagementList = getAllReviewManagement("reviewmanagement_impl");
		for (HashMap<String, Object> reviewmanagement : reviewmanagementList){
			int record_id = ((Double) reviewmanagement.get("record_id")).intValue();
			if (record_id == id){
				return reviewmanagement;
			}
		}
		return null;
	}

	public HashMap<String, Object> getReviewManagementById(int id){
		String idStr = vmjExchange.getGETParam("reviewIduserId"); 
		int id = Integer.parseInt(idStr);
		ReviewManagement reviewmanagement = reviewmanagementRepository.getObject(id);
		return reviewmanagement.toHashMap();
	}

    public List<HashMap<String,Object>> getAllReviewManagement(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<ReviewManagement> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ReviewManagement> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReviewManagement(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReviewManagement(requestBody);
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
