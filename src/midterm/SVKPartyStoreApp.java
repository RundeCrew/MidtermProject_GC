package midterm;

import java.util.List;
import java.util.Scanner;

import org.graalvm.compiler.hotspot.word.HotSpotWordTypes;

import com.sun.jdi.event.WatchpointEvent;

import sun.jvm.hotspot.HelloWorld;


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
//		
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
			
		
		askUserForPaymentMethod(scnr);
		
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

	public static void askUserForPaymentMethod(Scanner scnr) {
		System.out.println("Please select a payment method (1-3)");
		System.out.println("1. Cash\t\t2. Check\t3. Credit Card");
		String paymentMethod = scnr.nextLine();
		if (Validator.isMethodPaymentValid(paymentMethod) == false) {
			System.out.println("Please select an option (1 - 3)");
		}
	}
	
	public static void printInventory() {
		List<Inventory> inventoryList = SVKUtilFile.readFile();
		int i = 1;
		System.out.println("SKU  Product                        Price");
		System.out.println("===  ======================        =======");
		
		for (Inventory inv : inventoryList) {
			String format = "%2d. %-30s $%.2f%n";
	        System.out.printf(format, i++, inv.getProductName(), inv.getPrice());
		}
		return;
	}
	
}
