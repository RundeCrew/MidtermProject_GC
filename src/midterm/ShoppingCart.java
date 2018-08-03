package midterm;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
			
	// TODO figure out propr way to call the Array list in the parameters
	public static String getValidInventoryChoice (Scanner scnr, String prompt, Inventory <String, Double> inventory) { 
		int userInput;
		boolean inputIsValid = false;

		do {
			System.out.println(prompt);
			userInput = scnr.nextInt();
			if (Validator.getInt(scnr,"Please select the item number that you would like to add to your cart.", 1, inventory.getlength())) {  //Validatory for selecting item from the array list called invntory
				break; // Break the loop
			} else {
				System.out.println("We don't offer this item, please enter a new option.");
				continue;
			}
		} while (inputIsValid == false);
		
		return userInput;
	}
	
		// this will list every item with the price, just need to know how to call the items in the parameters
		// this method will also add the items price each time around and print a running subtotal
	private static void listPrice(ArrayList<String> shoppingCart, (((ARRAY LIST))), inventory) {
		double price = 0.0;
		double sumTotal = 0.0;
		
		for (String item : shoppingCart) {
			price = inventory.get(item);
			sumTotal = price + inventory.get(item);

			System.out.println(item + "\t\t\t$ " + price + "\nSum Total\t\t"+ sumTotal);
		}
	}
	
	private static void 
	
	
	// method to add to cart
	// int SKU1 = 0, SKU2 = 0, 
	// contains array of active cart
	
	// show updated list of what they have to date
	// print   Product  Units UnitPrice   Total Price
	//	                SKU2=4
		// running sub-total (formatted)
	// 
}
