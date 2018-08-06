package midterm;

import java.text.ParseException;
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
		System.out.printf("%40s", "Sales Tax: ");
		String priceStr = "$" + String.format("%.2f",  salesTax);
	    System.out.printf("%6s%n", priceStr);
	
//		System.out.printf("$%.2f%n",  salesTax);
		
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
		System.out.printf("%40s", "Deposit: ");
		priceStr = "$" + String.format("%.2f",  bottleDeposit);
	    System.out.printf("%6s%n", priceStr);
				
		//System.out.println("\t\t\tDeposit: $" + bottleDeposit);
		
		double grandTotal = subTotal + salesTax + bottleDeposit;
		System.out.printf("%40s", "Grand Total: ");
		System.out.printf("$%.2f%n",  grandTotal);
		return grandTotal;
	}
		
	public static void getPaymentMethod (Scanner scnr, double grandTotal) throws ParseException {
			
		//public static String askUserForPaymentMethod(Scanner scnr) {
		String paymentMethod = Validator.getStringMatchingRegex(scnr, 
                "How would you like to pay? Cash, Check or Charge? ",
                "cash|check|charge|Cash|Check|Charge");
	  		
		if (paymentMethod.equals("cash")) {
			System.out.println("How much money are you tendering to pay?");
			double tenderedCash = scnr.nextDouble();
			double change = tenderedCash - grandTotal;
			if (change >= 0.00) {
				System.out.printf("Thanks.  Your change is $" + "%.2f", change);
			}
			else {
				double balanceDue = -change;
				do {
					System.out.println("Your balance due is $" + balanceDue);
					System.out.println("Please enter additional cash payment amount:");
					tenderedCash = scnr.nextDouble();
					balanceDue = balanceDue - tenderedCash;
					if (balanceDue < 0.00) {
						change = -balanceDue;
						System.out.printf("Thanks.  Your change is $" + "%.2f", change);
					}
				} while (balanceDue > 0.00);
			}
			
		}
		else if (paymentMethod.equals("check")) {
			int checkNumber = Validator.getInt(scnr, "What is your checking account number?", 100000000, 999999999);
			// do a string to account for spaces and then parse?
			System.out.println("Thanks.  By the way, how are your grandchildren?");
		}
		else {
			CreditCard.checkCreditCard(scnr, "What is your credit card number?");
			Validator.checkExpiration(scnr, "What is the expiration date (MM/YY)");
			Validator.getInt(scnr, "What is your CVV code on the back?", 1, 999);
			System.out.println("Thanks!");
		}
	}
		
	public static void provideReceipt (Scanner scnr, String name) {
		System.out.println(name + ", would you like your receipt printed ('p') or by email ('e')?");
		String receiptType = scnr.next();
		if (receiptType.equals("p")) {
			printReceipt();
		}
		else {
			System.out.println("What is your email address?");
			String email = Validator.isEmailAddressValid(scnr);
			
			
			// format document that can be emailed
			// call email service
			
		}
		
	}
	
	private static void printReceipt() {
		System.out.println("Product\t\tQuantity\t\tUnit Price\t\tTotal Price");	
		}
	
}
