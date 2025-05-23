package SmartLibrary.ebookdisplay.displaywithprice;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import SmartLibrary.ebookdisplay.core.EBookResourceDecorator;
import SmartLibrary.ebookdisplay.core.EBookServiceComponent;
import SmartLibrary.ebookdisplay.core.EBook;
import SmartLibrary.ebookdisplay.core.EBookResourceComponent;
import prices.auth.vmj.annotations.Restricted;

public class EBookResourceImpl extends EBookResourceDecorator {
    
    private EBookServiceImpl ebookServiceImpl;
    
    public EBookResourceImpl(EBookResourceComponent record, EBookServiceComponent ebookServiceImpl) {
        super(record);
        this.ebookServiceImpl = new EBookServiceImpl(ebookServiceImpl);
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithprice/save")
    public List<HashMap<String,Object>> saveEBookWithPrice(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        return ebookServiceImpl.saveEBookWithPrice(vmjExchange);
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithprice")
    public HashMap<String,Object> createEBookWithPrice(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload();
            String priceStr = (String) vmjExchange.getRequestBodyForm("price");
            if (priceStr != null && !priceStr.isEmpty()) {
                requestBody.put("price", priceStr);
            }
            
            EBook result = ebookServiceImpl.createEBookWithPrice(requestBody);
            return result.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithprice/update")
    public HashMap<String, Object> updateEBookWithPrice(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        Map<String, Object> requestBody = vmjExchange.getPayload();
        String priceStr = (String) vmjExchange.getRequestBodyForm("price");
        if (priceStr != null && !priceStr.isEmpty()) {
            requestBody.put("price", priceStr);
        }
        
        return ebookServiceImpl.updateEBookWithPrice(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithprice/detail")
    public HashMap<String, Object> getEBookWithPrice(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return ebookServiceImpl.getEBookWithPrice(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithprice/list")
    public List<HashMap<String,Object>> getAllEBookWithPrice(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return ebookServiceImpl.getAllEBookWithPrice(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url="call/displaywithprice/delete")
    public List<HashMap<String,Object>> deleteEBookWithPrice(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return ebookServiceImpl.deleteEBookWithPrice(requestBody);
    }
}