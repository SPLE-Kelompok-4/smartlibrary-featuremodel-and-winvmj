package SmartLibrary.reviewmanagement.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface ReviewManagement {
	public UUID getReviewId();
	public void setReviewId(UUID reviewId);
	public UUID getUserId();
	public void setUserId(UUID userId);
	public String getName();
	public void setName(String name);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public EDate getUpdateAt();
	public void setUpdateAt(EDate updateAt);
	HashMap<String, Object> toHashMap();
}
