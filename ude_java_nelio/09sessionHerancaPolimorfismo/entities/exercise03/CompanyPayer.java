package entities.exercise03;

public class CompanyPayer extends TaxPayer {
	
	private int numberEmployees;
	
	// Constructos
	public CompanyPayer() {
		super();
	}
	
	public CompanyPayer(String name, Double anualIncome, int numberEmployees) {
		super(name, anualIncome);
		this.numberEmployees = numberEmployees;
	}
	
	// Getters and Setters
	public int getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	// Methods 
	
	@Override
	public Double totalTaxes() {
		Double taxAmount = 0.0;
		
		if (this.getNumberEmployees() > 10) {
			taxAmount = this.getAnualIncome() * 0.14; 
		} else {
			taxAmount = this.getAnualIncome() * 0.16;
		}
		return taxAmount;
	}
}
