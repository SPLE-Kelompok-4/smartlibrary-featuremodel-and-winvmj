package SmartLibrary.ebookdisplay.displaywithimage;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import SmartLibrary.ebookdisplay.core.EBookResourceDecorator;
import SmartLibrary.ebookdisplay.core.EBook;
import SmartLibrary.ebookdisplay.core.EBookResourceComponent;
import prices.auth.vmj.annotations.Restricted;

public class EBookResourceImpl extends EBookResourceDecorator {
    
    private EBookServiceImpl ebookServiceImpl;
    
    public EBookResourceImpl(EBookResourceComponent record) {
        super(record);
        this.ebookServiceImpl = new EBookServiceImpl();
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithimage/save")
    public List<HashMap<String,Object>> saveEBookWithImage(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        return ebookServiceImpl.saveEBookWithImage(vmjExchange);
    }

	// @Restricted(permission = "")
	// @Route(url="call/displaywithimage")
	// public EBook createEBookWithImage(Map<String, Object> requestBody) {
    //     // First create base ebook using the decorator pattern
    //     EBook ebook = record.createEBook(requestBody);
        
    //     // Then add image functionality
    //     String image = (String) requestBody.get("image");
    //     if (image != null) {
    //         ebook = new EBookImpl(ebook, image);
    //         Repository.saveObject(ebook);
    //     }
        
    //     return ebook;
    // }

    // @Restricted(permission = "")
    @Route(url="call/displaywithimage")
    public HashMap<String,Object> createEBookWithImage(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload();
            String image = (String) vmjExchange.getRequestBodyForm("image");
            requestBody.put("image", image);
            
            EBook result = ebookServiceImpl.createEBookWithImage(requestBody);
            return result.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithimage/update")
    public HashMap<String, Object> updateEBookWithImage(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        Map<String, Object> requestBody = vmjExchange.getPayload();
        String image = (String) vmjExchange.getRequestBodyForm("image");
        if (image != null && !image.isEmpty()) {
            requestBody.put("image", image);
        }
        
        return ebookServiceImpl.updateEBookWithImage(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithimage/detail")
    public HashMap<String, Object> getEBookWithImage(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return ebookServiceImpl.getEBookWithImage(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithimage/list")
    public List<HashMap<String,Object>> getAllEBookWithImage(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return ebookServiceImpl.getAllEBookWithImage(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithimage/delete")
    public List<HashMap<String,Object>> deleteEBookWithImage(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        return ebookServiceImpl.deleteEBookWithImage(requestBody);
    }
}