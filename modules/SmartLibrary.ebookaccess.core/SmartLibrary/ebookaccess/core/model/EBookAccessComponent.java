package SmartLibrary.ebookaccess.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EBookAccessComponent implements {
	@Id
	
	public Plan subscriptionPlanP;
	public EEList freeAccess;
	public EEList payPerBook;
	protected String objectName = EBookAccessComponent.class.getName();

	public EBookAccessComponent() {

	} 

	public EBookAccessComponent(
        Plan subscriptionPlanP, EEList freeAccess, EEList payPerBook
    ) {
        this.subscriptionPlanP = subscriptionPlanP;
        this.freeAccess = freeAccess;
        this.payPerBook = payPerBook;
    }

	public abstract Plan getSubscriptionPlanP();
	public abstract void setSubscriptionPlanP(Plan subscriptionPlanP);
	
	public abstract EEList getFreeAccess();
	public abstract void setFreeAccess(EEList freeAccess);
	
	public abstract EEList getPayPerBook();
	public abstract void setPayPerBook(EEList payPerBook);
	
 
	public abstract void createAccess();

	@Override
    public String toString() {
        return "{" +
            " subscriptionPlanP='" + getSubscriptionPlanP() + "'" +
            " freeAccess='" + getFreeAccess() + "'" +
            " payPerBook='" + getPayPerBook() + "'" +
            "}";
    }
	
}
