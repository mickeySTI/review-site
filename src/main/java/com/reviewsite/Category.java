package com.reviewsite;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Category {
	
	

	@Id
	@GeneratedValue
	private long id;

	
	
	private String category;
	
	@ManyToOne // establishing relationship
	private Review review;

	public Category() {
		
	}
	
	public Category(String category,Review review) {
		this.category = category;
		this.review = review;
		                                                                                                                                                                              
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
	
	
	

	

}
