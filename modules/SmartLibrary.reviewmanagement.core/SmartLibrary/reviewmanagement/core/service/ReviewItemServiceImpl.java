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
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ReviewItemServiceImpl extends ReviewItemServiceComponent{

    public List<HashMap<String,Object>> saveReviewItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		ReviewItem reviewitem = createReviewItem(requestBody);
		Repository.saveObject(reviewitem);
		return getAllReviewItem(requestBody);
	}

	@Override
	public List<HashMap<String, Object>> saveReviewItem(Map<String, Object> requestBody) {
		ReviewItem reviewitem = createReviewItem(requestBody);
		Repository.saveObject(reviewitem);
		return getAllReviewItem(requestBody);
	}

    public ReviewItem createReviewItem(Map<String, Object> requestBody){
		String reviewId = (String) requestBody.get("reviewId");
		String itemId = (String) requestBody.get("itemId");
		String addedAt = (String) requestBody.get("addedAt");
		
		ReviewItem reviewitem = ReviewItemFactory.createReviewItem(
			"SmartLibrary.reviewmanagement.core.ReviewItemImpl",
			reviewId, itemId, addedAt
		);

		return reviewitem;
	}

    public HashMap<String, Object> updateReviewItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reviewIditemId");
		int id = Integer.parseInt(idStr);
		ReviewItem reviewitem = Repository.getObject(id);
		
		
		Repository.updateObject(reviewitem);
		
		//to do: fix association attributes
		
		return reviewitem.toHashMap();
		
	}

    public HashMap<String, Object> getReviewItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reviewIditemId");
		int id = Integer.parseInt(idStr);
		ReviewItem reviewitem = Repository.getObject(id);
		return reviewitem.toHashMap();
	}

	public HashMap<String, Object> getReviewItemById(int id){
		ReviewItem reviewitem = Repository.getObject(id);
		return reviewitem.toHashMap();
	}

    public List<HashMap<String,Object>> getAllReviewItem(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<ReviewItem> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ReviewItem> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReviewItem(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReviewItem(requestBody);
	}

}
