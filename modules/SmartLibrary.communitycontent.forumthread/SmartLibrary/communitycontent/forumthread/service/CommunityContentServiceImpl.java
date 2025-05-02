package SmartLibrary.communitycontent.forumthread;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.communitycontent.core.CommunityContentServiceDecorator;
import SmartLibrary.communitycontent.core.CommunityContentImpl;
import SmartLibrary.communitycontent.core.CommunityContentServiceComponent;

public class CommunityContentServiceImpl extends CommunityContentServiceDecorator {
    public CommunityContentServiceImpl (CommunityContentServiceComponent record) {
        super(record);
    }

    
	public void createContent(String topic, String initialPost) {
		// TODO: implement this method
	}

	public void updateContent(UUID contentId, String topic, String initialPost) {
		// TODO: implement this method
	}

	public void addReply(UUID contentId, String comment) {
		// TODO: implement this method
	}
}
