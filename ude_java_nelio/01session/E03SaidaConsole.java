package course;

import java.util.Locale;

public class E03SaidaConsole {	
	
	public static void main(String[] args) {
		
		char gender = 'F';
		int age = 32;
		double balance = 10.35784;
		String name = "Maria das Dores";
		
		System.out.print("Good Morning");
		System.out.println("Good afternoon!");
		System.out.println("Good Night!");
		System.out.println("-------------------------------");
		System.out.printf("%.2f%n", balance);
		System.out.printf("%.4f%n", balance);
		
		// Alterar formata��o de n�mero decimal para o padr�o Canad�
		Locale.setDefault(Locale.CANADA);
		
		System.out.printf("%.2f%n", balance);
		System.out.printf("%.4f%n", balance);
		
		System.out.println("-------------------------------");
		
		System.out.printf("%s is %d years old, gender %c, and got balance = %.2f bitcoins.%n", name, age, gender, balance);
		
	}

}
