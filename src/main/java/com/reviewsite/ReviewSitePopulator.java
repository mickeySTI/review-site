package com.reviewsite;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewSitePopulator implements CommandLineRunner{
	
	
	@Resource
	private ReviewRepository reviewRepo;
	
	
	
	@Resource
	private CategoryRepository categoryRepo;


	//Data 
	@Override
	public void run(String... args) throws Exception {
		
		Review carOne = new Review( "WRXSTI","/images/WRXSTI.jpg","This is a review about the Subaru STI");
		carOne = reviewRepo.save(carOne);
		Review carTwo = new Review( "Corolla", "/images/Corolla.jpg","This is a review about the Toyota Corolla");
		carTwo = reviewRepo.save(carTwo);
		
		
		Category carCategory = new Category("Cars",carOne,carTwo);
		carCategory = categoryRepo.save(carCategory);
		
		
	}
	
	
	
	
	
	
	
	

}
