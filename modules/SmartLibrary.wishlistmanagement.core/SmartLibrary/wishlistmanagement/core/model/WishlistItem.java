package SmartLibrary.wishlistmanagement.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface WishlistItem {
	public UUID getWishlistItemId(); 
    public void setWishlistItemId(UUID wishlistItemId);
	public String getItemName();
	public void setItemName(String itemName);
	public EDate getAddedAt();
	public void setAddedAt(EDate addedAt);
	HashMap<String, Object> toHashMap();
}
