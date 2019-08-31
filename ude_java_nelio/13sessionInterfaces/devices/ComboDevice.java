package devices;

public class ComboDevice extends Device implements Printer, Scanner {
	// Uma classe pode implementar mais de uma interface, porém apenas 1 classe pode ser herdada.
		
	public ComboDevice(String serialNumber) {
		super(serialNumber);
	}

	@Override
	public String scan() {
		return "Combo scan result";
	}

	@Override
	public void print(String doc) {
		System.out.println("Combo printing: " + doc);		
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("ComboDevice processing: " + doc);		
	}
}
