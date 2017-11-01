package com.test.testcase;

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
	@Test
	public void testCalculate() {
		Assert.assertEquals(new Double(17), new Double(calc.calculate(null)));
	}
	@Test
	public void testPassCalculate() {
		LinkedHashMap<String, Order> orders = new LinkedHashMap<String, Order>();

		Order order = new Order();

		try {
			order.add(new OrderLine(new Item("book", (float) 13.74), 1));
			order.add(new OrderLine(new Item("music CD", (float) 16.49), 1));
			order.add(new OrderLine(new Item("chocolate bar", (float) 0.94), 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		orders.put("Order 1", order);
		Assert.assertEquals(new Double(29.16), new Double(calc.calculate(orders)));
	}
	

	@Test
	public void testFailCalculate() {
		LinkedHashMap<String, Order> orders = new LinkedHashMap<String, Order>();

		Order order = new Order();

		try {
			order.add(new OrderLine(new Item("imported box of chocolate", (float)11.5), 1));
			order.add(new OrderLine(new Item("imported bottle of perfume", (float) 54.62), 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		orders.put("Order 2", order);
		//Sum of orders: 57.11
		Assert.assertEquals(new Double(29.16), new Double(calc.calculate(orders)));
	}

}
