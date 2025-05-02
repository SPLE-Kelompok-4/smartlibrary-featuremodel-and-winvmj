package SmartLibrary.wishlistmanagement.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class WishlistManagementResourceDecorator extends WishlistManagementResourceComponent{
	protected WishlistManagementResourceComponent record;

    public WishlistManagementResourceDecorator(WishlistManagementResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveWishlishManagement(VMJExchange vmjExchange){
		return record.saveWishlishManagement(vmjExchange);
	}

    public WishlishManagement createWishlishManagement(VMJExchange vmjExchange){
		return record.createWishlishManagement(vmjExchange);
	}

    public WishlishManagement createWishlishManagement(VMJExchange vmjExchange, int id){
		return record.createWishlishManagement(vmjExchange, id);
	}

    public HashMap<String, Object> updateWishlishManagement(VMJExchange vmjExchange){
		return record.updateWishlishManagement(vmjExchange);
	}

    public HashMap<String, Object> getWishlishManagement(VMJExchange vmjExchange){
		return record.getWishlishManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllWishlishManagement(VMJExchange vmjExchange){
		return record.getAllWishlishManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteWishlishManagement(VMJExchange vmjExchange){
		return record.deleteWishlishManagement(vmjExchange);
	}

	public void addItem(Item ) {
		return record.addItem();
	}

	public void removeItem(UUID itemId) {
		return record.removeItem(itemId);
	}

	public void getItems() {
		return record.getItems();
	}
}
