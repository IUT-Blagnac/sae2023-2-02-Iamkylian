package main;

public class Main {

	public static void main(String[] args) {

		// Texte à classer
		String texte = "Il fait beau aujourd’hui comme en aout";

		// Ordre de classement des mots
		char[] ordre = {'f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'};

		long debut = System.nanoTime(); // Enregistrer le temps de début (au moment de l'éxecution du code)
		// System.currentTimeMillis() // Pour calculer le temps en Milliseconde

		String[] motsClasse = EfficaciteMeilleur.classifyText(texte, ordre);

		long fin = System.nanoTime(); // Enregistrer le temps de fin (une fois le code exécuté)
		long tempsExecution = fin - debut; // Calculer le temps écoulé en nanoseconde
		double tempsExecutionMillis = (double) tempsExecution / 1_000_000; // Conversion en millisecondes

		System.out.println("Le temps d'exécution est de : " + tempsExecutionMillis + " millisecondes.");

		//Mise en forme de l'output
		System.out.print("[");
		for (int i = 0; i < motsClasse.length; i++) {
			System.out.print("\"" + motsClasse[i] + "\"");
			if (i < motsClasse.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

	}

}
