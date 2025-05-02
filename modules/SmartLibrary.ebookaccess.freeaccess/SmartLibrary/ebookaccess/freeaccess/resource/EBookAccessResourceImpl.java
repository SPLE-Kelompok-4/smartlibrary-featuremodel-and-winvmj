package SmartLibrary.ebookaccess.freeaccess;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.ebookaccess.core.EBookAccessResourceDecorator;
import SmartLibrary.ebookaccess.core.EBookAccessImpl;
import SmartLibrary.ebookaccess.core.EBookAccessResourceComponent;

public class EBookAccessResourceImpl extends EBookAccessResourceDecorator {
    public EBookAccessResourceImpl (EBookAccessResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/freeaccess/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EBookAccessFreeAccess ebookaccessfreeaccess = createEBookAccessFreeAccess(vmjExchange);
		ebookaccessfreeaccessRepository.saveObject(ebookaccessfreeaccess);
		return getAllEBookAccessFreeAccess(vmjExchange);
	}

    public EBookAccess createEBookAccessFreeAccess(VMJExchange vmjExchange){
		
		EBookAccessFreeAccess ebookaccessfreeaccess = record.createEBookAccessFreeAccess(vmjExchange);
		EBookAccessFreeAccess ebookaccessfreeaccessdeco = EBookAccessFreeAccessFactory.createEBookAccessFreeAccess("SmartLibrary.freeaccess.core.EBookAccessImpl", ebookaccessfreeaccess, subscriptionPlanP, freeAccess, payPerBook
		book
		);
			return ebookaccessfreeaccessdeco;
	}


    public EBookAccess createEBookAccessFreeAccess(VMJExchange vmjExchange, int id){
		EBookAccessFreeAccess ebookaccessfreeaccess = ebookaccessfreeaccessRepository.getObject(id);
		int recordEBookAccessFreeAccessId = (((EBookAccessFreeAccessDecorator) savedEBookAccessFreeAccess.getRecord()).getId();
		
		EBookAccessFreeAccess ebookaccessfreeaccess = record.createEBookAccessFreeAccess(vmjExchange);
		EBookAccessFreeAccess ebookaccessfreeaccessdeco = EBookAccessFreeAccessFactory.createEBookAccessFreeAccess("SmartLibrary.freeaccess.core.EBookAccessImpl", id, ebookaccessfreeaccess, subscriptionPlanP, freeAccess, payPerBook
		book
		);
			return ebookaccessfreeaccessdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/freeaccess/update")
    public HashMap<String, Object> updateEBookAccessFreeAccess(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		EBookAccessFreeAccess ebookaccessfreeaccess = ebookaccessfreeaccessRepository.getObject(id);
		ebookaccessfreeaccess = createEBookAccessFreeAccess(vmjExchange, id);
		
		ebookaccessfreeaccessRepository.updateObject(ebookaccessfreeaccess);
		ebookaccessfreeaccess = ebookaccessfreeaccessRepository.getObject(id);
		//to do: fix association attributes
		
		return ebookaccessfreeaccess.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/freeaccess/detail")
    public HashMap<String, Object> getEBookAccessFreeAccess(VMJExchange vmjExchange){
		return record.getEBookAccessFreeAccess(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/freeaccess/list")
    public List<HashMap<String,Object>> getAllEBookAccessFreeAccess(VMJExchange vmjExchange){
		List<EBookAccessFreeAccess> ebookaccessfreeaccessList = ebookaccessfreeaccessRepository.getAllObject("ebookaccessfreeaccess_impl");
		return transformEBookAccessFreeAccessListToHashMap(ebookaccessfreeaccessList);
	}

    public List<HashMap<String,Object>> transformEBookAccessFreeAccessListToHashMap(List<EBookAccessFreeAccess> EBookAccessFreeAccessList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < EBookAccessFreeAccessList.size(); i++) {
            resultList.add(EBookAccessFreeAccessList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/freeaccess/delete")
    public List<HashMap<String,Object>> deleteEBookAccessFreeAccess(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		ebookaccessfreeaccessRepository.deleteObject(id);
		return getAllEBookAccessFreeAccess(vmjExchange);
	}

	public void createAccess(EBook ) {
		// TODO: implement this method
	}
	
}
