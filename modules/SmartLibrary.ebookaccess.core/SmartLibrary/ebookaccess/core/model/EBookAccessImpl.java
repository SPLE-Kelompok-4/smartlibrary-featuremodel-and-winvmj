package SmartLibrary.ebookaccess.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="_impl")
@Table(name="_impl")
public class EBookAccessImpl extends EBookAccessComponent {

	@Id
    private UUID id;
    
    public EBookAccessImpl() {
        super();
        this.id = UUID.randomUUID();
    }
    
    public EBookAccessImpl(Plan subscriptionPlanP, List<String> freeAccess, List<String> payPerBook) {
        super(subscriptionPlanP, freeAccess, payPerBook);
        this.id = UUID.randomUUID();
    }


	public void createAccess() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> Map = new HashMap<String,Object>();
		Map.put("subscriptionPlanP",getSubscriptionPlanP());
		Map.put("freeAccess",getFreeAccess());
		Map.put("payPerBook",getPayPerBook());

        return Map;
    }

}
