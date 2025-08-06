package io.github.rhaissabg.arraylist;

import java.util.ArrayList;
import java.util.Objects;

public class Order {

	private Integer id;
	private static Integer count = 1;
	private String customerName;
	private ArrayList<String> orderItems;
	private Boolean isDelivery;
	
	public Order(String customerName, ArrayList<String> orderItems, Boolean isDelivery) {
		this.customerName = customerName;
		this.orderItems = orderItems;
		this.isDelivery = isDelivery;
		this.id = count++;
	}

	public Order() {
		this.id = count++;
	}

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

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nOrder id: " + this.id);
		sb.append("\nCustomer name: " + this.customerName);
		sb.append("\nOrder items:\n");
		for (int i = 0; i < this.orderItems.size(); i++) {
			sb.append((i+1) + " - " + this.orderItems.get(i) + "\n");
		}
		sb.append("Delivery or pickup: " + (isDelivery ? "delivery" : "pickup") + "\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerName, id, isDelivery, orderItems);
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
		return Objects.equals(customerName, other.customerName) && Objects.equals(id, other.id)
				&& Objects.equals(isDelivery, other.isDelivery) && Objects.equals(orderItems, other.orderItems);
	}
	
}
