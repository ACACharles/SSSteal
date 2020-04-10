package com.samsteele.store.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class orderlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderID;
	
	int clientfk;
	
	String name;
	
	int totalprice;
	
	int itemcount;
	
	boolean isfinal;
	
	public orderlist() {
		super();
	}

	public orderlist(int clientfk, String name, int totalprice, int itemcount, boolean isfinal) {
		super();
		this.clientfk = clientfk;
		this.name = name;
		this.totalprice = totalprice;
		this.itemcount = itemcount;
		this.isfinal = isfinal;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getClientfk() {
		return clientfk;
	}

	public void setClientfk(int clientfk) {
		this.clientfk = clientfk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public boolean isIsfinal() {
		return isfinal;
	}

	public void setIsfinal(boolean isfinal) {
		this.isfinal = isfinal;
	}
	
	
	
}
