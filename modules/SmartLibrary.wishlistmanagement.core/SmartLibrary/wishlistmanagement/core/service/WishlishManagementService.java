package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlishManagementService {
	WishlishManagement createWishlishManagement(Map<String, Object> requestBody);
	WishlishManagement createWishlishManagement(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getWishlishManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveWishlishManagement(Map<String, Object> requestBody);
    HashMap<String, Object> updateWishlishManagement(Map<String, Object> requestBody);
    HashMap<String, Object> getWishlishManagementById(int id);
    List<HashMap<String,Object>> getAllWishlishManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteWishlishManagement(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
