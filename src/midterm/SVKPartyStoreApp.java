package midterm;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SVKPartyStoreApp {

	public static void main(String[] args) throws ParseException {
		
		Scanner scnr = new Scanner(System.in);				
		
		String cont = "y";
		int quantity;        
		int userChoice;
		
		List<Product> menu = SVKUtilFile.readFile();
		
		ArrayList<CartItem> cart = new ArrayList<>();
		
		System.out.println("Welcome to SVK Party Store! Southeast Michigan's Gourmet Party Store");
		System.out.println("Please enter your name:");
		String userName = scnr.next();
		scnr.nextLine();
		
		System.out.println("Hello " + userName + ", here is a list of the items we currently have in stock:");
		
		
		printInventory();   // method is below with formating. pulling from txt file
		System.out.println(" ");
		do {
			userChoice = Validator.getInt(scnr, userName + ", please select the item number you would like to purchase.", 1, menu.size());
			quantity = Validator.getQuantityInt(scnr, "How many would you like?", 1, menu.get(userChoice-1).getStock(), menu.get(userChoice-1));
			CartItem ci = new CartItem(menu.get(userChoice-1), quantity);
			cart.add(ci);
			
			// this method is here in the main
			printCart(cart);
			
			cont = Validator.checkContinue(scnr, "\nWould you like to add another item (yes or no) or see the list again (list)?");
			
		} while (cont.trim().toLowerCase().startsWith("y"));
		
		System.out.println(" " + userName + ", here is your final bill: \n ");
		
		double sum = printCart(cart);
		double grandTotal = CheckOut.calcTaxDeposit(cart, sum);
		
		CheckOut.getPaymentMethod(scnr, grandTotal);
		CheckOut.provideReceipt(scnr, userName);
		printCart(cart);
		CheckOut.calcTaxDeposit(cart, sum);
		

		System.out.println();
		
		System.out.println("Thank you for shopping at the SVK Party Store,\n "
				+ "\twe appreciate your business.");
		
	}
	
	private static double printCart(ArrayList<CartItem> cart) {
		
		int i = 1;
		double sum = 0;
		
		
		System.out.println(" #" + "  Product\t\t" + "Quantity " + "       Price");
		System.out.println(" =============================================");
		
		for (CartItem inv : cart) {
			System.out.printf("%2d. ",  i++);
			System.out.printf("%-21s ",  inv.getProduct().getProductName());
			System.out.printf("%4d", inv.getQuantity());
		    String priceStr = "$" + String.format("%.2f",  inv.getProduct().getPrice()*inv.getQuantity());
		    System.out.printf("%16s", priceStr);
		    System.out.println();
		    
	        sum += inv.getProduct().getPrice() * inv.getQuantity();
		}
		System.out.println("                              ________________");
		System.out.printf("%40s", "Subtotal: ");
		String priceStr = "$" + String.format("%.2f",  sum);
	    System.out.printf("%6s%n", priceStr);
	
		return sum;
	}
	
	public static void printInventory() {
		List<Product> menu = SVKUtilFile.readFile();
		int i = 1;
		System.out.println(" #" + "  Product\t\t\t" + "Price");
		System.out.println(" ========================================");
		
		for (Product inv : menu) {
			System.out.printf("%2d. ",  i++);
			System.out.printf("%-21s ",  inv.getProductName());
			String priceStr = "$" + String.format("%.2f", inv.getPrice());
		    System.out.printf("%12.12s", priceStr);
		    System.out.println();
		}
//			String format = "%2d. %-27s $%.2f%n";
//	        System.out.printf(format, i++, inv.getProductName(), inv.getPrice());
		}
	}
