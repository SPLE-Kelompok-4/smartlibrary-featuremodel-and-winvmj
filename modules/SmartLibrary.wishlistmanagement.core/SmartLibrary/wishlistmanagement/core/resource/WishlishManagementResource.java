package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlishManagementResource {
    List<HashMap<String,Object>> saveWishlishManagement(VMJExchange vmjExchange);
    HashMap<String, Object> updateWishlishManagement(VMJExchange vmjExchange);
    HashMap<String, Object> getWishlishManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllWishlishManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteWishlishManagement(VMJExchange vmjExchange);
	HashMap<String, Object> WishlishManagement(VMJExchange vmjExhange);
}
