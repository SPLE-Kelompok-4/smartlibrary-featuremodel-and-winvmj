package SmartLibrary.reviewmanagement.core;

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


@Entity(name="reviewitem_impl")
@Table(name="reviewitem_impl")
public class ReviewItemImpl extends ReviewItemComponent {

	public ReviewItemImpl(UUID reviewId, UUID itemId, EDate addedAt) {
		this.reviewId = reviewId;
		this.itemId = itemId;
		this.addedAt = addedAt;
	}

	public ReviewItemImpl() { }

	@Override
	public UUID getReviewId() {
		return this.reviewId;
	}

	@Override
	public void setReviewId(UUID reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public UUID getItemId() {
		return this.itemId;
	}

	@Override
	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	@Override
	public EDate getAddedAt() {
		return this.addedAt;
	}

	@Override
	public void setAddedAt(EDate addedAt) {
		this.addedAt = addedAt;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reviewitemMap = new HashMap<String,Object>();
		reviewitemMap.put("reviewId",getReviewId());
		reviewitemMap.put("itemId",getItemId());
		reviewitemMap.put("addedAt",getAddedAt());

        return reviewitemMap;
    }

}
