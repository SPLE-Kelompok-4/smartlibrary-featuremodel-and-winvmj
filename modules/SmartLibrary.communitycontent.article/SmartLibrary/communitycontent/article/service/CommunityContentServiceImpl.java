package SmartLibrary.communitycontent.article;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.communitycontent.core.CommunityContentServiceDecorator;
import SmartLibrary.communitycontent.core.CommunityContentImpl;
import SmartLibrary.communitycontent.core.CommunityContentServiceComponent;

public class CommunityContentServiceImpl extends CommunityContentServiceDecorator {
    public CommunityContentServiceImpl (CommunityContentServiceComponent record) {
        super(record);
    }

    
	public void createContent(String title, String body) {
		// TODO: implement this method
	}

	public void updateContent(UUID contentID, String body) {
		// TODO: implement this method
	}
}
