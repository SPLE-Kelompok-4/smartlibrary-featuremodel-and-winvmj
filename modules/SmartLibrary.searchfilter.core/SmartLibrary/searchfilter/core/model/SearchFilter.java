package SmartLibrary.searchfilter.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface SearchFilter {
	public EBookImpl getEbookimpl();
	public void setEbookimpl(EBookImpl ebookimpl);
	org.eclipse.uml2.uml.internal.impl.ClassImpl@65dbb82b (name: SearchFilterImpl, visibility: <unset>) (isLeaf: false, isAbstract: false, isFinalSpecialization: false) (isActive: false)
	HashMap<String, Object> toHashMap();
}
