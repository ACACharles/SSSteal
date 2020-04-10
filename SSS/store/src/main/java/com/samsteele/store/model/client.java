package com.samsteele.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int clientID;
	
	String fname;
	
	String lname;
	
	String pronoun;
	
	String street;
	
	String city;
	
	String state;
	
	int zip;
	
	

	public client() {
		super();
	}

	public client(String fname, String lname, String pronoun, String street, String city, String state, int zip) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.pronoun = pronoun;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPronoun() {
		return pronoun;
	}

	public void setPronoun(String pronoun) {
		this.pronoun = pronoun;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	
}
