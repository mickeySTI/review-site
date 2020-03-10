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
		underTest.findOneReview(arbId, model);
		verify(model).addAttribute("reviews",review);
		
		
	}
	

	
	@Test
	public void shouldAddSingleCategoryToModel () throws CategoryNotFound {
		long arbId = 1;
		when(categoryRepo.findById(arbId)).thenReturn(Optional.of(category));
		
		underTest.findOneCategory(arbId,model);
		verify(model).addAttribute("categories",category);
		
	}
	
	
	@Test
	public void shouldAddAllCategoriesToModel() {
		Collection<Category> allCategories = Arrays.asList(category, anotherCategory);
		
		when(categoryRepo.findAll()).thenReturn(allCategories);
		
		underTest.findAllCategories(model);
		verify(model).addAttribute("categories", allCategories);
		
		
		
	}
	
	

}
