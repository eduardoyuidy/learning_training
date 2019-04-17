package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rectangle;

public class Exercise01 {
	
	/**
	 * 
	 * @param args
	 * Fazer um programa para ler os valores da largura e altura
	 * de um retângulo. Em seguida, mostrar na tela o valor de
     * sua área, perímetro e diagonal. Usar uma classe como
     * mostrado no projeto ao lado.
	 */
	
	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Rectangle rectangle;
		
		rectangle = new Rectangle();
		
		System.out.println("Enter rectangle width and height:");
		rectangle.a = sc.nextDouble();
		rectangle.b = sc.nextDouble();
		
		sc.close();
		
		System.out.printf("AREA = %.2f%n", rectangle.area());
		System.out.printf("PERIMETER = %.2f%n", rectangle.perimeter());
		System.out.printf("DIAGONAL = %.2f%n", rectangle.diagonal());
		
	}
}
