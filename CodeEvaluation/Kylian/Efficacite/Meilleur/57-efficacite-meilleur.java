import java.util.*;

package exercice;
public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        Map<Character, Integer> orderMap = new HashMap<>();
        int index = 0;
        for (char c : ordre) {
            orderMap.put(c, index);
            index++;
        }

        List<String> mots = new ArrayList<>();
        StringBuilder motActuel = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                motActuel.append(c);
            } else {
                if (motActuel.length() > 0) {
                    mots.add(motActuel.toString());
                    motActuel.setLength(0);
                }
            }
        }
        if (motActuel.length() > 0) {
            mots.add(motActuel.toString());
        }

        mots.sort((a, b) -> {
            char premiereLettreA = Character.toLowerCase(a.charAt(0));
            char premiereLettreB = Character.toLowerCase(b.charAt(0));

            int orderA = orderMap.getOrDefault(premiereLettreA, Integer.MAX_VALUE);
            int orderB = orderMap.getOrDefault(premiereLettreB, Integer.MAX_VALUE);

            if (orderA == orderB) {
                return a.compareToIgnoreCase(b);
            }
            return Integer.compare(orderA, orderB);
        });

        return mots;
    }
}
