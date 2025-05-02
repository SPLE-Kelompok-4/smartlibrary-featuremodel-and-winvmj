package SmartLibrary.ebookaccess.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EBookAccessService {
	EBookAccess createEBookAccess(Map<String, Object> requestBody);
	EBookAccess createEBookAccess(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getEBookAccess(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveEBookAccess(Map<String, Object> requestBody);
    HashMap<String, Object> updateEBookAccess(Map<String, Object> requestBody);
    HashMap<String, Object> getEBookAccessById(int id);
    List<HashMap<String,Object>> getAllEBookAccess(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteEBookAccess(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
