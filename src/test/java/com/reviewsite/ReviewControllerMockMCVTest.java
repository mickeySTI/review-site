package com.reviewsite;


import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewSiteController.class)
class ReviewControllerMockMCVTest {
	
	@Resource
	private MockMvc mvc;
	
	@Mock
	private Review reviewOne;

	@Mock
	private Review reviewTwo;
	
	//inject repo for test
	@MockBean // MockBean is REPOS!
	private ReviewRepository reviewRepo;
	
	@MockBean // MockBean is REPOS!
	private CategoryRepository categoryRepo;
	
	

	@Test
	public void shouldGetStatusOfOkWhenNavigatingToAllReviews() throws Exception {
		long arbReviewId = 1;
		when(reviewRepo.findById(arbReviewId)).thenReturn(Optional.of(reviewOne));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
		
	}
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToSingleReview() throws Exception {
		long arbReviewId = 1;
		when(reviewRepo.findById(arbReviewId)).thenReturn(Optional.of(reviewOne));
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	
	@Test
	public void shouldNotBeOkForSingleReview() throws Exception {
		long arbReviewId = 1;
		when(reviewRepo.findById(arbReviewId)).thenReturn(Optional.of(reviewOne));
		mvc.perform(get("/review?id=42")).andExpect(status().isNotFound());
	}
	
	
	@Test
	public void shouldBeOkForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}
	

	
	@Test
	public void shouldPutSingleReviewIntoModel() throws Exception{
		when(reviewRepo.findById(1L)).thenReturn(Optional.of(reviewOne));
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("reviews", reviewOne));
	
	}
	
	@Test
	public void shouldPutAllReviewsIntoModel() throws Exception{
		Collection<Review> allReviews = Arrays.asList(reviewOne,reviewTwo);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", allReviews));
		
		
	}
	
	
	@Test
	public void shouldPutAllReviewsIntoView() throws Exception{
		mvc.perform(get("/show-reviews")).andExpect(view().name(is("reviews")));
		
	}
	
	
}
