package midterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
			
	// TODO figure out propr way to call the Array list in the parameters
	public static int getValidInventoryChoice (Scanner scnr, List<Product> menu) { 
//		int userChoice;
//		boolean inputIsValid = false;
//			if (Validator.getInt(scnr,"Please select the item number that you would like to add to your cart.", 1,12)) { 
//				int quantity = Validator.getQuantityInt(scnr,"How many would you like?", inventory);
//				break; // Break the loop
//			} else {
//				System.out.println("We don't offer this item, please enter a new option.");
//				continue;
//			}
		int userChoice = Validator.getInt(scnr,"Please select the item number that you would like to add to your cart.", 1, menu.size());
		return userChoice;
	}
	
//	private static void listPrice(userChoice) {
//		double price = 0.0;
//		double sumTotal = 0.0;
//		int quantity = 0;
//		
//		if (!userChoice = 0)
//		for (String item : shoppingCart) {
//			price = inventory.get(item);
//			sumTotal = price + inventory.get(item);
//			quantity = user
//			itemTotal = inventory.get(price) * userInput
//
//			System.out.println(item + "\t\t\t$ " + price + user + "\nSum Total\t\t"+ sumTotal);
//		}
	
	
} 
	
	
	// method to add to cart
	// int SKU1 = 0, SKU2 = 0, 
	// contains array of active cart
	
	// show updated list of what they have to date
	// print   Product  Units UnitPrice   Total Price
	//	                SKU2=4
		// running sub-total (formatted)
	// 

