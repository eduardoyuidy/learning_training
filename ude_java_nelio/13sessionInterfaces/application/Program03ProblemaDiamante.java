package application;

import devices.Printer;
import devices.Scanner;

public class Program03ProblemaDiamante {

	public static void main(String[] args) {
		
		Printer p = new Printer("1007");
		p.processDoc("My letter");
		p.print("My letter");
		
		Scanner s = new Scanner("2000");
		s.processDoc("My Email");
		System.out.println("Scan result: " + s.scan());
	}
}
