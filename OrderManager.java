package io.github.rhaissabg.arraylist;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderManager {

	Order registerNewOrder(Scanner sc) {
		Order order = new Order();
		System.out.print("\nEnter customer name: ");
		//		sc.nextLine();
		order.setCustomerName(sc.nextLine());

		ArrayList<String> items = new ArrayList<String>();
		boolean addMore = true;
		int count = 1;
		do {
			System.out.printf("Enter #%d item: ", count);
			String item = sc.nextLine();
			items.add(item);
			count++;
			int option = catchException("Do you want to add more items? (0 - no / 1 - yes) ", sc, 0, 1);
			if (option == 0) {
				addMore = false;
			}
		} while (addMore);
		order.setOrderItems(items);
		int option = catchException("Is the order for pickup (1) or delivery (2)? ", sc, 1, 2);
		if (option == 1) {
			order.setIsDelivery(false);
		} else if (option == 2) {
			order.setIsDelivery(true);
		}
		System.out.println("\nOrder created\n" + order + "\n");
		return order;
	}

	void serveOrder(ArrayList<Order> orders, ArrayList<Order> servedOrders) {
		if (!orders.isEmpty()) {
			servedOrders.add(orders.get(0));
			orders.remove(0);
		} else {
			System.out.println("You don't have any orders.");
		}
	}

	void createOrders(ArrayList<Order> orders) {
		for (int i = 1; i <= 10; i++) {
			orders.add(new Order(("Customer " + i), new ArrayList<String>(List.of(("item " + i), ("item " + (i+1)))), (i % 2 == 0)));
		}
	}

	void removeOrder(Scanner sc, ArrayList<Order> orders) {
		System.out.print("Enter the order id to delete order: ");
		int id = sc.nextInt();
		boolean validId = false;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getId().equals(id)) {
				validId = true;
				System.out.println("\nOrder " + id + " was successfully deleted");
				System.out.println(orders.get(i));
				orders.remove(i);
				break;
			}
		}
		if (!validId) {
			System.out.println("Order not found");
		}
//		int id = catchException("Enter the order id to delete order: ", sc, 0, (orders.size()));
//		System.out.println("\nOrder " + id + " was successfully deleted");
//		System.out.println(orders.get(id - 1));
//		orders.remove(id - 1);
	}

	int catchException(String msg, Scanner sc, int min, int max) {
		boolean validOption = false;
		while (!validOption) {
			try {
				System.out.print(msg);
				int option = sc.nextInt();
				sc.nextLine();
				if (option >= min && option <= max) {
					validOption = true;
					return option;
				} else {
					System.out.println("\nPlease, enter a valid option\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nPlease, enter a valid number option\n");
				sc.nextLine();
			}
		}
		return -1;
	}

	void showOrders(ArrayList<Order> orders) {
		if (!orders.isEmpty()) {
			for (Order order : orders) {
				System.out.println(order);
			}
		} else {
			System.out.println("You don't have any orders.");
		}
	}

}
