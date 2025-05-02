package SmartLibrary.ebookaccess.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EBookAccessResource {
    List<HashMap<String,Object>> saveEBookAccess(VMJExchange vmjExchange);
    HashMap<String, Object> updateEBookAccess(VMJExchange vmjExchange);
    HashMap<String, Object> getEBookAccess(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllEBookAccess(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteEBookAccess(VMJExchange vmjExchange);
	HashMap<String, Object> EBookAccess(VMJExchange vmjExhange);
}
