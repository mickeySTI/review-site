package com.reviewsite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {
	
	
	Map<Long,Review> reviewList = new HashMap<Long, Review>();
	private Review reviewOne = new Review(1L, "WRXSTI", "imageURL","sports car","specs");
	private Review reviewTwo = new Review(1L, "Corolla", "imageURL","casual sedan","specs");

	
	
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
