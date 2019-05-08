package entities;

public class OrderItem {

	private int quantity;
	private double price;
	private Product product;
	
	// Constructors
	public OrderItem() {		
	}

	public OrderItem(int quantity, double price, Product product) {		
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	// Getters and Setters
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	// Methods
	public double subTotal() {
	
		return this.getPrice() * this.getQuantity();
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getProduct().getName());
		sb.append(", $");
		sb.append(String.format("%.2f", this.getPrice()));
		sb.append(", Quantity: ");
		sb.append(this.getQuantity());
		sb.append(", Subtotal: $");
		sb.append(String.format("%.2f", this.subTotal()));
		
		return sb.toString();
	}
}
