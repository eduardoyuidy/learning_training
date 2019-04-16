package course;

import java.util.Locale;
import java.util.Scanner;

public class E08While {

	public static void main (String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number:");
		double d1 = sc.nextDouble();
				
		while (d1 >= 0.0) {
			System.out.printf("%.3f%n", Math.sqrt(d1));
			System.out.print("Enter another number:");
			d1 = sc.nextDouble();			
		}
		
		System.out.println("Negative number!");
		
		sc.close();
	}
}
