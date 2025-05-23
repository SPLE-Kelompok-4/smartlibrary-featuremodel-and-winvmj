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

@Entity(name="ebook_displaywithprice")
@Table(name="ebook_displaywithprice")
public class EBookImpl extends EBookDecorator {

	protected double price;
	public EBookImpl(){
        super();
        this.objectName = EBookImpl.class.getName();
    }
    
    public EBookImpl(double price) {
    	super();
		this.price = price;
		this.objectName = EBookImpl.class.getName();
    }
	
	public EBookImpl(EBookComponent record, double price) {
		super(record);
		this.price = price;
		this.objectName = EBookImpl.class.getName();
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> ebookMap = super.toHashMap();
		ebookMap.put("price", getPrice());
		
		return ebookMap;
	}

}
