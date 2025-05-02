package SmartLibrary.reviewmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewItemImplResource {
    List<HashMap<String,Object>> saveReviewItemImpl(VMJExchange vmjExchange);
    HashMap<String, Object> updateReviewItemImpl(VMJExchange vmjExchange);
    HashMap<String, Object> getReviewItemImpl(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReviewItemImpl(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReviewItemImpl(VMJExchange vmjExchange);
	HashMap<String, Object> ReviewItemImpl(VMJExchange vmjExhange);
}
