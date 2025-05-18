package SmartLibrary.ebookdisplay.displaywithprice;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import SmartLibrary.ebookdisplay.core.EBookServiceDecorator;
import SmartLibrary.ebookdisplay.core.EBook;
import SmartLibrary.ebookdisplay.core.EBookComponent;
import SmartLibrary.ebookdisplay.core.EBookServiceComponent;

public class EBookServiceImpl extends EBookServiceDecorator {
    
    public EBookServiceImpl(EBookServiceComponent record) {
        super(record);
    }
    
    public EBookServiceImpl() {
        super(null);
    }
    
    public List<HashMap<String, Object>> saveEBookWithPrice(VMJExchange exchange) {
        Map<String, Object> requestBody = exchange.getPayload();
        EBook ebook = createEBookWithPrice(requestBody);
        Repository.saveObject(ebook);
        return getAllEBookWithPrice(requestBody);
    }
    
    public EBook createEBookWithPrice(Map<String, Object> requestBody) {
        EBook ebook = record.createEBook(requestBody);
        
        String priceStr = (String) requestBody.get("price");
        if (priceStr != null) {
            double price = Double.parseDouble(priceStr);
            ebook = new EBookImpl((EBookComponent)ebook, price);
            Repository.saveObject(ebook);
        }
        
        return ebook;
    }
    
    public HashMap<String, Object> updateEBookWithPrice(Map<String, Object> requestBody) {
        HashMap<String, Object> result = record.updateEBook(requestBody);
        
        if (result != null && requestBody.get("price") != null) {
            String idStr = (String) requestBody.get("bookID");
            UUID id = UUID.fromString(idStr);
            
            EBook ebook = Repository.getObject(id);
            if (ebook instanceof EBookImpl) {
                double price = Double.parseDouble((String) requestBody.get("price"));
                ((EBookImpl) ebook).setPrice(price);
            } else {
                double price = Double.parseDouble((String) requestBody.get("price"));
                ebook = new EBookImpl((EBookComponent)ebook, price);
            }
            
            Repository.updateObject(ebook);
            return ebook.toHashMap();
        }
        
        return result;
    }
    
    public HashMap<String, Object> getEBookWithPrice(Map<String, Object> requestBody) {
        return record.getEBook(requestBody);
    }
    
    public List<HashMap<String, Object>> getAllEBookWithPrice(Map<String, Object> requestBody) {
        return record.getAllEBook(requestBody);
    }
    
    public List<HashMap<String, Object>> deleteEBookWithPrice(Map<String, Object> requestBody) {
        return record.deleteEBook(requestBody);
    }
}