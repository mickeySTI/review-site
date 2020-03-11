package com.reviewsite;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class) // Need this annotation any time we test JPA
@DataJpaTest // Need this annotation any time we test JPA
public class JPAMappingTest {
	
	
	@Resource // injecting entity manager
	private TestEntityManager entityManager;
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	
	
	
	@Test
	public void shouldLoadAndSaveReview() {
		Category category = categoryRepo.save(new Category("cars"));
		Review review = reviewRepo.save(new Review("STI", "img", "description"));
		long reviewId = review.getId(); 
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getTitle(), is("STI"));
		
		
	}
	
	
	@Test
	public void shouldGenerateReviewId() {
		Review review = reviewRepo.save(new Review("STI", "img", "description"));
		long reviewId =  review.getId();
		entityManager.flush();
		entityManager.clear();
		assertThat(reviewId, is(greaterThan(0L)));
		
	}
	
	
	@Test
	public void shouldSaveandLoadCategory(){
	Category category  = categoryRepo.save(new Category("cars"));
	long catId = category.getId();
	entityManager.flush();
	entityManager.clear();
	
	Optional<Category> result = categoryRepo.findById(catId);
	category = result.get();
	assertThat(category.getName(), is("cars"));
		
	}
	
	@Test
	public void shouldEstablishCategoryToReviewRelationship(){
		
		Review reviewOne = reviewRepo.save(new Review("STI", "img", "description"));
		Review reviewTwo = reviewRepo.save(new Review("Toyota", "img", "description"));
		
		Category category = categoryRepo.save(new Category("cars", reviewOne, reviewTwo));
		long catId = category.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Category>result = categoryRepo.findById(catId); //finding specific review we just created
		category = result.get(); // getting that specific review and assigning it to the variable review 
		
		assertThat(category.getReviews(), containsInAnyOrder(reviewOne, reviewTwo));
		
	}
	
	
	@Test
	public void shouldFindCategoriesForReview() {
		
		Review reviewOne = reviewRepo.save(new Review("STI", "img", "description"));
		
		Category category = categoryRepo.save(new Category("cars",reviewOne));
	

		entityManager.flush();  
		entityManager.clear();
							
		Collection<Category> categoryForReview = categoryRepo.findByReviewsContains(reviewOne);
		
		
		assertThat(categoryForReview, containsInAnyOrder(category));
		
	}
	
	@Test
	public void shouldFindCategoriesForReviewId() {
		Review review = reviewRepo.save(new Review("STI", "img", "cars"));
		long reviewId = review.getId();
	
		Category category  = categoryRepo.save(new Category("cars",review));
		
	
		entityManager.flush();  
		entityManager.clear();
																	
		Collection<Category> categoryForReview = categoryRepo.findByReviewsId(reviewId);
		
		
		assertThat(categoryForReview, containsInAnyOrder(category));
		
		
	}
	
	
	
	
	

}
