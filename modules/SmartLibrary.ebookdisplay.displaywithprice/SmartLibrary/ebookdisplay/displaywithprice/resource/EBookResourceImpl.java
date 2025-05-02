package SmartLibrary.ebookdisplay.displaywithprice;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.ebookdisplay.core.EBookResourceDecorator;
import SmartLibrary.ebookdisplay.core.EBookImpl;
import SmartLibrary.ebookdisplay.core.EBookResourceComponent;

public class EBookResourceImpl extends EBookResourceDecorator {
    public EBookResourceImpl (EBookResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/displaywithprice/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EBookDisplayDisplayWithPrice ebookdisplaydisplaywithprice = createEBookDisplayDisplayWithPrice(vmjExchange);
		ebookdisplaydisplaywithpriceRepository.saveObject(ebookdisplaydisplaywithprice);
		return getAllEBookDisplayDisplayWithPrice(vmjExchange);
	}

    public EBookDisplay createEBookDisplayDisplayWithPrice(VMJExchange vmjExchange){
		String priceStr = (String) vmjExchange.getRequestBodyForm("price");
		int price = Integer.parseInt(priceStr);
		
		EBookDisplayDisplayWithPrice ebookdisplaydisplaywithprice = record.createEBookDisplayDisplayWithPrice(vmjExchange);
		EBookDisplayDisplayWithPrice ebookdisplaydisplaywithpricedeco = EBookDisplayDisplayWithPriceFactory.createEBookDisplayDisplayWithPrice("SmartLibrary.displaywithprice.core.EBookImpl", ebookdisplaydisplaywithprice, releaseDate, description, eBookTitle, eBookAuthor, bookID, ISBN, categories, ebookaccessimpl, createdAt
		price
		);
			return ebookdisplaydisplaywithpricedeco;
	}


    public EBookDisplay createEBookDisplayDisplayWithPrice(VMJExchange vmjExchange, int id){
		String priceStr = (String) vmjExchange.getRequestBodyForm("price");
		int price = Integer.parseInt(priceStr);
		EBookDisplayDisplayWithPrice ebookdisplaydisplaywithprice = ebookdisplaydisplaywithpriceRepository.getObject(id);
		int recordEBookDisplayDisplayWithPriceId = (((EBookDisplayDisplayWithPriceDecorator) savedEBookDisplayDisplayWithPrice.getRecord()).getId();
		
		EBookDisplayDisplayWithPrice ebookdisplaydisplaywithprice = record.createEBookDisplayDisplayWithPrice(vmjExchange);
		EBookDisplayDisplayWithPrice ebookdisplaydisplaywithpricedeco = EBookDisplayDisplayWithPriceFactory.createEBookDisplayDisplayWithPrice("SmartLibrary.displaywithprice.core.EBookImpl", id, ebookdisplaydisplaywithprice, releaseDate, description, eBookTitle, eBookAuthor, bookID, ISBN, categories, ebookaccessimpl, createdAt
		price
		);
			return ebookdisplaydisplaywithpricedeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/displaywithprice/update")
    public HashMap<String, Object> updateEBookDisplayDisplayWithPrice(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		EBookDisplayDisplayWithPrice ebookdisplaydisplaywithprice = ebookdisplaydisplaywithpriceRepository.getObject(id);
		ebookdisplaydisplaywithprice = createEBookDisplayDisplayWithPrice(vmjExchange, id);
		
		ebookdisplaydisplaywithpriceRepository.updateObject(ebookdisplaydisplaywithprice);
		ebookdisplaydisplaywithprice = ebookdisplaydisplaywithpriceRepository.getObject(id);
		//to do: fix association attributes
		
		return ebookdisplaydisplaywithprice.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/displaywithprice/detail")
    public HashMap<String, Object> getEBookDisplayDisplayWithPrice(VMJExchange vmjExchange){
		return record.getEBookDisplayDisplayWithPrice(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/displaywithprice/list")
    public List<HashMap<String,Object>> getAllEBookDisplayDisplayWithPrice(VMJExchange vmjExchange){
		List<EBookDisplayDisplayWithPrice> ebookdisplaydisplaywithpriceList = ebookdisplaydisplaywithpriceRepository.getAllObject("ebookdisplaydisplaywithprice_impl");
		return transformEBookDisplayDisplayWithPriceListToHashMap(ebookdisplaydisplaywithpriceList);
	}

    public List<HashMap<String,Object>> transformEBookDisplayDisplayWithPriceListToHashMap(List<EBookDisplayDisplayWithPrice> EBookDisplayDisplayWithPriceList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < EBookDisplayDisplayWithPriceList.size(); i++) {
            resultList.add(EBookDisplayDisplayWithPriceList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/displaywithprice/delete")
    public List<HashMap<String,Object>> deleteEBookDisplayDisplayWithPrice(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		ebookdisplaydisplaywithpriceRepository.deleteObject(id);
		return getAllEBookDisplayDisplayWithPrice(vmjExchange);
	}

	
}
