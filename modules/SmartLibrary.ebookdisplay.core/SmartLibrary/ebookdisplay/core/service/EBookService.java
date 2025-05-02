package SmartLibrary.ebookdisplay.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EBookService {
	EBook createEBook(Map<String, Object> requestBody);
	EBook createEBook(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getEBook(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveEBook(Map<String, Object> requestBody);
    HashMap<String, Object> updateEBook(Map<String, Object> requestBody);
    HashMap<String, Object> getEBookById(int id);
    List<HashMap<String,Object>> getAllEBook(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteEBook(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
