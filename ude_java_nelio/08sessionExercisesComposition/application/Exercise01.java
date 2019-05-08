package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Exercise01 {

	public static void main (String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birthdate (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		Client cli = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status);
		
		System.out.print("How many items to this order? ");
		int quantityItems = sc.nextInt();
		
		for (int i = 1; i <= quantityItems; i++) {
			System.out.printf("Enter #%d item data:%n", i);
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product prod = new Product(productName, productPrice);
			OrderItem item = new OrderItem(quantity, productPrice, prod);
			
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order);		
		System.out.println(cli);
		System.out.println("Order items: ");
		for (OrderItem objItem : order.getItems()) {
			System.out.println(objItem);
		}
		System.out.printf("Total price: $%.2f%n", order.total());
				
		sc.close();
	}
}
