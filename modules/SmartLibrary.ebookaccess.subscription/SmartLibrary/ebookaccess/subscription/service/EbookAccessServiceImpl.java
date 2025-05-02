package SmartLibrary.ebookaccess.subscription;

import java.util.*;

import vmj.routing.route.VMJExchange;

import SmartLibrary.ebookaccess.core.EbookAccessServiceDecorator;
import SmartLibrary.ebookaccess.core.EbookAccessImpl;
import SmartLibrary.ebookaccess.core.EbookAccessServiceComponent;

public class EbookAccessServiceImpl extends EbookAccessServiceDecorator {
    public EbookAccessServiceImpl (EbookAccessServiceComponent record) {
        super(record);
    }

    
}
