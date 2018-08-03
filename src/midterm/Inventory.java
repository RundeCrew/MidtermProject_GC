package midterm;

public class Inventory {
	
	private String productName;
	private double price;
	private int stock;
	
	public Inventory(String product, double price) {
		super();
		this.productName = productName;
		this.price = price;
		this.stock = stock;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Inventory [productName =" + productName + ", price=" + price + "]";
	}
	
	
}
