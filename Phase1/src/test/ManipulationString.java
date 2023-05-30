package test;


/* Rôle : permet de tester différents moyens de manipuler des chaines de caractére
 * 
 * Type de manipulation :
 * 	N°1 : substring(str,n)
 * 		str l'index de début
 * 		n l'index de fin
 * 
 */

public class ManipulationString {

	public static void main(String[] args) {

		String str = "Techie Delight";
		int n = 1;

		String truncated = firstNChars(str, n);
		System.out.println(truncated);        // Techie


	}

	public static String firstNChars(String str, int n) {
		if (str == null) {
			return null;
		}
		return str.substring(0, n);
	}
}
