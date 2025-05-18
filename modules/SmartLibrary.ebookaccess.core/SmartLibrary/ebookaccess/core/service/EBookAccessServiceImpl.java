package SmartLibrary.ebookaccess.core;

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
import SmartLibrary.ebookaccess.EBookAccessFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class EBookAccessServiceImpl extends EBookAccessServiceComponent {
    
    private EBookAccessFactory factory;
    private EBookAccessRepository repository;
    
    public EBookAccessServiceImpl() {
        this.factory = new EBookAccessFactory();
        this.repository = new EBookAccessRepository();
    }

    public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        Map<String, Object> requestBody = vmjExchange.getRequestBody();
        EBookAccess access = create(requestBody);
        repository.saveObject(access);
        return getAll(vmjExchange);
    }

    public EBookAccess create(Map<String, Object> requestBody) {
        // Extract parameters from request body
        boolean subscriptionPlan = (boolean) requestBody.getOrDefault("subscriptionPlan", false);
        boolean freeAccess = (boolean) requestBody.getOrDefault("freeAccess", false);
        boolean payPerBook = (boolean) requestBody.getOrDefault("payPerBook", false);
        
        // Create new access object
        EBookAccess access = factory.create(
            "SmartLibrary.ebookaccess.core.EBookAccessImpl",
            subscriptionPlan,
            freeAccess,
            payPerBook
        );
        
        repository.saveObject(access);
        return access;
    }

    public EBookAccess create(Map<String, Object> requestBody, int id) {
        // Extract parameters from request body
        boolean subscriptionPlan = (boolean) requestBody.getOrDefault("subscriptionPlan", false);
        boolean freeAccess = (boolean) requestBody.getOrDefault("freeAccess", false);
        boolean payPerBook = (boolean) requestBody.getOrDefault("payPerBook", false);
        
        // Create new access object with specific ID
        EBookAccess access = factory.create(
            "SmartLibrary.ebookaccess.core.EBookAccessImpl", 
            subscriptionPlan, 
            freeAccess, 
            payPerBook
        );
        
        // Set ID if needed
        if (access instanceof EBookAccessImpl) {
            ((EBookAccessImpl) access).setId(id);
        }
        
        return access;
    }

    public HashMap<String, Object> update(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("id");
        int id = Integer.parseInt(idStr);
        EBookAccess access = repository.getObject(id);
        
        if (access != null) {
            // Update fields based on request body
            if (requestBody.containsKey("subscriptionPlan")) {
                access.setSubscriptionPlan((boolean) requestBody.get("subscriptionPlan"));
            }
            
            if (requestBody.containsKey("freeAccess")) {
                access.setFreeAccess((boolean) requestBody.get("freeAccess"));
            }
            
            if (requestBody.containsKey("payPerBook")) {
                access.setPayPerBook((boolean) requestBody.get("payPerBook"));
            }
            
            repository.updateObject(access);
        }
        
        return access != null ? access.toHashMap() : null;
    }

    public HashMap<String, Object> get(Map<String, Object> requestBody) {
        int id = 0;
        if (requestBody.containsKey("id")) {
            id = ((Number) requestBody.get("id")).intValue();
        }
        
        List<HashMap<String, Object>> accessList = getAll("EBookAccessImpl");
        for (HashMap<String, Object> accessMap : accessList) {
            int record_id = ((Number) accessMap.get("record_id")).intValue();
            if (record_id == id) {
                return accessMap;
            }
        }
        return null;
    }

    public HashMap<String, Object> getById(VMJExchange vmjExchange) {
        String idStr = vmjExchange.getGETParam("id");
        int id = Integer.parseInt(idStr);
        EBookAccess access = repository.getObject(id);
        return access != null ? access.toHashMap() : null;
    }

    public List<HashMap<String, Object>> getAll(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getRequestBody();
        String tableName = (String) requestBody.getOrDefault("table_name", "EBookAccessImpl");
        return getAll(tableName);
    }
    
    public List<HashMap<String, Object>> getAll(String tableName) {
        List<EBookAccess> accessList = repository.getAllObjects(tableName);
        return transformListToHashMap(accessList);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<EBookAccess> accessList) {
        List<HashMap<String, Object>> resultList = new ArrayList<>();
        for (EBookAccess access : accessList) {
            resultList.add(access.toHashMap());
        }
        return resultList;
    }

    public List<HashMap<String, Object>> delete(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("id");
        int id = Integer.parseInt(idStr);
        repository.deleteObject(id);
        return getAll("EBookAccessImpl");
    }

    public void createAccess() {
        // TODO: implement this method as per requirements
    }
}