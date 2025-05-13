package SmartLibrary.searchfilter.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface SearchFilter {
	public EBookImpl getEbookimpl();
	public void setEbookimpl(EBookImpl ebookimpl);
	HashMap<String, Object> toHashMap();
}
