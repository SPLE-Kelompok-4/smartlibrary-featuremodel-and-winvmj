package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewItemService {
	ReviewItem createReviewItem(Map<String, Object> requestBody);
	HashMap<String, Object> getReviewItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveReviewItem(Map<String, Object> requestBody);
    HashMap<String, Object> updateReviewItem(Map<String, Object> requestBody);
    HashMap<String, Object> getReviewItemById(int id);
    List<HashMap<String,Object>> getAllReviewItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteReviewItem(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<ReviewItem> list);
}
