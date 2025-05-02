package SmartLibrary.ebookdisplay.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="ebook_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EBookComponent implements EBook{
	@Id
	
	protected EDate releaseDate;
	protected String description;
	protected String eBookTitle;
	protected String eBookAuthor;
	protected UUID bookID;
	protected String ISBN;
	protected EEList categories;
	@ManyToOne(targetEntity=SmartLibrary..core.Component.class)
	public  ebookaccessimpl;
	protected EDate createdAt;
	protected String objectName = EBookComponent.class.getName();

	public EBookComponent() {

	} 

	public EBookComponent(
        EDate releaseDate, String description, String eBookTitle, String eBookAuthor, UUID bookID, String ISBN, EEList categories, EBookAccessImpl ebookaccessimpl, EDate createdAt
    ) {
        this.releaseDate = releaseDate;
        this.description = description;
        this.eBookTitle = eBookTitle;
        this.eBookAuthor = eBookAuthor;
        this.bookID = bookID;
        this.ISBN = ISBN;
        this.categories = categories;
        this.ebookaccessimpl = ebookaccessimpl;
        this.createdAt = createdAt;
    }

	public EDate getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(EDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getEBookTitle() {
		return this.eBookTitle;
	}

	public void setEBookTitle(String eBookTitle) {
		this.eBookTitle = eBookTitle;
	}
	public String getEBookAuthor() {
		return this.eBookAuthor;
	}

	public void setEBookAuthor(String eBookAuthor) {
		this.eBookAuthor = eBookAuthor;
	}
	public UUID getBookID() {
		return this.bookID;
	}

	public void setBookID(UUID bookID) {
		this.bookID = bookID;
	}
	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public EEList getCategories() {
		return this.categories;
	}

	public void setCategories(EEList categories) {
		this.categories = categories;
	}
	public abstract EBookAccessImpl getEbookaccessimpl();
	public abstract void setEbookaccessimpl(EBookAccessImpl ebookaccessimpl);
	
	public EDate getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(EDate createdAt) {
		this.createdAt = createdAt;
	}
 

	@Override
    public String toString() {
        return "{" +
            " releaseDate='" + getReleaseDate() + "'" +
            " description='" + getDescription() + "'" +
            " eBookTitle='" + getEBookTitle() + "'" +
            " eBookAuthor='" + getEBookAuthor() + "'" +
            " bookID='" + getBookID() + "'" +
            " ISBN='" + getISBN() + "'" +
            " categories='" + getCategories() + "'" +
            " ebookaccessimpl='" + getEbookaccessimpl() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            "}";
    }
	
}
