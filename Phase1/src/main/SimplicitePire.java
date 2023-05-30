package main;

import java.util.Arrays;

public class SimplicitePire {

	public static void main(String[] args) {
		
		long debut = System.nanoTime(); // Enregistrer le temps de début (au moment de l'éxecution du code)
		// System.currentTimeMillis() // Pour calculer le temps en Milliseconde
		
        String texte = "Il fait beau aujourd’hui comme en aout";
        char[] ordre = {'f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'};

        String[] mots = classifyText(texte, ordre);
        System.out.println(Arrays.toString(mots));
        
        long fin = System.nanoTime(); // Enregistrer le temps de fin (une fois le code exécuté)
		long tempsExecution = fin - debut; // Calculer le temps écoulé en nanoseconde
		double tempsExecutionMillis = (double) tempsExecution / 1_000_000; // Conversion en millisecondes
		
		System.out.println("Le temps d'exécution est de : " + tempsExecutionMillis + " millisecondes.");
    }

    public static String[] classifyText(String texte, char[] ordre) {
        String[] mots = texte.split(" ");
        sortWordsByOrder(mots, ordre);
        return mots;
    }

    private static void sortWordsByOrder(String[] mots, char[] ordre) {
        for (int i = 0; i < mots.length - 1; i++) {
            for (int j = i + 1; j < mots.length; j++) {
                if (compareWords(mots[i], mots[j], ordre) > 0) {
                    swap(mots, i, j);
                }
            }
        }
    }

    private static int compareWords(String mot1, String mot2, char[] ordre) {
        int length1 = mot1.length();
        int length2 = mot2.length();
        int minLength = Math.min(length1, length2);

        for (int i = 0; i < minLength; i++) {
            char c1 = mot1.charAt(i);
            char c2 = mot2.charAt(i);

            int index1 = getOrderIndex(ordre, c1);
            int index2 = getOrderIndex(ordre, c2);

            if (index1 != index2) {
                return Integer.compare(index1, index2);
            }
        }

        return Integer.compare(length1, length2);
    }

    private static int getOrderIndex(char[] ordre, char letter) {
        for (int i = 0; i < ordre.length; i++) {
            if (ordre[i] == letter) {
                return i;
            }
        }
        return ordre.length;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
