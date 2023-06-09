import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class sobrietemeilleur {
	/**
	 * Trie les mots d'une chaîne de caractères selon un ordre spécifié.
	 *
	 * @param pfPhrase La chaîne de caractères à trier.
	 * @param pfOrdre  La liste des caractères spécifiant l'ordre de tri.
	 * @return Une liste de mots de la phrase triée selon l'ordre spécifié.
	 */
	public static List<String> solution(String str, List<Character> ordre) {
		List<String> motsTries = diviserMots(str);
		motsTries.sort(Comparator.comparingInt(s -> {
			int minLength = Math.min(s.length(), ordre.size());
			for (int i = 0; i < minLength; i++) {
				int index = ordre.indexOf(s.charAt(i));
				if (index != -1) {
					return index;
				}
			}
			return s.length();
		}));
		return motsTries;
	}

	/**
	 * Divise une chaîne de caractères en mots individuels.
	 *
	 * @param pfPhrase La chaîne de caractères à diviser en mots.
	 * @return Une liste contenant les mots individuels extraits de la phrase.
	 */
	public static List<String> diviserMots(String pfPhrase) {
		List<String> mots = new ArrayList<>();
		StringBuilder motActuel = new StringBuilder();
		
		for (int i = 0; i < pfPhrase.length(); i++) {
			char charSuivant = pfPhrase.charAt(i);
			if (Character.isLetter(charSuivant)) {
				motActuel.append(charSuivant);
			} else if (motActuel.length() > 0) {
				mots.add(motActuel.toString());
				motActuel.setLength(0);
			}
		}
		
		if (motActuel.length() > 0) {
			mots.add(motActuel.toString());
		}
		
		return mots;
	}
}