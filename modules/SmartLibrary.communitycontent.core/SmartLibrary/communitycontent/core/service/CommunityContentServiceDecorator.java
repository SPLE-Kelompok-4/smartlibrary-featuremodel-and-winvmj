package SmartLibrary.communitycontent.core;
import java.util.*;


public abstract class CommunityContentServiceDecorator extends CommunityContentServiceComponent {
    protected CommunityContentServiceComponent record;
    public CommunityContentServiceDecorator(CommunityContentServiceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveCommunityContent(Map<String, Object> requestBody) {
        return record.saveCommunityContent(requestBody);
    }

    public CommunityContent createCommunityContent(Map<String, Object> requestBody) {
        return record.createCommunityContent(requestBody);
    }

    public CommunityContent createCommunityContent(Map<String, Object> requestBody, Map<String, Object> response) {
        return record.createCommunityContent(requestBody, response);
    }

    public HashMap<String, Object> updateCommunityContent(Map<String, Object> requestBody) {
        return record.updateCommunityContent(requestBody);
    }

    public HashMap<String, Object> getCommunityContent(Map<String, Object> requestBody) {
        return record.getCommunityContent(requestBody);
    }

    public List<HashMap<String,Object>> getAllCommunityContent(Map<String, Object> requestBody) {
        return record.getAllCommunityContent(requestBody);
    }

    public List<HashMap<String,Object>> transformListToHashMap(List<CommunityContent> list) {
        return record.transformListToHashMap(list);
    }

    public List<HashMap<String,Object>> deleteCommunityContent(Map<String, Object> requestBody) {
        return record.deleteCommunityContent(requestBody);
    }

    public HashMap<String, Object> getCommunityContentById(UUID id) {
        return record.getCommunityContentById(id);
    }
    
}
