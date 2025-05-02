package SmartLibrary.ebookdisplay.displaywithprice;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.ebookdisplay.core.EBookServiceDecorator;
import SmartLibrary.ebookdisplay.core.EBookImpl;
import SmartLibrary.ebookdisplay.core.EBookServiceComponent;

public class EBookServiceImpl extends EBookServiceDecorator {
    public EBookServiceImpl (EBookServiceComponent record) {
        super(record);
    }

    
}
