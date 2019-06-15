package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;
	
	private BrazilTaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxService taxService) {		
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		
		// System.out.printf("t1 value %.2f", t1);
		// System.out.printf("t2 value %.2f", t2);
		
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
