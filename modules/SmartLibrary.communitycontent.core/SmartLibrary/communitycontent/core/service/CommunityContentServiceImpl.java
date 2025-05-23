package SmartLibrary.communitycontent.core;
import java.util.*;
import com.google.gson.Gson;
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
// import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CommunityContentServiceImpl extends CommunityContentServiceComponent{

    public List<HashMap<String,Object>> saveCommunityContent(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		CommunityContent communitycontent = createCommunityContent(requestBody);
		Repository.saveObject(communitycontent);
		return getAllCommunityContent(requestBody);
	}

	@Override
	public List<HashMap<String,Object>> saveCommunityContent(Map<String, Object> requestBody) {
		CommunityContent communitycontent = createCommunityContent(requestBody);
		Repository.saveObject(communitycontent);
		return getAllCommunityContent(requestBody);
	}


    public CommunityContent createCommunityContent(Map<String, Object> requestBody){
		String contentAuthor = (String) requestBody.get("contentAuthor");

		
		//to do: fix association attributes
		CommunityContent communityContent = CommunityContentFactory.createCommunityContent(
			"SmartLibrary.communitycontent.core.CommunityContentImpl",
		contentAuthor
		);
		Repository.saveObject(communityContent);
		return communityContent;
	}

    public CommunityContent createCommunityContent(Map<String, Object> requestBody, Map<String, Object> response){
		return null;
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
		UUID id = UUID.fromString((String) requestBody.get("id"));
		Map<String,Object> req = new HashMap<>();
		req.put("table_name", "communitycontent_impl");

		List<HashMap<String,Object>> communitycontentList =
			getAllCommunityContent(req);
		for (HashMap<String, Object> communitycontent : communitycontentList){
			UUID record_id = (UUID) communitycontent.get("record_id");
			if (record_id == id){
				return communitycontent;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCommunityContentById(UUID id){
		CommunityContent communitycontent = Repository.getObject(id);
		return communitycontent.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCommunityContent(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<CommunityContent> list = Repository.getAllObject(table);
		return transformListToHashMap(list);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CommunityContent> list){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCommunityContent(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCommunityContent(requestBody);
	}

}
