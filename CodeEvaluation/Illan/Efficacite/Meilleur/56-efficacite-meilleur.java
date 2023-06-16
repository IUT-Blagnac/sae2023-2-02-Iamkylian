package exercice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exercice {

    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        StringBuilder motCourant = new StringBuilder();

        for (char lettre : ordre) {
            map.put(lettre, new ArrayList<>());
        }

        for (int i = 0; i < texte.length(); i++) {
            char caractere = texte.charAt(i);

            if (caractere == ' ') {
                String mot = motCourant.toString().trim();
                if (!mot.isEmpty()) {
                    char premiereLettre = mot.charAt(0);
                    if (map.containsKey(premiereLettre)) {
                        map.get(premiereLettre).add(mot);
                    }
                }
                motCourant.setLength(0);
            } else {
                motCourant.append(caractere);
            }
        }

        // Ajouter le dernier mot s'il n'est pas vide
        String dernierMot = motCourant.toString().trim();
        if (!dernierMot.isEmpty()) {
            char premiereLettre = dernierMot.charAt(0);
            if (map.containsKey(premiereLettre)) {
                map.get(premiereLettre).add(dernierMot);
            }
        }

        for (char lettre : ordre) {
            mots.addAll(map.get(lettre));
        }

        return mots;
    }
}