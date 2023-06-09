package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EfficaciteMeilleur {

    public static List<String> solution(String texte, List<Character> ordre) {
        Map<Character, Integer> ordreMap = creerMapOrdre(ordre);
        List<String> mots = extraireMots(texte);
        triRapide(mots, ordreMap, 0, mots.size() - 1);
        return mots;
    }

    private static Map<Character, Integer> creerMapOrdre(List<Character> ordre) {
        Map<Character, Integer> ordreMap = new HashMap<>();
        for (int i = 0; i < ordre.size(); i++) {
            ordreMap.put(ordre.get(i), i);
        }
        return ordreMap;
    }

    private static List<String> extraireMots(String texte) {
        List<String> mots = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();

        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);
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

        return mots;
    }

    private static void triRapide(List<String> mots, Map<Character, Integer> ordreMap, int bas, int haut) {
        if (bas < haut) {
            int pivotIndex = partitionner(mots, ordreMap, bas, haut);
            triRapide(mots, ordreMap, bas, pivotIndex - 1);
            triRapide(mots, ordreMap, pivotIndex + 1, haut);
        }
    }

    private static int partitionner(List<String> mots, Map<Character, Integer> ordreMap, int bas, int haut) {
        String pivot = mots.get(haut);
        int i = bas - 1;

        for (int j = bas; j < haut; j++) {
            if (comparerMots(mots.get(j), pivot, ordreMap) <= 0) {
                i++;
                echanger(mots, i, j);
            }
        }

        echanger(mots, i + 1, haut);
        return i + 1;
    }

    private static void echanger(List<String> mots, int i, int j) {
        String temp = mots.get(i);
        mots.set(i, mots.get(j));
        mots.set(j, temp);
    }

    private static int comparerMots(String mot1, String mot2, Map<Character, Integer> ordreMap) {
        int minLength = Math.min(mot1.length(), mot2.length());
        for (int i = 0; i < minLength; i++) {
            char c1 = mot1.charAt(i);
            char c2 = mot2.charAt(i);
            int index1 = ordreMap.getOrDefault(c1, ordreMap.size());
            int index2 = ordreMap.getOrDefault(c2, ordreMap.size());
            if (index1 != index2) {
                return Integer.compare(index1, index2);
            }
        }
        return Integer.compare(mot1.length(), mot2.length());
    }
}
