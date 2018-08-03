package midterm;

import java.util.List;
import java.util.Scanner;


public class SVKPartyStoreApp {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		SVKUtilFile.createBlankFile("inventory.txt");
		
		List<Product> menu = SVKUtilFile.readFile();
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
//		
//		}
		printInventory();
			
//		do {
//			System.out.println("What would you like to add to your shopping cart (enter SKU number)?");
//			// itemSKU = shoppingcart method
//			// prints out udpated cart with current subtotal
		
		System.out.println(getValidInventoryChoice(scnr, List<Product<>));
		
//			System.out.println("\nDo you want to add anything else ('y') "
//					+ "review products ('options') or checkout ('exit')?");
//			cont = scnr.next();
//				if (cont.equals("options")) {
//					printInventory(menu);
//					System.out.println("\nDo you want to add anything else ('y') "
//							+ "review products ('options') or checkout ('exit')?");
//				}
//			
//		} while (cont.equals('y'));
			
		//call to the checkout 
		
		//askUserForPaymentMethod(scnr);
		
		System.out.println("Would you like us ");
		
		printReceipt();
		
		// receipt - email option
		System.out.println();
		// thank you!!
	}
	
	private static void printReceipt() {
		System.out.println("Product\t\tQuantity\t\tUnit Price\t\tTotal Price");
		
//		System.out.println("SKU      Product                        Price");
//		System.out.println("Subtotal");
//		System.out.println("Deposit");
//		System.out.println("Tax");
//		System.out.println("Total Price);
		
		
	}
	
	public static void printInventory() {
		List<Product> inventoryList = SVKUtilFile.readFile();
		int i = 1;
		System.out.println("SKU  Product                        Price");
		System.out.println("===  ======================        =======");
		
		for (Product inv : inventoryList) {
			String format = "%2d. %-30s $%.2f%n";
	        System.out.printf(format, i++, inv.getProductName(), inv.getPrice());
		}
		return;
	}
	
}
