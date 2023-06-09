package exercice;

import java.util.List;
import java.util.ArrayList;

public class efficacite_pire {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (char c : ordre) {
                for (int j = 0; j <= i; j++) {
                    if (str.charAt(j) == c) {
                        result.add(str);
                        break;
                    }
                }
            }
        }

        return result;
    }
}
