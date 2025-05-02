package SmartLibrary.communitycontent.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class CommunityContentResourceDecorator extends CommunityContentResourceComponent{
	protected CommunityContentResourceComponent record;

    public CommunityContentResourceDecorator(CommunityContentResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveCommunityContent(VMJExchange vmjExchange){
		return record.saveCommunityContent(vmjExchange);
	}

    public CommunityContent createCommunityContent(VMJExchange vmjExchange){
		return record.createCommunityContent(vmjExchange);
	}

    public CommunityContent createCommunityContent(VMJExchange vmjExchange, int id){
		return record.createCommunityContent(vmjExchange, id);
	}

    public HashMap<String, Object> updateCommunityContent(VMJExchange vmjExchange){
		return record.updateCommunityContent(vmjExchange);
	}

    public HashMap<String, Object> getCommunityContent(VMJExchange vmjExchange){
		return record.getCommunityContent(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllCommunityContent(VMJExchange vmjExchange){
		return record.getAllCommunityContent(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteCommunityContent(VMJExchange vmjExchange){
		return record.deleteCommunityContent(vmjExchange);
	}

	public void createContent() {
		return record.createContent();
	}

	public void readContent() {
		return record.readContent();
	}

	public void updateContent() {
		return record.updateContent();
	}

	public void deleteContent() {
		return record.deleteContent();
	}
}
