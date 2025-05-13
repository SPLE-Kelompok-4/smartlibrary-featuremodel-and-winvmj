package SmartLibrary.communitycontent.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface CommunityContent {
	public String getContentAuthor();
	public void setContentAuthor(String contentAuthor);
	public UUID getContentID();
	public void setContentID(UUID contentID);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public EDate getUpdatedAt();
	public void setUpdatedAt(EDate updatedAt);
	HashMap<String, Object> toHashMap();
}
