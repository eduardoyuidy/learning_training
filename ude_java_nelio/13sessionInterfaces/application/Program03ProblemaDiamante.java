package application;

import devices.ComboDevice;
import devices.ConcretePrinter;
import devices.ConcreteScanner;

public class Program03ProblemaDiamante {

	public static void main(String[] args) {
		
		ConcretePrinter p = new ConcretePrinter("1007");
		p.processDoc("My letter");
		p.print("My letter");
		System.out.println();
		
		ConcreteScanner s = new ConcreteScanner("2000");
		s.processDoc("My Email");
		System.out.println("Scan result: " + s.scan());
		System.out.println();
		
		ComboDevice cb = new ComboDevice("3000");
		cb.processDoc("My Document");
		cb.print("My Document");
		System.out.println("Scan result: " + cb.scan());
	}
}
