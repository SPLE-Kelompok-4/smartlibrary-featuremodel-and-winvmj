package SmartLibrary.communitycontent.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CommunityContentServiceComponent implements CommunityContentService{
	protected RepositoryUtil<CommunityContent> Repository;

    public CommunityContentServiceComponent(){
        this.Repository = new RepositoryUtil<CommunityContent>(SmartLibrary.communitycontent.core.CommunityContentComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveCommunityContent(VMJExchange vmjExchange);
    public abstract CommunityContent createCommunityContent(Map<String, Object> requestBodye);
	public abstract CommunityContent createCommunityContent(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateCommunityContent(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getCommunityContent(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllCommunityContent(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<CommunityContent> List);
    public abstract List<HashMap<String,Object>> deleteCommunityContent(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getCommunityContentById(int id);

	public abstract void createContent();

	public abstract void readContent();

	public abstract void updateContent();

	public abstract void deleteContent();
}
