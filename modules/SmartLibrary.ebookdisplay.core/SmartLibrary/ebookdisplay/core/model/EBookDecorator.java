package SmartLibrary.ebookdisplay.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class EBookDecorator extends EBookComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected EBookComponent record;

	public EBookDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public EBookDecorator (EBookComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public EBookDecorator (, EBookComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public EBookDecorator (EBookComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public EBookDecorator() { }

	public EDate getReleaseDate() {
		return record.getReleaseDate();
	}
	public void setReleaseDate(EDate releaseDate) {
		record.setReleaseDate(releaseDate);
	}
	public String getDescription() {
		return record.getDescription();
	}
	public void setDescription(String description) {
		record.setDescription(description);
	}
	public String getEBookTitle() {
		return record.getEBookTitle();
	}
	public void setEBookTitle(String eBookTitle) {
		record.setEBookTitle(eBookTitle);
	}
	public String getEBookAuthor() {
		return record.getEBookAuthor();
	}
	public void setEBookAuthor(String eBookAuthor) {
		record.setEBookAuthor(eBookAuthor);
	}
	public UUID getBookID() {
		return record.getBookID();
	}
	public void setBookID(UUID bookID) {
		record.setBookID(bookID);
	}
	public String getISBN() {
		return record.getISBN();
	}
	public void setISBN(String ISBN) {
		record.setISBN(ISBN);
	}
	public EEList getCategories() {
		return record.getCategories();
	}
	public void setCategories(EEList categories) {
		record.setCategories(categories);
	}
	public EDate getCreatedAt() {
		return record.getCreatedAt();
	}
	public void setCreatedAt(EDate createdAt) {
		record.setCreatedAt(createdAt);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
