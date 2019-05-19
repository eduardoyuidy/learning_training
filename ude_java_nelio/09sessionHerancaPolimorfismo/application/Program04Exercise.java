package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.exercise.Employee;
import entities.exercise.OutsourcedEmployee;

public class Program04Exercise {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
			
		for (int i = 1; i <= n; i++) {
			System.out.printf("Employee #%d data:%n", i);
			System.out.print("Outsourced (y/n)? ");
			char outsourced = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String employeeName = sc.nextLine();
			System.out.print("Hours: ");
			int employeeHours = sc.nextInt();
			System.out.print("Value per hour: ");
			double employeeValuePerHour = sc.nextDouble();
			
			if (outsourced == 'y') {
				System.out.print("Additional charge: ");
				Double employeeAdditionalCharge = sc.nextDouble();
				
				employeeList.add(
						new OutsourcedEmployee(employeeName, employeeHours, employeeValuePerHour, employeeAdditionalCharge)
						);
			} else {
				
				employeeList.add(new Employee(employeeName, employeeHours, employeeValuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		
		for (int i = 0; i < employeeList.size(); i++) {
			System.out.println(employeeList.get(i).toString());
		}		

		sc.close();
	}
}
