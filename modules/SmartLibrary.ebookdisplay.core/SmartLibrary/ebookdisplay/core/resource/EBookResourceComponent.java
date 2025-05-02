package SmartLibrary.ebookdisplay.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class EBookResourceComponent implements EBookResource{
	
	public EBookResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveEBook(VMJExchange vmjExchange);
    public abstract EBook createEBook(VMJExchange vmjExchange);
	public abstract EBook createEBook(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateEBook(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getEBook(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllEBook(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteEBook(VMJExchange vmjExchange);

}
