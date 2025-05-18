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

		// CONVERT PAYLOAD
		Map<String, Object> requestBody = vmjExchange.getPayload();

		
		// CREATE OBJECT
		EBookAccess eBookAccess = create(requestBody);
		Repository.saveObject(eBookAccess);
		return getAll(requestBody);
	}


    public EBookAccess create(Map<String, Object> requestBody){
		UUID subscriptionPlanP = (UUID) requestBody.get("subscriptionPlanP");
		boolean freeAccess = (boolean) requestBody.get("freeAccess");
		boolean payPerBook = (boolean) requestBody.get("payPerBook");

		//to do: fix association attributes
		//   = Factory.create("SmartLibrary.ebookaccess.core.EBookAccessImpl", subscriptionPlanP, freeAccess, payPerBook);
		EBookAccess eBookAccess = EBookAccessFactory.createEBookAccess(
			"SmartLibrary.ebookaccess.core.EBookAccessImpl",
			subscriptionPlanP, freeAccess, payPerBook
		);

		return eBookAccess;
	}


	public EBookAccess create(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		//   = Factory.create("SmartLibrary.ebookaccess.core.EBookAccessImpl", subscriptionPlanP, freeAccess, payPerBook);
		return null;
	}

    public HashMap<String, Object> update(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		EBookAccess eBookAccess = (EBookAccess) Repository.getObject(id);
		
		
		Repository.updateObject(eBookAccess);
		
		//to do: fix association attributes
		return eBookAccess.toHashMap();
		
	}

    public HashMap<String, Object> get(Map<String, Object> requestBody){
		List<HashMap<String, Object>> List = getAll("_impl");
		for (HashMap<String, Object> record : List){
			int record_id = ((Double) record.get("record_id")).intValue();
			if (record_id == id){
				return record;
			}
		}
		return null;
	}

	public HashMap<String, Object> getById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		id = Integer.parseInt(idStr);
		EBookAccess eBookAccess = (EBookAccess) Repository.getObject(id);
		return eBookAccess.toHashMap();
	}

	public List<HashMap<String,Object>> getAll(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<EBookAccess> list = Repository.getAllObject(table);
		return transformListToHashMap(list);
	}

	public List<HashMap<String,Object>> transformListToHashMap(List<EBookAccess> list){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
		for(int i = 0; i < list.size(); i++) {
			resultList.add(list.get(i).toHashMap());
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
