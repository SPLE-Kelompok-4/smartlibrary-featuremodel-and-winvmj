package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewItemResource {
    List<HashMap<String,Object>> saveReviewItem(VMJExchange vmjExchange);
    HashMap<String, Object> updateReviewItem(VMJExchange vmjExchange);
    HashMap<String, Object> getReviewItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReviewItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReviewItem(VMJExchange vmjExchange);
	HashMap<String, Object> ReviewItem(VMJExchange vmjExhange);
}
