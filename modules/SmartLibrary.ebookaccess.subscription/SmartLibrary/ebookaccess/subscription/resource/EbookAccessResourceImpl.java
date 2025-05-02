package SmartLibrary.ebookaccess.subscription;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.ebookaccess.core.EbookAccessResourceDecorator;
import SmartLibrary.ebookaccess.core.EbookAccessImpl;
import SmartLibrary.ebookaccess.core.EbookAccessResourceComponent;

public class EbookAccessResourceImpl extends EbookAccessResourceDecorator {
    public EbookAccessResourceImpl (EbookAccessResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/subscription/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EBookAccessSubscription ebookaccesssubscription = createEBookAccessSubscription(vmjExchange);
		ebookaccesssubscriptionRepository.saveObject(ebookaccesssubscription);
		return getAllEBookAccessSubscription(vmjExchange);
	}

    public EBookAccess createEBookAccessSubscription(VMJExchange vmjExchange){
		
		EBookAccessSubscription ebookaccesssubscription = record.createEBookAccessSubscription(vmjExchange);
		EBookAccessSubscription ebookaccesssubscriptiondeco = EBookAccessSubscriptionFactory.createEBookAccessSubscription("SmartLibrary.subscription.core.EbookAccessImpl", ebookaccesssubscription, subscriptionPlanP, freeAccess, payPerBook
		startDate, endDate
		);
			return ebookaccesssubscriptiondeco;
	}


    public EBookAccess createEBookAccessSubscription(VMJExchange vmjExchange, int id){
		EBookAccessSubscription ebookaccesssubscription = ebookaccesssubscriptionRepository.getObject(id);
		int recordEBookAccessSubscriptionId = (((EBookAccessSubscriptionDecorator) savedEBookAccessSubscription.getRecord()).getId();
		
		EBookAccessSubscription ebookaccesssubscription = record.createEBookAccessSubscription(vmjExchange);
		EBookAccessSubscription ebookaccesssubscriptiondeco = EBookAccessSubscriptionFactory.createEBookAccessSubscription("SmartLibrary.subscription.core.EbookAccessImpl", id, ebookaccesssubscription, subscriptionPlanP, freeAccess, payPerBook
		startDate, endDate
		);
			return ebookaccesssubscriptiondeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/subscription/update")
    public HashMap<String, Object> updateEBookAccessSubscription(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		EBookAccessSubscription ebookaccesssubscription = ebookaccesssubscriptionRepository.getObject(id);
		ebookaccesssubscription = createEBookAccessSubscription(vmjExchange, id);
		
		ebookaccesssubscriptionRepository.updateObject(ebookaccesssubscription);
		ebookaccesssubscription = ebookaccesssubscriptionRepository.getObject(id);
		//to do: fix association attributes
		
		return ebookaccesssubscription.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/subscription/detail")
    public HashMap<String, Object> getEBookAccessSubscription(VMJExchange vmjExchange){
		return record.getEBookAccessSubscription(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/subscription/list")
    public List<HashMap<String,Object>> getAllEBookAccessSubscription(VMJExchange vmjExchange){
		List<EBookAccessSubscription> ebookaccesssubscriptionList = ebookaccesssubscriptionRepository.getAllObject("ebookaccesssubscription_impl");
		return transformEBookAccessSubscriptionListToHashMap(ebookaccesssubscriptionList);
	}

    public List<HashMap<String,Object>> transformEBookAccessSubscriptionListToHashMap(List<EBookAccessSubscription> EBookAccessSubscriptionList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < EBookAccessSubscriptionList.size(); i++) {
            resultList.add(EBookAccessSubscriptionList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/subscription/delete")
    public List<HashMap<String,Object>> deleteEBookAccessSubscription(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		ebookaccesssubscriptionRepository.deleteObject(id);
		return getAllEBookAccessSubscription(vmjExchange);
	}

	
}
