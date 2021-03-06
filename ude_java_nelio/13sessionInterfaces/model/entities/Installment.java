package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dueDate;
	private Double amount;
	
	// Constructors 
	public Installment() {		
	}

	public Installment(Date dueDate, Double amount) {		
		this.dueDate = dueDate;
		this.amount = amount;
	}

	// Getters & Setters
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	
	@Override
	public String toString() {		
		return String.format("%s - %.2f", sdf.format(this.getDueDate()), this.getAmount());
	}
}
