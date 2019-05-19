package entities.exercise;

public class OutsourcedEmployee extends Employee {

	private Double additionalCharger;
	
	// Constructors
	public OutsourcedEmployee() {
		super();
	}

	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharger) {
		super(name, hours, valuePerHour);
		this.additionalCharger = additionalCharger;
	}

	// Getters and Setters
	public Double getAdditionalCharger() {
		return additionalCharger;
	}

	public void setAdditionalCharger(Double additionalCharger) {
		this.additionalCharger = additionalCharger;
	}
	
	// Methods
	@Override
	public double payment() {
		Double paymentValue = super.payment();
		paymentValue += (this.getAdditionalCharger() * 1.10);
		return paymentValue;
	}
}
