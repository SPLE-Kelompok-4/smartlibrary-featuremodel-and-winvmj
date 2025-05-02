package SmartLibrary.ebookaccess.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class EBookAccessDecorator extends EBookAccessComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected EBookAccessComponent record;

	public EBookAccessDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public EBookAccessDecorator (EBookAccessComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public EBookAccessDecorator (, EBookAccessComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public EBookAccessDecorator (EBookAccessComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public EBookAccessDecorator() { }


	public void createAccess() {
		return record.createAccess();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
