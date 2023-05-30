package main;

import java.util.Arrays;

public class SimpliciteMeilleur {

	public static void main(String[] args) {
		
		long debut = System.nanoTime(); // Enregistrer le temps de début (au moment de l'éxecution du code)
		// System.currentTimeMillis() // Pour calculer le temps en Milliseconde
		
        String texte = "Il fait beau aujourd’hui comme en aout";
        char[] ordre = {'f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'};

        String[] mots = classifierText(texte, ordre);
        System.out.println(Arrays.toString(mots));
        
        long fin = System.nanoTime(); // Enregistrer le temps de fin (une fois le code exécuté)
		long tempsExecution = fin - debut; // Calculer le temps écoulé en nanoseconde
		double tempsExecutionMillis = (double) tempsExecution / 1_000_000; // Conversion en millisecondes
		
		System.out.println("Le temps d'exécution est de : " + tempsExecutionMillis + " millisecondes.");
        
    }

    public static String[] classifierText(String texte, char[] ordre) {
        String[] mots = texte.split(" ");
        Arrays.sort(mots, (mot1, mot2) -> {
            String sousChaine1 = getOrderedSubstring(mot1, ordre);
            String sousChaine2 = getOrderedSubstring(mot2, ordre);
            return sousChaine1.compareTo(sousChaine2);
        });
        return mots;
    }

    private static String getOrderedSubstring(String mot, char[] ordre) {
        for (int i = 0; i < mot.length(); i++) {
            char c = mot.charAt(i);
            if (!contains(ordre, c)) {
                return mot.substring(i);
            }
        }
        return mot;
    }

    private static boolean contains(char[] arr, char c) {
        for (char element : arr) {
            if (element == c) {
                return true;
            }
        }
        return false;
    }
}





