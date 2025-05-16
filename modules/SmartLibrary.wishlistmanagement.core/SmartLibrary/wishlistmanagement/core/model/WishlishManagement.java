package SmartLibrary.wishlistmanagement.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface WishlishManagement {
	public UUID getUserId();
	public void setUserId(UUID userId);
	public String getName();
	public void setName(String name);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public EDate getUpdateAt();
	public void setUpdateAt(EDate updateAt);
	public WishlistItemImpl getWishlistitemimpl();
	public void setWishlistitemimpl(WishlistItemImpl wishlistitemimpl);
	public UUID getWishlistItemId();
	public void setWishlistItemId(UUID wishlistItemId);
	public UUID getWishlistId();
	public void setWishlistId(UUID wishlistId);
	public UUID getItemId();
	public void setItemId(UUID itemId);
	public EDate getAddedItem();
	public void setAddedItem(EDate addedItem);
	HashMap<String, Object> toHashMap();
}
