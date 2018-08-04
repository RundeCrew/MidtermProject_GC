package midterm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SVKUtilFile {

	// The path to the file to use
	public static final String FILE_NAME = "inventory.txt";

	// Modify this method as necessary to convert a line of text from the file to a
	// new item instance
	private static Product convertLineToItem(String line) {
		String[] parts = line.split("~~~");
		Product product = new Product(); // changed the name of the variable from inventory to product
		product.setProductName(parts[0]); // because we are fetching product data from the inventory
		product.setPrice(Double.parseDouble(parts[1]));
		product.setStock(Integer.parseInt(parts[2]));
		return product;
	}
	
	public static List<Product> readFile() {
		List<Product> products = new ArrayList<>();
		String line;
		try {
			// Open/prepare the resources in the try resources block
			FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
			Scanner fileScanner = new Scanner(fileInputStream);
			// loop until the end of the file
			while (fileScanner.hasNextLine()) {
				// read each line as a string
				line = fileScanner.nextLine();
				// then convert it to an object
				Product product = convertLineToItem(line);
				products.add(product);
			}
			fileScanner.close();
		} catch (IOException e) {
			// If something else crazy goes wrong, print out the error.
			System.err.println("Something unexpected happended.");
			e.printStackTrace();
		} 
		// Finally return the array of items.
		return products;
	}
}
