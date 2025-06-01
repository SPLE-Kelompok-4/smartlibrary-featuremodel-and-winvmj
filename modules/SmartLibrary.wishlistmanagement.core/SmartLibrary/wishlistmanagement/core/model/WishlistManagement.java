package SmartLibrary.wishlistmanagement.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface WishlistManagement {
	public UUID getWishlistId();
	public void setWishlistId(UUID wishlistId);
	public String getName();
	public void setName(String name);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public EDate getUpdateAt();
	public void setUpdateAt(EDate updateAt);
	HashMap<String, Object> toHashMap();;
}
