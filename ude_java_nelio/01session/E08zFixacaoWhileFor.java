package course;

import java.util.Scanner;

public class E08zFixacaoWhileFor {

	public static void main (String[] args) {
		
		int higher = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter N: ");
		int quantityNumbers = sc.nextInt();
		
		while (quantityNumbers <= 0) {
			System.out.print("N must be positive! Try again: ");
			quantityNumbers = sc.nextInt();			
		}
		
		for (int count = 1; count <= quantityNumbers; count++) {
			System.out.printf("Value #%d :", count);
			int x = sc.nextInt();
			
			higher = (x > higher) ? x : higher;
		}
		
		sc.close();
		
		System.out.printf("Higher = %d%n", higher);
	}
}
