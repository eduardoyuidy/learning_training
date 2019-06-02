package model.entities;

import model.exceptions.ExerciseException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	// Constructors
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	// Getters and Setters
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}	
	
	// Methods
	public void deposit (Double amount) {
		this.balance += amount;
	}
	
	public void withdraw (Double amount) throws ExerciseException {
		
		if (this.withdrawLimit < amount) {
			throw new ExerciseException("Withdraw error: The amount exceeds withdraw limit.");
		}
		
		if (balance < amount) {
			throw new ExerciseException("Withdraw error: Not enough balance.");
		}
		
		this.balance -= amount;
	}
}
