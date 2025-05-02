package SmartLibrary.ebookaccess.subscription;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import SmartLibrary.ebookaccess.core.EbookAccessDecorator;
import SmartLibrary.ebookaccess.core.EbookAccess;
import SmartLibrary.ebookaccess.core.EbookAccessComponent;

@Entity(name="ebookaccess_subscription")
@Table(name="ebookaccess_subscription")
public class EbookAccessImpl extends EbookAccessDecorator {

	public EDate startDate;
	public EDate endDate;
	public EbookAccessImpl(
        super();
        this.objectName = EbookAccessImpl.class.getName();
    }
    
    public EbookAccessImpl(EDate startDate, EDate endDate, EBookAccessImpl ebookaccessimpl) {
    	super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.objectName = EbookAccessImpl.class.getName();
    }
	
	public EbookAccessImpl(EbookAccessComponent record, EDate startDate, EDate endDate, EBookAccessImpl ebookaccessimpl) {
		super(record);
		this.startDate = startDate;
		this.endDate = endDate;
		this.objectName = EbookAccessImpl.class.getName();
	}


	public void addPlan(Plan ) {
		// TODO: implement this method
	}

}
