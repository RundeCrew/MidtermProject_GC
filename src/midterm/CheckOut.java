package midterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckOut {

	// need shopping cart array from main that has product, price and units
	
	public static double checkOut (CartItem cart) {
		
		Scanner scnr = new Scanner(System.in);
		double total = 0.0, salesTax = 0.0, bottleDeposit = 0.0;
		String paymentMethod = null;
		
		double subTotal =
		salesTax = subTotal * .1;
		
		List<CartItem> FinalCart = new ArrayList<>();
		
		
		// calculate deposit
		
		for (CartItem productSold : cart) {
			if (productSold.equals("Two Hearted Ale")) {
				bottleDeposit = bottleDeposit + (.6 * cart.getQuantity);
			}
			else if (productSold.equals("M52")) {
				bottleDeposit = bottleDeposit + (.6 * cart.getQuantity);
			}
		}
		
//		for (int i = 0; i < cart.size(); i++) {
//			String item = cart.getProductName(); 
//			if (item.equals"Two Hearted Ale") {
//				bottleDeposit = bottleDeposit + (.6 * cart.getQuantity);
//			}
			// if repeats for M52 and wine bottle
		
		
		System.out.println("Your order for today:");
		// calculate grandtotal & print summary
		double grandTotal = subTotal + salesTax + bottleDeposit;
		// Assume cart only has items ordered, no product with 0 orders

		System.out.println("Product\t\tQuantity\t\tUnit Price\t\tTotal Price");
		System.out.println("=======\t\t========\t\t=========\t\t===========");
		
		// assume SubTotal coming over in cart - otherwise do math sku.getQuantity * sku.GetPrice
		for (CartItem sku : cart) {
			System.out.println(sku.getProductName + "\t\t" + sku.getQuantity + "\t\t$"
					+ sku.getPrice + "\t\t$" + sku.getSubTotal);
		}
		System.out.println("\t\t\t\t\tGrand Total: $" + grandTotal);
		
		//public static String askUserForPaymentMethod(Scanner scnr) {
		paymentMethod = Validator.getStringMatchingRegex(scnr, 
                "How would you like to pay? Cash, Check or Charge? ",
                "cash|check|charge");
	  		
		if (paymentMethod.equals("cash")) {
			System.out.println("How much money are you tendering to pay?");
			double tenderedCash = scnr.nextDouble();
			double change = grandTotal - tenderedCash;
			System.out.printf("Thanks.  Your change is $" + "%.2f", change);
		}
		else if (paymentMethod.equals("check")) {
			int checkNumber = Validator.getInt(scnr, "What is your checking account number?", 100000000, 999999999);
			// do a string to account for spaces and then parse?
			System.out.println("Thanks.  By the way, how are your grandchildren?");
		}
		else {
			Validator.(scnr, "What is your credit card number?");
			Validator.checkExpiration(scnr, "What is the expiration date (MM/YY)");
			Validator.getInt(scnr, "What is your CVV code on the back?", 1, 999);
			System.out.println("Thanks!");
		}
		return grandTotal;
	}
	
}
