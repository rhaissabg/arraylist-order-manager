package io.github.rhaissabg.arraylist;

import java.util.ArrayList;
import java.util.Objects;

public class Order {

	private String customerName;
	private ArrayList<String> orderItems;
	private Boolean isDelivery;
	
	public Order(String customerName, ArrayList<String> orderItems, Boolean isDelivery) {
		this.customerName = customerName;
		this.orderItems = orderItems;
		this.isDelivery = isDelivery;
	}

	public Order() {}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public ArrayList<String> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<String> orderItems) {
		this.orderItems = orderItems;
	}

	public Boolean getIsDelivery() {
		return isDelivery;
	}

	public void setIsDelivery(Boolean isDelivery) {
		this.isDelivery = isDelivery;
	}

	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", orderItems=" + orderItems + ", isDelivery=" + isDelivery
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerName, isDelivery, orderItems);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(isDelivery, other.isDelivery)
				&& Objects.equals(orderItems, other.orderItems);
	}
	
}
