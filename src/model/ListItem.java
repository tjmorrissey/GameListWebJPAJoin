package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="RATING")
	private int rating;
	@Column(name="PRICE")
	private double price;
	

	public ListItem() {
		super();
	}
	
	public ListItem(String name) {
		super();
		this.name = name;
	}
	
	public ListItem(String name, int rating, double price) {
		super();
		this.name = name;
		this.rating = rating;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String returnGameDetails() {
		return name + " | " + rating + "/10 | $" + price;
	}
	
}
