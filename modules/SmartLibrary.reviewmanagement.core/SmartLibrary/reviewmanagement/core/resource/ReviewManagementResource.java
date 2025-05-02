package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewManagementResource {
    List<HashMap<String,Object>> saveReviewManagement(VMJExchange vmjExchange);
    HashMap<String, Object> updateReviewManagement(VMJExchange vmjExchange);
    HashMap<String, Object> getReviewManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReviewManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReviewManagement(VMJExchange vmjExchange);
	HashMap<String, Object> ReviewManagement(VMJExchange vmjExhange);
}
