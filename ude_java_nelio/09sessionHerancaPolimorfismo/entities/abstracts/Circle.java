package entities.abstracts;

import entities.abstracts.enums.Color;

public class Circle extends Shape {
	
	private double radius;
	
	// Constructors
	public Circle() { 
		super();
	}

	public Circle(Color color, double radius) {
		super(color);
		this.radius = radius;
	}

	// Getters and Setters
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	// Methods

	@Override
	public Double area() {
		return Math.PI * this.radius * this.radius;
	}


}
