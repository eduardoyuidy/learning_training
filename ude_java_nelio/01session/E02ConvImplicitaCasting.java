package course;

public class E02ConvImplicitaCasting {

	public static void main(String[] args) {
		
		// Exemplo 01
		/*double a;
		float b;
		a = 5.0;
		b = (float)a;
		System.out.println(b);*/
		
		// Exemplo 02
		/*double a;
		int b;
		a = 5.0;
		b = (int)a;
		System.out.println(b);*/
			
		// Exemplo 03
		int a, b;
		double result;
		a = 5;
		b = 2;
		
		result = a / b; // Resultado n�o ser� 2.5, pois como 'a' e 'b' s�o int o java considera a divis�o como int; -- Resultado 2.0
		// result = (double) a / b; // Resultado ser� 2.5 pois como foi feito o casting de 'a' a divis�o ser� feita em float -- Resultado 2.5
		
		System.out.println(result);
		System.out.println();
	}

}
