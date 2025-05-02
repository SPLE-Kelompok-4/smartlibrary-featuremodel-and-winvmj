package SmartLibrary.communitycontent.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CommunityContentResourceComponent implements CommunityContentResource{
	
	public CommunityContentResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveCommunityContent(VMJExchange vmjExchange);
    public abstract CommunityContent createCommunityContent(VMJExchange vmjExchange);
	public abstract CommunityContent createCommunityContent(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateCommunityContent(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getCommunityContent(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllCommunityContent(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteCommunityContent(VMJExchange vmjExchange);

	public abstract void createContent();

	public abstract void readContent();

	public abstract void updateContent();

	public abstract void deleteContent();
}
