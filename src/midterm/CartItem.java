package midterm;

public class CartItem {
	
	private Product product;
	private int quantity;

	public CartItem(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}
	
	public CartItem() {
	}
	
	public Product getProduct() {
		return this.product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quantity=" + quantity + "]";
	}
	
}
