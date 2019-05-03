package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploLists {

	public static void main(String[] args) {		

		List<String> list = new ArrayList<>();
		
		list.add("Maria");		
		list.add("Alex");
		list.add("Bob");
		list.add("John");
		list.add("Ana");
		list.add("Arya");
		
		// Add 'Marco' at position 2
		list.add(2, "Marco");
		
		System.out.println(list.size());		
			
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("--------------------------");
		
		list.remove(1); // Remover o elemento da posição 1 da lista
		list.removeIf(x -> x.charAt(0) == 'M'); // Remover os elementos que começam com M - Função Lambda
		
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("--------------------------");		
		System.out.println("Index of John: " + list.indexOf("John"));
		System.out.println("Index of Marco: " + list.indexOf("Marco"));
		
		System.out.println("--------------------------");
		
		// Filtrar a lista com função lambda retornando apenas os elementos que iniciem com 'A'
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());		
		for (String str: result) {
			System.out.println(str);
		}
		
		System.out.println("--------------------------");
		
		// Encontrar o primeiro elemento que começa com 'A', caso não encontre irá retornar null
		String name = list.stream().filter(x -> x.charAt(0) == 'T').findFirst().orElse(null);		
		System.out.println(name);
	}
}
