package entities;

public class Product {

	private String name;
	private double price;
	private int quantity;
	
	// Constructor padrão da classe mantido, mesmo que estejamos fazendo sobrecarga de métodos construtores.
	public Product() { }
	
	// Constructor da classe Product recebendo 3 parâmetros
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	// Constructor da classe Product recebendo 2 parâmetros 
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	// Definição de métodos get e set
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	// Métodos de negócio da aplicação
	public double totalValueInStock() {		
		return this.price * this.quantity;		
	}
	
	public void addProducts(int quantity) {
		this.quantity += quantity;
	}
	
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}
	
	// Sobrescrita do método toString da classe Object que também é herdada.
	public String toString() {
	
		return this.name
			  + ", $ "
			  + String.format("%.2f", this.price)
			  + ", " 
			  + this.quantity
			  + " units, Total: $ "
			  + String.format("%.2f", this.totalValueInStock());
	}	
}
