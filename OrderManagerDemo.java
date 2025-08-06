package io.github.rhaissabg.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManagerDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		OrderManager orderManager = new OrderManager();

		ArrayList<Order> orders = new ArrayList<Order>();
		ArrayList<Order> servedOrders = new ArrayList<Order>();
		int option = 1;
		
		orderManager.createOrders(orders);
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
			option = orderManager.catchException(sb.toString(), sc, 0, 6);
			switch (option) {
			case 1:
				orders.add(orderManager.registerNewOrder(sc));
				break;
			case 2:
				if (!orders.isEmpty()) {
					System.out.println(orders.get(0));
				} else {
					System.out.println("You don't have any orders.");
				}
				break;
			case 3:
				orderManager.serveOrder(orders, servedOrders);
				break;
			case 4:
				orderManager.showOrders(orders);
				break;
			case 5:
				orderManager.showOrders(servedOrders);
				break;
			case 6:
				orderManager.removeOrder(sc, orders);
				break;
			default:
				break;
			}
		}

		sc.close();

	}

}
