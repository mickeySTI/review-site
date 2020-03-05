package com.reviewsite;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ReviewSiteControllerTest {
	
	@InjectMocks
	private ReviewSiteController underTest;
	
	@Mock
	private Review review;
	
	@Mock
	private Review anotherReview;
	
	@Mock
	private ReviewRepository reviewRepo;
	
	@Mock
	private Category category;
	
	@Mock
	private Category anotherCategory;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	
	
	@Mock
	private Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void shouldAddSingleReviewToModel() throws ReviewNotFound {
		long arbId = 1;
		when(reviewRepo.findById(arbId)).thenReturn(Optional.of(review));
		underTest.findOneCourse(arbId, model);
		verify(model).addAttribute("reviews",review);
		
		
	}
	
	@Test
	public void shouldFindAllCourses() {
		Collection<Review> allReviews = Arrays.asList(review,anotherReview);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		
		underTest.findAllReviews(model);
		verify(model).addAttribute("reviews", allReviews);
		
	}

	
	@Test
	public void shouldAddSingleCategoryToModel () {
		
	}
	
	
	@Test
	public void shouldAddAllCategoriesToModel() {
		
	}
	
	

}
