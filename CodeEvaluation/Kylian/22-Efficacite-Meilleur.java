package exercice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EfficaciteM {

    public static List<String> solution(String texte, List<Character> ordre) {
        Map<Character, Integer> orderMap = new HashMap<>();

        // Création d'une hashMap pour stocker l'indice de chaque lettre dans l'ordre
        for (int i = 0; i < ordre.size(); i++) {
            orderMap.put(ordre.get(i), i);
        }

        // Liste permettant de stocker les mots ayant leur première lettre dans le dictionnaire
        List<String> words = new ArrayList<>();
        // Liste permettant de stocker les mots n'ayant pas leur première lettre dans le dictionnaire
        List<String> unknownWords = new ArrayList<>();

        StringBuilder currentWord = new StringBuilder();

        // Parcours du texte caractère par caractère
        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);

            // Si le caractère est une lettre
            if (Character.isLetter(c) || Character.isDigit(c)) {
                currentWord.append(c);

                // Si le caractère suivant n'est pas une lettre ou si on a atteint la fin du texte
                if (i == texte.length() - 1 || !Character.isLetterOrDigit(texte.charAt(i + 1))) {
                    String word = currentWord.toString();

                    // Si la lettre est dans la hashMap dictionnaire
                    if (orderMap.containsKey(word.charAt(0))) {
                        words.add(word);
                    } else {
                        unknownWords.add(word);
                    }

                    currentWord.setLength(0); // Réinitialisation du mot en cours
                }
            }
        }

        // Trie des mots en utilisant l'ordre spécifié
        sortWords(words, orderMap);

        words.addAll(unknownWords);

        return words;
    }
    
    /*
     * Permet de trier les mots
     * @param List
     */
    private static void sortWords(List<String> words, Map<Character, Integer> orderMap) {
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                String word1 = words.get(i);
                String word2 = words.get(j);

                int minLength = Math.min(word1.length(), word2.length());

                // Comparaison caractère par caractère jusqu'à trouver une différence
                for (int k = 0; k < minLength; k++) {
                    char char1 = word1.charAt(k);
                    char char2 = word2.charAt(k);

                    // Si les caractères sont différents, utilise l'ordre défini
                    if (char1 != char2) {
                        int order1 = orderMap.get(char1);
                        int order2 = orderMap.get(char2);

                        if (order1 != order2) {
                            if (order1 > order2) {
                                swapWords(words, i, j);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void swapWords(List<String> words, int i, int j) {
        String temp = words.get(i);
        words.set(i, words.get(j));
        words.set(j, temp);
    }
}
