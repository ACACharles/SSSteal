package com.samsteele.store.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsteele.store.model.client;
import com.samsteele.store.model.inventory;
//import com.samsteele.store.model.ole;
import com.samsteele.store.model.orderlist;
import com.samsteele.store.service.StainlessService;

@RestController
public class StoreSheath {
	
	@Autowired
	StainlessService steel;
	
	@GetMapping("/creator")
	String whoMadeYou() {return"Charles Roy Washington III";}
	
	@GetMapping("/hello")
	String helloWorld() {return "hello you i'm me";}
	
	@GetMapping("/invy")
	Iterable<inventory> getAllInvy() {
		return steel.showAllInvy();
	}
	
	@GetMapping("/invy/{name}")
	Iterable<inventory> getInvyName(@PathVariable String name){
		return steel.showAllInvyLikeName(name);
	}
	
	@GetMapping("/builtin/{name}")
	Iterable<inventory> getInvyNameBI(@PathVariable String name){
		return steel.builtInLikeName(name);
	}
	
	@GetMapping("/builtin/{one}/{two}")
	Iterable<inventory> getTypeBI(@PathVariable int one, @PathVariable int two){
		return steel.builtInBetweenPrice(one, two);
	}
	
	// "/invy/type/{type}"
	// type  R/B
	// "/invy/type/R/B"
	@GetMapping("/invy/type/{type}")
	Iterable<inventory> getInvyType(@PathVariable String type){
		return steel.showAllInvy(type);
	}
	
	@GetMapping("/invy/{PriceHi}/{PriceLow}")
	Iterable<inventory> getInvyBetweenPrice(@PathVariable int PriceHi, @PathVariable int PriceLow){
		return steel.showAllInvy(PriceLow, PriceHi);
	}
	
	@GetMapping("/invy/{Price}/below")
	Iterable<inventory> getInvyBelowPrice(@PathVariable int Price){
		return steel.showAllInvy(Price,"below");
	}
	
	@GetMapping("/invy/{Price}/above")
	Iterable<inventory> getInvyPrice(@PathVariable int Price){
		return steel.showAllInvy(Price,"above");
	}
	
	@GetMapping("/viewOrder/{OID}")
	Iterable<inventory> getOrderLineitems(@PathVariable int OID){
		return steel.viewWorldOrder(OID);
	}
	
	@GetMapping("/Customer/{id}")
	client showClient(@PathVariable int id){
		return steel.viewCustomer(id);
	}
	
	@PostMapping("/Customer")
	client newCient(@RequestParam String fn, @RequestParam String ln, @RequestParam String pn,@RequestParam  String street, @RequestParam String city, 
			       @RequestParam String state, @RequestParam int zip) {
		return steel.addCustomer(fn, ln, pn, street, city, state, zip);
	}
	
	@PostMapping("/Order")
	orderlist newOrder(@RequestParam int CID, @RequestParam String oName) {
		return steel.newWorldOrder(CID, oName);
	}
	
	@PostMapping("/AddItem")
	boolean addLineItem(@RequestParam int OID, @RequestParam  int IID,@RequestParam  int QTY) {
		return steel.addItem(OID, IID, QTY);
	}
	
	@PutMapping("/update/Client")
	client upClient(@RequestParam int CID, @RequestParam int zip, @RequestParam String state, @RequestParam String city, 
					@RequestParam String street, @RequestParam String pn, @RequestParam String ln, @RequestParam String fn) {
		return steel.updateCustomer(CID, fn, ln, pn, street, city, state, zip);
	}
	
	@PutMapping("/update/Order")	
	boolean upItem(@RequestParam int id, @RequestParam int OID, @RequestParam int IID, @RequestParam int QTY) {
		return steel.upItem(id, OID, IID, QTY);
	}
	
	@PutMapping("/update/Finish")
	orderlist done(@RequestParam int OID) {
		return steel.Fianzlize(OID);
	}
	
	@DeleteMapping("/delete/LineItem")
	boolean donzo(@RequestParam int id) {
		return steel.deleteI(id);
	}
}
