package midterm;

public class Inventory {
	
	private String productName;
	private double price;
	
	public Inventory(String product, double price) {
		super();
		this.productName = productName;
		this.price = price;
	}
	
	public Inventory() {
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Inventory [productName =" + productName + ", price=" + price + "]";
	}
	
	
}
