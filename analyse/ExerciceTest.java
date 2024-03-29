package test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ExerciceTest {
	@Test
	public void testSolution() {
		// Chaine simple avec ordre complet
		assertEquals(List.of("666","the", "the", "number", "of", "beast"),
				exercice.Exercice.solution("666, the number of the beast",List.of('6', 't', 'n', 'o', 'b')));
		// Chaine à 1 mot
		assertEquals("Erreur de chaine à 1 mot", List.of("OK"),
				exercice.Exercice.solution("OK",List.of('a', 'b', 'c', 'd', 'e')));
		// Chaine vide
		assertEquals(List.of(), exercice.Exercice.solution("",List.of('6', 't', 'n', 'o', 'b')));
		// Chaine donnée en exemple
		assertEquals(List.of("fait", "Il", "aujourd", "aout", "beau", "hui", "comme", "en"),
				exercice.Exercice.solution("Il fait beau aujourd'hui comme en aout",List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o')));
		
		// Chaine donnée en exemple
		assertEquals(List.of("fait", "Il", "aujourd", "aout", "beau", "comme", "hui", "en"),
				exercice.Exercice.solution("Il fait beau comme aujourd'hui en aout", List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o')));
		// Chaine donnée avec ordre différent
		assertEquals(List.of("fait", "Il", "aujourd", "aout", "beau", "comme", "hui", "en"),
				exercice.Exercice.solution("Il fait beau aout comme aujourd'hui en", List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o')));
	}
}