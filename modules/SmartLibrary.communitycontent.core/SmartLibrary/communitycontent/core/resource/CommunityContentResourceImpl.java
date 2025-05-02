package SmartLibrary.communitycontent.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.communitycontent.CommunityContentFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class CommunityContentResourceImpl extends CommunityContentResourceComponent{
	
	private CommunityContentServiceImpl communitycontentServiceImpl = new CommunityContentServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/communitycontent/save")
    public List<HashMap<String,Object>> saveCommunityContent(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CommunityContent communitycontent = createCommunityContent(vmjExchange);
		communitycontentRepository.saveObject(communitycontent);
		return getAllCommunityContent(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/communitycontent")
    public HashMap<String,Object> communitycontent(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CommunityContent result = communitycontentServiceImpl.createCommunityContent(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public CommunityContent createCommunityContent(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CommunityContent result = communitycontentServiceImpl.createCommunityContent(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public CommunityContent createCommunityContent(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CommunityContent result = communitycontentServiceImpl.createCommunityContent(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/communitycontent/update")
    public HashMap<String, Object> updateCommunityContent(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return communitycontentServiceImpl.updateCommunityContent(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/communitycontent/detail")
    public HashMap<String, Object> getCommunityContent(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communitycontentServiceImpl.getCommunityContent(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/communitycontent/list")
    public List<HashMap<String,Object>> getAllCommunityContent(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communitycontentServiceImpl.getAllCommunityContent(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/communitycontent/delete")
    public List<HashMap<String,Object>> deleteCommunityContent(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return communitycontentServiceImpl.deleteCommunityContent(requestBody);
	}


	
	public void createContent() {
		// TODO: implement this method
	}

	
	public void readContent() {
		// TODO: implement this method
	}

	
	public void updateContent() {
		// TODO: implement this method
	}

	
	public void deleteContent() {
		// TODO: implement this method
	}
}
