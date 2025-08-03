package io.github.rhaissabg.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManagerDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Order> orders = new ArrayList<Order>();
		int option = 1;
		
		while (option != 0) {
			System.out.println("Enter a number to select an action: ");
			System.out.println("1 - Register new order");
			System.out.println("2 - Serve next order");
			System.out.println("3 - List all pending orders");
			System.out.println("4 - List all served orders");
			System.out.println("5 - Cancel order");
			System.out.println("0 - Exit");
			option = sc.nextInt();
			switch (option) {
			case 1:
				orders.add(registerNewOrder(sc));
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
			}
		}
		
		System.out.println(orders);
		sc.close();

	}
	
	private static Order registerNewOrder(Scanner sc) {
		Order order = new Order();
		System.out.print("Enter customer name: ");
		sc.nextLine();
		order.setCustomerName(sc.nextLine());

		ArrayList<String> items = new ArrayList<String>();
		boolean addMore = true;
		int count = 1;
		do {
			System.out.printf("Enter #%d item: ", count);
			String item = sc.nextLine();
			items.add(item);
			count++;
			System.out.print("Do you want to add more items? (0 - no / 1 - yes) ");
			int option = sc.nextInt();
			sc.nextLine();
			if (option == 0) {
				addMore = false;
			}
		} while (addMore);
		order.setOrderItems(items);
		System.out.print("Is the order for pickup (1) or delivery (2)? ");
		int deliveryOrPickup = sc.nextInt();
		if (deliveryOrPickup == 1) {
			order.setIsDelivery(false);
		} else if (deliveryOrPickup == 2) {
			order.setIsDelivery(true);
		}
		return order;
	}

}
