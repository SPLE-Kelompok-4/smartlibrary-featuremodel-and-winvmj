package SmartLibrary.ebookdisplay.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class EBookResourceDecorator extends EBookResourceComponent{
	protected EBookResourceComponent record;

    public EBookResourceDecorator(EBookResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveEBook(VMJExchange vmjExchange){
		return record.saveEBook(vmjExchange);
	}

    public EBook createEBook(VMJExchange vmjExchange){
		return record.createEBook(vmjExchange);
	}

    public EBook createEBook(VMJExchange vmjExchange, int id){
		return record.createEBook(vmjExchange, id);
	}

    public HashMap<String, Object> updateEBook(VMJExchange vmjExchange){
		return record.updateEBook(vmjExchange);
	}

    public HashMap<String, Object> getEBook(VMJExchange vmjExchange){
		return record.getEBook(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllEBook(VMJExchange vmjExchange){
		return record.getAllEBook(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteEBook(VMJExchange vmjExchange){
		return record.deleteEBook(vmjExchange);
	}

}
