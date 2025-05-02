package SmartLibrary.ebookdisplay.displaywithprice;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.ebookdisplay.core.EBookDecorator;
import SmartLibrary.ebookdisplay.core.EBook;
import SmartLibrary.ebookdisplay.core.EBookComponent;

@Entity(name="ebookdisplay_displaywithprice")
@Table(name="ebookdisplay_displaywithprice")
public class EBookImpl extends EBookDecorator {

	protected int price;
	public EBookImpl(
        super();
        this.objectName = EBookImpl.class.getName();
    }
    
    public EBookImpl(int price) {
    	super();
		this.price = price;
		this.objectName = EBookImpl.class.getName();
    }
	
	public EBookImpl(EBookComponent record, int price) {
		super(record);
		this.price = price;
		this.objectName = EBookImpl.class.getName();
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


}
