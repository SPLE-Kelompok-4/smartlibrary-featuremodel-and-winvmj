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


@Entity(name="reviewmanagement_impl")
@Table(name="reviewmanagement_impl")
public class ReviewManagementImpl extends ReviewManagementComponent {

	public ReviewManagementImpl(UUID reviewId, UUID userId, String name, EDate createdAt, ReviewItemImpl reviewitemimpl, EDate updateAt) {
		this.reviewId = reviewId;
		this.userId = userId;
		this.name = name;
		this.createdAt = createdAt;
		this.reviewitemimpl = reviewitemimpl;
		this.updateAt = updateAt;
	}


	public ReviewManagementImpl() { }


	public void addReview(ReviewItem reviewItem) {
		// TODO: implement this method
	}

	public void removeReview(UUID itemId) {
		// TODO: implement this method
	}

	public void getReviews() {
		// TODO: implement this method
	}

	@Override
	public UUID getReviewId() {
		return this.reviewId;
	}

	@Override
	public void setReviewId(UUID reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public UUID getUserId() {
		return this.userId;
	}

	@Override
	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public EDate getCreatedAt() {
		return this.createdAt;
	}

	@Override
	public void setCreatedAt(EDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public ReviewItemImpl getReviewitemimpl() {
		return this.reviewitemimpl;
	}

	@Override
	public void setReviewitemimpl(ReviewItemImpl reviewitemimpl) {
		this.reviewitemimpl = reviewitemimpl;
	}

	@Override
	public EDate getUpdateAt() {
		return this.updateAt;
	}

	@Override
	public void setUpdateAt(EDate updateAt) {
		this.updateAt = updateAt;
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reviewmanagementMap = new HashMap<String,Object>();
		reviewmanagementMap.put("reviewId",getReviewId());
		reviewmanagementMap.put("userId",getUserId());
		reviewmanagementMap.put("name",getName());
		reviewmanagementMap.put("createdAt",getCreatedAt());
		reviewmanagementMap.put("reviewitemimpl",getReviewitemimpl());
		reviewmanagementMap.put("updateAt",getUpdateAt());

        return reviewmanagementMap;
    }

}
