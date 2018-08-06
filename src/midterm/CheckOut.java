package midterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckOut {

	// need shopping cart array from main that has product, price and units
	
	public static double calcTaxDeposit (List<CartItem> cart, double sum) {
		
		Scanner scnr = new Scanner(System.in);
		double total = 0.0, salesTax = 0.0, bottleDeposit = 0.0;
		String paymentMethod = null;
		
		double subTotal = sum;
		salesTax = subTotal * .06;
		System.out.println("\t\t\tSales Tax: $ " + salesTax);
		
		// List<CartItem> finalCart = new ArrayList<>();
		
		
		// calculate deposit
		
		for (CartItem productSold : cart) {

			if (productSold.getProduct().getProductName().equals("Two Hearted Ale")) {
				bottleDeposit = bottleDeposit + (.6 * productSold.getQuantity());
				
			}
			else if (productSold.getProduct().getProductName().equals("M43 IPA")) {
				bottleDeposit = bottleDeposit + (.6 * productSold.getQuantity());
				
			}
			else if (productSold.getProduct().getProductName().equals("Dales Pale IPA")) {
				bottleDeposit = bottleDeposit + (.6 * productSold.getQuantity());
			}
		}
		System.out.println("\t\t\tDeposit: $" + bottleDeposit);
		
		double grandTotal = subTotal + salesTax + bottleDeposit;

		System.out.println("\t\t\tGrand Total: $" + grandTotal);
		return grandTotal;
	}
		
//	public static void getPaymentMethod (Scanner scnr) {
//			
//		//public static String askUserForPaymentMethod(Scanner scnr) {
//		paymentMethod = Validator.getStringMatchingRegex(scnr, 
//                "How would you like to pay? Cash, Check or Charge? ",
//                "cash|check|charge");
//	  		
//		if (paymentMethod.equals("cash")) {
//			System.out.println("How much money are you tendering to pay?");
//			double tenderedCash = scnr.nextDouble();
//			double change = grandTotal - tenderedCash;
//			System.out.printf("Thanks.  Your change is $" + "%.2f", change);
//		}
//		else if (paymentMethod.equals("check")) {
//			int checkNumber = Validator.getInt(scnr, "What is your checking account number?", 100000000, 999999999);
//			// do a string to account for spaces and then parse?
//			System.out.println("Thanks.  By the way, how are your grandchildren?");
//		}
//		else {
//			checkCreditCard(scnr, "What is your credit card number?");
//			Validator.checkExpiration(scnr, "What is the expiration date (MM/YY)");
//			Validator.getInt(scnr, "What is your CVV code on the back?", 1, 999);
//			System.out.println("Thanks!");
//		}
//	}
//		
//	public static void provideReceipt (Scanner scnr) {
//		System.out.println("Would you like your receipt printed ('p') or by email?");
//		String receiptType = scnr.next();
//		if (receiptType.equals("p")) {
//			printReceipt();
//		}
//		else {
//			System.out.println("What is your email address?");
//			String email = Validator.isEmailAddressValid(scnr.next());
//			// format document that can be emailed
//			// call email service
//			
//		}
//		
//	}
//	
//	private static void printReceipt() {
//		System.out.println("Product\t\tQuantity\t\tUnit Price\t\tTotal Price");	
//		}
//	
}
