package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewManagementService {
	ReviewManagement createReviewManagement(Map<String, Object> requestBody);
	ReviewManagement createReviewManagement(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getReviewManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveReviewManagement(Map<String, Object> requestBody);
    HashMap<String, Object> updateReviewManagement(Map<String, Object> requestBody);
    HashMap<String, Object> getReviewManagementById(int id);
    List<HashMap<String,Object>> getAllReviewManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteReviewManagement(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
