package com.reviewsite;

public class Review {

		private Long id;
		private String title;
		private String urlImage;
		private String reviewCategory;
		private String engine;
		private String hp;
	
		public Review(long id, String title, String urlImage, String reviewCategory, String engine, String hp) {
		this.id = id;
		this.title = title;
		this.urlImage = urlImage;
		this.reviewCategory = reviewCategory;
		this.engine = engine;
		this.hp = hp;
	}

	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public String getReviewCategory() {
		return reviewCategory;
	}

	public String getEngine() {
		return engine;
	}

	public String getHp() {
		return hp;
	}
	
	

}
