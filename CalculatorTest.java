
package com.test;

import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.test.Calculator;
import com.test.Item;
import com.test.Order;
import com.test.OrderLine;

public class CalculatorTest {
	Calculator calc = null;
	
	@Before
    public void setUp() throws Exception {
		calc = new Calculator();
    }
	/*@Test
	public void testCalculate() {
		Assert.assertEquals(new Double(17), new Double(calc.calculate(null)));
	}*/
	@Test
	public void testPassCalculate() {
		LinkedHashMap<String, Order> orders = new LinkedHashMap<String, Order>();

		Order order = new Order();

		try {
			order.add(new OrderLine(new Item("book", (float) 12.49), 1));
			order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
			order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		orders.put("Order 1", order);
		double d=calc.calculate(orders);
		 
		Assert.assertEquals(new Double(28.33),Double.valueOf(Math.round(d*100.0)/100.0));
		
	}
	

	@Test
	public void testFailCalculate() {
		LinkedHashMap<String, Order> orders = new LinkedHashMap<String, Order>();

		Order order = new Order();

		try {
			order.add(new OrderLine(new Item("imported box of chocolate",10), 1));
			order.add(new OrderLine(new Item("imported bottle of perfume", (float)47.50), 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		orders.put("Order 2", order);
		//Sum of orders: 57.5
		double d=calc.calculate(orders);
		Assert.assertEquals(new Double(57.5), Double.valueOf(Math.round(d*100.0)/100.0));
	}
	@Test
	public void testOrderThreeCal()
	{
		LinkedHashMap<String, Order> orders = new LinkedHashMap<String, Order>();

		Order order = new Order();

		try {
			order.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
			order.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
			order.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
			order.add(new OrderLine(new Item("box of importd chocolates", (float) 11.25), 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		orders.put("Order 3", order);
		//Sum of orders: 67.98
		double d=calc.calculate(orders);
		Assert.assertEquals(new Double(67.98), Double.valueOf(Math.round(d*100.0)/100.0));
		
	}

}

 
 
