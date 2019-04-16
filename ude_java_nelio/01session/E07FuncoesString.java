package course;

public class E07FuncoesString {

	public static void main (String[] args) {
		
		String original = "abcde FGHIJ ABC abc DEFG     ";
		
		String s01 = original.toLowerCase();
		String s02 = original.toUpperCase();
		String s03 = original.trim();
		String s04 = original.substring(2);
		String s05 = original.substring(2, 9);
		String s06 = original.replace('a', 'x');
		String s07 = original.replace("abc", "xyz");
		int i = original.indexOf("bc");
		int j = original.lastIndexOf("bc");
		
		System.out.println("Original: -" + original + "-");
		System.out.println("LowerCase: -" + s01 + "-");
		System.out.println("UpperCase: -" + s02 + "-");
		System.out.println("Trim: -" + s03 + "-");
		System.out.println("Substring(2): -" + s04 + "-");
		System.out.println("Substring(2, 9): -" + s05 + "-");
		System.out.println("replace('a', 'x'): -" + s06 + "-");
		System.out.println("replace('abc', 'xyz'): -" + s07 + "-");
		System.out.println("indexOf('bc'): -" + i + "-");
		System.out.println("lastIndexOf('bc'): -" + j + "-");
		
		System.out.println("-----------------------------");
		
		String sString = "potato apple lemon";
		
		String[] vect = sString.split(" ");
		
		String word1 = vect[0];
		String word2 = vect[1];
		String word3 = vect[2];
		
		System.out.println("sString: " + sString);
		System.out.println("Word1: " + word1);
		System.out.println("Word2: " + word2);
		System.out.println("Word3: " + word3);
	}
}
