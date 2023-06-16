package exercice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercice2Mailleur {

	public static List<String> solution(String str, List<Character> ordre) {

        List<String> mots = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                motCourant.append(c);
            } else if (motCourant.length() > 0) {
                mots.add(motCourant.toString());
                motCourant.setLength(0);
            }
        }

        if (motCourant.length() > 0) {
            mots.add(motCourant.toString());
        }

        mots.sort(Comparator.comparingInt(mot -> getOrderValue(mot, ordre)));

        return mots;
    }

    private static int getOrderValue(String mot, List<Character> ordre) {
        String lowerCaseMot = mot.toLowerCase();
        for (int i = 0; i < ordre.size(); i++) {
            if (lowerCaseMot.startsWith(String.valueOf(ordre.get(i)).toLowerCase())) {
                return i;
            }
        }
        return ordre.size();
    }

}
