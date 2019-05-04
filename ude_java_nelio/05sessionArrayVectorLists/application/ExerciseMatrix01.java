package application;

import java.util.Locale;
import java.util.Scanner;

public class ExerciseMatrix01 {
	
	/*Fazer um programa para ler dois números inteiros M e N, e depois ler
	uma matriz de M linhas por N colunas contendo números inteiros,
	podendo haver repetições. Em seguida, ler um número inteiro X que
	pertence à matriz. Para cada ocorrência de X, mostrar os valores à
	esquerda, acima, à direita e abaixo de X, quando houver, conforme
	exemplo.
	
	M: 3
	N: 4
	10 8 15 12
	21 11 23 8
	14 5 13 19
	X: 8
	
	Position 0, 1:
	Left: 10
	Right: 15
	Down: 11
	Position 1, 3:
	Left: 23
	Up: 12
	Down: 19	
	*/

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("M: ");
		int m = sc.nextInt();		
		System.out.print("N: ");
		int n = sc.nextInt();
		
		int[][] mat = new int[m][n];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.print("X: ");
		int x = sc.nextInt();
		
		System.out.println("");
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == x) {
					
					System.out.printf("Position %d, %d:%n", i, j);
					
					// Left
					if ((j - 1) >= 0) {
						System.out.printf("Left: %d%n", mat[i][j-1]);
					}
					
					// Up
					if ((i - 1) >= 0) {
						System.out.printf("Up: %d%n", mat[i-1][j]);
					}
					
					// Right
					if ((j + 1) >= 0 && (j + 1) < mat[i].length) {
						System.out.printf("Right: %d%n", mat[i][j+1]);
					}
										
					// Down
					if ((i + 1) >= 0 && (i + 1) < mat.length) {
						System.out.printf("Down: %d%n", mat[i+1][j]);
					}
				}
			}
		}
		
		sc.close();
	}
}
