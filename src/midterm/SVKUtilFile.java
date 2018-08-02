package midterm;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class SVKUtilFile {

		// The path to the file to use
		public static final String FILE_NAME = "inventory.txt";
		
		
		public static void createBlankFile(String pathName) {
			Path path = Paths.get(pathName);
			if (Files.notExists(path)) {
				try {
					Files.createFile(path);
					System.out.println("File created at " + path.toAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private static Inventory convertLineToItem(String line) {
			String[] parts = line.split("\t");
			Inventory inventory = new Inventory();
			inventory.setProductName(parts[0]);
			inventory.(Double.parseDouble(setPrice(parts[1]));
			System.out.println("Printing line" + line);
			
			inventory.setProductName(line);
			return inventory;
		}
		private static String convertItemToLine(CountryInventory country) {
			// System.out.println(country.getCountryName());
			String newCountry = null;
			newCountry = (country.getCountryName());
			// System.out.println(newCountry);
			return newCountry;
			
			// return String output = (country.getCountryName());
			
			// return String.format("%s", country.getCountryName());
			
			// return String.format("%s\t%d", player.getName(), player.getJersey());
			// return String.format("%s", country.getCountryName());
		}
			
		public static List<Country> readFile() {
			List<Country> items = new ArrayList<>();
			
			try (
				// Open/prepare the resources in the try resources block
				FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
				Scanner fileScanner = new Scanner(fileInputStream)
			) {
				// loop until the end of the file
				while (fileScanner.hasNextLine()) {
					// read each line as a string
					String line = fileScanner.nextLine();
					// then convert it to an object
					items.add( convertLineToItem(line) );
				}
				fileInputStream.close();
				fileScanner.close();
			} catch (FileNotFoundException ex) {
				// If the file doesn't exist, there just aren't any items.
				return items;
			} catch (IOException e) {
				// If something else crazy goes wrong, print out the error.
				System.err.println("Something unexpected happended.");
				e.printStackTrace();
			}
//			finally {
//			fileInputStream.close();
//			fileScanner.close();
//			}
			
			// Finally return the array of items.
			return items;
		}
		public static void appendLine(Country item) {
			// convert player object to a string line of text to be written to the file
			String line = convertItemToLine(item);
			// System.out.println(line);
			
			// String line = item.getCountryName();
			try (
				// The `true` here tells the FileOutputStream to append to the file rather than overwriting it
				FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, true);
				PrintWriter fileWriter = new PrintWriter(fileOutputStream);
			) {
				// write to the file
				fileWriter.println(line);
				fileOutputStream.close();
				fileWriter.close();
			} catch (IOException e) {
				// If something else crazy goes wrong, print out the error.
				System.err.println("Something unexpected happended.");
				e.printStackTrace();
			}
		}
		
	}

}
