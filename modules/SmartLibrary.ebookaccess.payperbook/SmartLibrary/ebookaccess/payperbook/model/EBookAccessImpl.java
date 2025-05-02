package SmartLibrary.ebookaccess.payperbook;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.ebookaccess.core.EBookAccessDecorator;
import SmartLibrary.ebookaccess.core.EBookAccess;
import SmartLibrary.ebookaccess.core.EBookAccessComponent;

@Entity(name="ebookaccess_payperbook")
@Table(name="ebookaccess_payperbook")
public class EBookAccessImpl extends EBookAccessDecorator {

	public EBook book;
	public EDate accessStamp;
	public EBookAccessImpl(
        super();
        this.objectName = EBookAccessImpl.class.getName();
    }
    
    public EBookAccessImpl(EBook book, EDate accessStamp) {
    	super();
		this.book = book;
		this.accessStamp = accessStamp;
		this.objectName = EBookAccessImpl.class.getName();
    }
	
	public EBookAccessImpl(EBookAccessComponent record, EBook book, EDate accessStamp) {
		super(record);
		this.book = book;
		this.accessStamp = accessStamp;
		this.objectName = EBookAccessImpl.class.getName();
	}


	public void createAccess(EBook ) {
		// TODO: implement this method
	}

}
