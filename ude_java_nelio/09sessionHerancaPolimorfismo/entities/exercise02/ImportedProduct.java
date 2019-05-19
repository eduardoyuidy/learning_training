package entities.exercise02;

public class ImportedProduct extends Product {

	private Double customsFee;
	
	// Constructors 
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	// Getters and Setters
	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		return String.format("%s $ %.2f (Customs fee: $ %.2f)", this.getName(), this.totalPrice(), this.getCustomsFee());
	}
	
	public double totalPrice() {
		return this.getPrice() + this.customsFee;
	}
}
