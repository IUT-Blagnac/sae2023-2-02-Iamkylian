package main;

import java.util.List;

public class SimpliciteMeilleur {

	public static List<String> solution(String texte, List<Character> ordre) {
        texte = texte.replace("'", " ");
        texte = texte.replace(",", "");
        texte = texte.replace(".", "");
        String[] mots = texte.split(" ");
        triParOrdre(mots, ordre);
        return List.of(mots);
    }



	private static void triParOrdre(String[] mots, List<Character> ordre) {
	    for (int i = 0; i < mots.length - 1; i++) {
	        for (int j = i + 1; j < mots.length; j++) {
	            if (compareMots(mots[j], mots[i], ordre)) {
	                String temp = mots[i];
	                mots[i] = mots[j];
	                mots[j] = temp;
	            }
	        }
	    }
	}

	private static boolean compareMots(String mot1, String mot2, List<Character> ordre) {
	    int length1 = mot1.length();
	    int length2 = mot2.length();
	    int minLength = Math.min(length1, length2);

	    for (int i = 0; i < minLength; i++) {
	        char char1 = mot1.charAt(i);
	        char char2 = mot2.charAt(i);
	        int index1 = getOrdreIndex(ordre, char1);
	        int index2 = getOrdreIndex(ordre, char2);

	        if (index1 != index2) {
	            return index1 < index2;
	        }
	    }

	    return length1 < length2;
	}



	private static int getOrdreIndex(List<Character> ordre, char lettre) {

		for (int i = 0; i < ordre.size(); i++) {
			if (ordre.get(i) == lettre) {
				return i;
			}
		}

		return ordre.size();
	}

}

