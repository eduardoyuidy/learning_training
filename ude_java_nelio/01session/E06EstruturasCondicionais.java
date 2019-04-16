package course;

import java.util.Scanner;

public class E06EstruturasCondicionais {

	public static void main(String[] args) {

		// Exercicio 01 - Even or Odd
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("Enter an integer number:"); int number = sc.nextInt();
		 * 
		 * if (number % 2 == 0) { System.out.println("Even!"); } else {
		 * System.out.println("Odd!"); }
		 * 
		 * sc.close();
		 */

		// Exercicio 02 - What time is it?
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("What time is it?"); int hour = sc.nextInt();
		 * 
		 * if (hour < 12) { System.out.println("Good morning!"); } else if (hour >= 12
		 * && hour < 18) { System.out.println("Good afternoon!"); } else if (hour >= 18
		 * && hour <= 24) { System.out.println("Good night"); } else {
		 * System.out.println("Invalid hour"); }
		 * 
		 * sc.close();
		 */

		// Exercicio 03 - Higher number
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("Enter 3 numbers separed by spaces in the same line:");
		 * int n1 = sc.nextInt(); int n2 = sc.nextInt(); int n3 = sc.nextInt(); int
		 * higher;
		 * 
		 * if (n1 >= n2 && n1 >= n3) { higher = n1; } else if (n2 >= n3 && n2 >= n1) {
		 * higher = n2; } else { higher = n3; }
		 * 
		 * System.out.printf("Higher: %d", higher);
		 * 
		 * sc.close();
		 */

		// Exercício 04 - Switch Case -- Weekdays
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe um número entre 1 e 7");
		int i = sc.nextInt();
		String day;

		switch (i) {
		case 1:
			day = "Sunday";
			break;
		case 2:
			day = "Monday";
			break;
		case 3:
			day = "Tuesday";
			break;
		case 4:
			day = "Wednesday";
			break;
		case 5:
			day = "Thursday";
			break;
		case 6:
			day = "Friday";
			break;
		case 7:
			day = "Saturday";
			break;
		default:
			day = "Invalid value";
		}

		System.out.println("Day: " + day);

		sc.close();		
		
	}
}
