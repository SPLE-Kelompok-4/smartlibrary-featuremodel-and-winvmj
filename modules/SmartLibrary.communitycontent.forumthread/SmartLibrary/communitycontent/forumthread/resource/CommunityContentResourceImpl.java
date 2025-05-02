package SmartLibrary.communitycontent.forumthread;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.communitycontent.core.CommunityContentResourceDecorator;
import SmartLibrary.communitycontent.core.CommunityContentImpl;
import SmartLibrary.communitycontent.core.CommunityContentResourceComponent;

public class CommunityContentResourceImpl extends CommunityContentResourceDecorator {
    public CommunityContentResourceImpl (CommunityContentResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/forumthread/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CommunityContentForumThread communitycontentforumthread = createCommunityContentForumThread(vmjExchange);
		communitycontentforumthreadRepository.saveObject(communitycontentforumthread);
		return getAllCommunityContentForumThread(vmjExchange);
	}

    public CommunityContent createCommunityContentForumThread(VMJExchange vmjExchange){
		String topic = (String) vmjExchange.getRequestBodyForm("topic");
		String initialPost = (String) vmjExchange.getRequestBodyForm("initialPost");
		
		CommunityContentForumThread communitycontentforumthread = record.createCommunityContentForumThread(vmjExchange);
		CommunityContentForumThread communitycontentforumthreaddeco = CommunityContentForumThreadFactory.createCommunityContentForumThread("SmartLibrary.forumthread.core.CommunityContentImpl", communitycontentforumthread, contentAuthor, contentID, createdAt, updatedAt
		topic, initialPost, replies
		);
			return communitycontentforumthreaddeco;
	}


    public CommunityContent createCommunityContentForumThread(VMJExchange vmjExchange, int id){
		String topic = (String) vmjExchange.getRequestBodyForm("topic");
		String initialPost = (String) vmjExchange.getRequestBodyForm("initialPost");
		CommunityContentForumThread communitycontentforumthread = communitycontentforumthreadRepository.getObject(id);
		int recordCommunityContentForumThreadId = (((CommunityContentForumThreadDecorator) savedCommunityContentForumThread.getRecord()).getId();
		
		CommunityContentForumThread communitycontentforumthread = record.createCommunityContentForumThread(vmjExchange);
		CommunityContentForumThread communitycontentforumthreaddeco = CommunityContentForumThreadFactory.createCommunityContentForumThread("SmartLibrary.forumthread.core.CommunityContentImpl", id, communitycontentforumthread, contentAuthor, contentID, createdAt, updatedAt
		topic, initialPost, replies
		);
			return communitycontentforumthreaddeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/forumthread/update")
    public HashMap<String, Object> updateCommunityContentForumThread(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		CommunityContentForumThread communitycontentforumthread = communitycontentforumthreadRepository.getObject(id);
		communitycontentforumthread = createCommunityContentForumThread(vmjExchange, id);
		
		communitycontentforumthreadRepository.updateObject(communitycontentforumthread);
		communitycontentforumthread = communitycontentforumthreadRepository.getObject(id);
		//to do: fix association attributes
		
		return communitycontentforumthread.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/forumthread/detail")
    public HashMap<String, Object> getCommunityContentForumThread(VMJExchange vmjExchange){
		return record.getCommunityContentForumThread(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/forumthread/list")
    public List<HashMap<String,Object>> getAllCommunityContentForumThread(VMJExchange vmjExchange){
		List<CommunityContentForumThread> communitycontentforumthreadList = communitycontentforumthreadRepository.getAllObject("communitycontentforumthread_impl");
		return transformCommunityContentForumThreadListToHashMap(communitycontentforumthreadList);
	}

    public List<HashMap<String,Object>> transformCommunityContentForumThreadListToHashMap(List<CommunityContentForumThread> CommunityContentForumThreadList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < CommunityContentForumThreadList.size(); i++) {
            resultList.add(CommunityContentForumThreadList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/forumthread/delete")
    public List<HashMap<String,Object>> deleteCommunityContentForumThread(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		communitycontentforumthreadRepository.deleteObject(id);
		return getAllCommunityContentForumThread(vmjExchange);
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
