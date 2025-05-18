package SmartLibrary.reviewmanagement.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface ReviewItem {
	public UUID getReviewId();
	public void setReviewId(UUID reviewId);
	public UUID getItemId();
	public void setItemId(UUID itemId);
	public EDate getAddedAt();
	public void setAddedAt(EDate addedAt);
	HashMap<String, Object> toHashMap();
}
