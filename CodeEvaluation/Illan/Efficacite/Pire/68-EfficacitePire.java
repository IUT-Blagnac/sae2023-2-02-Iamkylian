package efficacite;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class EfficacitePire {

    public static List<String> solution(String texte, List<String> ordre) throws InterruptedException {

        // Expression Regex pour séparer les mots à chaque caractère non-alphabétique
        List<String> decoupage = Arrays.asList(texte.split("[^\\p{L}]"));

        // Tri en fonction de l'ordre
        List<String> resultat = new ArrayList<String>();
        int i = 0;
        while (i < ordre.size()) {
            int j = 0;
            while (j < decoupage.size()) {
                if (decoupage.get(j).startsWith(ordre.get(i))) {
                    resultat.add(decoupage.get(j));

                    // Ralentir le programme
                    Thread.sleep(delay);
                }
                j++;
            }
            i++;
        }

        // Ajout des mots restants
        int k = 0;
        while (k < decoupage.size()) {
            if (!resultat.contains(decoupage.get(k))) {
                resultat.add(decoupage.get(k));

                // Ralentir le programme
                Thread.sleep(delay);
            }
            k++;
        }
        return resultat;
    }

}
