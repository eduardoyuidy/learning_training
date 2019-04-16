package course;

import java.util.Scanner;

public class E08For {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many integers numbers are you going to enter? ");
		int quantity = sc.nextInt();
		int sum = 0;
		
		if (quantity > 0) {			
			for (int count = 1; count <= quantity; count++) {
				System.out.printf("Value #%d: ", count);
				int num = sc.nextInt();
				sum += num;				
			}
		}
		
		sc.close();
		
		System.out.printf("Sum = %d%n", sum);
	}
}
