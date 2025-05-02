package SmartLibrary.ebookdisplay.core;
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
import SmartLibrary.ebookdisplay.EBookFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class EBookServiceImpl extends EBookServiceComponent{

    public List<HashMap<String,Object>> saveEBook(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EBook ebook = createEBook(vmjExchange);
		ebookRepository.saveObject(ebook);
		return getAllEBook(vmjExchange);
	}

    public EBook createEBook(Map<String, Object> requestBody){
		String description = (String) requestBody.get("description");
		String eBookTitle = (String) requestBody.get("eBookTitle");
		String eBookAuthor = (String) requestBody.get("eBookAuthor");
		String ISBN = (String) requestBody.get("ISBN");
		
		//to do: fix association attributes
		EBook EBook = EBookFactory.createEBook(
			"SmartLibrary.ebookdisplay.core.EBookImpl",
		releaseDate
		, description
		, eBookTitle
		, eBookAuthor
		, bookID
		, ISBN
		, categories
		, ebookaccessimpl
		, createdAt
		);
		Repository.saveObject(ebook);
		return ebook;
	}

    public EBook createEBook(Map<String, Object> requestBody, int id){
		String description = (String) vmjExchange.getRequestBodyForm("description");
		String eBookTitle = (String) vmjExchange.getRequestBodyForm("eBookTitle");
		String eBookAuthor = (String) vmjExchange.getRequestBodyForm("eBookAuthor");
		String ISBN = (String) vmjExchange.getRequestBodyForm("ISBN");
		
		//to do: fix association attributes
		
		EBook ebook = EBookFactory.createEBook("SmartLibrary.ebookdisplay.core.EBookImpl", releaseDate, description, eBookTitle, eBookAuthor, bookID, ISBN, categories, ebookaccessimpl, createdAt);
		return ebook;
	}

    public HashMap<String, Object> updateEBook(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		EBook ebook = Repository.getObject(id);
		
		ebook.setDescription((String) requestBody.get("description"));
		ebook.setEBookTitle((String) requestBody.get("eBookTitle"));
		ebook.setEBookAuthor((String) requestBody.get("eBookAuthor"));
		ebook.setISBN((String) requestBody.get("ISBN"));
		
		Repository.updateObject(ebook);
		
		//to do: fix association attributes
		
		return ebook.toHashMap();
		
	}

    public HashMap<String, Object> getEBook(Map<String, Object> requestBody){
		List<HashMap<String, Object>> ebookList = getAllEBook("ebook_impl");
		for (HashMap<String, Object> ebook : ebookList){
			int record_id = ((Double) ebook.get("record_id")).intValue();
			if (record_id == id){
				return ebook;
			}
		}
		return null;
	}

	public HashMap<String, Object> getEBookById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		EBook ebook = ebookRepository.getObject(id);
		return ebook.toHashMap();
	}

    public List<HashMap<String,Object>> getAllEBook(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<EBook> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<EBook> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteEBook(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllEBook(requestBody);
	}

}
