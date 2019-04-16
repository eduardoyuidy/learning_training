package course;

import java.util.Locale;
import java.util.Scanner;

public class E05EntradaDadosJava {

	public static void main (String[] args) {
		
		// Exemplo 01 
		/*
		Scanner sc = new Scanner(System.in);
		
		String sentence, x, y, z;
		String colorX, colorY, colorZ;
		
		// Leitura de uma linha até a quebra da linha.
		sentence = sc.nextLine();
		
		// Leitura de uma única palavra, em linhas diferentes ou em linhas separadas.
		x = sc.next();
		y = sc.next();
		z = sc.next();
		
		System.out.println(sentence);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		x = sc.next();
		y = sc.next();
		z = sc.next();
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		// Encerrar o Scanner
		sc.close();
		*/
		
		// Exemplo 02
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt(); // Digitado: 35
		
		sc.nextLine(); // Flush para limpar a pendência da quebra de linha realizada na leitura anterior.
		
		String name = sc.nextLine(); // Digitado: Bob Brown
		
		char gender = sc.next().charAt(0); // Digitado: F
		
		String s = sc.next(); // Digitado: b5
		char letter = s.charAt(0); // Capturado apenas a primeira posição da string
		int digit = Integer.parseInt(s.substring(1)); // Capturada apenas a partir da posição 1
		
		// Digitado 4.32 (para capturar o separador de double como ponto, foi necessário alterar o locale para US (Antes de instanciar o Scanner).
		double d1 = sc.nextDouble();
		
				
		// Digitado: Maria F 23 1.68
		String name2 = sc.next();
		char gender2 = sc.next().charAt(0);
		int age2 = sc.nextInt();
		double height2 = sc.nextDouble();
		
		System.out.println(n1);
		System.out.println(name);
		System.out.println(gender);
		System.out.println(letter);
		System.out.println(digit);
		System.out.println(d1);
		
		System.out.println(name2);
		System.out.println(gender2);
		System.out.println(age2);
		System.out.println(height2);
		
		sc.close();
		
	}
}
