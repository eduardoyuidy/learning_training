package entities.abstracts;

import entities.abstracts.enums.Color;

public class Rectangle extends Shape {
	
	private double width;
	private double height;
	
	// Constructors
	public Rectangle() {
		super();
	}

	public Rectangle(Color color, double width, double height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	// Getters and Setters
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	// Methods
	
	@Override
	public Double area() {		
		return this.width * this.height;
	}
	
	
	
}
