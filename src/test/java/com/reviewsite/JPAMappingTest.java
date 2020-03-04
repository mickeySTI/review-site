package com.reviewsite;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
		Review review = reviewRepo.save(new Review("STI", "img", "review category", "EJ257", "300hp"));
		long reviewId = review.getId();
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getTitle(), is("STI"));
		
		
	}
	
	
	
	@Test
	public void shouldGenerateReviewId() {
		Review review = reviewRepo.save(new Review("STI", "img", "review category", "EJ257", "300hp"));	
		long reviewId =  review.getId();
		entityManager.flush();
		entityManager.clear();
		assertThat(reviewId, is(greaterThan(0L)));
		
	}
	
	
	
	
	
	@Test
	public void shouldSaveandLoadCategory(){
	Review review = reviewRepo.save(new Review("STI", "img", "review category", "EJ257", "300hp"));	
	Category category  = categoryRepo.save(new Category("cars",review));
	long catId = category.getId();
	entityManager.flush();
	entityManager.clear();
	
	Optional<Category> result = categoryRepo.findById(catId);
	category = result.get();
	assertThat(category.getCategory(), is("cars"));
	
	
	
		
		
	}
	
	
	

}