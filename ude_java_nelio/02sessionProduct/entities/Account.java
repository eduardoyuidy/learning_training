package entities;

public class Account {
	
	private int accountNumber;
	private String accountHolder;
	private double accountBalance;
	
	// Constructors
	public Account() {		
	}
	
	public Account (int accountNumber, String accountHolder) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}
	
	public Account (int accountNumber, String accountHolder, double initialDeposit) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		deposit(initialDeposit);
	}
	
	// GETTERS - SETTERS	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public String getAccountHolder() {
		return this.accountHolder;
	}
	
	public void setAccountHolder(String accountHolder) { 
		this.accountHolder = accountHolder;
	}
	
	// Class's methods
	public void deposit(double value) {
		if (value > 0) {
			this.accountBalance += value;
		}
	}
	
	public void withdraw(double value) {
		if (value > 0) {
			this.accountBalance -= value;
			this.accountBalance -= 5.00; // Withdraw tax
		}
	}
	
	public String toString() {
		return 
				"Account " +
				this.accountNumber + 
				", Holder: " + 
				this.accountHolder + 
				", Balance: $ " + 
				String.format("%.2f", this.accountBalance);				
	}
}
