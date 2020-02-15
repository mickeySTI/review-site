package com.reviewsite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {
	
	
	private Map<Long,Review> reviewList = new HashMap<>();
	private Review reviewOne = new Review(1L, "WRXSTI", "https://farm6.staticflickr.com/5038/7066030169_2a16e9aef1_b.jpg","Sports Car","Specs");
	private Review reviewTwo = new Review(2L, "Corolla", "https://farm5.staticflickr.com/4166/34257513110_d96b22c672_b.jpg","Casual Sedan","Specs");

	
	
	
	public ReviewRepository() {
		reviewList.put(reviewOne.getId(), reviewOne);
		reviewList.put(reviewTwo.getId(), reviewTwo);
	}
	
	
	//variable argument for testing
	public ReviewRepository(Review...reviews) {
		for(Review review : reviews) {
			reviewList.put(review.getId(), review);
		}
	
	}

	public Review findOneReview(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAllReviews() {
		return reviewList.values();
	}

}
