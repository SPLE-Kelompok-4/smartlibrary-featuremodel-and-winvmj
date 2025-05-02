package SmartLibrary.ebookdisplay.core;

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


@Entity(name="ebook_impl")
@Table(name="ebook_impl")
public class EBookImpl extends EBookComponent {

	public EBookImpl(EDate releaseDate, String description, String eBookTitle, String eBookAuthor, UUID bookID, String ISBN, EEList categories, EBookAccessImpl ebookaccessimpl, EDate createdAt) {
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

	public EBookImpl(EDate releaseDate, String description, String eBookTitle, String eBookAuthor, UUID bookID, String ISBN, EEList categories, EBookAccessImpl ebookaccessimpl, EDate createdAt) {
		this. =  .randomUUID();;
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

	public EBookImpl() { }

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
	public EDate getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(EDate createdAt) {
		this.createdAt = createdAt;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> ebookMap = new HashMap<String,Object>();
		ebookMap.put("releaseDate",getReleaseDate());
		ebookMap.put("description",getDescription());
		ebookMap.put("eBookTitle",getEBookTitle());
		ebookMap.put("eBookAuthor",getEBookAuthor());
		ebookMap.put("bookID",getBookID());
		ebookMap.put("ISBN",getISBN());
		ebookMap.put("categories",getCategories());
		ebookMap.put("ebookaccessimpl",getEbookaccessimpl());
		ebookMap.put("createdAt",getCreatedAt());

        return ebookMap;
    }

}
