package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Exercise03 {
	
	/**
	 *  
	 * @param args
	 * Fazer um programa para ler o nome de um aluno e as tr�s notas que ele obteve nos tr�s trimestres do ano
	 * (primeiro trimestre vale 30 e o segundo e terceiro valem 35 cada). Ao final, mostrar qual a nota final do aluno no
	 * ano. Dizer tamb�m se o aluno est� aprovado (PASS) ou n�o (FAILED) e, em caso negativo, quantos pontos faltam
	 * para o aluno obter o m�nimo para ser aprovado (que � 60% da nota). Voc� deve criar uma classe Student para
	 * resolver este problema.	  
	 */

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Student student;		
		student = new Student();
		
		student.name = sc.nextLine();
		student.grade1 = sc.nextDouble();
		student.grade2 = sc.nextDouble();
		student.grade3 = sc.nextDouble();
		
		System.out.printf("FINAL GRADE: %.2f%n", student.finalGrade());
		
		System.out.println(student.status());
		
		if (student.status() == "FAILED") {
			System.out.printf("MISSING %.2f POINTS", student.missingPoints());
		}
		
		sc.close();
	}
}
