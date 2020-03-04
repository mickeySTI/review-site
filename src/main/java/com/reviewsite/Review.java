package com.reviewsite;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Review {
	
	
		@Id
		@GeneratedValue
		private long id;
	
	//
		//default constructor
		public Review() {
			
		}
		

							
		@OneToMany(mappedBy = "review")
		private Collection<Category> categories;
		
		
		
		private String title;
		private String urlImage;
		private String engine;
		private String hp;
		private String description;
	
		public Review(String title, String urlImage, String description, String engine, String hp) {
		this.title = title;
		this.urlImage = urlImage;
		this.description = description;
		this.engine = engine;
		this.hp = hp;
	}

	public long getId() {
		return id;
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
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getTitle() {
		return title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public String getEngine() {
		return engine;
	}

	public String getHp() {
		return hp;
	}

	public String getDescription() {
		return description;
	}

	public Collection<Category> getCategories() {
		// TODO Auto-generated method stub
		return categories;
	}
	
	

}
