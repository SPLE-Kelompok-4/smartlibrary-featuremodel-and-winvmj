package SmartLibrary.ebookdisplay.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class EBookServiceComponent implements EBookService{
	protected RepositoryUtil<EBook> Repository;

    public EBookServiceComponent(){
        this.Repository = new RepositoryUtil<EBook>(SmartLibrary.ebookdisplay.core.EBookComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveEBook(VMJExchange vmjExchange);
    public abstract EBook createEBook(Map<String, Object> requestBodye);
	public abstract EBook createEBook(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateEBook(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getEBook(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllEBook(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<EBook> List);
    public abstract List<HashMap<String,Object>> deleteEBook(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getEBookById(int id);

}
