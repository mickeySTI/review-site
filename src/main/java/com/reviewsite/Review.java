package com.reviewsite;

public class Review {

		private Long id;
		private String title;
		private String urlImage;
		private String reviewCategory;
		private String content;
	
		public Review(long id, String title, String urlImage, String reviewCategory, String content) {
		this.id = id;
		this.title = title;
		this.urlImage = urlImage;
		this.reviewCategory = reviewCategory;
		this.content = content;
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

	public String getContent() {
		return content;
	}
	
	

}
