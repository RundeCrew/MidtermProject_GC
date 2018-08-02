package midterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SVKPartyStoreApp {

	public static void main(String[] args) {
		// Welcome guest
		// Get name?
		
		Scanner scnr = new Scanner(System.in);
		SVKUtilFile.createBlankFile("inventory.txt");
		List<Inventory> inventory = SVKUtilFile.readFile();
		for (Inventory inv : inventory) {
			System.out.println(inv.getProductName() + "\t" + inv.getPrice());
		}
		// Present today's products in an Array
		// DO/WHILE
			// Ask what product they want to start with?
			// Call ShoppingCart method
			// Asks if they want to add anything else?
			// Option to print original product list again any time
		// When exiting call CheckOut for total 
			// then call Checkout.payment
		//give option to email reciept
	}
}
