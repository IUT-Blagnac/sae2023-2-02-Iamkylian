package test;

import java.util.Arrays;
import java.util.List;

import exercice.Exercice;
import exercice.Exercice1;

public class TestConsoElectrique {

	public static void main(String[] args) {

		List<Character> ordre = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

		List<String> testStrings = Arrays.asList(
				"L",
				"Lorem amet",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam auctor bibendum turpis, nec pretium odio venenatis sed. Fusce viverra gravida lectus, sed scelerisque lectus iaculis sit amet. In eu mauris id ipsum ultrices ultrices. Morbi rutrum urna et ipsum congue convallis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Mauris convallis ultricies neque, at cursus metus. Curabitur non diam erat. Maecenas posuere ante id lacinia varius. Suspendisse interdum eleifend nulla, id semper lectus hendrerit quis. Integer sed diam varius, tristique libero ac, fringilla neque. Integer hendrerit rutrum ligula eu tincidunt. Pellentesque nec massa ut dolor facilisis pretium. Nullam iaculis mi a nisi fringilla, ut elementum elit tristique. Duis accumsan neque ac fringilla convallis. In non ante odio. Nullam sed leo consequat, egestas urna id, fringilla massa. Integer lacinia posuere viverra. Proin ut tincidunt felis. Sed interdum feugiat velit ac convallisos."
				);

		double pcConsumptionPerNs = 5.5555556e-11; // Consommation électrique d'un PC en watt par nano seconde
		//double conversionFactor = 1e9 * 60 * 60; // Conversion de nanosecondes à heures

		for (String str : testStrings) {
			long startTime = System.nanoTime();
			List<String> result = Exercice1.solution(str, ordre);
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			double tempsExecutionMillis = (double) executionTime / 1_000_000; // Conversion en millisecondes

			System.out.println("Temps d'exécution (en milliseconde): " + tempsExecutionMillis);

			double executionTimeHours = executionTime * pcConsumptionPerNs;

			double valLog = Math.log10(executionTimeHours);

			double valAbs = Math.abs(valLog);

			System.out.println("Chaîne de caractères: " + str);
			System.out.println("Résultat : " + result);
			System.out.printf("Consommation électrique du programme (en Watt): %.5f%n", valAbs);
			System.out.println("---------------------------------------");
		}

	}

}
