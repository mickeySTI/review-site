package com.reviewsite;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Review {
	
	
		@Id
		@GeneratedValue
		private long id;
	
		//default constructor
		public Review() {
			
		}
		

							
		@ManyToOne // owning side 
		private Category category;
		
		
		
		private String title;
		private String urlImage;
		private String engine;
		private String hp;
		@Lob
		private String description;
	
		public Review(String title, String urlImage, String description, Category category){
		this.title = title;
		this.urlImage = urlImage;
		this.description = description;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}
	
	

}
