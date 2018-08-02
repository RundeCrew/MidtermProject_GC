package midterm;

import java.util.List;
import java.util.Scanner;


public class SVKPartyStoreApp {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		SVKUtilFile.createBlankFile("inventory.txt");
		List<Inventory> inventory = SVKUtilFile.readFile();
		String cont = null;
		
		// Present today's products in an Array
				// DO/WHILE
					// Ask what product they want to start with?
					// Call ShoppingCart method
					// Asks if they want to add anything else?
					// Option to print original product list again any time
				// When exiting call CheckOut for total 
					// then call Checkout.payment
				//give option to email reciept
		
		System.out.println("Welcome to SVK Party Store!");
		System.out.println("Southeast Michigan's Gourmet Party Store");
		
		// String guestName = Validator.getString(scnr, "What is your name?");
		// System.out.println("Thanks " + guestName + ", today our selection of gourmet products is:");
		int itemSKU = 0;
		
//		int i = 1;
//		System.out.println("SKU\tProduct\t\t\tPrice");
//		System.out.println("===\t=======\t\t\t======");
//		
//		for (Inventory inv : inventory) {
//			System.out.println(i++ + ".\t" + inv.getProductName() + "\t\t\t" + inv.getPrice());
//		}
		printInventory();
			
//		do {
//			System.out.println("What would you like to add to your shopping cart (enter SKU number)?");
//			// itemSKU = shoppingcart method
//			// prints out udpated cart with current subtotal
//			System.out.println("\nDo you want to add anything else ('y') "
//					+ "review products ('options') or checkout ('exit')?");
//			cont = scnr.next();
//				if (cont.equals("options")) {
//					printInventory(inventory);
//					System.out.println("\nDo you want to add anything else ('y') "
//							+ "review products ('options') or checkout ('exit')?");
//				}
//			
//		} while (cont.equals('y'));
			
		// receipt - email option
		// thank you!!
	}
	
	public static void printInventory() {
		List<Inventory> inventoryList = SVKUtilFile.readFile();
		int i = 1;
		System.out.println("SKU\tProduct\t\t\tPrice");
		System.out.println("===\t=======\t\t\t======");
		
		for (Inventory inv : inventoryList) {
			System.out.println(i++ + ".\t" + inv.getProductName() + "\t\t\t" + inv.getPrice());
		}
		return;
	}
	
}
