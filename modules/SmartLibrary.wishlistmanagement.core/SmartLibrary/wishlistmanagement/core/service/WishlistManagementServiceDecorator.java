package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class WishlistManagementServiceDecorator extends WishlistManagementServiceComponent{
	protected WishlistManagementServiceComponent record;

    public WishlistManagementServiceDecorator(WishlistManagementServiceComponent record) {
        this.record = record;
    }

	public WishlistManagementImpl createWishlishManagement(Map<String, Object> requestBody){
		return record.createWishlishManagement(requestBody);
	}

    public WishlishManagement createWishlishManagement(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createWishlishManagement(requestBody, response);
	}

	public HashMap<String, Object> getWishlishManagement(Map<String, Object> requestBody){
		return record.getWishlishManagement(requestBody);
	}

	public List<HashMap<String,Object>> getAllWishlishManagement(Map<String, Object> requestBody){
		return record.getAllWishlishManagement(requestBody);
	}

    public List<HashMap<String,Object>> saveWishlishManagement(VMJExchange vmjExchange){
		return record.saveWishlishManagement(vmjExchange);
	}

    public HashMap<String, Object> updateWishlishManagement(Map<String, Object> requestBody){
		return record.updateWishlishManagement(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<WishlishManagement> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteWishlishManagement(Map<String, Object> requestBody){
		return record.deleteWishlishManagement(requestBody);
	}

	public HashMap<String, Object> getWishlishManagementById(int id){
        return record.getWishlishManagementById(id);
    }

	public void addItem(Item item) {
		return record.addItem();
	}

	public void removeItem(UUID itemId) {
		return record.removeItem(itemId);
	}

	public void getItems() {
		return record.getItems();
	}
}
