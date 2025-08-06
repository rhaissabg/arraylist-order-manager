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
		
//		createOrders(orders);
		while (option != 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("\nEnter a number to select an action: \n");
			sb.append("1 - Register new order\n");
			sb.append("2 - Show next order\n");
			sb.append("3 - Serve next order\n");
			sb.append("4 - List all pending orders\n");
			sb.append("5 - List all served orders\n");
			sb.append("6 - Cancel order\n");
			sb.append("0 - Exit\n");
			option = catchException(sb.toString(), sc, 0, 6);
			switch (option) {
			case 1:
				orders.add(registerNewOrder(sc));
				break;
			case 2:
				if (!orders.isEmpty()) {
					System.out.println(orders.get(0));
				} else {
					System.out.println("You don't have any orders.");
				}
				break;
			case 3:
				serveOrder(orders, servedOrders);
				break;
			case 4:
				showOrders(orders);
				break;
			case 5:
				showOrders(servedOrders);
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
		return order;
	}

	private static void serveOrder(ArrayList<Order> orders, ArrayList<Order> servedOrders) {
		if (!orders.isEmpty()) {
			servedOrders.add(orders.get(0));
			orders.remove(0);
		} else {
			System.out.println("You don't have any orders.");
		}
	}

	private static void createOrders(ArrayList<Order> orders) {
		for (int i = 1; i <= 10; i++) {
			orders.add(new Order(("Customer " + i), new ArrayList<String>(List.of(("item " + i), ("item " + (i+1)))), (i % 2 == 0)));
		}
	}

	private static void removeOrder(Scanner sc, ArrayList<Order> orders) {
		System.out.print("Enter the client name to delete order: ");
		String customerName = sc.nextLine();
		for (int i = 0; i < orders.size(); i++) {
			if (customerName.equalsIgnoreCase(orders.get(i).getCustomerName())) {
				orders.remove(i);
			}
		}
		System.out.println("Order was successfully deleted");
	}
	
	private static int catchException(String msg, Scanner sc, int min, int max) {
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
	
	private static void showOrders(ArrayList<Order> orders) {
		if (!orders.isEmpty()) {
			for (Order order : orders) {
				System.out.println(order);
			}
		} else {
			System.out.println("You don't have any orders.");
		}
	}

}
