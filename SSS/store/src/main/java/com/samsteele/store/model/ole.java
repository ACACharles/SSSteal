package com.samsteele.store.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int oleID;
	
	int orderfk;
	
	int invyfk;
	
	int quantity;

	public ole() {
		super();
	}

	public ole(int orderfk, int invyfk, int quantity) {
		super();
		this.orderfk = orderfk;
		this.invyfk = invyfk;
		this.quantity = quantity;
	}

	public int getOleID() {
		return oleID;
	}

	public void setOleID(int oleID) {
		this.oleID = oleID;
	}

	public int getOrderfk() {
		return orderfk;
	}

	public void setOrderfk(int orderfk) {
		this.orderfk = orderfk;
	}

	public int getInvyfk() {
		return invyfk;
	}

	public void setInvyfk(int invyfk) {
		this.invyfk = invyfk;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
