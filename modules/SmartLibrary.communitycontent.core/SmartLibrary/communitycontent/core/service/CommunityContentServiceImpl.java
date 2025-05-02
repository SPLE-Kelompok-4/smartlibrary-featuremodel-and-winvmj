package SmartLibrary.communitycontent.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.communitycontent.CommunityContentFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CommunityContentServiceImpl extends CommunityContentServiceComponent{

    public List<HashMap<String,Object>> saveCommunityContent(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CommunityContent communitycontent = createCommunityContent(vmjExchange);
		communitycontentRepository.saveObject(communitycontent);
		return getAllCommunityContent(vmjExchange);
	}

    public CommunityContent createCommunityContent(Map<String, Object> requestBody){
		String contentAuthor = (String) requestBody.get("contentAuthor");
		
		//to do: fix association attributes
		CommunityContent CommunityContent = CommunityContentFactory.createCommunityContent(
			"SmartLibrary.communitycontent.core.CommunityContentImpl",
		contentAuthor
		, contentID
		, createdAt
		, updatedAt
		);
		Repository.saveObject(communitycontent);
		return communitycontent;
	}

    public CommunityContent createCommunityContent(Map<String, Object> requestBody, int id){
		String contentAuthor = (String) vmjExchange.getRequestBodyForm("contentAuthor");
		
		//to do: fix association attributes
		
		CommunityContent communitycontent = CommunityContentFactory.createCommunityContent("SmartLibrary.communitycontent.core.CommunityContentImpl", contentAuthor, contentID, createdAt, updatedAt);
		return communitycontent;
	}

    public HashMap<String, Object> updateCommunityContent(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		CommunityContent communitycontent = Repository.getObject(id);
		
		communitycontent.setContentAuthor((String) requestBody.get("contentAuthor"));
		
		Repository.updateObject(communitycontent);
		
		//to do: fix association attributes
		
		return communitycontent.toHashMap();
		
	}

    public HashMap<String, Object> getCommunityContent(Map<String, Object> requestBody){
		List<HashMap<String, Object>> communitycontentList = getAllCommunityContent("communitycontent_impl");
		for (HashMap<String, Object> communitycontent : communitycontentList){
			int record_id = ((Double) communitycontent.get("record_id")).intValue();
			if (record_id == id){
				return communitycontent;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCommunityContentById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		CommunityContent communitycontent = communitycontentRepository.getObject(id);
		return communitycontent.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCommunityContent(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<CommunityContent> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CommunityContent> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCommunityContent(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCommunityContent(requestBody);
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
