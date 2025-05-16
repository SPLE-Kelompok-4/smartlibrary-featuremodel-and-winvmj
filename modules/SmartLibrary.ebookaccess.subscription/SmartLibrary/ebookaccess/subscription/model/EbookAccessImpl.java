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
import SmartLibrary.ebookaccess.payperbook.EBookAccessImpl;

@Entity(name="ebookaccess_subscription")
@Table(name="ebookaccess_subscription")
public class EbookAccessImpl extends EbookAccessDecorator {

    @Column
    public EDate startDate;
    
    @Column
    public EDate endDate;
    
    @Column
    public EBookAccessImpl ebookAccessImpl;
    
    public EbookAccessImpl() {
        super();
        this.objectName = EbookAccessImpl.class.getName();
    }
    
    public EbookAccessImpl(EDate startDate, EDate endDate, EBookAccessImpl ebookAccessImpl) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.ebookAccessImpl = ebookAccessImpl;
        this.objectName = EbookAccessImpl.class.getName();
    }
    
    public EbookAccessImpl(EbookAccessComponent record, EDate startDate, EDate endDate, EBookAccessImpl ebookAccessImpl) {
        super(record);
        this.startDate = startDate;
        this.endDate = endDate;
        this.ebookAccessImpl = ebookAccessImpl;
        this.objectName = EbookAccessImpl.class.getName();
    }

    @Override
    public void addPlan(Plan plan) {
        // TODO: implement this method
    }
}