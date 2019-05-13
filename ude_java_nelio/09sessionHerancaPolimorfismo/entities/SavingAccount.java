package entities;

public class SavingAccount extends Account {
	
	private Double interestRate;
	
	// Constructors
	public SavingAccount() {
		super();
	}

	public SavingAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	// Getters and Setters
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	// Methods
	public void updateBalance() {
		this.balance += this.balance * this.interestRate;
	}
	
	
}
