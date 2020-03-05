package com.reviewsite;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;




@Entity
public class Category {
	
	

	@Id
	@GeneratedValue
	private long id;

	
	
	private String category;
	
	@ManyToMany // establishing relationship
	private Collection<Review> reviews;

	public Category() {
		
	}
	
	public Category(String category,Review...reviews) {
		this.category = category;
		this.reviews = new HashSet<>(Arrays.asList(reviews));
		                                                                                                                                                                              
	}

	public String getCategory() {
		return category;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}
	
	
	public Collection<Review> getReviews(){
		return reviews;
	}

	

}
