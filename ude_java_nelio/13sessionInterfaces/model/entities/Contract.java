package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Integer number;
	private Date date;
	private Double totalValue;
	
	private List<Installment> installments = new ArrayList<>();
	
	// Constructors	
	public Contract() {		
	}
	
	public Contract(Integer number, Date date, Double totalValue) {		
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	// Getters & Setters
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public List<Installment> getInstallment() {
		return this.installments;
	}
	
	public void addInstallment(Installment installment) {
		this.installments.add(installment);
	}
	
	public void removeInstallment(Installment installment) {
		this.installments.remove(installment);
	}
}
