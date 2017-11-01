package com.test;

import java.util.LinkedHashMap;

/**
 * Fooed class is main class to calculate the Food orders.
 * @see Calculator
 * @see Order
 */
public class Foo {
	public static void main(String[] args) throws Exception {

		LinkedHashMap<String, Order> orders = new LinkedHashMap<String, Order>();

		Order order = new Order();

		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		orders.put("Order 1", order);

		// Reuse cart for an other order
		order = new Order();

		order.add(new OrderLine(new Item("imported box of chocolate",10), 1));
		order.add(new OrderLine(new Item("imported bottle of perfume", (float)47.50), 1));

		orders.put("Order 2", order);

		// Reuse cart for an other order
		order = new Order();

		order.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		order.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		order.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		order.add(new OrderLine(new Item("box of importd chocolates", (float) 11.25), 1));

		orders.put("Order 3", order);

		new Calculator().calculate(orders);

	}
}
