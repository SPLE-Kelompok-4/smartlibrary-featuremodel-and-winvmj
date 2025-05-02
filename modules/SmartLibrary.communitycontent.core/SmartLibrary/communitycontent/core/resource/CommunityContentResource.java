package SmartLibrary.communitycontent.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CommunityContentResource {
    List<HashMap<String,Object>> saveCommunityContent(VMJExchange vmjExchange);
    HashMap<String, Object> updateCommunityContent(VMJExchange vmjExchange);
    HashMap<String, Object> getCommunityContent(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCommunityContent(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteCommunityContent(VMJExchange vmjExchange);
	HashMap<String, Object> CommunityContent(VMJExchange vmjExhange);
}
