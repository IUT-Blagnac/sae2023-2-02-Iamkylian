package test;

import java.util.Arrays;
import java.util.List;

import exercice.Exercice;

public class TestConsoElectrique {

	public static void main(String[] args) {

		List<Character> ordre = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

		List<String> testStrings = Arrays.asList(
				"Lorem ipsum dolor sit amet",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
				);

		double pcConsumptionPerNs = 5.5555556e-11; // Consommation électrique d'un PC en watt par nano seconde
		double conversionFactor = 1e9 * 60 * 60; // Conversion de nanosecondes à heures

		for (String str : testStrings) {
			long startTime = System.nanoTime();
			String result = Exercice.solution(str, ordre);
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			double executionTimeHours = executionTime / conversionFactor; // Conversion en heures
			double energyConsumption = pcConsumptionPerNs * executionTimeHours;
			double tempsExecutionMillis = (double) executionTime / 1_000_000; // Conversion en millisecondes

			System.out.println("Chaîne de caractères: " + str);
			System.out.println("Résultat : " + result);
			System.out.println("Temps d'exécution (en milliseconde): " + tempsExecutionMillis);
			System.out.printf("Consommation électrique du programme (en Watt-heure): %.5f%n", energyConsumption);
			System.out.println("---------------------------------------");
		}

	}

}
