package SmartLibrary.ebookaccess.payperbook;
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
    @Route(url="call/payperbook/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EBookAccessPayPerBook ebookaccesspayperbook = createEBookAccessPayPerBook(vmjExchange);
		ebookaccesspayperbookRepository.saveObject(ebookaccesspayperbook);
		return getAllEBookAccessPayPerBook(vmjExchange);
	}

    public EBookAccess createEBookAccessPayPerBook(VMJExchange vmjExchange){
		
		EBookAccessPayPerBook ebookaccesspayperbook = record.createEBookAccessPayPerBook(vmjExchange);
		EBookAccessPayPerBook ebookaccesspayperbookdeco = EBookAccessPayPerBookFactory.createEBookAccessPayPerBook("SmartLibrary.payperbook.core.EBookAccessImpl", ebookaccesspayperbook, subscriptionPlanP, freeAccess, payPerBook
		book, accessStamp
		);
			return ebookaccesspayperbookdeco;
	}


    public EBookAccess createEBookAccessPayPerBook(VMJExchange vmjExchange, int id){
		EBookAccessPayPerBook ebookaccesspayperbook = ebookaccesspayperbookRepository.getObject(id);
		int recordEBookAccessPayPerBookId = (((EBookAccessPayPerBookDecorator) savedEBookAccessPayPerBook.getRecord()).getId();
		
		EBookAccessPayPerBook ebookaccesspayperbook = record.createEBookAccessPayPerBook(vmjExchange);
		EBookAccessPayPerBook ebookaccesspayperbookdeco = EBookAccessPayPerBookFactory.createEBookAccessPayPerBook("SmartLibrary.payperbook.core.EBookAccessImpl", id, ebookaccesspayperbook, subscriptionPlanP, freeAccess, payPerBook
		book, accessStamp
		);
			return ebookaccesspayperbookdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/payperbook/update")
    public HashMap<String, Object> updateEBookAccessPayPerBook(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		EBookAccessPayPerBook ebookaccesspayperbook = ebookaccesspayperbookRepository.getObject(id);
		ebookaccesspayperbook = createEBookAccessPayPerBook(vmjExchange, id);
		
		ebookaccesspayperbookRepository.updateObject(ebookaccesspayperbook);
		ebookaccesspayperbook = ebookaccesspayperbookRepository.getObject(id);
		//to do: fix association attributes
		
		return ebookaccesspayperbook.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/payperbook/detail")
    public HashMap<String, Object> getEBookAccessPayPerBook(VMJExchange vmjExchange){
		return record.getEBookAccessPayPerBook(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/payperbook/list")
    public List<HashMap<String,Object>> getAllEBookAccessPayPerBook(VMJExchange vmjExchange){
		List<EBookAccessPayPerBook> ebookaccesspayperbookList = ebookaccesspayperbookRepository.getAllObject("ebookaccesspayperbook_impl");
		return transformEBookAccessPayPerBookListToHashMap(ebookaccesspayperbookList);
	}

    public List<HashMap<String,Object>> transformEBookAccessPayPerBookListToHashMap(List<EBookAccessPayPerBook> EBookAccessPayPerBookList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < EBookAccessPayPerBookList.size(); i++) {
            resultList.add(EBookAccessPayPerBookList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/payperbook/delete")
    public List<HashMap<String,Object>> deleteEBookAccessPayPerBook(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		ebookaccesspayperbookRepository.deleteObject(id);
		return getAllEBookAccessPayPerBook(vmjExchange);
	}

	public void createAccess(EBook ) {
		// TODO: implement this method
	}
	
}
