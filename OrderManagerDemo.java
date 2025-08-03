package io.github.rhaissabg.arraylist;

import java.util.ArrayList;
import java.util.List;

public class OrderManagerDemo {

	public static void main(String[] args) {
		
		Order order = new Order("Customer 1", new ArrayList<String>(List.of("hot dog", "hamburger")), true);
		System.out.println(order);

	}

}
