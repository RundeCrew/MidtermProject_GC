package midterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckOut {

	// need shopping cart array from main that has product, price and units
	
	public static double checkOut (Inventory shoppingcart) {
		
		Scanner scnr = new Scanner(System.in);
		double total = 0.0, salesTax = 0.0, bottleDeposit = 0.0;
		String paymentMethod = null;
		
		double subTotal =
		salesTax = subTotal * .1;
		
		List<Inventory> shoppingcart = new ArrayList<>();
		
		
		// calculate deposit
		
		for (int i = 0; i < shoppingcart.length; i++) {
			String item = shoppingcart.getProductName(); 
			if (item.equals"Two Hearted Ale") {
				bottleDeposit = bottleDeposit + (.6 * item.getUnits);
			}
			// if repeats for M52 and wine bottle
		}
		
		
		System.out.println("Your order for today:");
		// calculate grandtotal & print summary
		double grandTotal = subTotal + salesTax + bottleDeposit;
		// borrow print set up from shopping cart
		
		paymentMethod = Validator.getString(scnr, "How would you like to pay today? (cash, check or credit card)");
		
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
			int ccNumber = Validator.getCC(scnr, "What is your credit card number?");
			int ccExpiration = Validator.getExpiration(scnr, "What is the expiration date (MM/YY)");
			int ccCVV = Validator.getInt(scnr, "What is your CVV code on the back?", 1, 999);
			System.out.println("Thanks!");
		}
		return grandTotal;
	}
	
}
