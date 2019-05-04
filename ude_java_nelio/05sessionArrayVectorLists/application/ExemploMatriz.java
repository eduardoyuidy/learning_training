package application;

import java.util.Locale;
import java.util.Scanner;

public class ExemploMatriz {

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input the number of positions: ");
		int n = sc.nextInt();
		
		/* Arranjo bidimensional (Matriz) tbm conhecido como Vetor de vetores */
		int[][] mat = new int[n][n];
		int negativeNumbers = 0;
		
		for (int i = 0; i < mat.length; i++) {			
			for (int j = 0; j < mat[i].length; j++) {
				
				mat[i][j] = sc.nextInt();
				
				if (mat[i][j] < 0) {
					negativeNumbers++;
				}
			}
		}
		
		/* 
		System.out.printf("Length of first position: %d", mat[0].length);*/		
		
		sc.close();
		
		System.out.println("Main diagonal");
		
		for (int i = 0; i < mat.length; i++) {
			System.out.print(mat[i][i] + " ");
		}
		System.out.println();
		
		System.out.printf("Negative numbers = %d", negativeNumbers);		
	}
}
