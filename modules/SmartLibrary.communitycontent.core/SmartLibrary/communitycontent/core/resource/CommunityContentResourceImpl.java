package SmartLibrary.communitycontent.core;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import prices.auth.vmj.annotations.Restricted;

public class CommunityContentResourceImpl extends CommunityContentResourceComponent {
	
	private CommunityContentServiceImpl communitycontentServiceImpl = new CommunityContentServiceImpl();
	
	// @Restricted(permission = "")
    @Route(url="call/communitycontent/save")
    public List<HashMap<String,Object>> saveCommunityContent(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return saveCommunityContent(vmjExchange);
	}
	
	// @Restricted(permission = "")
    @Route(url="call/communitycontent")
    public HashMap<String,Object> createCommunityContent(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CommunityContent result = communitycontentServiceImpl.createCommunityContent(requestBody, new HashMap<>());
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
    
    // @Override
    // public CommunityContent createCommunityContent(VMJExchange vmjExchange) {
    //     // Implementation of the required abstract method
    //     return createCommunityContent(vmjExchange);
    // }
    
    // public CommunityContent createCommunityContent(VMJExchange vmjExchange) {
	// 	if (vmjExchange.getHttpMethod().equals("POST")) {
	// 	    Map<String, Object> requestBody = vmjExchange.getPayload(); 
	// 		CommunityContent result = communitycontentServiceImpl.createCommunityContent(requestBody, new HashMap<>());
	// 		// Fix return type - assuming toHashMap() doesn't exist or returns wrong type
	// 		return result;
	// 	}
	// 	throw new NotFoundException("Route tidak ditemukan");
	// }
    
	
	// @Restricted(permission = "")
    @Route(url="call/communitycontent/update")
    public HashMap<String, Object> updateCommunityContent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return communitycontentServiceImpl.updateCommunityContent(requestBody);
	}
	
	// @Restricted(permission = "")
    @Route(url="call/communitycontent/detail")
    public HashMap<String, Object> getCommunityContent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communitycontentServiceImpl.getCommunityContent(requestBody);
	}
	
	// @Restricted(permission = "")
    @Route(url="call/communitycontent/list")
    public List<HashMap<String,Object>> getAllCommunityContent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communitycontentServiceImpl.getAllCommunityContent(requestBody);
	}
	
	// @Restricted(permission = "")
    @Route(url="call/communitycontent/delete")
    public List<HashMap<String,Object>> deleteCommunityContent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return communitycontentServiceImpl.deleteCommunityContent(requestBody);
	}

}