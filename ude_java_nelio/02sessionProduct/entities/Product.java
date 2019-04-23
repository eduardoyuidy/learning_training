package entities;

public class Product {

	private String name;
	private double price;
	private int quantity;
	
	// Constructor padr�o da classe mantido, mesmo que estejamos fazendo sobrecarga de m�todos construtores.
	public Product() { }
	
	// Constructor da classe Product recebendo 3 par�metros
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	// Constructor da classe Product recebendo 2 par�metros 
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	// Defini��o de m�todos get e set
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
	
	// M�todos de neg�cio da aplica��o
	public double totalValueInStock() {		
		return this.price * this.quantity;		
	}
	
	public void addProducts(int quantity) {
		this.quantity += quantity;
	}
	
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}
	
	// Sobrescrita do m�todo toString da classe Object que tamb�m � herdada.
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
