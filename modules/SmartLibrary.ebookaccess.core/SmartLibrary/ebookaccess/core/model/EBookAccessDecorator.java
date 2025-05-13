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

	public EBookAccessDecorator() {
        super();
        this.id = UUID.randomUUID();
    }
    
    public EBookAccessDecorator(EBookAccessComponent record) {
        super();
        this.id = UUID.randomUUID();
        this.record = record;
    }

    public EBookAccessDecorator(UUID id, EBookAccessComponent record) {
        super();
        this.id = id;
        this.record = record;
    }
    
    public EBookAccessDecorator(EBookAccessComponent record, String objectName) {
        super();
        this.id = UUID.randomUUID();
        this.record = record;
        this.objectName = objectName;
    }


	public void createAccess() {
		return record.createAccess();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
