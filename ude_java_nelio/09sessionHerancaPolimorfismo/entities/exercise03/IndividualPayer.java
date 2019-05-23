package entities.exercise03;

public class IndividualPayer extends TaxPayer {
	
	private Double healthExpenses;
	
	// Constructors
	public IndividualPayer() {
		super();		
	}
	
	public IndividualPayer(String name, Double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}
	
	// Getters and Setters
	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	// Methods 
	@Override
	public Double totalTaxes() {
		Double taxAmount = 0.0;
		
		if (this.getAnualIncome() < 20000.00) {
			taxAmount = this.getAnualIncome() * 0.15;
		} else {
			taxAmount = this.getAnualIncome() * 0.25;
		}
		
		if (this.getHealthExpenses() > 0.0) {
			taxAmount -= this.getHealthExpenses() * 0.50;
		}
		
		return taxAmount;
	}

}
