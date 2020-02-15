package com.reviewsite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static  org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;


class ReviewRepositoryTest {
	
	
	private ReviewRepository underTest;
	
	private Review reviewOne = new Review(1L, "title", "imageURL","reviewCategory","content");
	private Review reviewTwo = new Review(2L, "title", "imageURL","reviewCategory","content");

	@Test
	void shouldFindReviewOneById() {
		underTest = new ReviewRepository(reviewOne); //injecting the Repository and creating Contructor in ReviewRepository
		Review foundReview = underTest.findOneReview(1L);
		assertThat(foundReview, is(reviewOne));
		
	}
	
	
	@Test
	void shouldFindReviewTwoById() {
		Review reviewTwo = new Review(2L, "title", "imageURL","reviewCategory","content");
		underTest = new ReviewRepository(reviewTwo); 
		Review foundReview = underTest.findOneReview(2L);
		assertThat(foundReview, is(reviewTwo));
		
	}
	
	@Test
	void shouldFindAllReviews() {
		underTest = new ReviewRepository(reviewOne, reviewTwo);
		Collection<Review> foundReviews = underTest.findAllReviews();
		assertThat(foundReviews, hasSize(2));
	}
	
	
	
	
	
	

}
