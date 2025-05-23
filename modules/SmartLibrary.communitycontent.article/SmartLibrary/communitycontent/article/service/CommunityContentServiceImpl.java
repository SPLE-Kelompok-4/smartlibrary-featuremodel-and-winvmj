package SmartLibrary.communitycontent.article;

import java.util.*;
import java.util.UUID;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

import SmartLibrary.communitycontent.core.CommunityContent;
import SmartLibrary.communitycontent.core.CommunityContentComponent;
import SmartLibrary.communitycontent.core.CommunityContentServiceComponent;
import SmartLibrary.communitycontent.core.CommunityContentServiceDecorator;

public class CommunityContentServiceImpl extends CommunityContentServiceDecorator {

	private RepositoryUtil<CommunityContent> repository = new RepositoryUtil<>(CommunityContentImpl.class);
	private CommunityContentComponent record;

	public CommunityContentServiceImpl(CommunityContentServiceComponent record) {
		super(record);
	}

	// public CommunityContentServiceImpl() {
	// super(null);
	// }

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
		String articleTitle = (String) requestBody.get("articleTitle");
		String body = (String) requestBody.get("body");

		CommunityContent communityContent = new CommunityContentImpl(
				record,
				articleTitle, body);

		repository.saveObject(communityContent);

		return communityContent;
	}

	@Override
	public HashMap<String, Object> updateCommunityContent(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id"));
		CommunityContent existing = repository.getObject(id);

		((CommunityContentImpl) existing).setArticleTitle((String) requestBody.get("articleTitle"));
		((CommunityContentImpl) existing).setBody((String) requestBody.get("body"));

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
		List<CommunityContent> list = repository.getAllObject("communitycontent_article");
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
