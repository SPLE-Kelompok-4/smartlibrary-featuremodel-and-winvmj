package SmartLibrary.communitycontent.forumthread;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.communitycontent.core.CommunityContentResourceDecorator;
import SmartLibrary.communitycontent.core.CommunityContentImpl;
import SmartLibrary.communitycontent.core.CommunityContentResourceComponent;
import SmartLibrary.communitycontent.core.CommunityContent;

public class CommunityContentResourceImpl extends CommunityContentResourceDecorator {
	private CommunityContentServiceImpl communityContentServiceImpl;

    public CommunityContentResourceImpl (CommunityContentResourceComponent record) {
        super(record);
    }

	@Route(url="call/forumthread/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
        Map<String, Object> requestBody = vmjExchange.getPayload();

		CommunityContent result = communityContentServiceImpl.createCommunityContent(requestBody);
		List<HashMap<String, Object>> response = new ArrayList<>();
        response.add(result.toHashMap());
        return response;
	}

    // public CommunityContent createCommunityContentForumThread(VMJExchange vmjExchange){
	// 	String topic = (String) vmjExchange.getRequestBodyForm("topic");
	// 	String initialPost = (String) vmjExchange.getRequestBodyForm("initialPost");
		
	// 	CommunityContentForumThread communitycontentforumthread = record.createCommunityContentForumThread(vmjExchange);
	// 	CommunityContentForumThread communitycontentforumthreaddeco = CommunityContentForumThreadFactory.createCommunityContentForumThread("SmartLibrary.forumthread.core.CommunityContentImpl", communitycontentforumthread, contentAuthor, contentID, createdAt, updatedAt,
	// 	topic, initialPost, replies
	// 	);
	// 		return communitycontentforumthreaddeco;
	// }

	@Route(url="call/forumthread/create")
    public HashMap<String,Object> createCommunityContentForumThread(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CommunityContent result = communityContentServiceImpl.createCommunityContent(requestBody, new HashMap<>());
			return result.toHashMap();
		} else {
			return null;
		}
	}


    // public CommunityContent createCommunityContentForumThread(VMJExchange vmjExchange, int id){
	// 	String topic = (String) vmjExchange.getRequestBodyForm("topic");
	// 	String initialPost = (String) vmjExchange.getRequestBodyForm("initialPost");
	// 	CommunityContentForumThread communitycontentforumthread = Repository.getObject(id);
	// 	int recordCommunityContentForumThreadId = ((CommunityContentForumThreadDecorator) savedCommunityContentForumThread.getRecord()).getId();
		
	// 	communitycontentforumthread = record.createCommunityContentForumThread(vmjExchange);
	// 	CommunityContentForumThread communitycontentforumthreaddeco = CommunityContentForumThreadFactory.createCommunityContentForumThread("SmartLibrary.forumthread.core.CommunityContentImpl", id, communitycontentforumthread, contentAuthor, contentID, createdAt, updatedAt,
	// 	topic, initialPost, replies
	// 	);
	// 		return communitycontentforumthreaddeco;
	// }

	// @Restriced(permission = "")
    @Route(url="call/forumthread/update")
    public HashMap<String, Object> updateCommunityContentAForumThread(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communityContentServiceImpl.updateCommunityContent(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/forumthread/detail")
    public HashMap<String, Object> getCommunityContentAForumThread(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communityContentServiceImpl.getCommunityContent(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/forumthread/list")
    public List<HashMap<String,Object>> getAllCommunityContentForumThread(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communityContentServiceImpl.getAllCommunityContent(requestBody);
	}

    public List<HashMap<String,Object>> transformCommunityContentForumThreadListToHashMap(List<CommunityContent> list){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/forumthread/delete")
    public List<HashMap<String,Object>> deleteCommunityContentAForumThread(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communityContentServiceImpl.deleteCommunityContent(requestBody);
	}

	public void createContent(String topic, String initialPost) {
		// TODO: implement this method
	}

	public void updateContent(UUID contentId, String topic, String initialPost) {
		// TODO: implement this method
	}

	public void addReply(UUID contentId, String comment) {
		// TODO: implement this method
	}
	
}
