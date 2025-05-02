package SmartLibrary.ebookaccess.freeaccess;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.ebookaccess.core.EBookAccessServiceDecorator;
import SmartLibrary.ebookaccess.core.EBookAccessImpl;
import SmartLibrary.ebookaccess.core.EBookAccessServiceComponent;

public class EBookAccessServiceImpl extends EBookAccessServiceDecorator {
    public EBookAccessServiceImpl (EBookAccessServiceComponent record) {
        super(record);
    }

    
	public void createAccess(EBook ) {
		// TODO: implement this method
	}
}
