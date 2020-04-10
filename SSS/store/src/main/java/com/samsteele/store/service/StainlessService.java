package com.samsteele.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsteele.store.face.*;
import com.samsteele.store.model.*;

@Service
public class StainlessService {

	@Autowired
	invyTable invy;
	
	@Autowired
	clientTable Customer;
	
	@Autowired
	orderTable Kart;
	
	@Autowired
	oleTable item;
	
	public Iterable<inventory> showAllInvy(){
		return invy.findAll();
	}
	
	public Iterable<inventory> showAllInvy(int Price, String compare){
		if(compare == "below") {
			return invy.belowPrive(Price);
		}
		else
			return invy.abovePrive(Price);
	}
	
	public Iterable<inventory> showAllInvy(int PriceLow, int PriceHi){
		return invy.betweenPrive(PriceLow, PriceHi);
	}
	
	public Iterable<inventory> showAllInvy(String type){
		return invy.findByType(type);
	}
	
	public Iterable<inventory> showAllInvyLikeName(String name){
		name = "%"+name+"%";
		return invy.findLikeName(name);
		
	}
	
	public Iterable<inventory> builtInLikeName(String name){
		return invy.findByItemnameLike(name);
	}
	
	public Iterable<inventory> builtInBetweenPrice(int one, int two){
		return invy.findByPriceBetween(one, two);
	}
	
	public client addCustomer(String fn, String ln, String pn, String street, String city, String state, int zip) {
		client newC = new client(fn, ln, pn, street, city, state, zip);
		return Customer.save(newC);
	}
	
	public client updateCustomer(int CID, String fn, String ln, String pn, String street, String city, String state, int zip) {
		client updateC = Customer.findById(CID).isEmpty()? null: 
						  Customer.findById(CID).get();
		if(updateC == null)
			return null;
		
		updateC.setCity(city);
		updateC.setFname(fn);
		updateC.setLname(ln);
		updateC.setPronoun(pn);
		updateC.setState(state);
		updateC.setStreet(street);
		updateC.setZip(zip);
		
		return Customer.save(updateC);
	}
	
	public client viewCustomer(int CID) {
		return Customer.findById(CID).isEmpty()?null:Customer.findById(CID).get();
	}
	
	public orderlist newWorldOrder(int CID, String oName) {
		Kart.AddCust(CID, oName);
		orderlist NWO = Kart.lastAdded();
		
		return NWO;
	}
	
	public Iterable<inventory> viewWorldOrder(int OID){
		return invy.viewLineItems(OID);
	}
	
	private boolean UOI(int OID) {
		
		
		orderlist reUp = Kart.findById(OID).isPresent()?Kart.findById(OID).get():null;
		if(reUp == null)
			return false;
		
		Iterable<inventory> items = viewWorldOrder(reUp.getOrderID());
		int count = 0, total = 0;
		for(inventory item: items) {
			count ++;
			total += (item.getPrice() * item.getInvyID());
		}
		
		reUp.setItemcount(count);
		reUp.setTotalprice(total);
		
		Kart.save(reUp);
		
		return true;
	}
	
	public boolean addItem(int OID, int IID, int QTY) {
		
		ole newItem = new ole(OID,IID,QTY);
		item.save(newItem);
		UOI(OID);
		return true;
	}
	
	public boolean upItem(int id, int OID, int IID, int QTY) {
		ole holder = item.findById(id).isEmpty()?null:
					  item.findById(id).get();
		
		if(holder == null){return false;}
		
		holder.setInvyfk(IID);
		holder.setOrderfk(OID);
		holder.setQuantity(QTY);
		
		item.save(holder);
		
		UOI(OID);
		return true;		
	}
	
	public boolean deleteI(int id) {
		int OID;
		if(item.existsById(id) ) {
			OID = item.findById(id).get().getOrderfk();
			item.deleteById(id);
		}
		else
			return false;
		
		UOI(OID);
		return true;
	}
	
	public orderlist Fianzlize(int OID) {
		orderlist FZ = Kart.findById(OID).isEmpty()?null:Kart.findById(OID).get();
		
		if(FZ == null)
			return null;
		
		FZ.setIsfinal(true);
		
		return Kart.save(FZ);
	}
}
