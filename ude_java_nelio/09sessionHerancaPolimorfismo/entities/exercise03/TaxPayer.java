package entities.exercise03;

public abstract class TaxPayer {
	
	private String name;
	private Double anualIncome;
	
	// Constructors
	public TaxPayer() {		
	}

	public TaxPayer(String name, Double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
	// Methods
	public abstract Double totalTaxes();
	
}
