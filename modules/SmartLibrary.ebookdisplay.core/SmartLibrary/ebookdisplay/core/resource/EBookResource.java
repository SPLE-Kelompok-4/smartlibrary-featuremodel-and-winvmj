package SmartLibrary.ebookdisplay.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EBookResource {
    List<HashMap<String,Object>> saveEBook(VMJExchange vmjExchange);
    HashMap<String, Object> updateEBook(VMJExchange vmjExchange);
    HashMap<String, Object> getEBook(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllEBook(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteEBook(VMJExchange vmjExchange);
	HashMap<String, Object> EBook(VMJExchange vmjExhange);
}
