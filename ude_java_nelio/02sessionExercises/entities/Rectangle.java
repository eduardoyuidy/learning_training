package entities;

public class Rectangle {
	
	public double a;
	public double b;
	
	public double area() {
		return this.a * this.b;
	}
	
	public double perimeter() {
		return (this.a * 2) + (this.b * 2);		
	}
	
	public double diagonal() {
		return Math.sqrt((this.a * this.a) + (this.b * this.b));		
	}
}
