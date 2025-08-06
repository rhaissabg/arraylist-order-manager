package io.github.rhaissabg.arraylist;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderManagerDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Order> orders = new ArrayList<Order>();
		ArrayList<Order> servedOrders = new ArrayList<Order>();
		int option = 1;
		createOrders(orders);
		while (option != 0) {
			System.out.println("\nEnter a number to select an action: ");
			System.out.println("1 - Register new order");
			System.out.println("2 - Show next order");
			System.out.println("3 - Serve next order");
			System.out.println("4 - List all pending orders");
			System.out.println("5 - List all served orders");
			System.out.println("6 - Cancel order");
			System.out.println("0 - Exit");
			option = sc.nextInt();
			switch (option) {
			case 1:
				orders.add(registerNewOrder(sc));
				break;
			case 2:
				System.out.println(orders.get(0));
				break;
			case 3:
				serveOrder(orders, servedOrders);
				break;
			case 4:
				for (Order order : orders) {
					System.out.println(order);
				}
				break;
			case 5:
				for (Order order : servedOrders) {
					System.out.println(order);
				}
				break;
			case 6:
				removeOrder(sc, orders);
				break;
			default:
				break;
			}
		}

		sc.close();

	}

	private static Order registerNewOrder(Scanner sc) {
		Order order = new Order();
		System.out.print("\nEnter customer name: ");
		sc.nextLine();
		order.setCustomerName(sc.nextLine());

		ArrayList<String> items = new ArrayList<String>();
		boolean addMore = true;
		int count = 1;
		boolean validOption = false;
		do {
			System.out.printf("Enter #%d item: ", count);
			String item = sc.nextLine();
			items.add(item);
			count++;
			validOption = false;
			while (!validOption) {
				try {
					System.out.print("Do you want to add more items? (0 - no / 1 - yes) ");
					int option = sc.nextInt();
					sc.nextLine();
					if (option == 0) {
						addMore = false;
						validOption = true;
					} else if (option == 1) {
						validOption = true;
					} else {
						System.out.println("\nInvalid option, try again\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("\nEnter a valid option please\n");
					sc.nextLine();
				}
			}
		} while (addMore);
		order.setOrderItems(items);
		validOption = false;
		while (!validOption) {
			try {
				System.out.print("Is the order for pickup (1) or delivery (2)? ");
				int deliveryOrPickup = sc.nextInt();
				if (deliveryOrPickup == 1) {
					order.setIsDelivery(false);
					validOption = true;
				} else if (deliveryOrPickup == 2) {
					order.setIsDelivery(true);
					validOption = true;
				} else {
					System.out.println("\nInvalid option, try again\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nEnter a valid option please\n");
				sc.nextLine();
			}
		}
		return order;
	}

	private static void serveOrder(ArrayList<Order> orders, ArrayList<Order> servedOrders) {
		servedOrders.add(orders.get(0));
		orders.remove(0);
	}

	private static void createOrders(ArrayList<Order> orders) {
		for (int i = 1; i <= 10; i++) {
			orders.add(new Order(("Customer " + i), new ArrayList<String>(List.of(("item " + i), ("item " + (i+1)))), (i % 2 == 0)));
		}
	}

	private static void removeOrder(Scanner sc, ArrayList<Order> orders) {
		System.out.print("Enter the client name to delete order: ");
		sc.nextLine();
		String customerName = sc.nextLine();
		for (int i = 0; i < orders.size(); i++) {
			if (customerName.equalsIgnoreCase(orders.get(i).getCustomerName())) {
				orders.remove(i);
			}
		}
		System.out.println("Order was successfully deleted");
	}

}
