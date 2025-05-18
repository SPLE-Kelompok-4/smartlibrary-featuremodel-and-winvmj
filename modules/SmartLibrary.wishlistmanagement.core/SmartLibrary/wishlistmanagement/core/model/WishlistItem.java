package SmartLibrary.wishlistmanagement.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface WishlistItem {
	public UUID getWishlistId();
	public void setWishlistId(UUID wishlistId);
	public UUID getItemId();
	public void setItemId(UUID itemId);
	public EDate getAddedAt();
	public void setAddedAt(EDate addedAt);
	HashMap<String, Object> toHashMap();
}
