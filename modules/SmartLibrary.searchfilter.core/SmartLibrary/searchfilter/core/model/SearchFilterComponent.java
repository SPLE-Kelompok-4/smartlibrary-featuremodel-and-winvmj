package SmartLibrary.searchfilter.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="searchfilter_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SearchFilterComponent implements SearchFilter{
	@Id
	
	@ManyToOne(targetEntity=SmartLibrary.ebook.core.EBookComponent.class)
	public EBook ebookimpl;
	protected String objectName = SearchFilterComponent.class.getName();

	public SearchFilterComponent() {

	} 

	public SearchFilterComponent(
        EBookImpl ebookimpl
    ) {
        this.ebookimpl = ebookimpl;
    }

	public abstract EBookImpl getEbookimpl();
	public abstract void setEbookimpl(EBookImpl ebookimpl);
	
 
	public abstract EEList apply(EEList EBooks);

	@Override
    public String toString() {
        return "{" +
            " ebookimpl='" + getEbookimpl() + "'" +
            "}";
    }
	
}
