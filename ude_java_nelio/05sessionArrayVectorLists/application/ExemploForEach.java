package application;

public class ExemploForEach {

	public static void main(String[] args) {
		
		String[] vect = new String[] {"Maria", "Bob", "Alex", "John", "Arya"};
		
		for (String posicao : vect) {
			
			System.out.println(posicao);
		}
		
		System.out.println("-----------------------");
		
		for (int i = 0; i<vect.length ; i++) {
			
			System.out.println(vect[i]);
		}
	}
}
