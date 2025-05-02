package SmartLibrary.communitycontent.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CommunityContentService {
	CommunityContent createCommunityContent(Map<String, Object> requestBody);
	CommunityContent createCommunityContent(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getCommunityContent(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveCommunityContent(Map<String, Object> requestBody);
    HashMap<String, Object> updateCommunityContent(Map<String, Object> requestBody);
    HashMap<String, Object> getCommunityContentById(int id);
    List<HashMap<String,Object>> getAllCommunityContent(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteCommunityContent(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
