package SmartLibrary.ebookaccess.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class EBookAccessServiceComponent implements Service{
	protected RepositoryUtil<> Repository;

    public EBookAccessServiceComponent(){
        this.Repository = new RepositoryUtil<>(SmartLibrary.ebookaccess.core.EBookAccessComponent.class);
    }	

    public abstract List<HashMap<String,Object>> save(VMJExchange vmjExchange);
    public abstract  create(Map<String, Object> requestBodye);
	public abstract  create(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> update(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> get(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAll(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<> List);
    public abstract List<HashMap<String,Object>> delete(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getById(int id);

	public abstract void createAccess();
}
