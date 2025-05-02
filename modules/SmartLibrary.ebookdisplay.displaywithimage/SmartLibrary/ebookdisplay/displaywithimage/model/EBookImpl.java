package SmartLibrary.ebookdisplay.displaywithimage;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.ebookdisplay.core.EBookDecorator;
import SmartLibrary.ebookdisplay.core.EBook;
import SmartLibrary.ebookdisplay.core.EBookComponent;

@Entity(name="ebookdisplay_displaywithimage")
@Table(name="ebookdisplay_displaywithimage")
public class EBookImpl extends EBookDecorator {

	protected String image;
	public EBookImpl(
        super();
        this.objectName = EBookImpl.class.getName();
    }
    
    public EBookImpl(String image) {
    	super();
		this.image = image;
		this.objectName = EBookImpl.class.getName();
    }
	
	public EBookImpl(EBookComponent record, String image) {
		super(record);
		this.image = image;
		this.objectName = EBookImpl.class.getName();
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}
