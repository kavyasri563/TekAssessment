package com.test;

import java.util.LinkedHashMap;

/**
 * Fooed class is main class to calculate the Food orders.
 * @see Calculator
 * @see Order
 */
public class Fooed {
	public static void main(String[] args) throws Exception {

		LinkedHashMap<String, Order> orders = new LinkedHashMap<String, Order>();

		Order order = new Order();

		order.add(new OrderLine(new Item("book", (float) 13.74), 1));
		order.add(new OrderLine(new Item("music CD", (float) 16.49), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.94), 1));

		orders.put("Order 1", order);

		// Reuse cart for an other order
		order = new Order();

		order.add(new OrderLine(new Item("imported box of chocolate", (float)11.5), 1));
		order.add(new OrderLine(new Item("imported bottle of perfume", (float) 54.62), 1));

		orders.put("Order 2", order);

		// Reuse cart for an other order
		order = new Order();

		order.add(new OrderLine(new Item("Imported bottle of perfume", (float) 32.19), 1));
		order.add(new OrderLine(new Item("bottle of perfume", (float) 20.89), 1));
		order.add(new OrderLine(new Item("packet of headache pills", (float) 10.73), 1));
		order.add(new OrderLine(new Item("box of importd chocolates", (float) 12.94), 1));

		orders.put("Order 3", order);

		new Calculator().calculate(orders);

	}
}
