package entities;

public class Employee {

	public String name;
	public double grossSalary;
	public double tax;
	
	public double netSalary() {
		return this.grossSalary - this.tax;
	}
	
	public void increaseSalary(double valuePercentage) {
		this.grossSalary = (this.grossSalary * (100 + valuePercentage)) / 100;
	}
	
	public String toString() {
		return this.name + ", $ " + String.format("%.2f", this.netSalary());
	}
}
