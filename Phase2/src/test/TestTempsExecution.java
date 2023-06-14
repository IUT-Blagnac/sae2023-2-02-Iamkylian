package test;

import java.util.Arrays;
import java.util.List;

import exercice.Exercice;

public class TestTempsExecution {

	public static void main(String[] args) {

		List<Character> ordre = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

        List<String> testStrings = Arrays.asList(
                "Lorem ipsum dolor sit amet",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur"
        );

        for (String str : testStrings) {
            long startTime = System.nanoTime();
            String result = Exercice.solution(str, ordre);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            double tempsExecutionMillis = (double) executionTime / 1_000_000; // Conversion en millisecondes
            
            System.out.println("Chaîne de caractères: " + str);
            System.out.println("Résultat: " + result);
            System.out.println("Temps d'exécution (en milliseconde): " + tempsExecutionMillis);
            System.out.println("---------------------------------------");
        }

	}

}
