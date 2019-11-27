package com.pizza.bean;

public class PizzaOrder {
	private int orderId; 
	private int customerId;
	private String topup;
	private double totalPrice;
	public String getTopup() {
		return topup;
	}
	public void setTopup(String topup) {
		this.topup = topup;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String toString()
	{
		return ""+totalPrice+"";
	}

}
