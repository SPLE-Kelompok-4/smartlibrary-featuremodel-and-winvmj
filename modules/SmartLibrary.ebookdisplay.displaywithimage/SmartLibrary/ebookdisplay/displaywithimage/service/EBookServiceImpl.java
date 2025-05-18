package SmartLibrary.ebookdisplay.displaywithimage;

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
    
    public List<HashMap<String, Object>> saveEBookWithImage(VMJExchange exchange) {
        Map<String, Object> requestBody = exchange.getPayload();
        EBook ebook = createEBookWithImage(requestBody);
        Repository.saveObject(ebook);
        return getAllEBookWithImage(requestBody);
    }
    
    public EBook createEBookWithImage(Map<String, Object> requestBody) {
        EBook ebook = record.createEBook(requestBody);
        
        String image = (String) requestBody.get("image");
        if (image != null) {
            ebook = new EBookImpl((EBookComponent)ebook, image);
            Repository.saveObject(ebook);
        }
        
        return ebook;
    }
    
    public HashMap<String, Object> updateEBookWithImage(Map<String, Object> requestBody) {
        HashMap<String, Object> result = record.updateEBook(requestBody);
        
        if (result != null && requestBody.get("image") != null) {
            String idStr = (String) requestBody.get("bookID");
            UUID id = UUID.fromString(idStr);
            
            EBook ebook = Repository.getObject(id);
            if (ebook instanceof EBookImpl) {
                ((EBookImpl) ebook).setImage((String) requestBody.get("image"));
            } else {
                ebook = new EBookImpl((EBookComponent)ebook, (String) requestBody.get("image"));
            }
            
            Repository.updateObject(ebook);
            return ebook.toHashMap();
        }
        
        return result;
    }
    
    public HashMap<String, Object> getEBookWithImage(Map<String, Object> requestBody) {
        return record.getEBook(requestBody);
    }
    
    public List<HashMap<String, Object>> getAllEBookWithImage(Map<String, Object> requestBody) {
        return record.getAllEBook(requestBody);
    }
    
    public List<HashMap<String, Object>> deleteEBookWithImage(Map<String, Object> requestBody) {
        return record.deleteEBook(requestBody);
    }
}