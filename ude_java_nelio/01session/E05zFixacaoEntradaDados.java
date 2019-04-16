package course;

import java.util.Locale;
import java.util.Scanner;

public class E05zFixacaoEntradaDados {

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your full name:");
		String name = sc.nextLine(); // Digitado: 'Alex Green'
		
		System.out.println("How many bedrooms are there in your house?");
		int bedrooms = sc.nextInt(); // Digitado: '3'
		
		System.out.println("Enter product price:");
		float price = sc.nextFloat(); // Digitado: '500.5'
		
		System.out.println("Enter your last name, age and height (same line)");
		// Digitado: 'Green 21 1.73'
		String lastName = sc.next();
		int age = sc.nextInt();
		float height = sc.nextFloat();
		
		sc.close();
		
		System.out.println(name);
		System.out.println(bedrooms);
		System.out.printf("%.2f%n", price);
		System.out.println(lastName);
		System.out.println(age);
		System.out.printf("%.2f%n", height);
	}
}
