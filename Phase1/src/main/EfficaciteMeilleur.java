package main;

public class EfficaciteMeilleur {

	public static void main(String[] args) {
		// Texte à classer
		String texte = "Il fait beau aujourd’hui comme en aout";

		// Ordre de classement des mots
		char[] ordre = {'f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'};

		long debut = System.nanoTime(); // Enregistrer le temps de début (au moment de l'éxecution du code)
		// System.currentTimeMillis() // Pour calculer le temps en Milliseconde


		String[] motsClasses = classifyText(texte, ordre);

		long fin = System.nanoTime(); // Enregistrer le temps de fin (une fois le code exécuté)
		long tempsExecution = fin - debut; // Calculer le temps écoulé en nanoseconde
		double tempsExecutionMillis = (double) tempsExecution / 1_000_000; // Conversion en millisecondes

		//Mise en forme de l'output
		System.out.print("[");
		for (int i = 0; i < motsClasses.length; i++) {
			System.out.print("\"" + motsClasses[i] + "\"");
			if (i < motsClasses.length - 1) {
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
	public static String[] classifyText(String texte, char[] ordre) {
		// Remplace le caractère "'" par un espace pour diviser correctement les mots
		texte = texte.replace("’", " ");

		// Sépare le texte en mots en utilisant l'espace comme séparateur
		String[] mots = texte.split(" ");

		// Trie les mots selon l'ordre spécifié en utilisant la méthode triParOrdre
		triParOrdre(mots, ordre);

		// Retourne les mots triés
		return mots;
	}



	/**
	 * Trie les mots en fonction de l'ordre spécifié.
	 * @param mots les mots à trier
	 * @param ordre l'ordre de classement des mots
	 */
	private static void triParOrdre(String[] mots, char[] ordre) {

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
	private static int getOrderIndex(char[] ordre, char letter) {

		// Parcourt tous les éléments de l'array "ordre"
		for (int i = 0; i < ordre.length; i++) {

			// Vérifie si l'élément actuel correspond à la lettre recherchée
			if (ordre[i] == letter) {

				return i; // Renvoie l'indice de l'élément correspondant
			}
		}

		// Si la lettre n'est pas présente dans "ordre", on la place à la fin
		return ordre.length;
	}

}
