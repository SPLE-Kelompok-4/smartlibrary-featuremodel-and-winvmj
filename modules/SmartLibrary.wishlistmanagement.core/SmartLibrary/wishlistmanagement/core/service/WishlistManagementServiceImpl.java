package SmartLibrary.wishlistmanagement.core;
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
import SmartLibrary.wishlistmanagement.WishlistManagementFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistManagementServiceImpl extends WishlistManagementServiceComponent{

    public List<HashMap<String,Object>> saveWishlishManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		WishlishManagement wishlishmanagement = createWishlishManagement(vmjExchange);
		wishlishmanagementRepository.saveObject(wishlishmanagement);
		return getAllWishlishManagement(vmjExchange);
	}

    public WishlishManagement createWishlishManagement(Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		
		//to do: fix association attributes
		WishlishManagement WishlishManagement = WishlishManagementFactory.createWishlishManagement(
			"SmartLibrary.wishlistmanagement.core.WishlistManagementImpl",
		wishlistId
		, userId
		, name
		, createdAt
		, updateAt
		, wishlistitemimpl
		);
		Repository.saveObject(wishlishmanagement);
		return wishlishmanagement;
	}

    public WishlishManagement createWishlishManagement(Map<String, Object> requestBody, int id){
		String name = (String) vmjExchange.getRequestBodyForm("name");
		
		//to do: fix association attributes
		
		WishlishManagement wishlishmanagement = WishlishManagementFactory.createWishlishManagement("SmartLibrary.wishlistmanagement.core.WishlistManagementImpl", wishlistId, userId, name, createdAt, updateAt, wishlistitemimpl);
		return wishlishmanagement;
	}

    public HashMap<String, Object> updateWishlishManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("wishlistIduserId");
		int id = Integer.parseInt(idStr);
		WishlishManagement wishlishmanagement = Repository.getObject(id);
		
		wishlishmanagement.setName((String) requestBody.get("name"));
		
		Repository.updateObject(wishlishmanagement);
		
		//to do: fix association attributes
		
		return wishlishmanagement.toHashMap();
		
	}

    public HashMap<String, Object> getWishlishManagement(Map<String, Object> requestBody){
		List<HashMap<String, Object>> wishlishmanagementList = getAllWishlishManagement("wishlishmanagement_impl");
		for (HashMap<String, Object> wishlishmanagement : wishlishmanagementList){
			int record_id = ((Double) wishlishmanagement.get("record_id")).intValue();
			if (record_id == id){
				return wishlishmanagement;
			}
		}
		return null;
	}

	public HashMap<String, Object> getWishlishManagementById(int id){
		String idStr = vmjExchange.getGETParam("wishlistIduserId"); 
		int id = Integer.parseInt(idStr);
		WishlishManagement wishlishmanagement = wishlishmanagementRepository.getObject(id);
		return wishlishmanagement.toHashMap();
	}

    public List<HashMap<String,Object>> getAllWishlishManagement(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<WishlishManagement> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<WishlishManagement> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteWishlishManagement(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllWishlishManagement(requestBody);
	}

	public void addItem(Item ) {
		// TODO: implement this method
	}

	public void removeItem(UUID itemId) {
		// TODO: implement this method
	}

	public void getItems() {
		// TODO: implement this method
	}
}
