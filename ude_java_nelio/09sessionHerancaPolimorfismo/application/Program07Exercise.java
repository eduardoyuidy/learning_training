package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.exercise03.CompanyPayer;
import entities.exercise03.IndividualPayer;
import entities.exercise03.TaxPayer;

public class Program07Exercise {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		List<TaxPayer> listPayers = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			System.out.printf("Tax payer #%d data: %n", i);
			System.out.print("Individual or Company (i/c)? ");
			char payerType = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			if (payerType == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenses = sc.nextDouble();
				listPayers.add(new IndividualPayer(name, anualIncome, healthExpenses));
			} else {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				listPayers.add(new CompanyPayer(name, anualIncome, employees));
			}
		}
		
		System.out.println("");
		System.out.println("TAXES PAID:");
		
		double totalTaxes = 0.0;
		for (TaxPayer tp : listPayers) {
			System.out.printf("%s: $ %.2f%n", tp.getName(), tp.totalTaxes());
			totalTaxes += tp.totalTaxes();
		}
		
		System.out.printf("%nTOTAL TAXES: $%.2f", totalTaxes);
		
		sc.close();		
	}
}
