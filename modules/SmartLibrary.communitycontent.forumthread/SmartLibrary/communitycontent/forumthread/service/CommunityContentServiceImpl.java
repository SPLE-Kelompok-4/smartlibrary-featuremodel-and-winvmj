package SmartLibrary.communitycontent.forumthread;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import SmartLibrary.communitycontent.core.CommunityContentServiceDecorator;
import SmartLibrary.communitycontent.core.CommunityContent;
import SmartLibrary.communitycontent.core.CommunityContentServiceComponent;

public class CommunityContentServiceImpl extends CommunityContentServiceDecorator {
    // public CommunityContentServiceImpl (CommunityContentServiceComponent record) {
    //     super(record);
    // }

    
	// public void createContent(String topic, String initialPost) {
	// 	// TODO: implement this method
	// }

	// public void updateContent(UUID contentId, String topic, String initialPost) {
	// 	// TODO: implement this method
	// }

	// public void addReply(UUID contentId, String comment) {
	// 	// TODO: implement this method
	// }

	private RepositoryUtil<CommunityContent> repository = new RepositoryUtil<>(CommunityContentImpl.class);

	public CommunityContentServiceImpl(CommunityContentServiceComponent record) {
		super(record);
	}

	public CommunityContentServiceImpl() {
		super(null);
	}

	public List<HashMap<String, Object>> saveCommunityContent(VMJExchange exchange) {
		return saveCommunityContent(exchange.getPayload());
	}

	@Override
	public List<HashMap<String, Object>> saveCommunityContent(Map<String, Object> requestBody) {
		CommunityContent cc = createCommunityContent(requestBody);
		repository.saveObject(cc);
		return getAllCommunityContent(requestBody);
	}

	@Override
	public CommunityContent createCommunityContent(Map<String, Object> requestBody) {
		String topic = (String) requestBody.get("topic");
		String initialPost = (String) requestBody.get("initialPost");

		return new CommunityContentImpl(topic, initialPost);
	}

	@Override
	public HashMap<String, Object> updateCommunityContent(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id"));
		CommunityContent existing = repository.getObject(id);

		((CommunityContentImpl) existing).setTopic((String) requestBody.get("topic"));
		((CommunityContentImpl) existing).setInitialPost((String) requestBody.get("initialPost"));

		repository.updateObject(existing);
		return existing.toHashMap();
	}

	@Override
	public HashMap<String, Object> getCommunityContent(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id"));
		CommunityContent cc = repository.getObject(id);
		return cc.toHashMap();
	}

	@Override
	public List<HashMap<String, Object>> getAllCommunityContent(Map<String, Object> requestBody) {
		List<CommunityContent> list = repository.getAllObject("communitycontent_forumthread");
		List<HashMap<String, Object>> out = new ArrayList<>(list.size());
		for (CommunityContent cc : list) {
			out.add(cc.toHashMap());
		}
		return out;
	}

	@Override
	public List<HashMap<String, Object>> deleteCommunityContent(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id"));
		repository.deleteObject(id);
		return getAllCommunityContent(requestBody);
	}
}
