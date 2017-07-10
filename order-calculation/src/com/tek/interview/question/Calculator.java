package com.tek.interview.question;


import java.util.Map;

/***
 * Returns the Rounded tax/totals for the orders
*/
public class Calculator {
	public static double rounding(double value) {
		return (double)( Math.round((value * 100)) )/ 100;
		
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

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;
				
				// imported items
				if (r.get(i).getItem().getDescription().contains("imported")) {
					tax = rounding(r.get(i).getItem().getPrice() * 0.15); // Extra 5% tax on
					tax = (((r.get(i).getItem().getPrice() * 0.15)) * 100) / 100; // Extra 5% tax on
														
				} else {
					tax = rounding(r.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() + tax ;

				// Print out the item's total price
				System.out.println(r.get(i).getQuantity()+" "+r.get(i).getItem().getDescription() + ": " + rounding(totalprice));

				// Keep a running total
				totalTax += tax;
				total += rounding(r.get(i).getItem().getPrice());
							
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			// Print out the total amount
		
			System.out.println("Total: " + rounding(total));
			grandtotal += total;
		}
			// Print out the total sum of orders
		System.out.println("Sum of orders: " + (grandtotal * 100) / 100);
	}
}
