package entities;

public class Student {

	public String name;
	public double grade1;
	public double grade2;
	public double grade3;
	
	public double finalGrade() {
		return this.grade1 + this.grade2 + this.grade3;
	}
	
	public String status() {
		if (this.finalGrade() >= 60.0) {
			return "PASS";
		} else {
			return "FAILED";
		}
	}
	
	public double missingPoints() {
		return 60.0 - this.finalGrade();
	}
	
}
