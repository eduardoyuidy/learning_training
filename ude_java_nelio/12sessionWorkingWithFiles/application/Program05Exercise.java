package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Product;

public class Program05Exercise {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		String path = "C:\\_TempY_VALID\\subdirectory\\in.txt";
		String pathOutput = "C:\\_TempY_VALID\\subdirectory\\out.txt"; 
		
		try (BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(pathOutput))) {
			
			String line = br.readLine();
			
			List<Product> lista = new ArrayList<Product>();
			
			while (line != null) {
				String name = line.split(",")[0];
				Double price = Double.parseDouble(line.split(",")[1]);
				int quantity = Integer.parseInt(line.split(",")[2]);				
				Product prod = new Product(name, price, quantity);
				lista.add(prod);				
				line = br.readLine();
			}
			
			for (Product prod : lista) {
				bw.write(prod.toString());
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
