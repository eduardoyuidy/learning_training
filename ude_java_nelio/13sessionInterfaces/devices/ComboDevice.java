package devices;

public class ComboDevice extends Scanner, Printer {
	
	// Uma classe n�o pode herdar de mais de uma classe
	
	public ComboDevice(String serialNumber) {
		super(serialNumber);
	}

}
