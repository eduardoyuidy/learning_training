package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class ExerciseList01 {
	
	/*Fazer um programa para ler um n�mero inteiro N e depois os dados (id, nome e salario) de
	N funcion�rios. N�o deve haver repeti��o de id.
	Em seguida, efetuar o aumento de X por cento no sal�rio de um determinado funcion�rio.
	Para isso, o programa deve ler um id e o valor X. Se o id informado n�o existir, mostrar uma
	mensagem e abortar a opera��o. Ao final, mostrar a listagem atualizada dos funcion�rios,
	conforme exemplos.
	Lembre-se de aplicar a t�cnica de encapsulamento para n�o permitir que o sal�rio possa
	ser mudado livremente. Um sal�rio s� pode ser aumentado com base em uma opera��o de
	aumento por porcentagem dada.*/

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registred? ");
		int quantityEmployees = sc.nextInt();
		
		sc.nextLine();
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		for (int count = 1; count < quantityEmployees + 1; count++) {
					
			System.out.printf("%nEmployee #%d:%n", count);			
			System.out.print("Id: ");			
			int id = sc.nextInt();
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			employeeList.add(new Employee(id, name, salary));
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idIncrease = sc.nextInt();
		
		System.out.print("Enter the percentage: ");
		Double percent = sc.nextDouble();
		
		boolean found = false;
		
		// Increase Employee's salary		
		for (Employee obj : employeeList) {
			if (obj.getId() == idIncrease) {
				found = true;
				obj.increaseSalary(percent);
			}
		}
		
		if (found == false) {
			System.out.println("This id does not exist!");
		}
		
		System.out.println("");
		System.out.println("List of employees:");
		for (Employee obj : employeeList) {
			System.out.println(obj);		
		}
				
		sc.close();
	}
}
