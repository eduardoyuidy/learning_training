package model.entities;

public class Product {

	private String name;
	private Double price;
	private Integer quantity;
	
	// Constructors
	public Product(String name, Double price, Integer quantity) {		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	// Methods
	public Double totalValue() {
		return this.price * this.quantity;
	}

	@Override
	public String toString() {
		return String.format("%s,%.2f", this.name, this.totalValue());
	}	
}
