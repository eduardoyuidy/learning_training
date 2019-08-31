package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {		
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
						
		double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		
		double basePayment;
		
		if (hours <= 12.0) {
			basePayment = Math.ceil(hours) * pricePerHour;
		}
		else {
			basePayment = Math.ceil(hours / 24) * pricePerDay;
		}
		
		double tax = this.taxService.tax(basePayment);
		
		carRental.setInvoice(new Invoice(basePayment, tax));
	}	
}
