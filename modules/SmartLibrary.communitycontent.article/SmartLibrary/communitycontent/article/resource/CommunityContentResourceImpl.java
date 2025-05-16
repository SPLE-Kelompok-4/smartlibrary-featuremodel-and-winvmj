package SmartLibrary.communitycontent.article;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.communitycontent.core.CommunityContentResourceDecorator;
import SmartLibrary.communitycontent.core.CommunityContentImpl;
import SmartLibrary.communitycontent.core.CommunityContent;
import SmartLibrary.communitycontent.core.CommunityContentResourceComponent;

public class CommunityContentResourceImpl extends CommunityContentResourceDecorator {
	private CommunityContentServiceImpl communityContentServiceImpl;

    public CommunityContentResourceImpl (CommunityContentResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/article/save")
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


	@Route(url="call/article/create")
    public HashMap<String,Object> createCommunityContentArticle(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CommunityContent result = communityContentServiceImpl.createCommunityContent(requestBody, new HashMap<>());
			return result.toHashMap();
		} else {
			return null;
		}
	}


    // public CommunityContent createCommunityContentArticle(VMJExchange vmjExchange, int id){
	// 	String articleTitle = (String) vmjExchange.getRequestBodyForm("articleTitle");
	// 	String body = (String) vmjExchange.getRequestBodyForm("body");
	// 	CommunityContentArticle communitycontentarticle = Repository.getObject(id);
	// 	int recordCommunityContentArticleId = ((CommunityContentArticleDecorator) savedCommunityContentArticle.getRecord()).getId();
		
	// 	communitycontentarticle = record.createCommunityContentArticle(vmjExchange);
	// 	CommunityContentArticle communitycontentarticledeco = CommunityContentArticleFactory.createCommunityContentArticle("SmartLibrary.article.core.CommunityContentImpl", id, communitycontentarticle, contentAuthor, contentID, createdAt, updatedAt,
	// 	articleTitle, body
	// 	);
	// 		return communitycontentarticledeco;
	// }

	// @Restriced(permission = "")
    @Route(url="call/article/update")
    public HashMap<String, Object> updateCommunityContentArticle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communityContentServiceImpl.updateCommunityContent(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/article/detail")
    public HashMap<String, Object> getCommunityContentArticle(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communityContentServiceImpl.getCommunityContent(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/article/list")
    public List<HashMap<String,Object>> getAllCommunityContentArticle(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communityContentServiceImpl.getAllCommunityContent(requestBody);
	}

    public List<HashMap<String,Object>> transformCommunityContentArticleListToHashMap(List<CommunityContent> list){
		return communityContentServiceImpl.transformListToHashMap(list);
	}

	// @Restriced(permission = "")
    @Route(url="call/article/delete")
    public List<HashMap<String,Object>> deleteCommunityContentArticle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return communityContentServiceImpl.deleteCommunityContent(requestBody);
	}

	public void createContent(String title, String body) {
		// TODO: implement this method
	}

	public void updateContent(UUID contentID, String body) {
		// TODO: implement this method
	}
	
}
