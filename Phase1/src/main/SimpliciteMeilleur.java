package main;

import java.util.Arrays;

public class SimpliciteMeilleur {

	public static void main(String[] args) {
		String texte = "Il fait beau aujourd’hui comme en aout";
		char[] ordre = {'f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'};

		long debut = System.nanoTime();

		String[] mots = texte.split(" ");
		triParOrdre(mots, ordre);

		System.out.println(Arrays.toString(mots));

		long fin = System.nanoTime();
		long tempsExecution = fin - debut;
		double tempsExecutionMillis = (double) tempsExecution / 1_000_000;

		System.out.println("Le temps d'exécution est de : " + tempsExecutionMillis + " millisecondes.");
	}

	private static void triParOrdre(String[] mots, char[] ordre) {
		Arrays.sort(mots, (mot1, mot2) -> {
			char c1 = mot1.charAt(0);
			char c2 = mot2.charAt(0);
			return Integer.compare(getOrderIndex(ordre, c1), getOrderIndex(ordre, c2));
		});
	}

	private static int getOrderIndex(char[] ordre, char letter) {
		for (int i = 0; i < ordre.length; i++) {
			if (ordre[i] == letter) {
				return i;
			}
		}
		return ordre.length;
	}
}





