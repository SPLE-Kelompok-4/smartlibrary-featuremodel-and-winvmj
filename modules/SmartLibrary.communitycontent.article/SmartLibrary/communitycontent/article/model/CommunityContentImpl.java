package SmartLibrary.communitycontent.article;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.communitycontent.core.CommunityContentDecorator;
import SmartLibrary.communitycontent.core.CommunityContent;
import SmartLibrary.communitycontent.core.CommunityContentComponent;

@Entity(name="communitycontent_article")
@Table(name="communitycontent_article")
public class CommunityContentImpl extends CommunityContentDecorator {

	protected String articleTitle;
	protected String body;
	public CommunityContentImpl(
        super();
        this.objectName = CommunityContentImpl.class.getName();
    }
    
    public CommunityContentImpl(String articleTitle, String body) {
    	super();
		this.articleTitle = articleTitle;
		this.body = body;
		this.objectName = CommunityContentImpl.class.getName();
    }
	
	public CommunityContentImpl(CommunityContentComponent record, String articleTitle, String body) {
		super(record);
		this.articleTitle = articleTitle;
		this.body = body;
		this.objectName = CommunityContentImpl.class.getName();
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void createContent(String title, String body) {
		// TODO: implement this method
	}

	public void updateContent(UUID contentID, String body) {
		// TODO: implement this method
	}

}
