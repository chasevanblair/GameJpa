package model;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GameObj
 *
 */
@Entity
@Table (name="gameList")
public class GameObj{
	
	//hand created
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="PRICE")
	private double price;
	@Column(name="RATING")
	private int ratingPercent;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRatingPercent() {
		return ratingPercent;
	}

	public void setRatingPercent(int ratingPercent) {
		this.ratingPercent = ratingPercent;
	}

	public GameObj() {
		super();
	}
	
	public String toString() {
		return "Title: " + title + "\nPrice: " + price + "\nRating: " + ratingPercent;
	}
	
	public GameObj(String title, double price, int ratingPercent) {
		super();
		this.title = title;
		this.price = price;
		this.ratingPercent = ratingPercent;
	}
	
	
   
}
