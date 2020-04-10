package com.samsteele.store.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int invyID;
	
	String itemname;
	
	int price;
	
	String description;
	
	String type;

	public inventory() {
		super();
	}

	public inventory(String itemname, int price, String description, String t) {
		super();
		this.itemname = itemname;
		this.price = price;
		this.description = description;
		type = t;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getInvyID() {
		return invyID;
	}

	public void setInvyID(int invyID) {
		this.invyID = invyID;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
