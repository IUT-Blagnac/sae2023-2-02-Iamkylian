package exercice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> motsClasses = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                motCourant.append(c);
            } else {
                if (motCourant.length() > 0) {
                    motsClasses.add(motCourant.toString());
                    motCourant.setLength(0);
                }
            }
        }

        if (motCourant.length() > 0) {
            motsClasses.add(motCourant.toString());
        }

        Comparator<String> ordreComparator = Comparator.comparingInt(s -> getIndex(s.charAt(0), ordre));
        Collections.sort(motsClasses, ordreComparator);

        return motsClasses;
    }

    private static int getIndex(char c, List<Character> ordre) {
        for (int i = 0; i < ordre.size(); i++) {
            if (ordre.get(i) == c) {
                return i;
            }
        }
        return ordre.size();
    }
}
