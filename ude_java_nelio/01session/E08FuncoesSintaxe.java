package course;

import java.util.Scanner;

public class E08FuncoesSintaxe {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Informe três números inteiros");
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		int higher = max(n1, n2 , n3);
		
		showResult(higher);

		sc.close();
	}
	
	public static int max(int x, int y, int z) {
		int aux = 0;
		if (x > y && x > z) {
			aux = x;
		} else if (y > x && y > z) {
			aux = y;
		} else {
			aux = z;
		}
		return aux;		
	}
	
	public static void showResult(int value) {
		System.out.println("Higher is " + value);
	}

}
