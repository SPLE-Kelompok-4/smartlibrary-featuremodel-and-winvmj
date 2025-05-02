package SmartLibrary.communitycontent.article;
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
    @Route(url="call/article/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CommunityContentArticle communitycontentarticle = createCommunityContentArticle(vmjExchange);
		communitycontentarticleRepository.saveObject(communitycontentarticle);
		return getAllCommunityContentArticle(vmjExchange);
	}

    public CommunityContent createCommunityContentArticle(VMJExchange vmjExchange){
		String articleTitle = (String) vmjExchange.getRequestBodyForm("articleTitle");
		String body = (String) vmjExchange.getRequestBodyForm("body");
		
		CommunityContentArticle communitycontentarticle = record.createCommunityContentArticle(vmjExchange);
		CommunityContentArticle communitycontentarticledeco = CommunityContentArticleFactory.createCommunityContentArticle("SmartLibrary.article.core.CommunityContentImpl", communitycontentarticle, contentAuthor, contentID, createdAt, updatedAt
		articleTitle, body
		);
			return communitycontentarticledeco;
	}


    public CommunityContent createCommunityContentArticle(VMJExchange vmjExchange, int id){
		String articleTitle = (String) vmjExchange.getRequestBodyForm("articleTitle");
		String body = (String) vmjExchange.getRequestBodyForm("body");
		CommunityContentArticle communitycontentarticle = communitycontentarticleRepository.getObject(id);
		int recordCommunityContentArticleId = (((CommunityContentArticleDecorator) savedCommunityContentArticle.getRecord()).getId();
		
		CommunityContentArticle communitycontentarticle = record.createCommunityContentArticle(vmjExchange);
		CommunityContentArticle communitycontentarticledeco = CommunityContentArticleFactory.createCommunityContentArticle("SmartLibrary.article.core.CommunityContentImpl", id, communitycontentarticle, contentAuthor, contentID, createdAt, updatedAt
		articleTitle, body
		);
			return communitycontentarticledeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/article/update")
    public HashMap<String, Object> updateCommunityContentArticle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		CommunityContentArticle communitycontentarticle = communitycontentarticleRepository.getObject(id);
		communitycontentarticle = createCommunityContentArticle(vmjExchange, id);
		
		communitycontentarticleRepository.updateObject(communitycontentarticle);
		communitycontentarticle = communitycontentarticleRepository.getObject(id);
		//to do: fix association attributes
		
		return communitycontentarticle.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/article/detail")
    public HashMap<String, Object> getCommunityContentArticle(VMJExchange vmjExchange){
		return record.getCommunityContentArticle(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/article/list")
    public List<HashMap<String,Object>> getAllCommunityContentArticle(VMJExchange vmjExchange){
		List<CommunityContentArticle> communitycontentarticleList = communitycontentarticleRepository.getAllObject("communitycontentarticle_impl");
		return transformCommunityContentArticleListToHashMap(communitycontentarticleList);
	}

    public List<HashMap<String,Object>> transformCommunityContentArticleListToHashMap(List<CommunityContentArticle> CommunityContentArticleList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < CommunityContentArticleList.size(); i++) {
            resultList.add(CommunityContentArticleList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/article/delete")
    public List<HashMap<String,Object>> deleteCommunityContentArticle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		communitycontentarticleRepository.deleteObject(id);
		return getAllCommunityContentArticle(vmjExchange);
	}

	public void createContent(String title, String body) {
		// TODO: implement this method
	}

	public void updateContent(UUID contentID, String body) {
		// TODO: implement this method
	}
	
}
