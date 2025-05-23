package SmartLibrary.ebookdisplay.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import SmartLibrary.ebookdisplay.core.EEList;

public interface EBook {
	public EDate getReleaseDate();
	public void setReleaseDate(EDate releaseDate);
	public String getDescription();
	public void setDescription(String description);
	public String getEBookTitle();
	public void setEBookTitle(String eBookTitle);
	public String getEBookAuthor();
	public void setEBookAuthor(String eBookAuthor);
	public UUID getBookID();
	public void setBookID(UUID bookID);
	public String getISBN();
	public void setISBN(String ISBN);
	public EEList getCategories();
	public void setCategories(EEList categories);
	// public EBookAccessImpl getEbookaccessimpl();
	// public void setEbookAccessImpl(EBookAccessImpl ebookaccessimpl);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	HashMap<String, Object> toHashMap();
}
