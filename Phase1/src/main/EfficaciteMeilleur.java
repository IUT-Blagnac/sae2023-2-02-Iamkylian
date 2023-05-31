package main;

import java.util.List;

public class EfficaciteMeilleur {

	public static void main(String[] args) {
		// Texte à classer
		String texte = "Il fait beau aujourd’hui comme en aout";

		// Ordre de classement des mots
		List<Character> ordre = List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o');


		long debut = System.nanoTime(); // Enregistrer le temps de début (au moment de l'éxecution du code)
		// System.currentTimeMillis() // Pour calculer le temps en Milliseconde


		List<String> motsClasses = classifyText(texte, ordre);

		long fin = System.nanoTime(); // Enregistrer le temps de fin (une fois le code exécuté)
		long tempsExecution = fin - debut; // Calculer le temps écoulé en nanoseconde
		double tempsExecutionMillis = (double) tempsExecution / 1_000_000; // Conversion en millisecondes

		//Mise en forme de l'output
		System.out.print("[");
		for (int i = 0; i < motsClasses.size(); i++) {
			System.out.print("\"" + motsClasses.get(i) + "\"");
			if (i < motsClasses.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

		System.out.println("Le temps d'exécution est de : " + tempsExecutionMillis + " millisecondes.");


	}

	/**
	 * Classe les mots du texte en fonction de l'ordre spécifié.
	 * @param texte le texte à classer
	 * @param ordre l'ordre de classement des mots
	 * @return un tableau de mots classés selon l'ordre spécifié
	 */
	public static List<String> classifyText(String texte, List<Character> ordre) {
        texte = texte.replace("'", " ");
        texte = texte.replace(",", "");
        String[] mots = texte.split(" ");
        triParOrdre(mots, ordre);
        return List.of(mots);
    }



	/**
	 * Trie les mots en fonction de l'ordre spécifié.
	 * @param mots les mots à trier
	 * @param ordre l'ordre de classement des mots
	 */
	private static void triParOrdre(String[] mots, List<Character> ordre) {

		// Parcourt tous les mots, à l'exception du dernier
		for (int i = 0; i < mots.length - 1; i++) {

			// Parcourt les mots restants à partir du mot suivant "i"
			for (int j = i + 1; j < mots.length; j++) {

				// Vérifie si l'ordre des mots doit être inversé en comparant les premières lettres
				if (getOrderIndex(ordre, mots[j].charAt(0)) < getOrderIndex(ordre, mots[i].charAt(0))) {

					// Échange les positions des mots si l'ordre n'est pas respecté
					String temp = mots[i];
					// Échange les positions du mot actuel avec celui d'aprés
					mots[i] = mots[j];
					// Le mot d'aprés prend la position du mot actuel
					mots[j] = temp;
				}
			}
		}
	}


	/**
	 * Retourne l'index de la lettre dans l'ordre spécifié.
	 * @param ordre l'ordre de classement des lettres
	 * @param letter la lettre à chercher
	 * @return l'index de la lettre dans l'ordre spécifié, ou la longueur de l'ordre si la lettre n'est pas présente
	 */
	private static int getOrderIndex(List<Character> ordre, char letter) {

		// Parcourt tous les éléments de l'array "ordre"
		for (int i = 0; i < ordre.size(); i++) {

			// Vérifie si l'élément actuel correspond à la lettre recherchée
			if (ordre.get(i) == letter) {

				return i; // Renvoie l'indice de l'élément correspondant
			}
		}

		// Si la lettre n'est pas présente dans "ordre", on la place à la fin
		return ordre.size();
	}

}
