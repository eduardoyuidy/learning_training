package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program02 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Product[] vectProduct = new Product[n];
		
		for (int i=0; i < vectProduct.length ; i++) {
			sc.nextLine();
			String name = sc.nextLine();
			double price = sc.nextDouble();
			
			vectProduct[i] = new Product(name, price);
		}
		
		double sum = 0.0;
		for (int i=0; i < vectProduct.length; i++) {
			sum += vectProduct[i].getPrice();
		}
		
		double avg = (sum / vectProduct.length);
			
		System.out.printf("AVERAGE PRICE = %.2f%n", avg);
		
		sc.close();
	}
}
