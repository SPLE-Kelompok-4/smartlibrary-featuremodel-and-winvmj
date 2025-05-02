package SmartLibrary.ebookdisplay.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import SmartLibrary.ebookdisplay.EBookFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class EBookResourceImpl extends EBookResourceComponent{
	
	private EBookServiceImpl ebookServiceImpl = new EBookServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/ebookdisplay/save")
    public List<HashMap<String,Object>> saveEBook(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EBook ebook = createEBook(vmjExchange);
		ebookRepository.saveObject(ebook);
		return getAllEBook(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/ebookdisplay")
    public HashMap<String,Object> ebook(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			EBook result = ebookServiceImpl.createEBook(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public EBook createEBook(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			EBook result = ebookServiceImpl.createEBook(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public EBook createEBook(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			EBook result = ebookServiceImpl.createEBook(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/ebookdisplay/update")
    public HashMap<String, Object> updateEBook(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return ebookServiceImpl.updateEBook(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/ebookdisplay/detail")
    public HashMap<String, Object> getEBook(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return ebookServiceImpl.getEBook(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/ebookdisplay/list")
    public List<HashMap<String,Object>> getAllEBook(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return ebookServiceImpl.getAllEBook(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/ebookdisplay/delete")
    public List<HashMap<String,Object>> deleteEBook(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return ebookServiceImpl.deleteEBook(requestBody);
	}


}
