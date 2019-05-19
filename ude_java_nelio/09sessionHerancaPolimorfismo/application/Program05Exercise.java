package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.exercise02.ImportedProduct;
import entities.exercise02.Product;
import entities.exercise02.UsedProduct;

public class Program05Exercise {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		ArrayList<Product> productsList = new ArrayList<Product>();
		
		for (int i = 1; i <= n; i++) {
			
			System.out.printf("Product #%d data: %n", i);
			System.out.print("Commom, Used or Imported (c/u/i) ? ");
			char chProductType = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String productName = sc.nextLine();
			System.out.print("Price: ");
			Double productPrice = sc.nextDouble();
			sc.nextLine();
						
			switch(chProductType) {
			case 'c':
				productsList.add(new Product(productName, productPrice));
				break;
			case 'u':
				System.out.print("Manufature Date (DD/MM/YYYY): ");
				String inputValue = sc.nextLine();
				Date productManufatureDate = sdf.parse(inputValue.toString());
				productsList.add(new UsedProduct(productName, productPrice, productManufatureDate));				
				break;
			case 'i':
				System.out.print("Customs fee: ");
				Double productCustomsFee = sc.nextDouble();				
				productsList.add(new ImportedProduct(productName, productPrice, productCustomsFee));
				break;
			default: 
				System.out.println("######## Invalid Product Type. ########");
			}				
		}
		
		System.out.println("");
		System.out.println("PRICE TAGS: ");
		
		for(int i = 0; i < productsList.size(); i++) {
			System.out.println(productsList.get(i).priceTag());
		}
		
		sc.close();
	}
}
