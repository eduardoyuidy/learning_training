package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class Program03Overide {

	public static void main(String[] args) {
		
		// Override 'withdraw' method from Account class
		Account acc1 = new Account(1001, "Alex Green", 1000.00);
		acc1.withdraw(100.00);
		System.out.println(acc1.getBalance());
		
		Account acc2 = new SavingAccount(1002, "Alex Green", 1000.00, 0.5);
		acc2.withdraw(100.00);
		System.out.println(acc2.getBalance());
		
		Account acc3 = new BusinessAccount(1003, "Bob", 1000.00, 500.0);
		acc3.withdraw(100.00);
		System.out.println(acc3.getBalance());		
	}
}
