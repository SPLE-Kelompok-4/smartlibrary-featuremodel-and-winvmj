package SmartLibrary.ebookaccess.core;
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
import SmartLibrary.ebookaccess.EBookAccessFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class EBookAccessServiceImpl extends EBookAccessServiceComponent{

    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public  create(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		  = Factory.create(
			"SmartLibrary.ebookaccess.core.EBookAccessImpl",
		subscriptionPlanP
		, freeAccess
		, payPerBook
		);
		Repository.saveObject();
		return ;
	}

    public  create(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		  = Factory.create("SmartLibrary.ebookaccess.core.EBookAccessImpl", subscriptionPlanP, freeAccess, payPerBook);
		return ;
	}

    public HashMap<String, Object> update(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		  = Repository.getObject(id);
		
		
		Repository.updateObject();
		
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

    public HashMap<String, Object> get(Map<String, Object> requestBody){
		List<HashMap<String, Object>> List = getAll("_impl");
		for (HashMap<String, Object>  : List){
			int record_id = ((Double) .get("record_id")).intValue();
			if (record_id == id){
				return ;
			}
		}
		return null;
	}

	public HashMap<String, Object> getById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		  = Repository.getObject(id);
		return .toHashMap();
	}

    public List<HashMap<String,Object>> getAll(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> delete(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(requestBody);
	}

	public void createAccess() {
		// TODO: implement this method
	}
}
