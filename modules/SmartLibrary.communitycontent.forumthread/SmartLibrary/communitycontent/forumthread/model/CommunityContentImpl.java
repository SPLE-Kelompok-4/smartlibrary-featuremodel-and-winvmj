package SmartLibrary.communitycontent.forumthread;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.communitycontent.core.CommunityContentDecorator;
import SmartLibrary.communitycontent.core.CommunityContent;
import SmartLibrary.communitycontent.core.CommunityContentComponent;

@Entity(name="communitycontent_forumthread")
@Table(name="communitycontent_forumthread")
public class CommunityContentImpl extends CommunityContentDecorator {

	protected String topic;
	protected String initialPost;
	public CommunityContentImpl() {
        super();
        this.objectName = CommunityContentImpl.class.getName();
    }
    
    public CommunityContentImpl(String topic, String initialPost) {
    	super();
		this.topic = topic;
		this.initialPost = initialPost;
		this.objectName = CommunityContentImpl.class.getName();
    }
	
	public CommunityContentImpl(CommunityContentComponent record, String topic, String initialPost) {
		super(record);
		this.topic = topic;
		this.initialPost = initialPost;
		this.objectName = CommunityContentImpl.class.getName();
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getInitialPost() {
		return this.initialPost;
	}

	public void setInitialPost(String initialPost) {
		this.initialPost = initialPost;
	}
	

	public void createContent(String topic, String initialPost) {
		// TODO: implement this method
	}

	public void updateContent(UUID contentId, String topic, String initialPost) {
		// TODO: implement this method
	}

}
