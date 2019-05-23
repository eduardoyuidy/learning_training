package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.abstracts.Circle;
import entities.abstracts.Rectangle;
import entities.abstracts.Shape;
import entities.abstracts.enums.Color;

public class Program06Abstract {

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		char shapeType = ' ';
		
		System.out.print("Enter the number of shapes: ");
		int n = sc.nextInt();
		
		List<Shape> listShapes = new ArrayList<Shape>();
		
		for (int i = 1; i<=n; i++) {
			System.out.printf("Shape #%d data:%n", i);		
			
			while (true) {
				System.out.print("Rectangle or Circle (r/c)? ");
				shapeType = sc.next().charAt(0);
				
				if (shapeType == 'r' || shapeType == 'c') {
					break;
				}
			}
			
			sc.nextLine();
			System.out.print("Color (BLACK/BLUE/RED): ");
			String color = sc.nextLine();
			
			if (shapeType == 'r') {
				System.out.print("Width: ");
				double shapeWidth = sc.nextDouble();
				System.out.print("Height: ");
				double shapeHeight = sc.nextDouble();
				
				listShapes.add(new Rectangle(Color.valueOf(color), shapeWidth, shapeHeight));
			} else if (shapeType == 'c') {
				System.out.print("Radius: ");
				double shapeRadius = sc.nextDouble();
				
				listShapes.add(new Circle(Color.valueOf(color), shapeRadius));
			}
		}
		
		System.out.println();
		System.out.println("SHAPE AREAS");
		
		for (Shape sp : listShapes) {
			System.out.println(String.format("%.2f", sp.area()));
		}
		
		sc.close();
	}
}
