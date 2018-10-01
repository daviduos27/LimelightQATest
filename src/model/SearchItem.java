package model;

public class SearchItem {
	
	String name;
	float price;
	float rating;
	int ratingPosition;
	int pricePosition;
	int generalQualification;
	
	public SearchItem(String name, float price, float rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getRatingPosition() {
		return ratingPosition;
	}
	public void setRatingPosition(int ratingPosition) {
		this.ratingPosition = ratingPosition;
	}
	public int getPricePosition() {
		return pricePosition;
	}
	public void setPricePosition(int pricePosition) {
		this.pricePosition = pricePosition;
	}
	public int getGeneralQualification() {
		return generalQualification;
	}
	public void setGeneralQualification(int generalQualification) {
		this.generalQualification = generalQualification;
	}
	
}
