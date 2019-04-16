package course;

public class E01TipoDadosJava {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		byte b1 = -128;
		byte b2 = 127;
		
		boolean concluido = true;
		
		char gender = 'M';
		char letter = '\u0041'; // Também podemos atribuir um valor através do código unicode-table) 0041 = 'A'
		
		int n2 = 2147483647;
		long n4 = 2147483648l; // Devemos colocar o L para o Java entender que o número que estamos passando deve ser considerado um long
		
		float f1 = 4.5f; // Devemos adicionar o f no final para o Java entender que o número que estamos passando deve ser considerado como Float e não um Double 
		double d6 = 4.5;
		
		// Tipos Genéricos
		String nome = "Maria Antonieta";
		Object obj1 = "Antonio Carlos";
		Object obj2 = 4.6f;
		
		
		System.out.println(b1);
		System.out.println(b2);		
		System.out.println(concluido);
		System.out.println(gender);
		System.out.println(letter);
		System.out.println(n2);
		System.out.println(n4);
		System.out.println(f1);
		System.out.println(d6);
		
		System.out.println(nome);
		System.out.println(obj1);
		System.out.println(obj2);
	}

}
