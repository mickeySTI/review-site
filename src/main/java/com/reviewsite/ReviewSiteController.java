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
	
	
	@RequestMapping("/review")
	public String findOneCourse(@RequestParam(value="id")long id, Model model) throws ReviewNotFound{
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
	
	
	

}
