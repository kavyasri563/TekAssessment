package com.test;

import java.util.Map;

/**
 * Calculator class is useful to calculate the item's sales tax, total price and grand total for the orders.
 * @see Order
 */
public class Calculator {

	/**
	 * Rounding for the given value.
	 * @param value
	 * @return
	 */
	public static double rounding(double value) {
		return ((value * 100)) / 100;
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;
		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");

			Order r = entry.getValue();

			double salesTax = 0;
			double totalAmount = 0;
			Item item = null;
			double totalprice = 0;

			// Iterate through the items in the order
			//Indexes should be 0 to (size-1).
			for (int i = 0; i < r.size(); i++) {
				item = r.get(i).getItem();
				// Calculate the taxes
				double tax = 0;
				
				// In foo Item is started with Capital Imported so here I have added toLowerCase.
				if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					tax = rounding(item.getPrice() * 0.15); // Extra 5% tax on
					// imported items
				} else {
					tax = rounding(item.getPrice() * 0.10);
				}

				// Calculate the total price
				totalprice = item.getPrice() + tax;

				// Print out the item's total price
				System.out.println(item.getDescription() + ": " +Math.round(totalprice*100.0)/100.0);

				// Keep a running total
				salesTax += tax;
				totalAmount += totalprice;
			}
			// multiplying with 100 and rounding with the first 100 and again dividing it with 100 makes the output.
			// Print out the total taxes
			System.out.println("Sales Tax: " + Math.round(salesTax*100.0)/100.0);

			totalAmount = totalAmount - salesTax;

			// multiplying with 100 and rounding with the first 100 and again dividing it with 100 makes the output.
			// Print out the total amount
			System.out.println("Total: " +Math.round(totalAmount*100.0)/100.0);
			grandtotal += totalAmount;
		}
		// multiplying with 100 and rounding with the first 100 and again dividing it with 100 makes the output.
		System.out.println("Sum of orders: " + Math.round(grandtotal * 100.0) / 100.0);
	}
}
