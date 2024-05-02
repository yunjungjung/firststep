package com.itwill.posproject.model;

public class Order extends Object{
	private String name;
	private int price;

public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price
				+ "]";
	}
	
	
}