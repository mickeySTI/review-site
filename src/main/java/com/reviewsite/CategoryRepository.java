package com.reviewsite;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository <Category,Long> {

	Collection<Category> findByReviewsContains(Review reviews);

	Collection<Category> findByReviewsId(long reviewsId);
	
	

}
