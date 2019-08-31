package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService; 
	
	public ContractService(OnlinePaymentService onlinePaymentService) { 
		
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		Double basicQuota = contract.getTotalValue() / months;		
			
		for (int count = 1; count <= months; count++) {
			
			Date dateInstallment = addMonth(contract.getDate(), count);
			
			double updatedQuota = basicQuota + this.onlinePaymentService.interest(basicQuota, count);
			
			double fullQuota = updatedQuota + this.onlinePaymentService.paymentFee(updatedQuota);
			
			contract.addInstallment(new Installment(dateInstallment, fullQuota));
		}
	}
	
	private Date addMonth(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);
		
		return cal.getTime();		
	}
}
