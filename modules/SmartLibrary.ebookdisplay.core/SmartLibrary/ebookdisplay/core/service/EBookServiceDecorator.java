package SmartLibrary.ebookdisplay.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class EBookServiceDecorator extends EBookServiceComponent {
    protected EBookServiceComponent record;
    
    public EBookServiceDecorator(EBookServiceComponent record) {
        this.record = record;
    }

    // public List<HashMap<String,Object>> saveEBook(VMJExchange vmjExchange) {
    //     return record.saveEBook(vmjExchange);
    // }

    public EBook createEBook(Map<String, Object> requestBody) {
        return record.createEBook(requestBody);
    }

    public EBook createEBook(Map<String, Object> requestBody, Map<String, Object> response) {
        return record.createEBook(requestBody, response);
    }

    public HashMap<String, Object> updateEBook(Map<String, Object> requestBody) {
        return record.updateEBook(requestBody);
    }

    public HashMap<String, Object> getEBook(Map<String, Object> requestBody) {
        return record.getEBook(requestBody);
    }

    public List<HashMap<String,Object>> getAllEBook(Map<String, Object> requestBody) {
        return record.getAllEBook(requestBody);
    }

    public List<HashMap<String,Object>> transformListToHashMap(List<EBook> list) {
        return record.transformListToHashMap(list);
    }

    public List<HashMap<String,Object>> deleteEBook(Map<String, Object> requestBody) {
        return record.deleteEBook(requestBody);
    }

    public HashMap<String, Object> getEBookById(UUID id) {
        return record.getEBookById(id);
    }
}