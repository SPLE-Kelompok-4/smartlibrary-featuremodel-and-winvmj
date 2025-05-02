package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewItemImplService {
	ReviewItemImpl createReviewItemImpl(Map<String, Object> requestBody);
	ReviewItemImpl createReviewItemImpl(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getReviewItemImpl(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveReviewItemImpl(Map<String, Object> requestBody);
    HashMap<String, Object> updateReviewItemImpl(Map<String, Object> requestBody);
    HashMap<String, Object> getReviewItemImplById(int id);
    List<HashMap<String,Object>> getAllReviewItemImpl(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteReviewItemImpl(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
