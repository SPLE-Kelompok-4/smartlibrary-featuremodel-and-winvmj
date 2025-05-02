package SmartLibrary.ebookaccess.freeaccess;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.ebookaccess.core.EBookAccessDecorator;
import SmartLibrary.ebookaccess.core.EBookAccess;
import SmartLibrary.ebookaccess.core.EBookAccessComponent;

@Entity(name="ebookaccess_freeaccess")
@Table(name="ebookaccess_freeaccess")
public class EBookAccessImpl extends EBookAccessDecorator {

	public EBook book;
	public EBookAccessImpl(
        super();
        this.objectName = EBookAccessImpl.class.getName();
    }
    
    public EBookAccessImpl(EBook book) {
    	super();
		this.book = book;
		this.objectName = EBookAccessImpl.class.getName();
    }
	
	public EBookAccessImpl(EBookAccessComponent record, EBook book) {
		super(record);
		this.book = book;
		this.objectName = EBookAccessImpl.class.getName();
	}


	public void createAccess(EBook ) {
		// TODO: implement this method
	}

}
