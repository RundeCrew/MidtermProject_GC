package midterm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	    double sumDep = 0.00;
		for (CartItem productSold : cart) {

			if (productSold.getProduct().getProductName().equals("Two Hearted Ale")) {
				bottleDeposit = (.6 * productSold.getQuantity());
			}
			else if (productSold.getProduct().getProductName().equals("M43 IPA")) {
				bottleDeposit = (.6 * productSold.getQuantity());
			}
			else if (productSold.getProduct().getProductName().equals("Dales Pale Ale")) {
				bottleDeposit = (.6 * productSold.getQuantity());
			}
			sumDep += bottleDeposit;
		}
		System.out.printf("%40s", "Deposit: ");
		priceStr = "$" + String.format("%.2f",  sumDep);
	    System.out.printf("%6s%n", priceStr);
				
		//System.out.println("\t\t\tDeposit: $" + bottleDeposit);
		
		double grandTotal = subTotal + salesTax + sumDep;
		System.out.printf("%40s", "Grand Total: ");
		priceStr = "$" + String.format("%.2f",  grandTotal);
	    System.out.printf("%6s%n", priceStr);
		
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
				System.out.println();
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
						System.out.println();
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
	
	public static void printReceiptHeader(String name) {
		System.out.println("\t___");
		System.out.println("\t|   \\     / | /  Party");
		System.out.println("\t|__  \\   /  |/   Store");
		System.out.println("\t   |  \\ /   |\\   Serving Grand Circus");
		System.out.println("\t___|   V    | \\  Since 2018\n");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println();
		
		System.out.println("Sales Receipt: " + name + "\t   " + dateFormat.format(date));
		System.out.println("______________________________________________");

	
		}
	
	public static String printEmailSummary (List<CartItem> cart, double sum) {
				
		double salesTax = 0.0, bottleDeposit = 0.0;				
		double subTotal = sum;
		salesTax = subTotal * .06;
		
		StringBuilder sb = new StringBuilder();
		
		String salesTaxFormat = String.format("%40s", "Sales Tax: ");		
		String priceFormat = "$" + String.format("%.2f",  salesTax);
	    String output1Format = String.format("%6s%n", priceFormat);
	    
	    sb.append(salesTaxFormat );
	    sb.append(priceFormat);
	    sb.append(output1Format+ "\n");
	
	    double sumDep = 0.00;
		for (CartItem productSold : cart) {

			if (productSold.getProduct().getProductName().equals("Two Hearted Ale")) {
				bottleDeposit = (.6 * productSold.getQuantity());
			}
			else if (productSold.getProduct().getProductName().equals("M43 IPA")) {
				bottleDeposit = (.6 * productSold.getQuantity());
			}
			else if (productSold.getProduct().getProductName().equals("Dales Pale Ale")) {
				bottleDeposit = (.6 * productSold.getQuantity());
			}
			sumDep += bottleDeposit;
		}
		
		String depositFormat = String.format("%40s", "Deposit: ");		
		priceFormat = "$" + String.format("%.2f",  sumDep);
	    String output2Format = String.format("%6s%n", priceFormat);
	    
	    sb.append(depositFormat);
	    sb.append(output2Format);	    
				
		//System.out.println("\t\t\tDeposit: $" + bottleDeposit);
		
		double grandTotal = subTotal + salesTax + sumDep;
		String grandTotalFormat = String.format("%40s", "Grand Total: ");
		priceFormat = "$" + String.format("%.2f",  grandTotal);
	    String output3Format = String.format("%6s%n", priceFormat);
	    
	    sb.append(grandTotalFormat);
	    sb.append(output3Format);	    
		
	    String result = sb.toString();
		return result;
	}
	
//	public static double printReceiptSummary (List<CartItem> cart, double sum) {
//		
//		Scanner scnr = new Scanner(System.in);
//		double total = 0.0, salesTax = 0.0, bottleDeposit = 0.0;
//		String paymentMethod = null;
//		
//		double subTotal = sum;
//		salesTax = subTotal * .06;
//		System.out.printf("%40s", "Sales Tax: ");
//		String priceStr = "$" + String.format("%.2f",  salesTax);
//	    System.out.printf("%6s%n", priceStr);
//		
//	    double totalDep = 0.00;
//	    
//		for (CartItem productSold : cart) {
//
//			if (productSold.getProduct().getProductName().equals("Two Hearted Ale")) {
//				bottleDeposit = (.6 * productSold.getQuantity());
//				
//			}
//			if (productSold.getProduct().getProductName().equals("M43 IPA")) {
//				bottleDeposit = (.6 * productSold.getQuantity());
//				
//			}
//			if (productSold.getProduct().getProductName().equals("Dales Pale Ale")) {
//				bottleDeposit = (.6 * productSold.getQuantity());
//			}
//			totalDep += bottleDeposit;
//		}
//		System.out.printf("%40s", "Deposit: ");
//		priceStr = "$" + String.format("%.2f",  totalDep);
//	    System.out.printf("%6s%n", priceStr);
//		
//		double grandTotal = subTotal + salesTax + totalDep;
//		System.out.printf("%40s", "Grand Total: ");
//		priceStr = "$" + String.format("%.2f",  grandTotal);
//	    System.out.printf("%6s%n", priceStr);
//		return grandTotal;
//		
//	}
}
