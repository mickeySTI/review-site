package com.reviewsite;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewSiteController {
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	
	
	@RequestMapping("/review")
	public String findOneReview(@RequestParam(value="id")long id, Model model) throws ReviewNotFound{
		 Optional<Review> review = reviewRepo.findById(id);
		 
		 if(review.isPresent()) {
			 					// this always stays plural
			 model.addAttribute("reviews", review.get());
			 return "review";
		 }
		throw new ReviewNotFound();
		 
		
	}


	@RequestMapping("/show-reviews") // name on of end point
	public String findAllReviews(Model model) {
							// this always stays plural
		model.addAttribute("reviews", reviewRepo.findAll());
		return("reviews"); // name of template
		
	}


	public String findOneCategory(@RequestParam(value="id")long id, Model model) throws CategoryNotFound {
		Optional<Category> category = categoryRepo.findById(id);
		
		if(category.isPresent()) {
			model.addAttribute("categories", category.get());
			return "category";
			
		}
		
		throw new CategoryNotFound();
		
	}

	@RequestMapping("/show-categories") // end point
	public String findAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return("categories"); //name plate
		
	}
	
	
	

}
