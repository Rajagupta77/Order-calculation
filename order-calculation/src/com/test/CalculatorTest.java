package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.tek.interview.question.Calculator;
import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;

public class CalculatorTest {
	
	Calculator cal = new Calculator();
	
	@Test
	public void roundingTest() {
	double rounding = cal.rounding(13.73999999);
	assertEquals(13.74,rounding,0.0);
	}
	@Test
	public void calculateTest() throws Exception {
		Map<String, Order> orderList = new LinkedHashMap<String, Order>();

		Order order = new Order();
		
		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		orderList.put("Order 1", order);

		assertEquals(null,orderList.get("Order 3"));
		assertTrue(orderList.containsKey("Order 1"));
		
		for (Map.Entry<String,Order> entry : orderList.entrySet()){
			String actualValue = entry.getKey();
			Order actual = entry.getValue();
			assertNotNull(actualValue);
			assertEquals(entry.getValue(),actual);
		}
		
			
	}
	}

