package application;

import entities.BusinessAccount;

public class Program01Heranca {

	public static void main (String[] args) {
		
		BusinessAccount bcAccount = new BusinessAccount(
										500,
										"Eduardo Yuidy",
										200.00,
										1000.00);
		
		bcAccount.deposit(400.00);
		System.out.println(bcAccount.getBalance());		
	}
}
