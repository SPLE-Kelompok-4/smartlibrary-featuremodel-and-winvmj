package SmartLibrary.ebookdisplay.core;
import java.util.*;
import com.google.gson.Gson;
import java.time.LocalDate;
import java.time.ZoneId;
import SmartLibrary.ebookdisplay.core.EEList;
import SmartLibrary.ebookdisplay.core.EDate;
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

    // public List<HashMap<String,Object>> saveEBook(VMJExchange vmjExchange) {
    //     if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
    //         return null;
    //     }
        
    //     Map<String, Object> requestBody = vmjExchange.getRequestBody();
    //     EBook ebook = createEBook(requestBody);
    //     Repository.saveObject(ebook);
    //     return getAllEBook(requestBody);
    // }

    public EBook createEBook(Map<String, Object> requestBody){
		String description = (String) requestBody.get("description");
		String eBookTitle = (String) requestBody.get("eBookTitle");
		String eBookAuthor = (String) requestBody.get("eBookAuthor");
		String ISBN = (String) requestBody.get("ISBN");
		
		String releaseDateStr = (String) requestBody.get("releaseDate");
		LocalDate localDateValue = LocalDate.parse(releaseDateStr);
		long milliseconds = localDateValue.atStartOfDay(ZoneId.systemDefault())
										.toInstant()
										.toEpochMilli();
		EDate releaseDate = new EDate(milliseconds);

		UUID bookID = UUID.randomUUID();
		List<String> categories = new ArrayList<>(); // TODO: Need to fix this later maybe
		if (requestBody.get("categories") != null) {
			categories = (List<String>) requestBody.get("categories");
		}
		// Convert List<String> to EEList before passing to factory
		EEList categoriesEEList = new EEList(categories);

		if (requestBody.get("categories") != null) {
            categories = (List<String>) requestBody.get("categories");
        }
		// EBookAccessImpl ebookaccessimpl = null; // This should be retrieved or created
		Date createdAt = new Date();
		EBook ebook = EBookFactory.createEBook(
			"SmartLibrary.ebookdisplay.core.EBookImpl",
		releaseDate
		, description
		, eBookTitle
		, eBookAuthor
		, bookID
		, ISBN
		, categoriesEEList
		// , ebookaccessimpl
		, createdAt
		);
		Repository.saveObject(ebook);
		return ebook;
	}

	public EBook createEBook(Map<String, Object> requestBody, Map<String, Object> response) {   
		return null;
	}

    public HashMap<String, Object> updateEBook(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("bookID");
		if (idStr == null) {
			return null;
		}
		
		UUID id = UUID.fromString(idStr);
		EBook ebook = Repository.getObject(id);
		if (ebook == null) {
			return null;
		}
		
		if (requestBody.get("description") != null) {
			ebook.setDescription((String) requestBody.get("description"));
		}
		
		if (requestBody.get("eBookTitle") != null) {
			ebook.setEBookTitle((String) requestBody.get("eBookTitle"));
		}
		
		if (requestBody.get("eBookAuthor") != null) {
			ebook.setEBookAuthor((String) requestBody.get("eBookAuthor"));
		}
		
		if (requestBody.get("ISBN") != null) {
			ebook.setISBN((String) requestBody.get("ISBN"));
		}
		
		if (requestBody.get("releaseDate") != null) {
			String releaseDateStr = (String) requestBody.get("releaseDate");
			
			LocalDate localDateValue = LocalDate.parse(releaseDateStr);
			
			long milliseconds = localDateValue.atStartOfDay(ZoneId.systemDefault())
											.toInstant()
											.toEpochMilli();
			
			EDate releaseDate = new EDate(milliseconds);
			ebook.setReleaseDate(releaseDate);
		}

		if (requestBody.get("categories") != null) {
			List<String> categories = (List<String>) requestBody.get("categories");
			
			// Convert List<String> to EEList before setting
			EEList categoriesEEList = new EEList(categories);
			
			ebook.setCategories(categoriesEEList);
		}
		Repository.updateObject(ebook);
		return ebook.toHashMap();
	}

	public HashMap<String, Object> getEBook(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id"));
		Map<String, Object> req = new HashMap<>();
		req.put("table_name", "ebook_impl");
		
		List<HashMap<String, Object>> ebookList = getAllEBook(req);
		for (HashMap<String, Object> ebook : ebookList) {
			UUID record_id = (UUID) ebook.get("bookID");
			if (record_id.equals(id)) { 
				return ebook;
			}
		}
		return null;
	}

	public HashMap<String, Object> getEBookById(UUID id) {
		EBook ebook = Repository.getObject(id);
		return ebook != null ? ebook.toHashMap() : null;
	}

    public List<HashMap<String,Object>> getAllEBook(Map<String, Object> requestBody){
		String table = "ebook_impl";
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
		String idStr = ((String) requestBody.get("bookID"));
		UUID recordId = UUID.fromString(idStr);
		Repository.deleteObject(recordId);
		return getAllEBook(requestBody);
	}

}
