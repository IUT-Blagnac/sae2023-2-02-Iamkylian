package main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String texte = "666, the number of the beast";
        List<Character> ordre = List.of('6', 't', 'n', 'o', 'b');

        long debut = System.nanoTime(); // Enregistrer le temps de début (au moment de l'éxecution du code)
		// System.currentTimeMillis() // Pour calculer le temps en Milliseconde

        System.out.println(SimpliciteMeilleur.solution(texte,ordre));
        // output: [classer, texte, exemple, a, de]

        long fin = System.nanoTime(); // Enregistrer le temps de fin (une fois le code exécuté)
		long tempsExecution = fin - debut; // Calculer le temps écoulé en nanoseconde
		double tempsExecutionMillis = (double) tempsExecution / 1_000_000; // Conversion en millisecondes

		System.out.println("Le temps d'exécution est de : " + tempsExecutionMillis + " millisecondes.");

		/********************* Test n°4 ************************/

		String texte1 = "Il fait beau aujourd'hui comme en aout";
        List<Character> ordre1 = List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o');

        long debut1 = System.nanoTime(); // Enregistrer le temps de début (au moment de l'éxecution du code)
		// System.currentTimeMillis() // Pour calculer le temps en Milliseconde

        System.out.println(SimpliciteMeilleur.solution(texte1,ordre1));
        // output: [classer, texte, exemple, a, de]

        long fin1 = System.nanoTime(); // Enregistrer le temps de fin (une fois le code exécuté)
		long tempsExecution1 = fin1 - debut1; // Calculer le temps écoulé en nanoseconde
		double tempsExecutionMillis1 = (double) tempsExecution1 / 1_000_000; // Conversion en millisecondes

		System.out.println("Le temps d'exécution est de : " + tempsExecutionMillis1 + " millisecondes.");

    }
}
